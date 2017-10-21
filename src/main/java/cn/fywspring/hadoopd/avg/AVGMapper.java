package cn.fywspring.hadoopd.avg;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.log4j.Logger;


public class AVGMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
	
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		String string = value.toString();
		String[] data = string.split(" ");
		String name = data[0];
		int score = Integer.parseInt(data[1]);
		context.write(new Text(name), new IntWritable(score));
	}
}
