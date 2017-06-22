package org.eko.jobs;

import org.eko.BusinessJobs.Job1;
import org.eko.BusinessJobs.Job2;
import org.eko.BusinessJobs.Job3;
import org.eko.BusinessJobs.Job4;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;


@DisallowConcurrentExecution
public class BusinessJobA extends QuartzJobBean
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
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);

		System.out.println("\nStarted Executing Business Object A\n");
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
		
		System.out.println("\nStopped Executing Business Object A\n");
	}
}
