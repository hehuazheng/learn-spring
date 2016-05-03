package study;

import org.springframework.context.ApplicationEvent;

public class MyEvent extends ApplicationEvent {
	private static final long serialVersionUID = 1L;
	private String eventName;

	public MyEvent(Object source) {
		super(source);
	}

	public MyEvent(Object source, String eventName) {
		super(source);
		this.eventName = eventName;
	}

	public String getEventName() {
		return eventName;
	}

}
