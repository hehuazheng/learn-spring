package study.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hhz.multiple.transaction.service.MultipleTransactionService;

@Controller
@RequestMapping("/test")
public class TestController {
	@Autowired
	private MultipleTransactionService multipleTransactionService;
	
	@ResponseBody
	@RequestMapping("/m1")
	public String multipleTest(int id) {
		multipleTransactionService.multipleTransactionTest(id);
		return "m1...";
	}
}
