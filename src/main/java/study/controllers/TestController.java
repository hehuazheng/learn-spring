package study.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

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

	@Resource
	private SimpleDateFormat dateformat;

	@ResponseBody
	@RequestMapping("/hw")
	public String testHelloWorld(String world) {
		myApplicationContextAware.publishEvent(world);
		return "hello, " + world;
	}

	@ResponseBody
	@RequestMapping("/ns")
	public String testNs() {
		String dateStr = dateformat.format(new Date());
		System.out.println(dateStr);
		return dateStr;
	}
}
