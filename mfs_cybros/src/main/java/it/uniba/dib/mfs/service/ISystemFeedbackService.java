package it.uniba.dib.mfs.service;

import java.util.List;

import it.uniba.dib.mfs.model.SystemFeedback;

public interface ISystemFeedbackService {

	void addSystemFeedback(String user, String text);
	
	void saveSystemFeedback(SystemFeedback systemFeedback);
	
	void deleteSystemFeedback(long id);
	
	List<SystemFeedback> getAllSystemFeedback();
	
}
