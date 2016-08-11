package study.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class TestController {
	@Autowired
	private AmqpTemplate amqpTemplate;

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
	@RequestMapping("/sendObj")
	public String testSendObj(String name, String msg) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("data", msg);
		amqpTemplate.convertAndSend(name, map);
		return "send";
	}
}
