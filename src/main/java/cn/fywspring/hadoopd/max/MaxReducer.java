package cn.fywspring.hadoopd.max;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class MaxReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
	@Override
	protected void reduce(Text key, Iterable<IntWritable> values,
			Reducer<Text, IntWritable, Text, IntWritable>.Context context) throws IOException, InterruptedException {
		int max = 0;
		for (IntWritable value : values) {
			if (max < value.get()) {
				max = value.get();
			}
		}
		context.write(key, new IntWritable(max));
	}
}
