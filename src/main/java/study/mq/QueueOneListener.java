package study.mq;

import java.io.UnsupportedEncodingException;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Service;

@Service
public class QueueOneListener implements MessageListener {
	@Override
	public void onMessage(Message msg) {
		try {
			String json = new String(msg.getBody(), "UTF-8");
			System.out.println(json);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("queue one: " + msg);
	}
}
