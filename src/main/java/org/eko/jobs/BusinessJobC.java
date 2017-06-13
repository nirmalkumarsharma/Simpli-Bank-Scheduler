package org.eko.jobs;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.InterruptableJob;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.UnableToInterruptJobException;

@DisallowConcurrentExecution
public class BusinessJobC implements Job, InterruptableJob
{
	public static int REPEATINTERVALINMILLISECONDS=200;
	
	@Override
	public void interrupt() throws UnableToInterruptJobException
	{
		
	}

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("Executing Business Object C");
		for(int i=0;i<10;i++) System.out.print(i+" ");
		System.out.println();
	}
}
