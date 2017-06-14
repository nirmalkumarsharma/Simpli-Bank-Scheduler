package org.eko.controller;

import org.eko.entity.SimpliJob;
import org.eko.repository.SimpliJobRepository;
import org.eko.rest.InputJsonSimpliJob;
import org.eko.rest.OutputJsonSimpliJob;
import org.eko.service.SimpliJobService;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpliJobRestController {

	@Autowired
	private SimpliJobService simpliJobService;
	
	@Autowired
	private SimpliJobRepository simpliJobRepository;
	
	@Autowired
	private QuartzSchedulerController quartzSchedulerController;
	
	@RequestMapping(value="/simplijob/rest/unschedule/{id}", method=RequestMethod.PUT,produces = { "application/json" }, consumes = MediaType.ALL_VALUE)
	public @ResponseBody OutputJsonSimpliJob unscheduleSimpliJob(@PathVariable int id,@RequestBody InputJsonSimpliJob inputJsonSimpliJob) throws SchedulerException
	{
		SimpliJob simpliJob=simpliJobService.findOne(id);
		
		OutputJsonSimpliJob outputJsonSimpliJob=new OutputJsonSimpliJob();
		outputJsonSimpliJob.setId(id);
		
		if(simpliJob != null)
		{
			if(inputJsonSimpliJob.getStatus()==1)
			{
				simpliJobRepository.save(simpliJob);
				quartzSchedulerController.unscheduleJob(simpliJob);
				outputJsonSimpliJob.setResult("Successfully Descheduled");
				outputJsonSimpliJob.setDescription("Job is Descheduled");
			}
		}
		else
		{
			System.err.println("Obejct is null");
			outputJsonSimpliJob.setResult("Descheduling Failed");
			outputJsonSimpliJob.setDescription("Job is still Scheduled");
		}
		return outputJsonSimpliJob;
	}
	@RequestMapping(value="/simplijob/rest/schedule/{id}", method=RequestMethod.PUT,produces = { "application/json" }, consumes = MediaType.ALL_VALUE)
	public @ResponseBody OutputJsonSimpliJob scheduleSimpliJob(@PathVariable int id,@RequestBody InputJsonSimpliJob inputJsonSimpliJob) throws SchedulerException
	{
		SimpliJob simpliJob=simpliJobService.findOne(id);
		
		OutputJsonSimpliJob outputJsonSimpliJob=new OutputJsonSimpliJob();
		outputJsonSimpliJob.setId(id);
		if(simpliJob != null)
		{
			simpliJob.setStartTime(inputJsonSimpliJob.getStartTime());
			simpliJobRepository.save(simpliJob);
			if(inputJsonSimpliJob.getStatus()==2)
			{
				quartzSchedulerController.scheduleJob(simpliJob);
				System.out.println("REST Job scheduled");
				outputJsonSimpliJob.setDescription("The Job is set and scheduled");
			}
			else
			{
				outputJsonSimpliJob.setDescription("The Job is set but inactive");
			}
			outputJsonSimpliJob.setResult("Successfully Scheduled");
		}
		else
		{
			outputJsonSimpliJob.setResult("Scheduling Failed");
			outputJsonSimpliJob.setDescription("The Job isunable to set");
			System.err.println("Obejct is null");
		}
		return outputJsonSimpliJob;
	}
}
