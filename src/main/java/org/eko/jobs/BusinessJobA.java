package org.eko.jobs;

import javax.transaction.Transactional;

import org.eko.BusinessJobs.Job1;
import org.eko.BusinessJobs.Job2;
import org.eko.BusinessJobs.Job3;
import org.eko.BusinessJobs.Job4;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.InterruptableJob;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.UnableToInterruptJobException;
import org.springframework.beans.factory.annotation.Autowired;

@Transactional
@DisallowConcurrentExecution
public class BusinessJobA implements Job, InterruptableJob
{
	public static int REPEATINTERVALINMILLISECONDS=2000;
	public static int REPEATCOUNT=20;
	
	@Autowired
	private Job1 job1;
	
	@Autowired
	private Job2 job2;
	
	@Autowired
	private Job3 job3;
	
	@Autowired
	private Job4 job4;
	
	public BusinessJobA() {}
	
	public BusinessJobA(Job1 job1, Job2 job2, Job3 job3, Job4 job4) {
		super();
		this.job1 = job1;
		this.job2 = job2;
		this.job3 = job3;
		this.job4 = job4;
	}

	public Job1 getJob1() {
		return job1;
	}

	public void setJob1(Job1 job1) {
		this.job1 = job1;
	}

	public Job2 getJob2() {
		return job2;
	}

	public void setJob2(Job2 job2) {
		this.job2 = job2;
	}

	public Job3 getJob3() {
		return job3;
	}

	public void setJob3(Job3 job3) {
		this.job3 = job3;
	}

	public Job4 getJob4() {
		return job4;
	}

	public void setJob4(Job4 job4) {
		this.job4 = job4;
	}

	@Override
	public void interrupt() throws UnableToInterruptJobException
	{

	}

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException
	{
		System.out.println("Executing Business Object A");
		for(int i=0;i<10;i++) System.out.print(i+" ");
		System.out.println();
		job1.doPerform();
		job2.doPerform();
		job3.doPerform();
		job4.doPerform();
	}
}
