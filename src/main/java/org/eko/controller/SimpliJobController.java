package org.eko.controller;

import org.eko.entity.SimpliJob;
import org.eko.service.SimpliJobService;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SimpliJobController {
	
	@Autowired
	private SimpliJobService simpliJobService;
	
	@Autowired
	private QuartzSchedulerController quartzSchedulerController;

	@RequestMapping("/simplijob/unschedule/{id}")
	public String unscheduleSimpliJob(@PathVariable int id) throws SchedulerException
	{
		SimpliJob simpliJob=simpliJobService.findOne(id);
		if(simpliJob != null){
		quartzSchedulerController.unscheduleJob(simpliJob);
		}
		else
		{
			System.err.println("Obejct is null");
		}
		return "redirect:/";
	}
	
	@RequestMapping("/simplijob/schedule/{id}")
	public String scheduleSimpliJob(@PathVariable int id) throws SchedulerException
	{
		SimpliJob simpliJob=simpliJobService.findOne(id);
		if(simpliJob != null){
		quartzSchedulerController.scheduleJob(simpliJob);
		}
		else
		{
			System.err.println("Obejct is null");
		}
		return "redirect:/";
	}
}
