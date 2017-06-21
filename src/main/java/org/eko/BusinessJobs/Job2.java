package org.eko.BusinessJobs;

import java.util.List;

import javax.transaction.Transactional;

import org.eko.entity.SimpliJob;
import org.eko.repository.SimpliJobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class Job2 {

	@Autowired
	private SimpliJobRepository simpliJobRepository;
	
	public void doPerform()
	{
		Sort sortName=new Sort(new Sort.Order(Sort.Direction.DESC,"name"));
		
		List<SimpliJob> jobsDescName=simpliJobRepository.findAll(sortName);
		for (SimpliJob simpliJob : jobsDescName) {
			System.out.println(simpliJob);
		}
	}
}
