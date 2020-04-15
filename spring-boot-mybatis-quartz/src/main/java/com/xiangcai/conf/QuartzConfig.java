package com.xiangcai.conf;

import org.quartz.JobDetail;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

import com.xiangcai.quartz.InsertJob;

/**
 * Quartz的配置类，创建job,trigger.scheduler的对象
 * @author meimei
 */
@Configuration
public class QuartzConfig {
	//1:创建Job对象
	@Bean
	public JobDetailFactoryBean getJobDetailFactoryBean() {
		JobDetailFactoryBean  jobDetailFactory=new JobDetailFactoryBean();
		//关联自己的job
		jobDetailFactory.setJobClass(InsertJob.class);
		return jobDetailFactory;
	}
	//2:创建Trigger对象
	//2.1:简单的Trigger对象创建
	@Bean
	public SimpleTriggerFactoryBean getSimpleTriggerFactoryBean(JobDetailFactoryBean jobDetailFactoryBean) {
		SimpleTriggerFactoryBean factory=new SimpleTriggerFactoryBean();
		//关联jobDetail对象
		factory.setJobDetail(jobDetailFactoryBean.getObject());
		//设置定时间隔时间，ms
		factory.setRepeatInterval(1000);
		//设置重复次数
		//factory.setRepeatCount(10);
		return factory;
	}
	//2.2:corn trigger对象创建
	@Bean
	public CronTriggerFactoryBean getCronTriggerFactoryBean(JobDetailFactoryBean jobDetailFactoryBean) {
		CronTriggerFactoryBean factory=new CronTriggerFactoryBean();
		//关联jobDetail对象
		factory.setJobDetail(jobDetailFactoryBean.getObject());
		//设置触发时间cron表达式
		factory.setCronExpression("0/1 * * * * ?");
		return factory;
	}
	//3:创建Scheduler对象
	@Bean
	public SchedulerFactoryBean getSchedulerFactoryBean(
			CronTriggerFactoryBean cronTriggerFactoryBean,MyAdaptableJobFactory myAdaptableJobFactory) {
		SchedulerFactoryBean factory=new SchedulerFactoryBean();
		//关联trigger对象
		factory.setTriggers(cronTriggerFactoryBean.getObject());
		//重新设置job实例化工厂
		factory.setJobFactory(myAdaptableJobFactory);
		return factory;
	}
}
