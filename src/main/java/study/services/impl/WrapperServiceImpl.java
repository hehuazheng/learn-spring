package study.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import study.services.TransactionService;
import study.services.WrapperService;

@Service
public class WrapperServiceImpl implements WrapperService {
	@Autowired
	private TransactionService transactionService;

	@Override
	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
	public void wrapInNewThread(final int id) {
		new Thread() {
			public void run() {
				System.out.println("in wrap service start");
				transactionService.addInto2Tables(id);
				System.out.println("in wrap service end");
			}
		}.start();
	}

}
