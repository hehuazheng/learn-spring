package study.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.common.spring.helper.annotation.ReadWriteTransactional;
import study.dao.mapper.OpLogMapper;
import study.dao.mapper.Tb1Mapper;
import study.dao.model.OpLog;
import study.dao.model.Tb1;
import study.services.Tb1TransactionService;

@Service
public class Tb1TransactionServiceImpl implements Tb1TransactionService {
	@Autowired
	private OpLogMapper opLogMapper;

	@Autowired
	private Tb1Mapper tb1Mapper;

	@ReadWriteTransactional
	public void insert(int id) {
		Tb1 record = new Tb1();
		record.setId(id);
		record.setCol1("col" + id);
		tb1Mapper.insertSelective(record);
		OpLog log = new OpLog();
		log.setTableName("tb1");
		log.setType("insert");
		opLogMapper.insertSelective(log);
	}

}
