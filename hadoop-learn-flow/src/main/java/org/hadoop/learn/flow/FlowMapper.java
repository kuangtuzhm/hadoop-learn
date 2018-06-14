package org.hadoop.learn.flow;

import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class FlowMapper extends Mapper<LongWritable, Text, Text, FlowBean> {

	@Override
	protected void map(LongWritable key, Text value,
			Context context)
			throws IOException, InterruptedException {
		String line = value.toString();
		if(StringUtils.isNotEmpty(line))
		{
			String [] fields = line.split("\t");
			
			if(fields != null && fields.length == 3)
			{
				String phone = fields[0];
				Integer flowUp = Integer.parseInt(fields[1]);
				Integer flowDown = Integer.parseInt(fields[2]);
				
				FlowBean info = new FlowBean();
				info.setFlowDown(flowDown);
				info.setFlowUp(flowUp);
				context.write(new Text(phone), info);
			}
		}
	}
	
}
