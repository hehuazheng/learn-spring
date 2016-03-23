package study.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import study.services.AsyncWrapperService;

@Controller
@RequestMapping("/test")
public class TestController {
	@Autowired
	private AsyncWrapperService asyncWrapperService;

	@ResponseBody
	@RequestMapping("/async")
	public String async(int id, String value) {
		asyncWrapperService.wrap(id, value);
		return "async...";
	}
}
