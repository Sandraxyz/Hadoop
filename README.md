# Hadoop

Using Cloudera: https://www.cloudera.com/downloads/quickstart_vms.html and data file

Commands:

hadoop fs -mkdir /user/cloudera/maxtemperature
hadoop fs -mkdir /user/cloudera/maxtemperature/input 
hadoop fs -put * /user/cloudera/maxtemperature/input
ensure that all files were copied to hdfs by running: hadoop fs -ls /user/cloudera/maxtemperature/input/

Copy the following three files from this folder into cloudera/workspace/MaxTemperature/src
MaxTemperature.java 
MaxTemperatureMapper.java 
MaxTemperatureReducer.java

Export -> Jar

If the jar is there, run the hadoop job:
hadoop jar maxtemp.jar MaxTemperature /user/cloudera/maxtemperature/input /user/cloudera/maxtemperature/output

examine the output folder that was created:
hadoop fs -ls /user/cloudera/maxtemperature
hadoop fs -ls /user/cloudera/maxtemperature/output

Next, to see the contents of the output file run:
hadoop fs -cat /user/cloudera/maxtemperature/output/part-r-00000

Modify the MaxTemperature programs to compute the minimum and average of the data read. Name the job files MinTemp.java and AvgTemp.java, respectively. 

References/Source used:
https://github.com/tomwhite/hadoop-book/
