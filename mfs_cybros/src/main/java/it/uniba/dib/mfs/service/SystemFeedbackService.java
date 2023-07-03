package it.uniba.dib.mfs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniba.dib.mfs.model.SystemFeedback;
import it.uniba.dib.mfs.repository.SystemFeedbackRepository;

@Service
public class SystemFeedbackService implements ISystemFeedbackService {

	@Autowired
	private SystemFeedbackRepository systemFeedbackRepository;
	
	@Override
	public void addSystemFeedback(String user, String text) {
		systemFeedbackRepository.save(new SystemFeedback(user, text));
	}
	
	@Override
	public void saveSystemFeedback(SystemFeedback systemFeedback) {
		systemFeedbackRepository.save(systemFeedback);
	}
	
	@Override
	public void deleteSystemFeedback(long id) {
		systemFeedbackRepository.deleteById(id);
	}
	
	 @Override
	    public List<SystemFeedback> getAllSystemFeedback() {
	        return systemFeedbackRepository.findAll();
	    }

}
