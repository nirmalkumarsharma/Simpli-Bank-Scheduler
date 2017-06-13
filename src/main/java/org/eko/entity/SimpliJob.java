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
	private Calendar endtime;
	
	public SimpliJob() {
		// TODO Auto-generated constructor stub
	}
	public SimpliJob(int id, String name, String simpliGroup, Calendar startTime, Calendar endtime) {
		super();
		this.id = id;
		this.name = name;
		this.simpliGroup = simpliGroup;
		this.startTime = startTime;
		this.endtime = endtime;
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
	public Calendar getEndtime() {
		return endtime;
	}
	public void setEndtime(Calendar endtime) {
		this.endtime = endtime;
	}
}
