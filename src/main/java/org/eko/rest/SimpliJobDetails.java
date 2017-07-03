package org.eko.rest;

import java.util.Calendar;

import javax.xml.bind.annotation.XmlRootElement;

/* Class to map the SimpliJob class for Request and Response between application and the client*/
@XmlRootElement
public class SimpliJobDetails {

	private int id;
	private String name;
	private String simpliGroup;
	private Calendar startTime;
	private Calendar endTime;
	private int status;
	public SimpliJobDetails() {
		super();
	}
	public SimpliJobDetails(int id, String name, String simpliGroup, Calendar startTime, Calendar endTime, int status) {
		super();
		this.id = id;
		this.name = name;
		this.simpliGroup = simpliGroup;
		this.startTime = startTime;
		this.endTime = endTime;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSimpliGroup() {
		return simpliGroup;
	}
	public void setSimpliGroup(String simpliGroup) {
		this.simpliGroup = simpliGroup;
	}
	public Calendar getStartTime() {
		return startTime;
	}
	public void setStartTime(Calendar startTime) {
		this.startTime = startTime;
	}
	public Calendar getEndTime() {
		return endTime;
	}
	public void setEndTime(Calendar endTime) {
		this.endTime = endTime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
