package com.xiangcai.quartz;

import java.util.Date;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xiangcai.pojo.Test;
import com.xiangcai.service.TestService;

/**
  * 往测试表添加数据的任务类
 * @author meimei
 */
public class InsertJob implements Job{
	@Autowired
	TestService service;
	
    //执行定时任务的方法
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		//往test表中添加一条测试数据，调用业务层添加测试的方法
		Test  test=new Test(new Date());
		service.addTest(test);
	}

}
