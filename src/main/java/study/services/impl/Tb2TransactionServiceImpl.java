package study.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.common.spring.helper.annotation.ReadWriteTransactional;
import study.dao.mapper.OpLogMapper;
import study.dao.mapper.Tb2Mapper;
import study.dao.model.OpLog;
import study.dao.model.Tb2;
import study.services.Tb2TransactionService;

@Service
public class Tb2TransactionServiceImpl implements Tb2TransactionService {
	@Autowired
	private OpLogMapper opLogMapper;

	@Autowired
	private Tb2Mapper tb2Mapper;

	@ReadWriteTransactional
	public void insert(int id) {
		Tb2 record = new Tb2();
		record.setId(id);
		record.setCol1("col" + id);
		tb2Mapper.insertSelective(record);
		OpLog log = new OpLog();
		log.setTableName("tb2");
		log.setType("insert");
		opLogMapper.insertSelective(log);
	}
}
