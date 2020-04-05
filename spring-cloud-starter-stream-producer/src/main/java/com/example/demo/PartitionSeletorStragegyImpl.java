package com.example.demo;

import org.springframework.cloud.stream.binder.PartitionSelectorStrategy;

public class PartitionSeletorStragegyImpl implements PartitionSelectorStrategy {

	@Override
	public int selectPartition(Object key, int partitionCount) {
		int age = Integer.parseInt(key.toString());

		return age % partitionCount;
	}

}
