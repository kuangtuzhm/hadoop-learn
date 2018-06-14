package org.hadoop.learn.flow;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;

public class FlowBean implements Writable{

	private long flowUp;
	
	private long flowDown;
	
	private long total;

	

	public long getFlowUp() {
		return flowUp;
	}

	public void setFlowUp(long flowUp) {
		this.flowUp = flowUp;
	}

	public long getFlowDown() {
		return flowDown;
	}

	public void setFlowDown(long flowDown) {
		this.flowDown = flowDown;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	@Override
	public void readFields(DataInput in) throws IOException {
		
		flowUp = in.readLong();
		flowDown=in.readLong();
		total = in.readLong();
	}

	@Override
	public void write(DataOutput out) throws IOException {
		
		out.writeLong(flowUp);
		out.writeLong(flowDown);
		out.writeLong(total);
	}

	@Override
	public String toString() {
		
		return flowUp+"\t"+flowDown+"\t"+total;
	}
	
	
}
