package study.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import study.services.RecordTimeService;
import study.services.TransactionService;

@Controller
@RequestMapping("/test")
public class TestController {
	@Autowired
	private TransactionService transactionService;

	@Autowired
	private RecordTimeService recordTimeService;

	@ResponseBody
	@RequestMapping("/testTrac")
	public String testTransaction(String id) {
		transactionService.insertIntoTwoTables(Integer.parseInt(id));
		return "succ";
	}

	@ResponseBody
	@RequestMapping("/hw")
	public String testHelloWorld(String world) {
		return "hello, " + world;
	}

	@ResponseBody
	@RequestMapping("/m1")
	public String testM1() {
		recordTimeService.m1();
		return "m1...";
	}
}
