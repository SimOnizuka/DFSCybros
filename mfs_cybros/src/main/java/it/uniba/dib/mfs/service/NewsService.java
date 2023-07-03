package it.uniba.dib.mfs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniba.dib.mfs.model.News;
import it.uniba.dib.mfs.repository.NewsRepository;

@Service
public class NewsService implements INewsService {

	@Autowired
	private NewsRepository newsRepository;
	
	@Override
	public List<News> getAll(){
		return newsRepository.findAll();
	}
	
	@Override
	public News getByNull() {
		return newsRepository.findByTitle(null);
	}
	
	@Override
	public void updateNews(News news) {
		newsRepository.save(news);
	}
	
	@Override
	public void deleteNews() {
		newsRepository.delete(getByNull());
	}
	
	@Override
	public void addNews(String link) {
		newsRepository.save(new News(link));
	}
	
	@Override
	public void saveNews(News news) {
		newsRepository.save(news);
	}
	
	@Override
	public String getLink(String title) {
		return newsRepository.findByTitle(title).getLink();
	}
	
	@Override
	public News findByLink(String link) {
		return newsRepository.findByLink(link);
	}
}
