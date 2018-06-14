package org.hadoop.learn.groupcomparator;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class MyGroupingComparator extends WritableComparator {
	
	public MyGroupingComparator()
	{
		super(OrderBean.class,true);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public int compare(WritableComparable a, WritableComparable b) {
		OrderBean oba = (OrderBean)a;
		OrderBean obb = (OrderBean)b;
		return oba.getItemId().compareTo(obb.getItemId());
	}

	
}
