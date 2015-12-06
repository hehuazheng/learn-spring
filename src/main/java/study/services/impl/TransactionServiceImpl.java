package study.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.google.common.base.Preconditions;

import study.dao.mapper.Tb1Mapper;
import study.dao.mapper.Tb2Mapper;
import study.dao.model.Tb1;
import study.dao.model.Tb2;
import study.services.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {
	@Autowired
	private Tb1Mapper tb1Mapper;

	@Autowired
	private Tb2Mapper tb2Mapper;

	// 1 private 事务不生效
	// 2 final 事务不生效
	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
	public void insert(int id, boolean rollback) {
		realTrick(id, rollback);
	}

	// @Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED,
	// rollbackFor = Exception.class)
	private void realTrick(int id, boolean rollback) {
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
		} finally {
			if (rollback) {
				TransactionAspectSupport.currentTransactionStatus()
						.setRollbackOnly();
			}
		}
	}

	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public void insertRequiredNew(int id, boolean rollback) {
		realTrick(id, rollback);
	}

	public void testPrivateMethodTransaction(int id, String value) {
		privateMethodTransaction(id, value);
	}
	
	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
	private void privateMethodTransaction(int id, String value) {
		Tb1 tb1 = new Tb1();
		tb1.setId(id);
		tb1.setCol1("tb1-" + value);
		Preconditions.checkArgument(tb1Mapper.updateByPrimaryKey(tb1) > 0);

		Tb2 tb2 = new Tb2();
		tb2.setId(id);
		tb2.setCol1("tb2-" + value);
		Preconditions.checkArgument(tb2Mapper.updateByPrimaryKey(tb2) > 0);
	}

	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
	public final void testFinalMethodTransaction(int id, String value) {
		Tb1 tb1 = new Tb1();
		tb1.setId(id);
		tb1.setCol1("tb1-" + value);
		Preconditions.checkArgument(tb1Mapper.updateByPrimaryKey(tb1) > 0);

		Tb2 tb2 = new Tb2();
		tb2.setId(id);
		tb2.setCol1("tb2-" + value);
		Preconditions.checkArgument(tb2Mapper.updateByPrimaryKey(tb2) > 0);
	}
}
