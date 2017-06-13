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
	public void initFunction() throws SchedulerException
	{
		// GregorianCalendar(2017, 6, 13, 18, 24, 6));
		
		
		SimpliJob simpliJob1=new SimpliJob();
		simpliJob1.setName("Job1");
		simpliJob1.setSimpliGroup("Group1");
		simpliJob1.setStartTime(new GregorianCalendar(2017, 6, 13, 18, 24, 6));
		simpliJob1.setEndTime(new GregorianCalendar(2017, 6, 13, 18, 24, 9));
		simpliJob1.setStatus(1);
		simpliJobRepository.save(simpliJob1);
		
		SimpliJob simpliJob2=new SimpliJob();
		simpliJob2.setName("Job2");
		simpliJob2.setSimpliGroup("Group1");
		simpliJob2.setStartTime(new GregorianCalendar(2017, 6, 13, 18, 24, 7));
		simpliJob2.setEndTime(new GregorianCalendar(2017, 6, 13, 18, 24, 10));
		simpliJob2.setStatus(1);
		simpliJobRepository.save(simpliJob2);
		
		SimpliJob simpliJob3=new SimpliJob();
		simpliJob3.setName("Job3");
		simpliJob3.setSimpliGroup("Group1");
		simpliJob3.setStartTime(new GregorianCalendar(2017, 6, 13, 18, 24, 8));
		simpliJob3.setEndTime(new GregorianCalendar(2017, 6, 13, 18, 24, 11));
		simpliJob3.setStatus(1);
		simpliJobRepository.save(simpliJob3);
		
		SimpliJob simpliJob4=new SimpliJob();
		simpliJob4.setName("Job4");
		simpliJob4.setSimpliGroup("Group1");
		simpliJob4.setStartTime(new GregorianCalendar(2017, 6, 13, 18, 13, 9));
		simpliJob4.setEndTime(new GregorianCalendar(2017, 6, 13, 18, 13, 12));
		simpliJob4.setStatus(1);
		simpliJobRepository.save(simpliJob4);
	}
	
}
