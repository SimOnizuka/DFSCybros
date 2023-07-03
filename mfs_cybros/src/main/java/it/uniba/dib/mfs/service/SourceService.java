package it.uniba.dib.mfs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniba.dib.mfs.model.Source;
import it.uniba.dib.mfs.repository.SourceRepository;

@Service
public class SourceService implements ISourceService {

	@Autowired
	private SourceRepository sourceRepository;
	
	@Override
	public List<Source> getAll(){
		return sourceRepository.findAll();
	}
	
	@Override
	public List<Source> getBackList(){
		return sourceRepository.findBySourceConfidenceIndexLessThan(51);
	}
	
	@Override
	public List<Source> getWhiteList(){
		return sourceRepository.findBySourceConfidenceIndexGreaterThan(50);
	}
	
	@Override
	public void updateSource(Source source) {
		sourceRepository.save(source);
	}
	
	@Override
	public Source getSourceByName(String name) {
		return sourceRepository.findByName(name);
	}
	
	@Override
	public void addSource(String name, int sourceConfidenceIndex) {
		 Source source = new Source();
		 source.setName(name);
		 source.setSourceConfidenceIndex(sourceConfidenceIndex);
		 sourceRepository.save(source);
	}
	
	@Override
	public void deleteSource(long idSource) {
		Optional<Source> source = sourceRepository.findById(idSource);
		if(source.isPresent()) {
			sourceRepository.delete(source.get());
		}
	}
	
	@Override
	public void saveSource(Source source) {
		sourceRepository.save(source);
	}
}
