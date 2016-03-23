package study.services.impl;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.services.AsyncService;
import study.services.AsyncWrapperService;

@Service
public class AsyncWrapServiceImpl implements AsyncWrapperService {
	@Autowired
	private AsyncService asyncService;

	@Override
	public String wrap(final int id, final String value) {
		Callable<String> callable = new Callable<String>() {
			@Override
			public String call() throws Exception {
				return asyncService.asyncUpdatSequence(id, value);
			}
		};
		FutureTask<String> future = new FutureTask<String>(callable);
		new Thread(future).start();
		try {
			return future.get();
		} catch (Exception e) {
			e.printStackTrace();
			return "exception";
		}
	}

}
