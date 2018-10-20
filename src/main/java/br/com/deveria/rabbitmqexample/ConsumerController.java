package br.com.deveria.rabbitmqexample;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConsumerController {

	@RequestMapping(value="/consume", method=POST)
	public ModelAndView consume(@RequestParam String queueToConsume) {
		ModelAndView mv = new ModelAndView("welcome");
		mv.addObject("message", "Mensagem generica... fila: "+queueToConsume);
		return mv;
	}
}
