package org.hadoop.learn.groupcomparator;

import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class SortMapper extends Mapper<LongWritable, Text, OrderBean, NullWritable> {

	@Override
	protected void map(LongWritable key, Text value,
			Context context)
			throws IOException, InterruptedException {
		String line = value.toString();
		String [] fields = line.split(",");
		OrderBean bean = new OrderBean();
		bean.setItemId(new Text(fields[0]));
		bean.setAmount(new DoubleWritable(Double.parseDouble(fields[2])));
		context.write(bean, NullWritable.get());
	}

}
