package study.service;

import study.dao.model.Tb1;

public interface TransactionService {
	Tb1 read(int id);
	Tb1 write(int id);
}
