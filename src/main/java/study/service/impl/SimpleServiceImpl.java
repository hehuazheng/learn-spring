package study.service.impl;

import org.springframework.stereotype.Service;

import study.annotation.Interceptor1;
import study.annotation.Interceptor2;
import study.service.SimpleService;

@Service
public class SimpleServiceImpl implements SimpleService {
	@Interceptor1
	public String anno1() {
		return "anno1";
	}

	@Interceptor1
	@Interceptor2
	public String annoBoth() {
		return "anno2";
	}
}
