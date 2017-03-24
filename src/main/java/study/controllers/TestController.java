package study.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import study.service.SimpleService;

@Controller
@RequestMapping("/test")
public class TestController {
	private static final Logger LOG = LoggerFactory.getLogger(TestController.class);

	@Autowired
	private SimpleService simpleService;

	@ResponseBody
	@RequestMapping("/hw")
	public String testHelloWorld(String world) {
		return "hello, " + world;
	}

	@ResponseBody
	@RequestMapping("/ss")
	public String testSimpleService() {
		return simpleService.getName();
	}

	@ResponseBody
	@RequestMapping("/log")
	public String logOut() {
		LOG.info("test");
		return "suc";
	}
}
