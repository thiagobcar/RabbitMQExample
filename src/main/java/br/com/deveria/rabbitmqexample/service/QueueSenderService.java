package br.com.deveria.rabbitmqexample.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QueueSenderService {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Autowired
	private Queue simpleMessageQueue;
	
	@Autowired
	private Queue autoConsumeQueue;
	
	private List<String> queueNamesList;
	
	@PostConstruct
	public void init() {
		queueNamesList = new ArrayList<>();
		getQueueNamesList().add(simpleMessageQueue.getName());
		getQueueNamesList().add(autoConsumeQueue.getName());
	}

	public List<String> getQueueNamesList() {
		return queueNamesList;
	}
	
	public void sendMessage(String queueName, Integer numberOfMessages, String message) throws Exception {
		
		if(message == null || message.isEmpty()) {
			throw new Exception("empty message");
		}
		
		if(queueName == null || queueName.isEmpty()) {
			throw new Exception("select one queue");
		}
		
		for (int i = 0; i < numberOfMessages; i++) {
			rabbitTemplate.convertAndSend(queueName, message);
		}
	}
}
