package study.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import study.dao.dependencysystem.mapper.Q2tb1Mapper;
import study.dao.dependencysystem.model.Q2tb1;
import study.services.LoopInsertService;

@Controller
@RequestMapping("/test")
public class TestController {
	@Autowired
	private LoopInsertService loopInsertService;
	
	@Autowired
	private Q2tb1Mapper q2tb1Mapper;

	@ResponseBody
	@RequestMapping("/testTrac")
	public String testTransaction(String ids, int stop) {
		loopInsertService.insert(ids, stop);
		return "succ";
	}

	@ResponseBody
	@RequestMapping("/testTracNew")
	public String testTransactionRequiredNew(String ids, int stop) {
		loopInsertService.insertNew(ids, stop);
		return "succ";
	}
	
	@ResponseBody
	@RequestMapping("/q2select")
	public Q2tb1 selectDataInDependencySystem(int id) {
		Q2tb1 rec =  q2tb1Mapper.selectByPrimaryKey(id);
		return rec;
	}

	@ResponseBody
	@RequestMapping("/hw")
	public String testHelloWorld(String world) {
		return "hello, " + world;
	}
}
