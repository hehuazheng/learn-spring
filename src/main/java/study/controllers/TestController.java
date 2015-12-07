package study.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import study.dao.mapper.Tb1Mapper;
import study.dao.model.Tb1;
import study.services.TransactionService;

import com.pj.common.db.annotation.Read;
import com.pj.common.db.annotation.Write;

@Controller
@RequestMapping("/test")
public class TestController {
	@Autowired
	private Tb1Mapper tb1Mapper;
	
	@Autowired
	private TransactionService transactionService;

	@ResponseBody
	@RequestMapping("/hw")
	public String testHelloWorld(String world) {
		return "hello, " + world;
	}

	@Read
	@ResponseBody
	@RequestMapping("/read")
	public Tb1 read(int id) {
		return tb1Mapper.selectByPrimaryKey(id);
	}

	@Write
	@ResponseBody
	@RequestMapping("/write")
	public Tb1 write(int id) {
		return tb1Mapper.selectByPrimaryKey(id);
	}
	
	@ResponseBody
	@RequestMapping("/testTransaction")
	public String testTransaction(int id) {
		transactionService.insert(id);
		return "succ";
	}
}
