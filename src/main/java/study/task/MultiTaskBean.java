package study.task;

import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.taobao.pamirs.schedule.IScheduleTaskDealMulti;
import com.taobao.pamirs.schedule.TaskItemDefine;

@Component
public class MultiTaskBean implements IScheduleTaskDealMulti<String> {

	@Override
	public List<String> selectTasks(String taskParameter, String ownSign,
			int taskItemNum, List<TaskItemDefine> taskItemList,
			int eachFetchDataNum) throws Exception {
		System.out.println(JSON.toJSONString(taskItemList));
		return Lists.newArrayList("a","b", "c");
	}

	@Override
	public Comparator<String> getComparator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean execute(String[] tasks, String ownSign) throws Exception {
		for(String task : tasks) {
			System.out.println(task);
		}
		return true;
	}
	
}
