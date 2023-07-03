package it.uniba.dib.mfs.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.uniba.dib.mfs.model.SystemFeedback;
import it.uniba.dib.mfs.service.ISystemFeedbackService;

@Controller
public class SystemFeedbackController {

	@Autowired
	private ISystemFeedbackService systemFeedbackService;
	
	@GetMapping("/systemFeedbackPage")
	public String showSystemFeedback(ModelMap model) {
		return "systemFeedbackPage";
	}
	
	@GetMapping("/add-systemFeedback")
	public String showAddSystemFeedbackPage(ModelMap model) {
		model.addAttribute("systemFeedback", new SystemFeedback());
		return "systemFeedback";
	}
	
	@PostMapping("/add-systemFeedback")
	public String addSystemFeedback(ModelMap model, @Valid SystemFeedback systemFeedback, BindingResult result) {
		
		if(result.hasErrors()) {
			return "systemFeedback";
		}
		
		systemFeedbackService.saveSystemFeedback(systemFeedback);
		return"redirect:/systemFeedbackPage";
	}
	
	@GetMapping("/listSystemFeedbackMod")
	public String viewSystemFeedback(ModelMap model) {
		 model.addAttribute("feedbackList", systemFeedbackService.getAllSystemFeedback());
		return "listSystemFeedbackMod";
	}
	
	@PostMapping("/delete-systemFeedback")
	public String deleteSystemFeedback(ModelMap model, @RequestParam long id) {
	    systemFeedbackService.deleteSystemFeedback(id);
	    return "redirect:/listSystemFeedbackMod";
	}
	
}
