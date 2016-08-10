package study.mq;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Service;

@Service
public class QueueOneListener implements MessageListener {
	@Override
	public void onMessage(Message msg) {
		System.out.println("queue one: " + msg);
	}
}
