package org.eko.jobs;

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
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

@DisallowConcurrentExecution
public class BusinessJobC implements Job, InterruptableJob
{
	public static int REPEATINTERVALINMILLISECONDS=2000;
	public static int REPEATCOUNT=20;
	
	@Autowired
	Job1 job1;
	
	@Autowired
	Job2 job2;
	
	@Autowired
	Job3 job3;
	
	@Autowired
	Job4 job4;
	
	@Override
	public void interrupt() throws UnableToInterruptJobException
	{
		
	}

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);

		System.out.println("\nStarted Executing Business Object C\n");
		try
		{
			job1.doPerform();
			job2.doPerform();
			job3.doPerform();
			job4.doPerform();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("\nStopped Executing Business Object C\n");
	}
}
