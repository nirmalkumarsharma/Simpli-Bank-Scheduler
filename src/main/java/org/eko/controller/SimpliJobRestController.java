package org.eko.controller;

import java.util.List;

import org.eko.entity.SimpliJob;
import org.eko.repository.SimpliJobRepository;
import org.eko.rest.InputJsonSimpliJob;
import org.eko.rest.InputJsonSimpliJobDS;
import org.eko.rest.OutputJsonSimpliJob;
import org.eko.rest.ReturnMessage;
import org.eko.rest.SimpliJobDetails;
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
@RequestMapping(value="/simplijob/rest", produces = { "application/json" }, consumes = MediaType.ALL_VALUE)
public class SimpliJobRestController {

	@Autowired
	private SimpliJobService simpliJobService;
	
	@Autowired
	private SimpliJobRepository simpliJobRepository;
	
	@Autowired
	private QuartzSchedulerController quartzSchedulerController;
	
	@RequestMapping(value="/deschedule/{id}",method=RequestMethod.PUT)
	public @ResponseBody OutputJsonSimpliJob unscheduleSimpliJob(@PathVariable int id,@RequestBody InputJsonSimpliJobDS inputJsonSimpliJobDS) throws SchedulerException
	{
		SimpliJob simpliJob=simpliJobService.findOne(id);
		
		OutputJsonSimpliJob outputJsonSimpliJob=new OutputJsonSimpliJob();
		outputJsonSimpliJob.setId(id);
		
		if(simpliJob != null)
		{
			if(inputJsonSimpliJobDS.getStatus()==1&&simpliJob.getId()==id)
			{
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
	@RequestMapping(value="/schedule/{id}",method=RequestMethod.PUT)
	public @ResponseBody OutputJsonSimpliJob scheduleSimpliJob(@PathVariable int id,@RequestBody InputJsonSimpliJob inputJsonSimpliJob) throws SchedulerException
	{
		SimpliJob simpliJob=simpliJobService.findOne(id);
		
		OutputJsonSimpliJob outputJsonSimpliJob=new OutputJsonSimpliJob();
		outputJsonSimpliJob.setId(id);
		if(simpliJob != null)
		{
			simpliJob.setStartTime(inputJsonSimpliJob.getStartTime());
			simpliJobRepository.save(simpliJob);
			simpliJob=simpliJobRepository.findOne(id);
			if(inputJsonSimpliJob.getStatus()==2&&simpliJob.getId()==id)
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
	
	@RequestMapping(value="/list/{status}" ,method=RequestMethod.GET)
	public @ResponseBody List<SimpliJob> getSimpliJobs(@PathVariable int status)
	{
		List<SimpliJob> simpliJobList=null;
		
		if(status==1 || status==2)
		{
			simpliJobList=simpliJobRepository.findByStatus(status);
		}
		if(status==0)
		{
			simpliJobList=simpliJobRepository.findAll();
		}
		return simpliJobList;
	}
	
	@RequestMapping(value="/delete/{id}" ,method=RequestMethod.DELETE)
	public @ResponseBody ReturnMessage deleteSimpliJobs(@PathVariable int id)
	{
		ReturnMessage returnMessage=new ReturnMessage();
		returnMessage.setId(id);
		SimpliJob simpliJob=simpliJobRepository.findOne(id);
		if(simpliJob==null)
		{
			returnMessage.setMessage("No such Jobs");
		}
		else
		{
			simpliJobRepository.delete(simpliJob);
			returnMessage.setMessage("successfully deleted");
		}
		return returnMessage;
	}
	@RequestMapping(value="/add" ,method=RequestMethod.POST)
	public @ResponseBody SimpliJobDetails addSimpliJobs(@RequestBody SimpliJobDetails simpliJobDetails)
	{
		return simpliJobDetails;
	}
}
