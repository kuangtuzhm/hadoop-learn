package org.hadoop.learn.wordcount;

import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

	@Override
	protected void map(LongWritable key, Text value,
			Context context)
			throws IOException, InterruptedException {
		
		String line = value.toString();
		if(StringUtils.isNotEmpty(line))
		{
			String [] words = line.split(" ");
			for(String word : words)
			{
				context.write(new Text(word), new IntWritable(1));
			}
		}
		
	}

	
}
