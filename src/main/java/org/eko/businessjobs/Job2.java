package org.eko.businessjobs;

import java.util.List;

import org.eko.entity.SimpliJob;
import org.eko.repository.SimpliJobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/* The Class with Jobs performed by Business Job objects */
@Service
public class Job2 {

	@Autowired
	private SimpliJobRepository simpliJobRepository;
	
	public void doPerform()
	{
		System.out.println("\nJob2 Performing");
		
		Sort sortName=new Sort(new Sort.Order(Sort.Direction.DESC,"name"));
		
		List<SimpliJob> jobsDescName=simpliJobRepository.findAll(sortName);
		for (SimpliJob simpliJob : jobsDescName) {
			System.out.println(simpliJob);
		}
		System.out.println("\nJob2 Done\n");
	}
}
