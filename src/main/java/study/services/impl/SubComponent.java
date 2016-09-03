package study.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import study.dao.mapper.Tb1Mapper;
import study.dao.model.Tb1;

@Component("comp2")
public class SubComponent extends ParentService1Impl {
	@Autowired
	private Tb1Mapper tb1Mapper;
	
	@Override
	@Transactional(readOnly=false)
	public void doInsertA(int id) {
		System.out.println("do before insert");
		addIntoTb1(id);
		System.out.println("do after insert");
	}
	
	public void addIntoTb1(int id) {
		Tb1 r = new Tb1();
		r.setId(id);
		r.setCol1("id " + id);
		tb1Mapper.insert(r);
	}
}
