package com.activemq.listeners;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.management.RuntimeErrorException;

import org.apache.log4j.Logger;

import com.activemq.util.MyMessageConverter;

public class MyMessageListener implements MessageListener {
	private static final Logger logger = Logger
			.getLogger(MyMessageListener.class);
	private MyMessageConverter convertor;

	public MyMessageConverter getConvertor() {
		return this.convertor;
	}

	public void setConvertor(MyMessageConverter convertor) {
		this.convertor = convertor;
	}

	public void onMessage(Message mess) {
		try {
			logger.debug("before get message!");
			Object t = this.convertor.fromMessage(mess);
			System.out.println("msg: " + t);
			if("t".equals(t.toString())) {
				throw new RuntimeException("ssss");
			}
//			mess.acknowledge();
		} catch (Throwable te) {
			logger.error("consume failed", te);
			throw new RuntimeException(te);
		}
	}
}
