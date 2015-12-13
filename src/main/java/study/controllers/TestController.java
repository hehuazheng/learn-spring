package study.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import study.services.TransactionService;

@Controller
@RequestMapping("/test")
public class TestController {
	@Autowired
	private TransactionService transactionService;

	@ResponseBody
	@RequestMapping("/hw")
	public String testHelloWorld(String world) {
		return "hello, " + world;
	}

	@ResponseBody
	@RequestMapping("/transactionTest1")
	public String transactionTest1(int id) {
		transactionService.insertTest1(id);
		return "executed...";
	}

	@ResponseBody
	@RequestMapping("/transactionTest2")
	public String transactionTest2(int id) {
		transactionService.insertTest2(id);
		return "executed...";
	}
	
	@ResponseBody
	@RequestMapping("/transactionTest3")
	public String transactionTest3(int id) {
		transactionService.insertTest3(id);
		return "executed...";
	}
}
