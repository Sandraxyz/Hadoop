import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;


public class AvgTemperatureReducer extends Reducer<Text, IntWritable, Text, IntWritable> {

	@Override
	public void reduce(Text key, Iterable<IntWritable> values, Context context)
			throws IOException, InterruptedException {
		int avgValue = 0, size = 0;
		for (IntWritable value : values) {
			avgValue = value.get() + avgValue;
			size++;
		}
		
		if( size == 0 ){
			return;
		}
		avgValue = avgValue / size;
		
		context.write(key, new IntWritable(avgValue));
	}
}

