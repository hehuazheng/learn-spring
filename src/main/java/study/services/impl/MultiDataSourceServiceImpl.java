package study.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import study.dao.dependencysystem.mapper.Q2tb1Mapper;
import study.dao.dependencysystem.mapper.Q2tb2Mapper;
import study.dao.dependencysystem.model.Q2tb1;
import study.dao.dependencysystem.model.Q2tb2;
import study.dao.mapper.Tb1Mapper;
import study.dao.mapper.Tb2Mapper;
import study.dao.model.Tb1;
import study.dao.study2.mapper.S2tb1Mapper;
import study.dao.study2.mapper.S2tb2Mapper;
import study.dao.study2.model.S2tb1;
import study.dao.study2.model.S2tb2;
import study.services.MultiDataSourceService;
import study.services.TransactionService;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;

@Service
public class MultiDataSourceServiceImpl implements MultiDataSourceService {
	@Autowired
	private Tb1Mapper tb1Mapper;
	
	@Autowired
	private Tb2Mapper tb2Mapper;

	@Autowired
	private Q2tb1Mapper q2tb1Mapper;

	@Autowired
	private Q2tb2Mapper q2tb2Mapper;
	
	@Autowired
	private S2tb1Mapper s2tb1Mapper;
	
	@Autowired
	private S2tb2Mapper s2tb2Mapper;

	@Autowired
	private TransactionService transactionService;

	public String selectById(int id) {
		Tb1 tb1 = tb1Mapper.selectByPrimaryKey(id);
		Q2tb1 qtb1 = q2tb1Mapper.selectByPrimaryKey(id);
		return JSON.toJSONString(tb1) + ", " + JSON.toJSONString(qtb1);
	}

	@Transactional(value="transactionManager2", readOnly = false, isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
	public String updateById(int id, String value) {
		Q2tb1 q2tb1 = new Q2tb1();
		q2tb1.setId(id);
		q2tb1.setCol1("q2-" + value);
		Preconditions.checkArgument(q2tb1Mapper.updateByPrimaryKey(q2tb1) > 0);
		
		Tb1 tb1 = new Tb1();
		tb1.setId(id);
		tb1.setCol1(value);
		Preconditions.checkArgument(tb1Mapper.updateByPrimaryKey(tb1) > 0);

		Q2tb2 q2tb2 = new Q2tb2();
		q2tb2.setId(id);
		q2tb2.setCol1("q2-tb2-" + value);
		Preconditions.checkArgument(q2tb2Mapper.updateByPrimaryKey(q2tb2) > 0);

		return "succ";
	}

	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
	public String updateByIdOnSameInstance(int id, String value) {
		Tb1 tb1 = new Tb1();
		tb1.setId(id);
		tb1.setCol1(value);
		Preconditions.checkArgument(tb1Mapper.updateByPrimaryKey(tb1) > 0);
		
		
		S2tb1 s2tb1 = new S2tb1();
		s2tb1.setId(id);
		s2tb1.setCol1(value);
		Preconditions.checkArgument(s2tb1Mapper.updateByPrimaryKey(s2tb1) > 0);
		
		S2tb2 s2tb2 = new S2tb2();
		s2tb2.setId(id);
		s2tb2.setCol1(value);
		Preconditions.checkArgument(s2tb2Mapper.updateByPrimaryKey(s2tb2) > 0);
		
		return "succ";
	}

}
