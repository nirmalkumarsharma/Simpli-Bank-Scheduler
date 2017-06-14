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
public class SimpliJobRestController {

	@Autowired
	private SimpliJobService simpliJobService;
	
	@Autowired
	private QuartzSchedulerController quartzSchedulerController;
	
	
	@RequestMapping(value="/simplijob/rest/unschedule/{id}", method=RequestMethod.PUT)
	public @ResponseBody String unscheduleSimpliJob(@PathVariable int id) throws SchedulerException
	{
		SimpliJob simpliJob=simpliJobService.findOne(id);
		if(simpliJob != null){
		quartzSchedulerController.unscheduleJob(simpliJob);
		return "redirect:/";
		}
		else
		{
			System.err.println("Obejct is null");
			return "redirect:/";
		}
	}
	@RequestMapping(value="/simplijob/rest/schedule/{id}", method=RequestMethod.PUT)
	public @ResponseBody String scheduleSimpliJob(@PathVariable int id) throws SchedulerException
	{
		SimpliJob simpliJob=simpliJobService.findOne(id);
		if(simpliJob != null){
		quartzSchedulerController.scheduleJob(simpliJob);
		return "redirect:/";
		}
		else
		{
			System.err.println("Obejct is null");
			return "redirect:/";
		}
	}
}
