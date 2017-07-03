package org.eko.controller;

import java.util.List;

import org.eko.entity.SimpliJob;
import org.eko.repository.SimpliJobRepository;
import org.eko.rest.InputJsonSimpliJob;
import org.eko.rest.InputJsonSimpliJobDS;
import org.eko.rest.OutputJsonSimpliJob;
import org.eko.rest.ReturnMessage;
import org.eko.rest.SimpliJobDetails;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/*A Class to schedule or deschedule the jobs through RESTful API calls*/
@RestController
@RequestMapping(value="/simplijob/rest", consumes = MediaType.ALL_VALUE)
public class SimpliJobRestController {

	@Autowired
	private SimpliJobRepository simpliJobRepository;
	
	@Autowired
	private QuartzSchedulerController quartzSchedulerController;
	
	/* A utility function to deschedule the scheduled jobs with valid JSON request*/
	@RequestMapping(value="/deschedule/{id}",method=RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody OutputJsonSimpliJob descheduleSimpliJob(@PathVariable int id,@RequestBody InputJsonSimpliJobDS inputJsonSimpliJobDS) throws SchedulerException
	{
		SimpliJob simpliJob=simpliJobRepository.findOne(id);
		
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
	
	/* A utility function to schedule the unscheduled or descheduled jobs with the valid JSON request */
	@RequestMapping(value="/schedule/{id}",method=RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody OutputJsonSimpliJob scheduleSimpliJob(@PathVariable int id,@RequestBody InputJsonSimpliJob inputJsonSimpliJob) throws SchedulerException
	{
		SimpliJob simpliJob=simpliJobRepository.findOne(id);
		
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
			outputJsonSimpliJob.setDescription("Unable to set the job");
			System.err.println("Object is null");
		}
		return outputJsonSimpliJob;
	}
	
	/* A utility function to list the jobs with the requested status of jobs i.e. sheduled/unscheduled through a valid JSON request */
	@RequestMapping(value="/list/status/{status}" ,method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<SimpliJob> getSimpliJobsByStatus(@PathVariable int status)
	{
		List<SimpliJob> simpliJobList=null;
		
		if(status==1 || status==2)
		{
			simpliJobList=simpliJobRepository.findByStatus(status);
		}
		return simpliJobList;
	}
	
	/* A utility function to list the job with given id through a valid JSON request */
	@RequestMapping(value="/list/id/{id}" ,method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody SimpliJob getSimpliJobsById(@PathVariable int id)
	{
		return simpliJobRepository.findOne(id);
	}
	
	/* A utility function to list the job with given name through a valid JSON request */
	@RequestMapping(value="/list/name/{name}" ,method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody SimpliJob getSimpliJobsByName(@PathVariable String name)
	{
		return simpliJobRepository.findByName(name);
	}
	
	/* A utility function to all jobs through a valid JSON request */
	@RequestMapping(value="/list" ,method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<SimpliJob> getAllSimpliJobs()
	{
		List<SimpliJob> simpliJobList=null;
		simpliJobList=simpliJobRepository.findAll();
		return simpliJobList;
	}
	
	/* A utility function to check if application is running through a valid JSON request */
	@RequestMapping(method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ReturnMessage applicationRunningMessage()
	{
		ReturnMessage returnMessage=new ReturnMessage(0,"Application is running");
		return returnMessage;
	}
	
	/* A utility function to delete the job with given id through a valid JSON request */
	@RequestMapping(value="/delete/{id}" ,method=RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
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
			returnMessage.setMessage("Successfully deleted");
		}
		return returnMessage;
	}
	
	/* Does nothing just pass the JSON request as JSON response */
	@RequestMapping(value="/add" ,method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody SimpliJobDetails addSimpliJobs(@RequestBody SimpliJobDetails simpliJobDetails)
	{
		return simpliJobDetails;
	}
}
