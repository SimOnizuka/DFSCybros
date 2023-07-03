package it.uniba.dib.mfs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AnalysisController {
	
	@Autowired
	private NewsController newsController;
	
	@Autowired
	private SourceController sourceController;
	
	@Autowired
	private FeedbackNewsController feedbackNewsController;
	
//	Variables

    private String bodySourceString;
	
// Analysis Page
	
	@GetMapping("/analysis")
	public String showAnalysis(ModelMap model) {
		
		newsController.model_addAttribute(model);
		return "analysis";
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////
	
//Analyze page
	
	@GetMapping("/analyze")
	public String showAnalyze(ModelMap model) {
		if (newsController.existNews(newsController.getCopyLink())) {
			newsController.model_addAttribute_analysisNews(model);
			return "analyze";
		}
		newsController.save_analysisNews();		
		
		sourceController.sourceShowAnalyze(newsController.get_analysisNews_getSource(), newsController.get_analysisNews_getReliability());
		
		newsController.model_addAttribute_analysisNews(model); // Recupera l'oggetto News memorizzato
		 
		return "analyze";
	}
	
	
//ViewAnalysisPage-feedback
	
	@GetMapping("/viewanalysis")
	public String showFeedbackNewsPage(ModelMap model) {

		feedbackNewsController.showFeedbackNewsPage(model);
		return "viewanalysis";
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////

	public String getBodySourceString() {
		return bodySourceString;
	}


	@PostMapping("/lowerReliability")
	public String UpdateFeedbackNews(ModelMap model, @RequestParam String link) {
		newsController.updateFeedbackNews(model, link);
		return "redirect:/analyzedNews";
	}

}
