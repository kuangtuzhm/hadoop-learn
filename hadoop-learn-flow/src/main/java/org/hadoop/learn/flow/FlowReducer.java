package org.hadoop.learn.flow;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class FlowReducer extends Reducer<Text, FlowBean, Text, FlowBean> {

	@Override
	protected void reduce(Text key, Iterable<FlowBean> values,
			Context context)
			throws IOException, InterruptedException {
		
		long sumFlowUp = 0;
		long sumFlowDown = 0;
		long sumTotal = 0;
		for(FlowBean bean : values)
		{
			sumFlowUp += bean.getFlowUp();
			sumFlowDown += bean.getFlowDown();
		}
		sumTotal = sumFlowUp + sumFlowDown;
		
		FlowBean resultBean = new FlowBean();
		resultBean.setFlowUp(sumFlowUp);
		resultBean.setFlowDown(sumFlowDown);
		resultBean.setTotal(sumTotal);
		
		context.write(key, resultBean);
	}

}
