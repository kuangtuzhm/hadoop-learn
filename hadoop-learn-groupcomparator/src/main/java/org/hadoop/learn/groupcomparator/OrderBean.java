package org.hadoop.learn.groupcomparator;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;

public class OrderBean implements WritableComparable<OrderBean> {
	
	private Text itemId;
	
	private DoubleWritable amount;

	public Text getItemId() {
		return itemId;
	}

	public void setItemId(Text itemId) {
		this.itemId = itemId;
	}

	public DoubleWritable getAmount() {
		return amount;
	}

	public void setAmount(DoubleWritable amount) {
		this.amount = amount;
	}

	@Override
	public int compareTo(OrderBean o) {
		int ret = 0;
		if(o == null)
		{
			ret = 1;
		}
		else
		{
			ret = this.itemId.compareTo(o.getItemId());
			if(ret == 0)
			{
				ret = -this.amount.compareTo(o.getAmount());
			}
		}
		return ret;
	}

	@Override
	public void write(DataOutput out) throws IOException {
		
		out.writeUTF(itemId.toString());
		out.writeDouble(amount.get());
	}

	@Override
	public void readFields(DataInput in) throws IOException {
		
		this.itemId = new Text(in.readUTF());
		this.amount = new DoubleWritable(in.readDouble());
	}

	@Override
	public String toString() {
		return "OrderBean [itemId=" + itemId + ", amount=" + amount + "]";
	}

	
}
