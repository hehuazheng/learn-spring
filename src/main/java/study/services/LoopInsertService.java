package study.services;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoopInsertService {
	@Autowired
	private TransactionService transactionService;

	public void insert(String ids, int stop) {
		if (StringUtils.isNotEmpty(ids)) {
			int cnt = 0;
			for (String idStr : ids.split(",")) {
				try {
					cnt++;
					transactionService.insert(Integer.parseInt(idStr),
							cnt >= stop);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public String insertNew(String ids, int stop) {
		if (StringUtils.isNotEmpty(ids)) {
			int cnt = 0;
			for (String idStr : ids.split(",")) {
				try {
					cnt++;
					transactionService.insertRequiredNew(
							Integer.parseInt(idStr), cnt >= stop);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return "succ";
	}
}
