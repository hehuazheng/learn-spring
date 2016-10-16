package study.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import study.anno.InTransaction;
import study.dao.mapper.Tb1Mapper;
import study.dao.mapper.Tb2Mapper;
import study.dao.model.Tb1;
import study.dao.model.Tb1Example;
import study.dao.model.Tb2;
import study.services.TransactionService;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
	@Autowired
	private Tb1Mapper tb1Mapper;

	@Autowired
	private Tb2Mapper tb2Mapper;

	// 1 private 事务不生效
	// 2 final 事务不生效
	public void insertIntoTwoTables(int id) {
		realTrick(id);
	}

	@Override
	public void read(int id) {
		System.out.println("start read " + id);
		try {
			Thread.sleep(30000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Tb1Example exp = new Tb1Example();
		exp.createCriteria().andIdEqualTo(id);
		List<Tb1> list = tb1Mapper.selectByExample(exp);
		System.out.println(list.size());
	}

	// @Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED,
	// rollbackFor = Exception.class)
	private void realTrick(int id) {
		try {
			Tb1 r = new Tb1();
			r.setId(id);
			r.setCol1("id " + id);
			tb1Mapper.insert(r);

			Tb2 tb2 = new Tb2();
			tb2.setId(id);
			tb2.setCol1("id " + id);
			tb2Mapper.insert(tb2);
		} catch (Exception e) {
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus()
			.setRollbackOnly();
		} finally {
		}
	}

	@InTransaction
	@Override
	public void updateById(int id, String val) {
		tb1Mapper.updateCol(id, val);
		if(id == 3) {
			throw new RuntimeException();
		}
	}
}
