package it.uniba.dib.mfs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelpController {
	
	@GetMapping("/help")
	public String showHelpString () {
		return "help";
	}
	
	@GetMapping("/userGuide")
	public String showUserGuideString () {
		return "userGuide";
	}
	
	@GetMapping("/policy")
	public String showPolicyString () {
		return "policy";
	}
}
