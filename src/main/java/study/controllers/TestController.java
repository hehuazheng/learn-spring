package study.controllers;

import java.util.Enumeration;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.QueueBrowser;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.BrowserCallback;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import study.service.ActiveMqService;

@Controller
@RequestMapping("/test")
public class TestController {
	@Autowired
	private ActiveMqService activeMqService;
	
	@Resource(name="myTemplate")
	private JmsTemplate jmsTemplate;
	
	@ResponseBody
	@RequestMapping("/hw")
	public String testHelloWorld(String world) {
		return "hello, " + world;
	}

	@ResponseBody
	@RequestMapping("/qsend")
	public String testActiveMqService(String message) {
		activeMqService.sendQueueMessage(message);
		return "succ";
	}

	@ResponseBody
	@RequestMapping("/tsend")
	public String testSendTopicActiveMqService(String message) {
		activeMqService.sendTopicMessage(message);
		return "succ";
	}
	
	@ResponseBody
	@RequestMapping("/q")
	public String q1() {
		int total = jmsTemplate.browse("testQueue1", new BrowserCallback<Integer>() {
			@Override
			public Integer doInJms(Session session, QueueBrowser browser)
					throws JMSException {
				Enumeration enum1 = browser.getEnumeration();
				int total = 0;
				while(enum1.hasMoreElements()) {
					enum1.nextElement();
					total++;
				}
				return total;
			}
		});
		return "t " + total;
	}
}
