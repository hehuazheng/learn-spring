package com.activemq.util;

import javax.jms.Destination;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;

public class MyMessageProducer {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(MyMessageProducer.class);

	private JmsTemplate template;
	private Destination destination;

	public JmsTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JmsTemplate template) {
		this.template = template;
	}

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}

	public void send(Object message) {
		try {
			template.convertAndSend(destination, message);
		} catch (Exception e) {
			LOGGER.error("发送消息失败" + message, e);
		}
	}
}
