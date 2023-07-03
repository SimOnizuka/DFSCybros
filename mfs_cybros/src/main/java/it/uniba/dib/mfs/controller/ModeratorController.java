package it.uniba.dib.mfs.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniba.dib.mfs.model.Moderator;
import it.uniba.dib.mfs.service.IModeratorService;

@Controller
public class ModeratorController {
	
	@Autowired
	private IModeratorService moderatorService;
	
	@GetMapping("/moderatorPage")
	public String index(ModelMap model) {
		model.addAttribute("name", getLoggedinUserName());
		return "moderatorPage";
	}
	
	@GetMapping("/registration")
	public String showRegistrationPage (ModelMap model) {
		model.addAttribute("moderator", new Moderator ());
		return "registrationPage";
	}
	
	@PostMapping("/registration")
	public String registration(ModelMap model, @Valid Moderator moderator, BindingResult result) {
		if(result.hasErrors()) {
			//valid error
			return "registrationPage";
		}
		try { //duplicate mail error
			moderatorService.saveModerator(moderator);
		} catch (IllegalArgumentException e) {
			String errorMessage = "Errore registrazione, email gia' esistente";
			model.addAttribute("errorMessage", errorMessage);
			return "error";
		}
		return "login"; //registration done!
	}
	
	
	//gestione profilo Moderatore
	@GetMapping("/profilePage")
	public String profile(ModelMap model) {
	model.addAttribute("name", getLoggedinUserName());
	model.addAttribute("moderator", moderatorService.findByEmailString(getLoggedinUserName()));
		return "profilePage";
	}
	
	@PostMapping("/profilePage")
	public String manageProfile(ModelMap model, @Valid Moderator moderator, BindingResult result) {
		if (result.hasErrors()) {
			return "redirect:/profilePag";
		}
		return "redirect:/profilePag";
	}
	
	@GetMapping("/updateProfile")
	public String showUpdateProfilePage(ModelMap model){
		Moderator moderator = moderatorService.findByEmailString(getLoggedinUserName());
		model.put("moderator", moderator);
		return "registrationPage";
	}
	
	@PostMapping("/updateProfile")
	public String updateProfile(ModelMap model, @Valid Moderator moderator, BindingResult result) {
		if (result.hasErrors()) {
			return "updateProfile";
		}
		Moderator existingModerator = moderatorService.findByEmailString(getLoggedinUserName());
		moderator.setId(existingModerator.getId()); // Imposta l'ID dell'oggetto esistente sul nuovo oggetto moderatore
		moderatorService.updateModerator(moderator);
		moderatorService.updateModerator(moderator);
		return "redirect:/profilePage";
	}
	
	@Controller
	public class LoginController {
		@GetMapping ("/login")
		String login() {
			return "login";
		}
	}
	
	@Controller
	public class LogoutController {
		@GetMapping ("/logout")
		public String logout (HttpServletRequest request, HttpServletResponse response) {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			if (authentication != null) {
				new SecurityContextLogoutHandler().logout(request, response, authentication);
			}
			return "redirect:/";
		}
	}

	private String getLoggedinUserName() {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		
		if (principal instanceof UserDetails) {
			return ((UserDetails) principal).getUsername();
		}
		
		return principal.toString();
	}
	
}
