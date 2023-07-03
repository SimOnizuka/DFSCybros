package it.uniba.dib.mfs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.uniba.dib.mfs.model.Source;

public interface SourceRepository extends JpaRepository<Source, Long> {

	List<Source> findBySourceConfidenceIndexLessThan(int sourceConfidenceIndex);
	
	List<Source> findBySourceConfidenceIndexGreaterThan(int sourceConfidenceIndex);

	Source findByName(String name);

}
