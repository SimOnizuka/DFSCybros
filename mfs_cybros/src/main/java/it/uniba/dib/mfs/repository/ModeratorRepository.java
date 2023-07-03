package it.uniba.dib.mfs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.uniba.dib.mfs.model.Moderator;

public interface ModeratorRepository extends JpaRepository<Moderator, Long>{
	
	Moderator findByEmailString (String emailString);

}
