package study.service.impl;

import org.springframework.stereotype.Service;

import study.service.SimpleService;

@Service
public class SimpleServiceImpl implements SimpleService {

	@Override
	public String getName() {
		return "i'm simple";
	}

}
