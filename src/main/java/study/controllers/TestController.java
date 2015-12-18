package study.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import study.dao.mapper.Tb1Mapper;
import study.dao.model.Tb1;
import study.dao.model.Tb1Example;
import study.services.TransactionService;

@Controller
@RequestMapping("/test")
public class TestController {
	@Autowired
	private TransactionService transactionService;
	
	@Autowired
	private Tb1Mapper tb1Mapper;

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
	
	@ResponseBody
	@RequestMapping("/s")
	public String query() {
		List<Tb1> tb1List = tb1Mapper.selectByExample(new Tb1Example());
		System.out.println(tb1List);
		tb1List.remove(0);
		System.out.println(tb1List);
		return "succ";
	}
}
