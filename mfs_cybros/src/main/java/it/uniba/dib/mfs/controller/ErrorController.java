package it.uniba.dib.mfs.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@Controller("error")
public class ErrorController {

	@ExceptionHandler(Exception.class)
	public ModelAndView handlException(HttpServletRequest request, Exception ex) {
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("exception", ex.getLocalizedMessage());
		mv.addObject("url", request.getRequestURL());
		
		mv.setViewName("error");
		return mv;
	}

	public void addError(ModelMap model, String errorMessage) {
		model.addAttribute("errorMessage", errorMessage);
	}
		
	

}
