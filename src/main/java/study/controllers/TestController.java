package study.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import study.service.ActiveMqService;

@Controller
@RequestMapping("/test")
public class TestController {
	@Autowired
	private ActiveMqService activeMqService;

	@ResponseBody
	@RequestMapping("/hw")
	public String testHelloWorld(String world) {
		return "hello, " + world;
	}

	@ResponseBody
	@RequestMapping("/ss")
	public String testActiveMqService(String message) {
		activeMqService.sendMessage(message);
		return "succ";
	}
}
