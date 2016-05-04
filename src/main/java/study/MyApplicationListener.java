package study;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class MyApplicationListener implements
		ApplicationListener<ContextRefreshedEvent> {

	/**
	 * spring will use ContextLoaderListener as parent of applicationContext, so
	 * event will be fired twice, to avoid this problem, should check whether
	 * the event is fired by the super root or else.
	 */
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if (event.getApplicationContext().getParent() == null) {
			System.out.println("application started: "
					+ event.getApplicationContext().toString());
		}
	}

}
