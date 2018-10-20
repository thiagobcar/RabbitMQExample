package br.com.deveria.rabbitmqexample.service;

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
	
	public void sendSimpleMessage(String message) throws Exception {
		if(message != null && !message.isEmpty()) {			
			rabbitTemplate.convertAndSend(simpleMessageQueue.getName(), message);
		} else {
			throw new Exception("mensagem vazia");
		}
	}
}
