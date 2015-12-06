package study.services;

public interface MultiDataSourceService {
	String selectById(int id);
	
	String updateById(int id, String value);
	
	String updateByIdOnSameInstance(int id, String value);
}
