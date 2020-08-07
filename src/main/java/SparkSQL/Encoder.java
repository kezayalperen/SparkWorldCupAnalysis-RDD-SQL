package SparkSQL;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class Encoder {
    public static void main(String[] args) {

        System.setProperty("hadoop.home.dir", "C:\\hadoop-common-2.2.0-bin-master");

        SparkSession spark = SparkSession.builder().appName("FirstSQL").master("local").getOrCreate();

        org.apache.spark.sql.Encoder<Person> personEncoder = Encoders.bean(Person.class);

        Dataset<Person> data = spark.read().json("C:\\Users\\Kezay\\Desktop\\person.json").as(personEncoder);

        // ÇALIŞIYOR AMA YANLIŞMIŞ GİBİ GÖSTERDİĞİ İÇİN KAPATTIM
        /*
        data.foreach(kv ->{
            System.out.println(kv.getName() + " : " + kv.getCity());
        });


         */
    }
}
