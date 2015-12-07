package study.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.dao.mapper.Tb1Mapper;
import study.dao.mapper.Tb2Mapper;
import study.dao.model.Tb1;
import study.dao.model.Tb2;
import study.services.TestTransactionService;

@Service
public class TestTransactionServiceImpl implements TestTransactionService {
	@Autowired
	private Tb1Mapper tb1Mapper;

	@Autowired
	private Tb2Mapper tb2Mapper;

	public String addInto2Tables(int id) {
		Tb1 r = new Tb1();
		r.setId(id);
		r.setCol1("id " + id);
		tb1Mapper.insert(r);

		Tb2 tb2 = new Tb2();
		tb2.setId(id);
		tb2.setCol1("id " + id);
		tb2Mapper.insert(tb2);
		return "succ";
	}
}
