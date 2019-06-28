package com.hqj.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
/**
 * springBoot整合Listener
 *
 *<listener>
 *	<listener-class>com.bjsxt.listener.FirstListener</listener-class>
 *</listener>
 *springboot整合listener方法二
 */
public class SecondListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("Listener...SecondListener...init......");

	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub

	}

}
