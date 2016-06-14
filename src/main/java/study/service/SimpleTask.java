package study.service;

import java.util.Comparator;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.taobao.pamirs.schedule.IScheduleTaskDealSingle;
import com.taobao.pamirs.schedule.TaskItemDefine;

public class SimpleTask implements IScheduleTaskDealSingle<String> {

	@Override
	public List<String> selectTasks(String taskParameter, String ownSign,
			int taskItemNum, List<TaskItemDefine> taskItemList,
			int eachFetchDataNum) throws Exception {
		System.out.println(ownSign + " " + taskItemNum + " "
				+ JSON.toJSONString(taskItemList) + " " + eachFetchDataNum);
		return Lists.newArrayList("one", "two", "three");
	}

	@Override
	public Comparator<String> getComparator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean execute(String task, String ownSign) throws Exception {
		System.out.println(new Date() + " " + task + " " + ownSign);
		return false;
	}

}
