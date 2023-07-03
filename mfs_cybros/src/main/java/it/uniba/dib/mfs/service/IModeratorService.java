package it.uniba.dib.mfs.service;

import it.uniba.dib.mfs.model.Moderator;

public interface IModeratorService {
	
	Moderator findByEmailString(String emailString);
	
	void updateModerator(Moderator moderator);
	
	void addModerator(String emailString, String passwordString);
	
	void deleteModerator(String emailString);
	
	void saveModerator(Moderator moderator);

}
