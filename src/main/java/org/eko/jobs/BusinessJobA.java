package org.eko.jobs;

import org.quartz.InterruptableJob;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.UnableToInterruptJobException;

public class BusinessJobA implements Job, InterruptableJob
{

	@Override
	public void interrupt() throws UnableToInterruptJobException {
		
	}

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		
	}
}
