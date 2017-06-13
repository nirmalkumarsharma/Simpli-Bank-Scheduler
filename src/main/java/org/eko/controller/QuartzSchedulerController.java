package org.eko.controller;

import org.eko.entity.SimpliJob;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.stereotype.Controller;

@Controller
public class QuartzSchedulerController {
	
	JobDetail jobDetail;
	Trigger trigger;
	Scheduler scheduler;
	
	public void scheduleJob(SimpliJob simpliJob) throws SchedulerException
	{
		/*System.out.println(simpliJob);
		if(simpliJob!=null){
		jobDetail=JobBuilder.newJob(SimpliJob.class).withIdentity(simpliJob.getName(),simpliJob.getSimpliGroup()).build();
		trigger=(Trigger) TriggerBuilder.newTrigger().withIdentity("Trigger1",simpliJob.getSimpliGroup())
				.startNow().withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInMilliseconds(2000).repeatForever()) 
	             .build();
		
		scheduler=new StdSchedulerFactory().getScheduler();
		scheduler.scheduleJob(jobDetail,trigger);
		scheduler.start();
		} else {
			System.err.println("Obejct is null");
		}*/
	}
	
	public void unscheduleJob(SimpliJob simpliJob) throws SchedulerException
	{
		if(simpliJob!=null){
		scheduler.deleteJob(jobDetail.getKey()); }
		else
			System.out.println("Obejct is null");
	}
	
	public Scheduler getScheduler()
	{
		return scheduler;
	}
}
