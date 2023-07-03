package it.uniba.dib.mfs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniba.dib.mfs.model.FeedbackNews;
import it.uniba.dib.mfs.repository.FeedbackNewsRepository;

@Service
public class FeedbackNewsService implements IFeedbackNewsService {
	
	@Autowired
	private FeedbackNewsRepository feedbackNewsRepository;
	
	@Override
	public void addFeedbackNews(String news, String user) {
		feedbackNewsRepository.save(new FeedbackNews(news, user));
	}
	
	@Override
	public void saveFeedbackNews(FeedbackNews feedbackNews) {
		feedbackNewsRepository.save(feedbackNews);
	}

	@Override
	public void deleteFeedbackNews(long idFbNews) {
		feedbackNewsRepository.deleteById(idFbNews);
	}
	
	
	public List<FeedbackNews> getAll(){
		return feedbackNewsRepository.findAll();
	}
}
