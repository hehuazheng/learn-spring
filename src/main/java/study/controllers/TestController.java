package study.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import study.MyApplicationContextAware;

@Controller
@RequestMapping("/test")
public class TestController {
	@Autowired
	private MyApplicationContextAware myApplicationContextAware;

	@ResponseBody
	@RequestMapping("/hw")
	public String testHelloWorld(String world) {
		myApplicationContextAware.publishEvent(world);
		return "hello, " + world;
	}
}
