package org.eko.jobs;

import org.quartz.InterruptableJob;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.UnableToInterruptJobException;

public class BusinessJobB implements Job, InterruptableJob
{

	@Override
	public void interrupt() throws UnableToInterruptJobException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		// TODO Auto-generated method stub
		
	}
}
