package org.eko.service;

import java.util.GregorianCalendar;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.eko.entity.SimpliJob;
import org.eko.repository.SimpliJobRepository;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;
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
		SimpliJob simpliJob1=new SimpliJob();
		simpliJob1.setName("Job1");
		simpliJob1.setSimpliGroup("Group1");
		simpliJob1.setStartTime(new GregorianCalendar(2017, 6, 12, 17, 5, 6));
		simpliJob1.setEndtime(new GregorianCalendar(2017, 6, 12, 17, 5, 9));
		simpliJobRepository.save(simpliJob1);
		
		SimpliJob simpliJo2=new SimpliJob();
		simpliJo2.setName("Job2");
		simpliJo2.setSimpliGroup("Group1");
		simpliJo2.setStartTime(new GregorianCalendar(2017, 6, 12, 17, 5, 7));
		simpliJo2.setEndtime(new GregorianCalendar(2017, 6, 12, 17, 5, 10));
		simpliJobRepository.save(simpliJo2);
		
		SimpliJob simpliJob3=new SimpliJob();
		simpliJob3.setName("Job3");
		simpliJob3.setSimpliGroup("Group1");
		simpliJob3.setStartTime(new GregorianCalendar(2017, 6, 12, 17, 5, 8));
		simpliJob3.setEndtime(new GregorianCalendar(2017, 6, 12, 17, 5, 11));
		simpliJobRepository.save(simpliJob3);
		
		SimpliJob simpliJob4=new SimpliJob();
		simpliJob4.setName("Job4");
		simpliJob4.setSimpliGroup("Group1");
		simpliJob4.setStartTime(new GregorianCalendar(2017, 6, 12, 17, 5, 9));
		simpliJob4.setEndtime(new GregorianCalendar(2017, 6, 12, 17, 5, 12));
		simpliJobRepository.save(simpliJob4);
	}
	
}
