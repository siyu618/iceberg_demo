package com.mt.iceberg;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class IcebergDemo {
    public static void main(String... args) {
        SparkSession spark = SparkSession
                .builder()
                .master("local")
                .appName("Iceberg spark example")
                .config("spark.sql.extensions", "org.apache.iceberg.spark.extensions.IcebergSparkSessionExtensions")
                .config("spark.sql.catalog.local", "org.apache.iceberg.spark.SparkCatalog")
                .config("spark.sql.catalog.local.type", "hadoop")
                .config("spark.sql.catalog.local.warehouse", "iceberg_warehouse")
                .getOrCreate();

        spark.sql("create database iceberg_db");
        spark.sql("CREATE TABLE IF NOT EXISTS local.iceberg_db.table (id bigint, data string) USING iceberg\n");
        spark.sql("INSERT INTO local.iceberg_db.table VALUES (1, 'a'), (2, 'b'), (3, 'c')");
        Dataset<Row> result = spark.sql("select * from local.iceberg_db.table");
        result.show();

    }
}
