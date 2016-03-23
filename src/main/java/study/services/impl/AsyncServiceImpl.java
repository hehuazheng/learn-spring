package study.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.dao.mapper.Tb1Mapper;
import study.dao.model.Tb1;
import study.services.AsyncService;

@Service
public class AsyncServiceImpl implements AsyncService {
	@Autowired
	private Tb1Mapper tb1Mapper;

	@Override
	public String asyncUpdatSequence(int id, String value) {
		Tb1 tb1 = new Tb1();
		tb1.setId(id);
		tb1.setCol1(value);
		tb1Mapper.updateByPrimaryKeySelective(tb1);
		return "success";
	}

}
