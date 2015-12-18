package study.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.dao.mapper.Tb1Mapper;
import study.dao.model.Tb1;
import study.service.RepeatableReadService;

import com.alibaba.fastjson.JSON;
import com.pj.common.db.annotation.Read;

@Service
public class RepeatableReadServiceImpl implements RepeatableReadService {
	@Autowired
	private Tb1Mapper tb1Mapper;

	@Read
	public void repeatableRead(int id, int times) {
		for (int i = 0; i < times; i++) {
			Tb1 tb1 = tb1Mapper.selectByPrimaryKey(id);
			System.out.println("times: " + i + " " + JSON.toJSONString(tb1));
		}
	}
}
