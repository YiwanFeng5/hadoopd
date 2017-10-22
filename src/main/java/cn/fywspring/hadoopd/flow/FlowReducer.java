package cn.fywspring.hadoopd.flow;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.log4j.Logger;

public class FlowReducer extends Reducer<Text, Flow, Text, Flow>{
	private static Logger log = Logger.getLogger(FlowReducer.class);
	@Override
	protected void reduce(Text key, Iterable<Flow> values, Reducer<Text, Flow, Text, Flow>.Context context)
			throws IOException, InterruptedException {
		Flow result = new Flow();
		for (Flow flow : values) {
			result.setPhone(flow.getPhone());
			result.setAddr(flow.getAddr());
			result.setName(flow.getName());
			result.setFlow(result.getFlow()+flow.getFlow());
		}
		log.info("++++++++++++++++++++"+result);
		context.write(key, result);
	}
}
