package study.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import study.component.TestInjectionComponent;

@Controller
@RequestMapping("/test")
public class TestController {
	@Autowired
	private TestInjectionComponent testInjectionComponent;
	
	@ResponseBody
	@RequestMapping("/hw")
	public String testHelloWorld(String world) {
		return "hello, " + world;
	}
	
	@ResponseBody
	@RequestMapping("/inject")
	public String testInjection() {
		return "a: " + testInjectionComponent.getTestProperty();
	}
}
