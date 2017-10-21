package cn.fywspring.hadoopd.wc_xml;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.log4j.Logger;

import cn.fywspring.hadoopd.test.XMLReaderDemo;

public class WCMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
	
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		try {
			String string = value.toString();
			String text = XMLReaderDemo.getValue(string);
			if(!"".equals(text)){
				String[] words = text.split(" ");
				for (String word : words) {
					context.write(new Text(word), new IntWritable(1));
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
