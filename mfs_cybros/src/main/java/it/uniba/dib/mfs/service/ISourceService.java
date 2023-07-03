package it.uniba.dib.mfs.service;

import java.util.List;

import it.uniba.dib.mfs.model.Source;

public interface ISourceService {
	
	List<Source> getAll();
	
	List<Source> getBackList();
	
	List<Source> getWhiteList();
	
	void updateSource(Source source);
	
	void addSource(String name, int sourceConfidenceIndex);
	
	void deleteSource(long idSource);
	
	void saveSource(Source source);

	Source getSourceByName(String name);

}
