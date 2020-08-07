package SparkSQL;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class Ders2 {
    public static void main(String[] args) {
        System.setProperty("hadoop.home.dir", "C:\\hadoop-common-2.2.0-bin-master");

        SparkSession spark = SparkSession.builder().appName("FirstSQL").master("local").getOrCreate();

        Dataset<Row> data = spark.read().json("C:\\Users\\Kezay\\Desktop\\person.json");

        data.createOrReplaceTempView("person");

        Dataset<Row> sql = spark.sql("select * from person");

        sql.show();
    }
}
