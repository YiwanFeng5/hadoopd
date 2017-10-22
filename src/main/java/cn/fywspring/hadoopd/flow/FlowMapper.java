package cn.fywspring.hadoopd.flow;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.log4j.Logger;

public class FlowMapper extends Mapper<LongWritable, Text, Text, Flow>{
//	private static Logger log = Logger.getLogger(FlowMapper.class);
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, Flow>.Context context)
			throws IOException, InterruptedException {
		String line = value.toString();
		String[] data = line.split(" ");
		Flow flow = new Flow();
		flow.setPhone(data[0]);
		flow.setAddr(data[1]);
		flow.setName(data[2]);
		flow.setFlow(Integer.parseInt(data[3]));
//		log.info("********************"+flow);
		context.write(new Text(flow.getPhone()), flow);
	}
}
