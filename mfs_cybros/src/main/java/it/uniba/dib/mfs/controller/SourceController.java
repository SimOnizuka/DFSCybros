package it.uniba.dib.mfs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;


import it.uniba.dib.mfs.model.Source;

import it.uniba.dib.mfs.service.ISourceService;

@Controller
public class SourceController {

	@Autowired
	private ISourceService sourceService;
	
	@GetMapping("/blacklist")
	public String showBlacklist(ModelMap model) {
		model.put("sources", sourceService.getBackList());
		return "blacklist";
	}
	
	@GetMapping("/whitelist")
	public String showWhitelist(ModelMap model) {
		model.put("sources", sourceService.getWhiteList());
		return "whitelist";
	}

	@GetMapping("/list-sourcesAndnews")
	public String showSourcesAndNews(ModelMap model) {
		return "list-sourcesAndnews";
	}
	
	public void sourceShowAnalyze(String name , int index) {
		if(sourceService.getSourceByName(name)==null) {
			Source source = new Source();
			source.setCounter();
			source.setName(name);
			source.setSourceConfidenceIndex(index);
			sourceService.saveSource(source);
			
		}
		else {
			sourceService.getSourceByName(name).setCounter();
			sourceService.getSourceByName(name).setSourceConfidenceIndex(index);
			sourceService.saveSource(sourceService.getSourceByName(name));
			
		}
		
	}
	
}
