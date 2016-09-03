package study.services.impl;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import study.services.ParentService;

@Component("comp1")
public class ParentService1Impl implements ParentService {

	@Override
	@Transactional(readOnly=false)
	public void insertA(int id) {
		System.out.println("try insert a");
		doInsertA(id);
		System.out.println("insert a end");
	}

	@Override
	@Transactional(readOnly=false)
	public void doInsertA(int id) {
		// TODO Auto-generated method stub
		
	}
	
	

}
