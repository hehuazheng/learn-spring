package com.hhz.multiple.transaction.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import study.services.TransactionService;

import com.hhz.multiple.transaction.service.MultipleTransactionService;

@Service
public class MultipleTransactionServiceImpl implements
		MultipleTransactionService {
	@Autowired
	private TransactionService transactionService;

	@Override
	@Transactional(isolation=Isolation.READ_COMMITTED)
	public void multipleTransactionTest(int id) {
		transactionService.addInto2Tables(id);
	}

}
