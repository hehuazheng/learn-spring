package study.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import study.dao.mapper.Tb1Mapper;
import study.dao.model.Tb1;
import study.service.RepeatableReadService;

import com.pj.common.db.annotation.Read;
import com.pj.common.db.annotation.Write;

@Controller
@RequestMapping("/test")
public class TestController {
	@Autowired
	private Tb1Mapper tb1Mapper;

	@Autowired
	private RepeatableReadService repeatableReadService;

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

	@ResponseBody
	@RequestMapping("/rread")
	public void repeatableRead(int id, int times) {
		repeatableReadService.repeatableRead(id, times);
	}

	@Write
	@ResponseBody
	@RequestMapping("/write")
	public Tb1 write(int id) {
		return tb1Mapper.selectByPrimaryKey(id);
	}
}
