package it.uniba.dib.mfs.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import it.uniba.dib.mfs.model.News;

import it.uniba.dib.mfs.service.INewsService;

@Controller
public class NewsController {
	
	private String copyLink;
	private News analysisNews;
    private String bodySourceString;
	
	@Autowired
	private INewsService newsService;
	
	@Autowired
	private ErrorController errorController;
	
	@Autowired
	private ApiController apiController;

	@GetMapping("/analyzedNews")
	public String showAnalyzedNews(ModelMap model) {
		model.put("news", newsService.getAll());
		return "analyzed-news";
	}
	
	public void model_addAttribute(ModelMap model) {
		model.addAttribute("news", new News());
	}
	
	@PostMapping("/analysis")
	public String entrLink (ModelMap model, @Valid News news, BindingResult result) {

		if(result.hasErrors()) {
			return "analysis";
		}
		
		copyLink = news.getLink();
		
		News foundNews = newsService.findByLink(copyLink);
		
		if(existNews(copyLink)) {
			//news = foundNews;
	        model.addAttribute("news", newsService.findByLink(copyLink));
	        analysisNews = foundNews;
			return "redirect:/analyze";
		}
		
		String copyTitle = WebScrapingController.titleWebScraping(copyLink);
		
		//System.out.println(copyTitle);
		news.setTitle(copyTitle);
		
		String copyData = WebScrapingController.dataWebScraping(copyLink);
        //System.out.println(copyData);
        news.setPublicationDate(copyData);
		
		String copySource = WebScrapingController.sourceWebScraping(copyLink);
        //System.out.println(copySource);
        news.setSource(copySource);
        
        bodySourceString = WebScrapingController.bodyWebScraping(copyLink);
        

		if (copyData != null && copyTitle != null && copySource != null && bodySourceString != "") {

			analysisNews = news; // da togliere
			//API 
			int resultGrammarCheck = apiController.grammarcheck(bodySourceString);
			System.out.println("analysisPrint: "+resultGrammarCheck);//verifico se funziona
			
			List<String> resultFactCheck = apiController.googleFactCheck(copyTitle);
			System.out.println("FactCheckPrint: "+resultFactCheck);//verifico se funziona
			analysisNews.setReliability(reliabilityCalculation(resultFactCheck,resultGrammarCheck));
			
		} else {
			
			String errorMessage = "ERROR to get link, change or check url";
			errorController.addError(model, errorMessage);
			return "error";
		}

		
		return "redirect:/analyze";
	}
	
	public void model_addAttribute_analysisNews(ModelMap model) {
		model.addAttribute("news", analysisNews);
	}
	
	public String get_analysisNews_getSource() {
		return analysisNews.getSource();
	}
	
	public int get_analysisNews_getReliability() {
		return analysisNews.getReliability();
	}
	
	public void save_analysisNews() {
		newsService.saveNews(analysisNews);
	}
	

	
	public void updateFeedbackNews(ModelMap model,  String link) {
		News news = newsService.findByLink(link);
		int reliability = news.getReliability();
		reliability = reliability - 15;
		if(reliability > 0 ) {
			news.setReliability(reliability);
		}else {
			news.setReliability(0);
		}
		newsService.saveNews(news);
	}
	
	public boolean existNews (String copyLink) {
		News foundNews = newsService.findByLink(copyLink);
			if(foundNews != null && copyLink.equals(foundNews.getLink())) {
				//news = foundNews
				return true;
			}
		return false;
	}
	

	public int reliabilityCalculation(List<String> resultFactCheck,int resultGrammarCheck) {
	    
		if(resultFactCheck.isEmpty()) {
			if(resultGrammarCheck >= 5) return 40;
			else return 60;
		}
		
		int vero = 0, falso = 0;
	    
	    for (String rating : resultFactCheck) {
	        if (rating.equals("True")) {
	            vero++;
	        }
	        if (rating.equals("False")) {
	            falso++;
	        }
	    }
	    
	    // Updated calculation
	    double risultato = ((double) vero / (vero + falso)) * 100;
	    int roundedResult = (int) risultato;
	    
	    if (resultGrammarCheck >= 5 && roundedResult >= 10) roundedResult -= 10;
	    if (resultGrammarCheck < 5 && roundedResult <= 90) roundedResult += 10 ;
	   
	    
	    return roundedResult;
	}
	
	
	public String getCopyLink () {
		return copyLink;
	}
	
	
}
