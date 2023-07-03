package it.uniba.dib.mfs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniba.dib.mfs.model.Moderator;
import it.uniba.dib.mfs.repository.ModeratorRepository;

@Service
public class ModeratorService implements IModeratorService{
	
	@Autowired
	private ModeratorRepository moderatorRepository;
	
	@Override
	public Moderator findByEmailString (String emailString) {
		return moderatorRepository.findByEmailString(emailString);
	}
	
	@Override
	public void updateModerator (Moderator moderator) {
		moderatorRepository.save(moderator);
	}
	
	@Override
	public void addModerator (String emailString, String passwordString) {
		moderatorRepository.save(new Moderator(emailString, passwordString));
	}
	
	@Override
	public void deleteModerator (String emailString) {
		Moderator moderator = moderatorRepository.findByEmailString(emailString);
		if(emailString!=null) {
			moderatorRepository.delete(moderator);
		}
		
	}
	
	@Override
	public void saveModerator (Moderator moderator) {
		Moderator existingModerator = moderatorRepository.findByEmailString(moderator.getEmailString());
		if(existingModerator == null || existingModerator.getId() == moderator.getId()) {
			moderatorRepository.save(moderator);
		}
		else {
			throw new IllegalArgumentException("L'email è gia' presente nel database");
		}
	}

}
