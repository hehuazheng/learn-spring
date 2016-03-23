package study.services;

public interface TransactionService {
	void addIntoTb1(int id);

	void addInto2Tables(int id);

	void addListIntoTb1(int startId, String value);

	void addListIntoS2Tb1(int startId, String value);
}
