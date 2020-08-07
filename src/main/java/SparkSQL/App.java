package SparkSQL;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.RelationalGroupedDataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class App {

        public static void main(String[] args) {

            System.setProperty("hadoop.home.dir", "C:\\hadoop-common-2.2.0-bin-master");

            SparkSession spark = SparkSession.builder().appName("FirstSQL").master("local").getOrCreate();

            Dataset<Row> data = spark.read().json("C:\\Users\\Kezay\\Desktop\\person.json");

            Dataset<Row> groupData = data.groupBy("city").sum("age");

            groupData.show();


        }
}
