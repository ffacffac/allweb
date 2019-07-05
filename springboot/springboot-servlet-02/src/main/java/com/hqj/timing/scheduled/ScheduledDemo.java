package com.hqj.timing.scheduled;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Scheduled 定时任务
 * 
 */
//@Component
//public class ScheduledDemo {

//	/**
//	 * 定时任务方法
//	 * 
//	 * @Scheduled:设置定时任务. cron 属性： cron 表达式。 定时任务触发是时间的一个字符串表达形式
//	 */
//	@Scheduled(cron = "0/5 * * * * ?")
////	@Scheduled(cron = "5 * * * * ?")//每分钟的第五秒出发任务
////	@Scheduled(cron = "5 50 18 * * ?")//每天18点50分第五秒发出任务
////	@Scheduled(cron = "5 50 18 15 2 ?")//2月份18点50分第五秒发出任务
////	@Scheduled(cron = "5 50 18 ? 2 4")//2月份星期四18点50分第五秒发出任务
//	public void scheduledMethod() {
//		System.out.println("定时发出的任务----" + new Date());
//	}
//}
