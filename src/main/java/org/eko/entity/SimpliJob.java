package org.eko.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.InterruptableJob;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.UnableToInterruptJobException;

@Entity
public class SimpliJob{

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String simpliGroup;
	private Calendar startTime;
	private Calendar endTime;
	private int status;
	
	public SimpliJob() {
		super();
	}
	public SimpliJob(int id, String name, String simpliGroup, Calendar startTime, Calendar endTime) {
		super();
		this.id = id;
		this.name = name;
		this.simpliGroup = simpliGroup;
		this.startTime = startTime;
		this.endTime = endTime;
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
