package study.service.impl;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import study.service.ActiveMqService;

@Service
public class ActiveMqServiceImpl implements ActiveMqService {
	@Autowired
	private JmsTemplate jmsTemplate;

	@Override
	public void sendMessage(final String message) {
		jmsTemplate.send(new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				System.out.println(Thread.currentThread().getName() + "发送消息"
						+ message);
				return session.createTextMessage(message);
			}
		});
	}

}
