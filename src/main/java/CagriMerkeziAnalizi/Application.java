package CagriMerkeziAnalizi;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class Application {
    public static void main(String[] args) {
        System.setProperty("hadoop.home.dir", "C:\\hadoop-common-2.2.0-bin-master");

        SparkSession sparkSession = SparkSession.builder().master("local").appName("Chicago-311-Spark-SQL-Job").getOrCreate();

        Dataset<Row> rawData = sparkSession.read().option("header","true").csv("C:\\Users\\Kezay\\Desktop\\original.csv");

        rawData.show();

    }
}
