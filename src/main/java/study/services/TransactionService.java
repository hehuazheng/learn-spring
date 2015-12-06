package study.services;

public interface TransactionService {
	void insert(int id, boolean rollback);

	void insertRequiredNew(int id, boolean rollback);
	
	void testPrivateMethodTransaction(int id, String value);
	
	void testFinalMethodTransaction(int id, String value);
}
