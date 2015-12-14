package study.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import study.service.SimpleService;

@Controller
@RequestMapping("/test")
public class TestController {
	@Autowired
	private SimpleService simpleService;

	@ResponseBody
	@RequestMapping("/hw")
	public String testHelloWorld(String world) {
		return "hello, " + world;
	}

	@ResponseBody
	@RequestMapping("/testMethodAop")
	public String testSimpleService() {
		return simpleService.getName();
	}

	@ResponseBody
	@RequestMapping("/testAnnoAop")
	public String testAnnoAop() {
		return simpleService.testAnnotationAspect();
	}
}
