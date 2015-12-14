package study.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import study.dao.mapper.Tb1Mapper;
import study.dao.mapper.Tb2Mapper;
import study.dao.model.Tb1;
import study.dao.model.Tb2;

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
}