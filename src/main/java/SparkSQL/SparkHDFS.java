package SparkSQL;

import org.apache.spark.sql.*;
import org.apache.spark.sql.Encoder;

public class SparkHDFS {
    public static void main(String[] args) {
        System.setProperty("hadoop.home.dir", "C:\\hadoop-common-2.2.0-bin-master");

        SparkSession spark = SparkSession.builder().appName("FirstSQL").master("local").getOrCreate();

        Encoder<MovieModal> movieModalEncoder = Encoders.bean(MovieModal.class);

        Dataset<MovieModal> data = spark.read().option("infershema",true)
                                        .option("header",true)
                                        .csv("hdfs://localhost:8020/user/ratings.csv")
                                        .as(movieModalEncoder);


        Dataset<Row> groupData = data.groupBy(new Column("userID")).count();

        groupData.write().format("csv").save("hdfs://localhost:8020/user/data2ulan.csv");

        //groupData.write().mode("append").format("csv").save("hdfs://localhost:8020/var/data2.csv");




    }
}
