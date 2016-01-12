package com.hzz.task;

import java.util.concurrent.atomic.AtomicInteger;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Service;

@Service
public class TestTask extends QuartzJobBean {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(TestTask.class);

	private AtomicInteger sequence = new AtomicInteger();

	@Override
	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {
		try {
			System.out.println("current sequence: "
					+ sequence.incrementAndGet());
		} catch (Exception e) {
			LOGGER.error("定时任务异常 ", e);
		}
	}

}
