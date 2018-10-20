package br.com.deveria.rabbitmqexample;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SenderController {

	@RequestMapping(value="/send", method=POST)
	public void send(@RequestParam String queue, @RequestParam String message) {
		System.out.println(queue);
		System.out.println(message);
	}
}
