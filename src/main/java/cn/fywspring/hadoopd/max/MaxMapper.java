package cn.fywspring.hadoopd.max;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MaxMapper extends Mapper<LongWritable,Text,Text,IntWritable>{
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		String string = value.toString();
		String year = string.substring(8, 12);
		int temp = Integer.parseInt(string.substring(18));
		context.write(new Text(year), new IntWritable(temp));
	}
}
