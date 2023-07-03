package it.uniba.dib.mfs.service;

import java.util.List;

import it.uniba.dib.mfs.model.FeedbackNews;

public interface IFeedbackNewsService {
	
	void addFeedbackNews(String news, String user);
	
	void saveFeedbackNews(FeedbackNews feedbackNews);
	
	void deleteFeedbackNews(long idFbNews);
	
	List<FeedbackNews> getAll();

}
