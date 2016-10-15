package study.task;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import study.dao.mapper.Tb1Mapper;
import study.dao.model.Tb1;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.taobao.pamirs.schedule.IScheduleTaskDealMulti;
import com.taobao.pamirs.schedule.TaskItemDefine;

@Component
public class MultiTaskBean implements IScheduleTaskDealMulti<Tb1> {
	@Autowired
	private Tb1Mapper tb1Mapper;
	
	@Override
	public List<Tb1> selectTasks(String taskParameter, String ownSign,
			int taskItemNum, List<TaskItemDefine> taskItemList,
			int eachFetchDataNum) throws Exception {
		System.out.println(JSON.toJSONString(taskItemList));
		List<Tb1> list = tb1Mapper.selectAll();
		return list;
	}

	@Override
	public Comparator<Tb1> getComparator() {
		return null;
	}

	@Override
	public boolean execute(Tb1[] tasks, String ownSign) throws Exception {
		for(Tb1 task : tasks) {
			tb1Mapper.updateStatusById(task.getId());
		}
		return true;
	}
	
}
