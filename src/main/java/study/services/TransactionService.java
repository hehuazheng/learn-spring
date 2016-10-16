package study.services;

public interface TransactionService {
	void insertIntoTwoTables(int id);

	void updateById(int id, String val);

	void read(int id);
}
