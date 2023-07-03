package it.uniba.dib.mfs.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "feedbackNews")
public class FeedbackNews {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idFbNews;
	
	private String linkNews;

	private String user;
	
	public FeedbackNews() {
		super();
	}

	public FeedbackNews(String linkNews, String user) {
		super();
		this.linkNews = linkNews;
		this.user = user;
	}

	public String getLinkNews() {
		return linkNews;
	}

	public void setLinkNews(String linkNews) {
		this.linkNews = linkNews;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public long getIdFbNews() {
		return idFbNews;
	}


	
}
