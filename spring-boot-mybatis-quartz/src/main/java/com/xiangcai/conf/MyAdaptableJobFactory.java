package com.xiangcai.conf;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.scheduling.quartz.AdaptableJobFactory;
import org.springframework.stereotype.Component;

/**
 * AdaptableJobFactory：作用采用反射机制创建Job实例
 * 需要重写方法：1：采用反射机制创建Job实例  2：需要将job实例手动放入到IOC容器中
 */
@Component
public class MyAdaptableJobFactory extends AdaptableJobFactory{
	//将对象添加到IOC容器中，并完成该对象的注入
	@Autowired
	AutowireCapableBeanFactory autowireCapableBeanFactory;
	
	//1：采用反射机制创建Job实例  2：需要将job实例手动放入到IOC容器中
	@Override
	protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
		Object job=super.createJobInstance(bundle);
		//job实例手动放入到Spring IOC容器中.并完成注入
		autowireCapableBeanFactory.autowireBean(job);
		return job;
	}
}
