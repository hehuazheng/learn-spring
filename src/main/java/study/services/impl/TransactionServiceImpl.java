package study.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.common.spring.helper.annotation.ReadWriteTransactional;
import study.services.Tb1TransactionService;
import study.services.Tb2TransactionService;
import study.services.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {
	@Autowired
	private Tb1TransactionService tb1TransactionService;

	@Autowired
	private Tb2TransactionService tb2TransactionService;

	@ReadWriteTransactional
	public void insertTest1(int start) {
		tb1TransactionService.insert(start);
		tb2TransactionService.insert(start);
	}

	//确认回滚tb2事务是否会引起tb1回滚
	@ReadWriteTransactional
	public void insertTest2(int start) {
		tb1TransactionService.insert(start);
		try {
			tb2TransactionService.insert(start);
		} catch (Exception e) {
			System.out.println("tb2 insert failure");
		}
	}

	@ReadWriteTransactional
	public void insertTest3(int start) {

	}
}
