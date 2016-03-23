package study.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import study.annotation.S2ReadWriteTransactional;
import study.dao.mapper.Tb1Mapper;
import study.dao.mapper.Tb2Mapper;
import study.dao.model.Tb1;
import study.dao.model.Tb2;
import study.s2.dao.mapper.S2Tb1Mapper;
import study.s2.dao.model.S2Tb1;
import study.services.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {
	@Autowired
	private Tb1Mapper tb1Mapper;

	@Autowired
	private Tb2Mapper tb2Mapper;

	@Autowired
	private S2Tb1Mapper s2Tb1Mapper;

	// 1 private 事务不生效
	// 2 final 事务不生效
	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
	public void addInto2Tables(int id) {
		Tb1 r = new Tb1();
		r.setId(id);
		r.setCol1("id " + id);
		tb1Mapper.insert(r);

		Tb2 tb2 = new Tb2();
		tb2.setId(id);
		tb2.setCol1("id " + id);
		tb2Mapper.insert(tb2);
	}

	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
	public void addIntoTb1(int id) {
		Tb1 r = new Tb1();
		r.setId(id);
		r.setCol1("id " + id);
		tb1Mapper.insert(r);
	}

	@Override
	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
	public void addListIntoTb1(int startId, String value) {
		for (int i = startId; i < startId + 2; i++) {
			addInS1(i, value);
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

	@Override
	@S2ReadWriteTransactional
	public void addListIntoS2Tb1(int startId, String value) {
		for (int i = startId; i < startId + 2; i++) {
			addInS2(i, value);
		}
	}
}
