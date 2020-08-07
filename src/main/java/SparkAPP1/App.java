package SparkAPP1;

import com.google.common.collect.Iterators;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.api.java.function.VoidFunction;
import org.apache.spark.sql.SparkSession;
import scala.Tuple2;

import javax.swing.text.Document;
import java.util.Iterator;

public class App {
    public static void main(String[] args) {

        System.setProperty("hadoop.home.dir", "C:\\hadoop-common-2.2.0-bin-master");

        SparkSession spark = SparkSession.builder()
                .master("local")
                .appName("mongoSpark")
                .config("spark.mongodb.input.uri","mongodb://127.0.0.1/test.WordCupCollection")
                .config("spark.mongodb.output.uri","mongodb://127.0.0.1/test.WordCupCollection")
                .getOrCreate();

        JavaSparkContext sc = new JavaSparkContext(spark.sparkContext());

        JavaRDD<String> rawData = sc.textFile("C:\\Users\\Kezay\\Desktop\\WorldCupPlayers.csv");

        // RDD STRING CONVERT MODAL (WE ALREADY CREATED THE MODAL CLASS )

        JavaRDD<PlayersModal> playersRDD = rawData.map(new Function<String, PlayersModal>() {
            public PlayersModal call(String line) throws Exception {
                String[] splitLine = line.split(",", -1);

                return new PlayersModal(splitLine[0], splitLine[1], splitLine[2], splitLine[3], splitLine[4], splitLine[5], splitLine[6], splitLine[7], splitLine[8]);
            }
        });

        //How many matches did Ilhan Mansiz play in the world cup

        JavaRDD<PlayersModal> ilhanRDD = playersRDD.filter(new Function<PlayersModal, Boolean>() {
            public Boolean call(PlayersModal playersModal) throws Exception {
                return playersModal.getPlayerName().equals("ILHAN MANSIZ");
            }
        });

        System.out.println("İlhan Mansız played " + ilhanRDD.count() + " matches in the world cup...");

        // Bir futbolcunun kaç maç oynadığını gösteren app

        JavaPairRDD<String, String> mapToPairRDD = playersRDD.mapToPair(new PairFunction<PlayersModal, String, String>() {
            public Tuple2<String, String> call(PlayersModal playersModal) throws Exception {
                return new Tuple2<String, String>(playersModal.getPlayerName(), playersModal.getMatchID());
            }
        });

        // Verileri dağınık tutuluyor

        mapToPairRDD.foreach(new VoidFunction<Tuple2<String, String>>() {
            public void call(Tuple2<String, String> line) throws Exception {
                System.out.println(line._1 + " " + line._2);
            }
        });

        // veriler gruplanarak tutuluyor

        JavaPairRDD<String, Iterable<String>> groupPlayer = mapToPairRDD.groupByKey();

        groupPlayer.foreach(new VoidFunction<Tuple2<String, Iterable<String>>>() {
            public void call(Tuple2<String, Iterable<String>> line) throws Exception {
                System.out.println(line._1 + " " + line._2);
            }
        });

        // Gruplanan verinin countu alınacak. groupPlayer classı oluşturuldu

        JavaRDD<GroupPlayer> resultRDD = groupPlayer.map(new Function<Tuple2<String, Iterable<String>>, GroupPlayer>() {
            public GroupPlayer call(Tuple2<String, Iterable<String>> dizi) throws Exception {
                Iterator<String> iteratorRaw = dizi._2().iterator();
                int size = Iterators.size(iteratorRaw);

                return new GroupPlayer(dizi._1, size);
            }
        });

        resultRDD.foreach(new VoidFunction<GroupPlayer>() {
            public void call(GroupPlayer groupPlayer) throws Exception {
                System.out.println(groupPlayer.getPlayerName() +" "+ groupPlayer.getMatchCount());
            }
        });

        // Bir oyuncunun kaç kere kaptanlık yaptığını gösteren program



    }

}
