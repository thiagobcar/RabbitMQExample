package br.com.deveria.rabbitmqexample.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.deveria.rabbitmqexample.service.QueueConsumerService;

@Controller
public class ConsumerController {

	@Autowired
	private QueueConsumerService queueConsumerService;
	
	@RequestMapping(value="/consume", method=POST)
	public ModelAndView consume() {
		ModelAndView mv = new ModelAndView("welcome");
		mv.addObject("message", queueConsumerService.consumeSimpleMessage());
		return mv;
	}
}
