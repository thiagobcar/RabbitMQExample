package br.com.deveria.rabbitmqexample.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class QueueConsumerService {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Autowired
	private Queue simpleMessageQueue;
	
	@Autowired
	private Queue autoConsumeQueue;
	
	private static final Logger logger = LoggerFactory.getLogger(QueueConsumerService.class);
	
	public String consumeSimpleMessage() {
		String queueAndValue = simpleMessageQueue.getName()+": "
				+ (String) rabbitTemplate.receiveAndConvert(simpleMessageQueue.getName());
		return queueAndValue;
	}
	
	@RabbitListener(queues = "${queue.autoconsume.name}")
	public void autoConsumeMessage(@Payload String message) {
		logger.info(autoConsumeQueue.getName()+": "+message);
	}
}
