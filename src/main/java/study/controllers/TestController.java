package study.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import study.services.TestTransactionService;
import study.services.TransactionService;

@Controller
@RequestMapping("/test")
public class TestController {
	@Autowired
	private TransactionService transactionService;

	@Autowired
	private TestTransactionService testTransactionService;
	
	@ResponseBody
	@RequestMapping("/testAdd")
	public String testAddInto2TablesTransaction(String id) {
		testTransactionService.addInto2Tables(Integer.parseInt(id));
		return "succ";
	}
	
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

}
