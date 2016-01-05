package study.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.dao.mapper.Tb1Mapper;
import study.dao.model.Tb1;
import study.service.TransactionService;

import com.hhz.spring.db.annotation.Read;
import com.hhz.spring.db.annotation.ReadWriteTransactional;
import com.hhz.spring.db.annotation.Write;

@Service
public class TransactionServiceImpl implements TransactionService {
	@Autowired
	private Tb1Mapper tb1Mapper;

	@Override
	@Read
	@ReadWriteTransactional
	public Tb1 read(int id) {
		return tb1Mapper.selectByPrimaryKey(id);
	}

	@Override
	@Write
	@ReadWriteTransactional
	public Tb1 write(int id) {
		return tb1Mapper.selectByPrimaryKey(id);
	}
}
