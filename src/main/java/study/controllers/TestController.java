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
	@RequestMapping("/t1")
	public String testInsert(int id, String val) {
		try {
			transactionService.updateById(id, val);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "exec";
	}

	@ResponseBody
	@RequestMapping("/read")
	public String testRead(int id) {
		transactionService.read(id);
		return "read completed.";
	}
}
