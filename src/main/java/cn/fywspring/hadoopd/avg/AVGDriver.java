package cn.fywspring.hadoopd.avg;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


public class AVGDriver {
	public static void main(String[] args) {
		try {
			Configuration conf = new Configuration();
			Job job = Job.getInstance(conf);
			
			job.setJarByClass(AVGDriver.class);
			job.setMapperClass(AVGMapper.class);
			job.setReducerClass(AVGReducer.class);
			
			job.setMapOutputKeyClass(Text.class);
			job.setMapOutputValueClass(IntWritable.class);
			
			job.setOutputKeyClass(Text.class);
			job.setOutputValueClass(IntWritable.class);
			
			FileInputFormat.setInputPaths(job, new Path("hdfs://hadoop01:9000/average"));
			FileOutputFormat.setOutputPath(job, new Path("hdfs://hadoop01:9000/average/result"));
			
			job.waitForCompletion(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
