package com.haoran.algorithems;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.dataflow.DataflowJob;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.zhwp.elisticjob.annotation.ElasticJobConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@ElasticJobConfig(
		name= "com.haoran.algorithems.RetryMessageDataflowJob",
		cron= "0/10 * * * * ?",
		description = "测试任务",
		overwrite = false,
		shardingTotalCount = 1
		)
public class RetryMessageDataflowJob implements SimpleJob {


	/*@Override
	public List<String> fetchData(ShardingContext shardingContext) {
		List<String> list = new ArrayList<>();
		list.add(System.currentTimeMillis()+"-1");
		list.add(System.currentTimeMillis()+"-2");
		return list;
	}

	@Override
	public void processData(ShardingContext shardingContext, List<String> list) {
		list.stream().forEach(item-> System.out.println(item));
	}*/

	@Override
	public void execute(ShardingContext shardingContext) {
		System.out.println(System.currentTimeMillis());
	}
}
