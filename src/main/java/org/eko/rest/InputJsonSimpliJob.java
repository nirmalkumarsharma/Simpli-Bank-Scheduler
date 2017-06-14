package org.eko.rest;

import java.util.Calendar;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class InputJsonSimpliJob{
	
	private int id;
	private Calendar startTime;
	private int status;

	public InputJsonSimpliJob() {
		super();
	}
	public InputJsonSimpliJob(int id, Calendar startTime, int status) {
		super();
		this.id = id;
		this.startTime = startTime;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Calendar getStartTime() {
		return startTime;
	}
	public void setStartTime(Calendar startTime) {
		this.startTime = startTime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
