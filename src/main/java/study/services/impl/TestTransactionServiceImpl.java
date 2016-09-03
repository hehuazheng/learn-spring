package study.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.dao.mapper.Tb1Mapper;
import study.dao.model.Tb1;
import study.s2.dao.mapper.S2Tb1Mapper;
import study.s2.dao.model.S2Tb1;
import study.services.TestTransactionService;

@Service
public class TestTransactionServiceImpl implements TestTransactionService {
	@Autowired
	private Tb1Mapper tb1Mapper;
	@Autowired
	private S2Tb1Mapper s2Tb1Mapper;
	
	@Override
	public void addIn2Db(int startId, String value, int type) {
		addInS1(startId, value);
		if(type == 1) {
			throw new RuntimeException("e1");
		}
		addInS2(startId, value);
		if(type == 2) {
			throw new RuntimeException("e2");
		}
		addInS1(startId+1, value);
		if(type == 3) {
			throw new RuntimeException("e2");
		}
		addInS2(startId+1, value);
		if(type == 4) {
			throw new RuntimeException("e2");
		}
	}
	
	private void addInS1(int startId, String value) {
		Tb1 tb1 = new Tb1();
		tb1.setId(startId);
		tb1.setCol1(value + startId);
		tb1Mapper.insert(tb1);
	}
	
	private void addInS2(int startId, String value) {
		S2Tb1 s2tb1 = new S2Tb1();
		s2tb1.setId(startId);
		s2tb1.setCol1(value + startId);
		s2Tb1Mapper.insert(s2tb1);
	}
}
