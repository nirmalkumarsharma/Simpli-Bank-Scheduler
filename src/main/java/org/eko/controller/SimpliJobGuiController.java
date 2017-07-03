package org.eko.controller;

import org.eko.entity.SimpliJob;
import org.eko.repository.SimpliJobRepository;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/*A Class to schedule or deschedule the jobs through GUI interface*/
@Controller
public class SimpliJobGuiController {
	
	@Autowired
	private SimpliJobRepository simpliJobRepository;
	
	@Autowired
	private QuartzSchedulerController quartzSchedulerController;

	/* A utility function to deschedule the scheduled jobs*/
	@RequestMapping("/simplijob/deschedule/{id}") //id defines the job to be deschedule
	public String descheduleSimpliJob(@PathVariable int id) throws SchedulerException
	{
		SimpliJob simpliJob=simpliJobRepository.findOne(id);
		if(simpliJob != null)
		{
			quartzSchedulerController.unscheduleJob(simpliJob);
		}
		else
		{
			System.err.println("Object is null");
		}
		return "redirect:/";
	}
	
	/* A utility function to schedule the unscheduled or descheduled jobs*/
	@RequestMapping("/simplijob/schedule/{id}") //id defines the job to be deschedule
	public String scheduleSimpliJob(@PathVariable int id) throws SchedulerException
	{
		SimpliJob simpliJob=simpliJobRepository.findOne(id);
		if(simpliJob != null)
		{
			quartzSchedulerController.scheduleJob(simpliJob);
		}
		else
		{
			System.err.println("Object is null");
		}
		return "redirect:/";
	}
}
