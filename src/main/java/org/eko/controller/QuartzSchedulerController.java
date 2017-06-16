package org.eko.controller;

import java.util.Calendar;

import org.eko.entity.SimpliJob;
import org.eko.jobs.BusinessJobA;
import org.eko.jobs.BusinessJobB;
import org.eko.jobs.BusinessJobC;
import org.eko.jobs.BusinessJobD;
import org.eko.repository.SimpliJobRepository;
import org.quartz.DateBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class QuartzSchedulerController {
	
	JobDetail jobDetail1;
	JobDetail jobDetail2;
	JobDetail jobDetail3;
	JobDetail jobDetail4;
	Trigger trigger1;
	Trigger trigger2;
	Trigger trigger3;
	Trigger trigger4;
	Scheduler scheduler;
	
	@Autowired
	private SimpliJobRepository simpliJobRepository;
	
	public void scheduleJob(SimpliJob simpliJob) throws SchedulerException
	{
		scheduler=new StdSchedulerFactory().getScheduler();
		scheduler.start();
		if(simpliJob.getStatus()==1){
		if(simpliJob.getId()==1)
		{
			jobDetail1=JobBuilder.newJob(BusinessJobA.class).withIdentity(simpliJob.getName(),simpliJob.getSimpliGroup()).build();
			trigger1=(Trigger) TriggerBuilder.newTrigger().withIdentity("Trigger1",simpliJob.getSimpliGroup()).startAt(DateBuilder.dateOf(simpliJob.getStartTime().get(Calendar.HOUR_OF_DAY), simpliJob.getStartTime().get(Calendar.MINUTE), simpliJob.getStartTime().get(Calendar.SECOND), simpliJob.getStartTime().get(Calendar.DAY_OF_MONTH),simpliJob.getStartTime().get(Calendar.MONTH)+1,simpliJob.getStartTime().get(Calendar.YEAR))).withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInMilliseconds(BusinessJobA.REPEATINTERVALINMILLISECONDS).withRepeatCount(BusinessJobA.REPEATCOUNT)).forJob(jobDetail1).build();
			scheduler.scheduleJob(jobDetail1,trigger1);
			System.out.println("BusinessObjectA Scheduled!");
		}
		if(simpliJob.getId()==2)
		{
			jobDetail2=JobBuilder.newJob(BusinessJobB.class).withIdentity(simpliJob.getName(),simpliJob.getSimpliGroup()).build();
			trigger2=(Trigger) TriggerBuilder.newTrigger().withIdentity("Trigger2",simpliJob.getSimpliGroup()).startAt(DateBuilder.dateOf(simpliJob.getStartTime().get(Calendar.HOUR_OF_DAY), simpliJob.getStartTime().get(Calendar.MINUTE), simpliJob.getStartTime().get(Calendar.SECOND), simpliJob.getStartTime().get(Calendar.DAY_OF_MONTH),simpliJob.getStartTime().get(Calendar.MONTH)+1,simpliJob.getStartTime().get(Calendar.YEAR))).withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInMilliseconds(BusinessJobB.REPEATINTERVALINMILLISECONDS).withRepeatCount(BusinessJobB.REPEATCOUNT)).forJob(jobDetail2).build();
			scheduler.scheduleJob(jobDetail2,trigger2);
			System.out.println("BusinessObjectB Scheduled!");
		}
		if(simpliJob.getId()==3)
		{
			jobDetail3=JobBuilder.newJob(BusinessJobC.class).withIdentity(simpliJob.getName(),simpliJob.getSimpliGroup()).build();
			trigger3=(Trigger) TriggerBuilder.newTrigger().withIdentity("Trigger3",simpliJob.getSimpliGroup()).startAt(DateBuilder.dateOf(simpliJob.getStartTime().get(Calendar.HOUR_OF_DAY), simpliJob.getStartTime().get(Calendar.MINUTE), simpliJob.getStartTime().get(Calendar.SECOND), simpliJob.getStartTime().get(Calendar.DAY_OF_MONTH),simpliJob.getStartTime().get(Calendar.MONTH)+1,simpliJob.getStartTime().get(Calendar.YEAR))).withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInMilliseconds(BusinessJobC.REPEATINTERVALINMILLISECONDS).withRepeatCount(BusinessJobC.REPEATCOUNT)).forJob(jobDetail3).build();
			scheduler.scheduleJob(jobDetail3,trigger3);
			System.out.println("BusinessObjectC Scheduled!");
		}
		if(simpliJob.getId()==4)
		{
			jobDetail4=JobBuilder.newJob(BusinessJobD.class).withIdentity(simpliJob.getName(),simpliJob.getSimpliGroup()).build();
			trigger4=(Trigger) TriggerBuilder.newTrigger().withIdentity("Trigger4",simpliJob.getSimpliGroup()).startAt(DateBuilder.dateOf(simpliJob.getStartTime().get(Calendar.HOUR_OF_DAY), simpliJob.getStartTime().get(Calendar.MINUTE), simpliJob.getStartTime().get(Calendar.SECOND), simpliJob.getStartTime().get(Calendar.DAY_OF_MONTH),simpliJob.getStartTime().get(Calendar.MONTH)+1,simpliJob.getStartTime().get(Calendar.YEAR))).withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInMilliseconds(BusinessJobD.REPEATINTERVALINMILLISECONDS).withRepeatCount(BusinessJobD.REPEATCOUNT)).forJob(jobDetail4).build();
			scheduler.scheduleJob(jobDetail4,trigger4);
			System.out.println("BusinessObjectD Scheduled!");
		}
		simpliJob.setStatus(2);
		simpliJobRepository.save(simpliJob);
		}
		else
		{
			System.err.println("Job Already Scheduled!");
		}
		scheduler.start();
	}
	
	public void unscheduleJob(SimpliJob simpliJob) throws SchedulerException
	{
		if(simpliJob.getStatus()==2){
		if(simpliJob.getId()==1)
		{
			scheduler.unscheduleJob(trigger1.getKey());
			System.out.println("BusinessObjectA Unscheduled!");
		}
		if(simpliJob.getId()==2)
		{
			scheduler.unscheduleJob(trigger2.getKey());
			System.out.println("BusinessObjectB Unscheduled!");
		}
		if(simpliJob.getId()==3)
		{
			scheduler.unscheduleJob(trigger3.getKey());
			System.out.println("BusinessObjectC Unscheduled!");
		}
		if(simpliJob.getId()==4)
		{
			scheduler.unscheduleJob(trigger4.getKey());
			System.out.println("BusinessObjectD Unscheduled!");
		}
		simpliJob.setStatus(1);
		simpliJobRepository.save(simpliJob);
		}
		else
		{
			System.err.println("Job Not Scheduled!");
		}
	}
}
