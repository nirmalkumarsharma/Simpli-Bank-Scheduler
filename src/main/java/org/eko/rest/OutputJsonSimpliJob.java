package org.eko.rest;

import javax.xml.bind.annotation.XmlRootElement;

/* Class to map the output JSON response from the application after start, schedule or stopping the job */
@XmlRootElement
public class OutputJsonSimpliJob {
	
	private int id;
	private String result;
	private String description;
	
	public OutputJsonSimpliJob() {
		super();
	}
	public OutputJsonSimpliJob(int id, String result, String description) {
		super();
		this.id = id;
		this.result = result;
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
