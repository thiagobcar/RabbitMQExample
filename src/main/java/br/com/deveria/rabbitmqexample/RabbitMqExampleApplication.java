package br.com.deveria.rabbitmqexample;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableRabbit
public class RabbitMqExampleApplication {
	
	@Value("${queue.simplemessage.name}")
	private String simpleMessageQueueName;
	
	public static void main(String[] args) {
		SpringApplication.run(RabbitMqExampleApplication.class, args);
	}
	
	@Bean
    public Queue simpleMessageQueue() {
        return new Queue(simpleMessageQueueName, true);
    }
}
