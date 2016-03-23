package study.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import study.services.TestTransactionService;

@Controller
@RequestMapping("/test")
public class TestController {
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
		testTransactionService.addInto2Tables(Integer.parseInt(id));
		return "succ";
	}

	@ResponseBody
	@RequestMapping("/hw")
	public String testHelloWorld(String world) {
		return "hello, " + world;
	}

	@ResponseBody
	@RequestMapping("/addIn2Db")
	public String testAddIn2Db(int startId, String value) {
		testTransactionService.addIn2Db(startId, value);
		return "m1...";
	}
}
