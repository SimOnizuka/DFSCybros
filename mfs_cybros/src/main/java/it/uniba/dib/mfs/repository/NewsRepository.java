package it.uniba.dib.mfs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.uniba.dib.mfs.model.News;

public interface NewsRepository extends JpaRepository<News, Long> {

	News findByLink(String link);
	
	News findByTitle(String title);
}
