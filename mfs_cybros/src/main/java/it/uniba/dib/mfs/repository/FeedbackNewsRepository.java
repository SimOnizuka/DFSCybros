package it.uniba.dib.mfs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.uniba.dib.mfs.model.FeedbackNews;

public interface FeedbackNewsRepository extends JpaRepository<FeedbackNews, Long> {

	FeedbackNews findByLinkNews(String linkNews);
}
