package study.service.impl;

import org.springframework.stereotype.Service;

import study.annotation.AnnotationAop;
import study.service.SimpleService;

@Service
public class SimpleServiceImpl implements SimpleService {

	@Override
	public String getName() {
		return "i'm simple";
	}

	@Override
	@AnnotationAop("Anno in SimpleServiceImpl")
	public String testAnnotationAspect() {
		return "should be in annotation aop";
	}

}
