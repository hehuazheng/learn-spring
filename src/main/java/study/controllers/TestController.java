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
		return "hel11o, " + world;
	}

	@ResponseBody
	@RequestMapping("/anno1")
	public String anno1() {
		return simpleService.anno1();
	}

	@ResponseBody
	@RequestMapping("/anno2")
	public String anno12() {
		return simpleService.annoBoth();
	}
}
