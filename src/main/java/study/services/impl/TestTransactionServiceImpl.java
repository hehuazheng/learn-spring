package study.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import study.services.TestTransactionService;
import study.services.TransactionService;
import study.services.WrapperService;

@Service
public class TestTransactionServiceImpl implements TestTransactionService {
	@Autowired
	private TransactionService transactionService;

	@Autowired
	private WrapperService wrapperService;

	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
	public String addInto2Tables(int id) {
		transactionService.addIntoTb1(id);
		wrapperService.wrapInNewThread(id + 1);
		return "succ";
	}
}
