package org.eko.businessjobs;

import java.util.List;

import org.eko.entity.SimpliJob;
import org.eko.repository.SimpliJobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/* The Class with Jobs performed by Business Job objects */
@Service
public class Job1 {

	@Autowired
	private SimpliJobRepository simpliJobRepository;
	
	public void doPerform()
	{
		System.out.println("\nJob1 Performing");
		
		Sort sortID=new Sort(new Sort.Order(Sort.Direction.DESC,"id"));
		
		List<SimpliJob> jobsDescID=simpliJobRepository.findAll(sortID);
		for (SimpliJob simpliJob : jobsDescID) {
			System.out.println(simpliJob);
		}
		System.out.println("\nJob1 Done\n");
	}
}
