Usage in Hadoop environment:  
1. `mvn clean install`  
1. Move `udf-template-1.0-SNAPSHOT.jar` into hadoop machine  
3. `hive`  
4. `ADD JAR udf-1.0-SNAPSHOT.jar;`  
5. `create temporary function sample_generic_udf as 'org.example.SampleGenericUdf';`