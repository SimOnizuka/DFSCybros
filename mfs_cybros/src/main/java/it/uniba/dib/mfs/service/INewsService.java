package it.uniba.dib.mfs.service;

import java.util.List;

import it.uniba.dib.mfs.model.News;

public interface INewsService {

	List<News> getAll();
	
	News getByNull();
	
	void updateNews(News news);
	
	void addNews(String link);
	
	void deleteNews();
	
	void saveNews(News news);
	
	String getLink(String title);

	News findByLink(String link);
}
