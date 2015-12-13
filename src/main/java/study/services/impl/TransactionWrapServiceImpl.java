package study.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import study.common.Callback;
import study.services.TransactionWrapperService;

@Service
public class TransactionWrapServiceImpl implements TransactionWrapperService {

	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public Object wrap(Callback callback) {
		return callback.call();
	}

}
