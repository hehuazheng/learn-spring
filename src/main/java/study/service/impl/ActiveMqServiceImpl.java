package study.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import study.service.ActiveMqService;

import com.activemq.util.MyMessageProducer;

@Service
public class ActiveMqServiceImpl implements ActiveMqService {
	@Resource(name="testQueueProducer")
	private MyMessageProducer testQueueProducer;
	
	@Resource(name="testTopicProducer")
	private MyMessageProducer testTopicProducer;

	@Override
	public void sendQueueMessage(String message) {
		testQueueProducer.send(message);
	}

	@Override
	public void sendTopicMessage(String message) {
		testTopicProducer.send(message);
	}
}
