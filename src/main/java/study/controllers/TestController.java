package study.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import study.services.AsyncService;

@Controller
@RequestMapping("/test")
public class TestController {
	@Autowired
	private AsyncService asyncService;

	@ResponseBody
	@RequestMapping("/async")
	public String async(int id, String value) {
		asyncService.asyncUpdatSequence(id, value);
		return "async...";
	}
}
