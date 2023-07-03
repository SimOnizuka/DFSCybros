package it.uniba.dib.mfs.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sources")
public class Source {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idSource;
	
	private String name;
	
	private int sourceConfidenceIndex;
	
	private int counter; // contatore di tutte le notizie analizzate per fonte , serve per setSourceConfidexIndex

	public Source() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSourceConfidenceIndex() {
		return this.sourceConfidenceIndex;
	}

	/**
	 * @param newValue = affidabilità nuova notizia
	 * @param n = counter
	 * @param middleValue = sourceConfidenceIndex
	 */
	public void setSourceConfidenceIndex(int newValue) {
		int n = getCounter();
		int middleValue = getSourceConfidenceIndex();
		double rslt = ((middleValue*(n-1))+newValue) / n;
		int result = (int) rslt;
		this.sourceConfidenceIndex = result;
	}

	public long getIdSource() {
		return idSource;
	}
	
	public int getCounter() {
		return counter;
	}

	public void setCounter() {
		this.counter++;
	}
	
}
