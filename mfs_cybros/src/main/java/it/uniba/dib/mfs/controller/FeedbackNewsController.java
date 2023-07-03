package it.uniba.dib.mfs.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.uniba.dib.mfs.model.FeedbackNews;
import it.uniba.dib.mfs.service.IFeedbackNewsService;

@Controller
public class FeedbackNewsController {
	
	private String copyLink;

	@Autowired
	private IFeedbackNewsService feedbackNewsService;
	
	@Autowired
	private NewsController newsController;
	
	@GetMapping("/FeedbackNewsMod")
	public String showAnalyzedNews(ModelMap model) {
		model.put("feedbackNewsList", feedbackNewsService.getAll());
		return "feedbackNewsPage";
	}
	
	@PostMapping("/deleteNewsFeedback")
	public String deleteNewsFeedback(ModelMap model, @RequestParam long idFbNews) {
		
		feedbackNewsService.deleteFeedbackNews(idFbNews);
	    return "redirect:/FeedbackNewsMod";
	}
	

	public void showFeedbackNewsPage(ModelMap model) {

		model.addAttribute("feedbacknews", new FeedbackNews());
		
	}
	
	@PostMapping("/viewanalysis")
	public String saveFeedbackNews(ModelMap model, @Valid FeedbackNews feedbackNews, BindingResult result) {
		
		if (result.hasErrors()) {
			return "viewanalysis";
		}
		
		copyLink = newsController.getCopyLink();
		
		feedbackNews.setLinkNews(copyLink);
		
		feedbackNewsService.saveFeedbackNews(feedbackNews);
		
		return "redirect:/analysis";
	}
	
	
}