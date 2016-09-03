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
	@RequestMapping("/addIn2Db")
	public String testAddIn2Db(int startId, String value, int type) {
		testTransactionService.addIn2Db(startId, value, type);
		return "m1...";
	}
}
