package br.com.deveria.rabbitmqexample.service;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QueueConsumerService {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Autowired
	private Queue simpleMessageQueue;
	
	public String consumeSimpleMessage() {
		return (String) rabbitTemplate.receiveAndConvert(simpleMessageQueue.getName());
	}
}
