package org.eko.service;

import java.util.GregorianCalendar;
import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.eko.entity.SimpliJob;
import org.eko.repository.SimpliJobRepository;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class InitDbService {
	
	@Autowired
	private SimpliJobRepository simpliJobRepository;
	
	@PostConstruct
	public void init() throws SchedulerException
	{
		System.out.println("Initiliazing Application");
		
		SimpliJob simpliJob1=simpliJobRepository.findByName("Job1");
		if(simpliJob1==null)
		{
			simpliJob1=new SimpliJob();
			simpliJob1.setName("Job1");
			simpliJob1.setSimpliGroup("Group1");
			simpliJob1.setStartTime(new GregorianCalendar(2017, 5, 14, 11, 27, 1));
			simpliJob1.setEndTime(new GregorianCalendar(2017, 5, 14, 11, 27, 59));
			simpliJob1.setStatus(1);
			simpliJobRepository.save(simpliJob1);
		}
		else if(simpliJob1.getStatus()==2)
		{
			simpliJob1.setStatus(1);
			simpliJobRepository.save(simpliJob1);
		}
		
		SimpliJob simpliJob2=simpliJobRepository.findByName("Job2");
		if(simpliJob2==null)
		{
			simpliJob2=new SimpliJob();
			simpliJob2.setName("Job2");
			simpliJob2.setSimpliGroup("Group1");
			simpliJob2.setStartTime(new GregorianCalendar(2017, 6, 14, 11, 27, 7));
			simpliJob2.setEndTime(new GregorianCalendar(2017, 6, 14, 11, 27, 10));
			simpliJob2.setStatus(1);
			simpliJobRepository.save(simpliJob2);
		}
		else if(simpliJob2.getStatus()==2)
		{
			simpliJob2.setStatus(1);
			simpliJobRepository.save(simpliJob2);
		}
		
		SimpliJob simpliJob3=simpliJobRepository.findByName("Job3");
		if(simpliJob3==null)
		{
			simpliJob3=new SimpliJob();
			simpliJob3.setName("Job3");
			simpliJob3.setSimpliGroup("Group1");
			simpliJob3.setStartTime(new GregorianCalendar(2017, 6, 14, 11, 27, 8));
			simpliJob3.setEndTime(new GregorianCalendar(2017, 6, 14, 11, 27, 11));
			simpliJob3.setStatus(1);
			simpliJobRepository.save(simpliJob3);
		}
		else if(simpliJob3.getStatus()==2)
		{
			simpliJob3.setStatus(1);
			simpliJobRepository.save(simpliJob3);
		}
		
		SimpliJob simpliJob4=simpliJobRepository.findByName("Job4");
		if(simpliJob4==null)
		{
			simpliJob4=new SimpliJob();
			simpliJob4.setName("Job4");
			simpliJob4.setSimpliGroup("Group1");
			simpliJob4.setStartTime(new GregorianCalendar(2017, 6, 14, 11, 27, 9));
			simpliJob4.setEndTime(new GregorianCalendar(2017, 6, 14, 11, 27, 12));
			simpliJob4.setStatus(1);
			simpliJobRepository.save(simpliJob4);
		}
		else if(simpliJob4.getStatus()==2)
		{
			simpliJob4.setStatus(1);
			simpliJobRepository.save(simpliJob4);
		}
	}
}
