package br.com.deveria.rabbitmqexample.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.deveria.rabbitmqexample.service.QueueSenderService;

@Controller
public class SenderController {
	
	@Autowired
	private QueueSenderService queueSenderService;

	@RequestMapping(value="/send", method=POST)
	public ModelAndView send(@RequestParam String queueName,
			@RequestParam String message,
			@RequestParam Integer times) {
		ModelAndView mv = new ModelAndView("redirect:/");
		String result = null;
		try {
			queueSenderService.sendMessage(queueName, times, message);
			result = "enviado";
		} catch (Exception e) {
			result = "Falha ao enviar! Erro:"+e.getMessage();
		}
		mv.addObject("senderResult", result);
		return mv;
	}
}
