package study.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import study.dao.mapper.Tb1Mapper;
import study.dao.model.Tb1;

import com.pj.common.db.annotation.Read;
import com.pj.common.db.annotation.Write;

@Controller
@RequestMapping("/test")
public class TestController {
	@Autowired
	private Tb1Mapper tb1Mapper;

	@ResponseBody
	@RequestMapping("/hw")
	public String testHelloWorld(String world) {
		return "hello, " + world;
	}

	static class Pair {
		public Pair(int f, int s) {
			this.f = f;
			this.s = s;
		}

		public int getF() {
			return f;
		}

		public void setF(int f) {
			this.f = f;
		}

		public int getS() {
			return s;
		}

		public void setS(int s) {
			this.s = s;
		}

		int f;
		int s;
	}

	@ResponseBody
	@RequestMapping("/json")
	public Pair json() {
		return new Pair(1, 2);
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
}
