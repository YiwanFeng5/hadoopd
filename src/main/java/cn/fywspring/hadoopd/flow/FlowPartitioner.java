package cn.fywspring.hadoopd.flow;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class FlowPartitioner extends Partitioner<Text,Flow>{

	@Override
	public int getPartition(Text key, Flow value, int numPartitions) {
		if ("bj".equals(value.getAddr())) {
			return 0;
		}else if ("sh".equals(value.getAddr())) {
			return 1;
		} else {
			return 2;
		}
	}

}
