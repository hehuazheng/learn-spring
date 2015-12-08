package study.services.impl;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

import study.services.RecordTimeService;

@Service
public class RecordTimeServiceImpl implements RecordTimeService {

	@Override
	public void m1() {
		System.out.println("in m1()");
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
		}
	}

	@Override
	public void m2() {
		System.out.println("in m2()");
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
		}
	}

}
