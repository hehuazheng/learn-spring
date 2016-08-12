package study.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.secoo.arch.rabbitmq.RabbitJmsMessageSender;

@Controller
@RequestMapping("/test")
public class TestController {
	@Autowired
	private AmqpTemplate amqpTemplate;
	
	@Autowired
	private RabbitJmsMessageSender messageSender;

	@ResponseBody
	@RequestMapping("/hw")
	public String testHelloWorld(String world) {
		return "hello, " + world;
	}

	@ResponseBody
	@RequestMapping("/send")
	public String testSendMsg(String name, String msg) {
		amqpTemplate.convertAndSend(name, msg);
		return "send";
	}
	
	@ResponseBody
	@RequestMapping("/send1")
	public String testSendMsg1(String name, String msg) {
		messageSender.send(name, msg);
		return "send";
	}
	
	@ResponseBody
	@RequestMapping("/send2")
	public String testSendMsg2(String name, String msg) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("data", msg);
		messageSender.sendJson(name, map);
		return "send";
	}
	
	@ResponseBody
	@RequestMapping("/sendObj")
	public String testSendObj(String name, String msg) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("data", msg);
		amqpTemplate.convertAndSend(name, map);
		return "send";
	}
}
