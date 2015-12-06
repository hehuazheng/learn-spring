package study.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import study.dao.dependencysystem.mapper.Q2tb1Mapper;
import study.dao.dependencysystem.model.Q2tb1;
import study.services.MultiDataSourceService;
import study.services.TransactionService;

@Controller
@RequestMapping("/test")
public class TestController {
	@Autowired
	private Q2tb1Mapper q2tb1Mapper;
	
	@Autowired
	private MultiDataSourceService multiDataSourceService;
	
	@Autowired
	private TransactionService transactionService;
	
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
	
	@ResponseBody
	@RequestMapping("selectFromMultiDS")
	public String testSelectFromMultiDS(int id) {
		return multiDataSourceService.selectById(id);
	}
	
	@ResponseBody
	@RequestMapping("multiDSTran")
	public String testMultiDatasourceTransaction(int id, String value) {
		return multiDataSourceService.updateById(id, value);
	}
	
	@ResponseBody
	@RequestMapping("multiDSSameInstanceTran")
	public String testMultiDatasourceOnSameInstanceTransaction(int id, String value) {
		return multiDataSourceService.updateByIdOnSameInstance(id, value);
	}
	
	@ResponseBody
	@RequestMapping("testPrivateTransaction") 
	public String testPrivateMethodTransaction(int id, String value) {
		transactionService.testPrivateMethodTransaction(id, value);
		return "succ";
	}
	
	@ResponseBody
	@RequestMapping("testFinalTransaction") 
	public String testFinalTransaction(int id, String value) {
		transactionService.testFinalMethodTransaction(id, value);
		return "succ";
	}
	
}
