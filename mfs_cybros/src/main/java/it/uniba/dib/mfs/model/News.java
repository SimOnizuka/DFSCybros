package it.uniba.dib.mfs.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.URL;

@Entity
@Table(name = "news")
public class News {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idNews;
	
	private String source;
	
	@URL
	private String link;
	
	private int reliability;
	
	private String publicationDate;
	
	private String title;
	
	public News() {
		super();
	}

	public News(String link) {
		super();
		this.link = link;
	}

	public String getSource() {
		return source;
	}


	public void setSource(String source) {
		this.source = source;
	}


	public String getLink() {
		return link;
	}


	public void setLink(String link) {
		this.link = link;
	}


	public int getReliability() {
		return reliability;
	}


	public void setReliability(int reliability) {
		this.reliability = reliability;
	}


	public String getPublicationDate() {
		return publicationDate;
	}


	public void setPublicationDate(String publicationDate) {
		this.publicationDate = publicationDate;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public long getIdNews() {
		return idNews;
	}
	
	
}
