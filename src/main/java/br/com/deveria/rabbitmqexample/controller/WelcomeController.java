package br.com.deveria.rabbitmqexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.deveria.rabbitmqexample.service.QueueSenderService;

@Controller
public class WelcomeController {
	
	@Autowired
	public QueueSenderService queueSenderService;
	
	@RequestMapping(value="/")
	public ModelAndView welcome(@RequestParam(required=false) String senderResult,
			@RequestParam(required=false) String consumedMessage) {
		ModelAndView mv = new ModelAndView("welcome");
		mv.addObject("queueNamesList", queueSenderService.getQueueNamesList());
		mv.addObject("senderResult", senderResult);
		mv.addObject("consumedMessage", consumedMessage);
		return mv;
	}
}
