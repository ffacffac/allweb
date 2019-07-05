package com.hqj.timing.quartz;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import com.hqj.pojo.Users;
import com.hqj.service.impl.UserServiceImpl;

/**
 * 定义任务类
 *
 */
public class QuartzDemo implements Job {

	/**
	 * 使用Quartz做定时任务时，不能直接通过@Autowired完成对象的注入，因为Quartz不通过Spring
	 * IOC容器完成对象注入；所以通过实现手动注入：类MyAdaptableJobFactory
	 * 
	 */
	@Autowired
	private UserServiceImpl userServiceImpl;

	/**
	 * 任务被触发时所执行的方法
	 */
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		System.out.println("Quartz---任务被执行" + new Date());
		Users users = userServiceImpl.findUsersById(1);
		System.out.println(users.getUsername());
	}

}
