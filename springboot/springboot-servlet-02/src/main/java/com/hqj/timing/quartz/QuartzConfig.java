package com.hqj.timing.quartz;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

/**
 * Quartz配置类
 * 
 */
@Configuration
public class QuartzConfig {

	/**
	 * 1.创建job
	 */
	@Bean
	public JobDetailFactoryBean jobDetailFactoryBean() {
		JobDetailFactoryBean factoryBean = new JobDetailFactoryBean();
		// 关联我们自己的job类
		factoryBean.setJobClass(QuartzDemo.class);
		return factoryBean;
	}

	/**
	 * 2.创建Trigger对象 简单的Trigger
	 */
//	@Bean
//	public SimpleTriggerFactoryBean simpleTriggerFactoryBean(JobDetailFactoryBean factoryBean) {
//		SimpleTriggerFactoryBean triggerFactoryBean = new SimpleTriggerFactoryBean();
//		// 关联JobDetail对象
//		triggerFactoryBean.setJobDetail(factoryBean.getObject());
//		// 执行的间隔时间：毫秒单位
//		triggerFactoryBean.setRepeatInterval(2000);
//		// 重复次数
//		triggerFactoryBean.setRepeatCount(5);
//		return triggerFactoryBean;
//	}

	@Bean
	public CronTriggerFactoryBean cronTriggerFactoryBean(JobDetailFactoryBean jobDetailFactoryBean) {
		CronTriggerFactoryBean cronTriggerFactoryBean = new CronTriggerFactoryBean();
		cronTriggerFactoryBean.setJobDetail(jobDetailFactoryBean.getObject());
		// 设置触发时间
		cronTriggerFactoryBean.setCronExpression("0/2 * * * * ?");
		return cronTriggerFactoryBean;
	}

	/**
	 * 3.创建Scheduler对象
	 */
//	@Bean
//	public SchedulerFactoryBean schedulerFactoryBean(SimpleTriggerFactoryBean simpleTriggerFactoryBean) {
//		SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
//		// 关联trigger
//		schedulerFactoryBean.setTriggers(simpleTriggerFactoryBean.getObject());
//		return schedulerFactoryBean;
//	}
	
//	@Bean
//	public SchedulerFactoryBean schedulerFactoryBean(CronTriggerFactoryBean cronTriggerFactoryBean) {
//		SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
//		// 关联trigger
//		schedulerFactoryBean.setTriggers(cronTriggerFactoryBean.getObject());
//		return schedulerFactoryBean;
//	}
	
	/**
	 * 解决Quartz Job类中注入对象的问题
	 * @param cronTriggerFactoryBean
	 * @return
	 */
	@Bean
	public SchedulerFactoryBean schedulerFactoryBean(CronTriggerFactoryBean cronTriggerFactoryBean,MyAdaptableJobFactory myAdaptableJobFactory) {
		SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
		// 关联trigger
		schedulerFactoryBean.setTriggers(cronTriggerFactoryBean.getObject());
		schedulerFactoryBean.setJobFactory(myAdaptableJobFactory);
		return schedulerFactoryBean;
	}
}
