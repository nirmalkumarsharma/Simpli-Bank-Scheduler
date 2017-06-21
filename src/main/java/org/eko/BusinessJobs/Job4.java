package org.eko.BusinessJobs;

import javax.transaction.Transactional;

import org.eko.entity.SimpliJob;
import org.eko.repository.SimpliJobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Job4 {

	@Autowired
	private SimpliJobRepository simpliJobRepository;
	
	public void doPerform()
	{
		SimpliJob simpliJob=simpliJobRepository.findTopByOrderByNameDesc();
		System.out.println(simpliJob);
	}
}
