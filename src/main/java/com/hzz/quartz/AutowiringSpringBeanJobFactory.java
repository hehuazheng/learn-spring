package com.hzz.quartz;

import java.util.HashMap;
import java.util.Map;

import org.quartz.spi.OperableTrigger;
import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;

public class AutowiringSpringBeanJobFactory extends SpringBeanJobFactory
		implements ApplicationContextAware {

	private transient AutowireCapableBeanFactory beanFactory;

	private static Map<String, Object> cacheMap = new HashMap<String, Object>();

	@Override
	public void setApplicationContext(final ApplicationContext context) {
		beanFactory = context.getAutowireCapableBeanFactory();
	}

	@Override
	protected Object createJobInstance(final TriggerFiredBundle bundle)
			throws Exception {
		OperableTrigger trigger = bundle.getTrigger();
		String jobKey = trigger.getJobKey().getGroup() + "."
				+ trigger.getJobKey().getName();
		Object job = cacheMap.get(jobKey);
		if (job == null) {
			synchronized (AutowiringSpringBeanJobFactory.class) {
				if (job == null) {
					job = super.createJobInstance(bundle);
					beanFactory.autowireBean(job);
					cacheMap.put(jobKey, job);
				}
			}
		}
		return job;
	}
}
