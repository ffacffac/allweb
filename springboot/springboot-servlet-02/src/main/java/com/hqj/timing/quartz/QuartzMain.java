package com.hqj.timing.quartz;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 * 还没有与springboot整合起来
 * @author huangqj
 *
 */
public class QuartzMain {

//	public static void main(String[] args) throws SchedulerException {
//
//		// 1.创建Jod对象：你要做什么事
//		JobDetail job = JobBuilder.newJob(QuartzDemo.class).build();
//
//		/**
//		 * 简单的 trigger 触发时间： 通过 Quartz 提供一个方法来完成简单的重复 调用。
//		 * 
//		 * @a cron Trigger： 按照 Cron 的表达式来给定触发的时间
//		 */
//		// 2.创建 Trigger 对象： 在什么时间做？
//		// 简单重复执行任务，每秒钟执行一次
////		Trigger trigger = TriggerBuilder.newTrigger().withSchedule(SimpleScheduleBuilder.repeatSecondlyForever())
////				.build();
//		Trigger trigger = TriggerBuilder.newTrigger().withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?"))
//				.build();
//		// 3.创建 Scheduler 对象： 在什么时间做什么事？
//		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
//		scheduler.scheduleJob(job, trigger);
//		// 启动
//		scheduler.start();
//	}
}
