package study.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import study.services.LoopInsertService;

@Controller
@RequestMapping("/test")
public class TestController {
	@Autowired
	private LoopInsertService loopInsertService;

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
}
