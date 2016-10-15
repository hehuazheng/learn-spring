package study.dao.mapper;

import java.util.List;

import study.dao.model.Tb1;

public interface Tb1Mapper {
	List<Tb1> selectAll();
	
	int updateStatusById(int id);
}
