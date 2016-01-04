package study.service;

public interface ActiveMqService {
	void sendQueueMessage(String message);

	void sendTopicMessage(String message);
}
