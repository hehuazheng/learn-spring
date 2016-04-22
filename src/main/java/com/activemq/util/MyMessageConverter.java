package com.activemq.util;

import java.io.Serializable;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;

public class MyMessageConverter implements MessageConverter {
	private static final Logger logger = LoggerFactory
			.getLogger(MyMessageConverter.class);

	public Object fromMessage(Message message) throws JMSException,
			MessageConversionException {
		if (message == null) {
			logger.error("message is not exist.");
			throw new JMSException("message is not exist.");
		}
		if ((message instanceof TextMessage)) {
			TextMessage tm = (TextMessage) message;
			return tm.getText();
		}
		if ((message instanceof ObjectMessage)) {
			ObjectMessage om = (ObjectMessage) message;
			return om.getObject();
		}
		logger.error("message is error.");
		throw new JMSException("message is error.");
	}

	public Message toMessage(Object obj, Session session) throws JMSException,
			MessageConversionException {
		if (obj == null) {
			logger.error("object is null.");
			throw new JMSException("object is null.");
		}
		if ((obj instanceof String)) {
			TextMessage tm = session.createTextMessage();
			tm.setText((String) obj);
			return tm;
		}
		if ((obj instanceof Serializable)) {
			ObjectMessage om = session.createObjectMessage();
			om.setObject((Serializable) obj);
			return om;
		}
		logger.error("(object instanceof Serializable) is false.");
		throw new JMSException("(object instanceof Serializable) is false.");
	}

}
