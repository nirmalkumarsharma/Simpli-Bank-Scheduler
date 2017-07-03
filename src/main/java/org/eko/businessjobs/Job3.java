package org.eko.businessjobs;

import java.util.List;

import org.eko.entity.SimpliJob;
import org.eko.repository.SimpliJobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/* The Class with Jobs performed by Business Job objects */
@Service
public class Job3 {

	@Autowired
	private SimpliJobRepository simpliJobRepository;
	
	public void doPerform()
	{
		System.out.println("\nJob3 Performing");

		Sort sortID=new Sort(new Sort.Order(Sort.Direction.DESC,"id"));
		Page<SimpliJob> simpliJobPage=simpliJobRepository.findAll(new PageRequest(0, 2, sortID));
		List<SimpliJob> simpliJobList=simpliJobPage.getContent(); 
		for (SimpliJob simpliJob : simpliJobList) {
			System.out.println(simpliJob);
		}
		System.out.println("\nJob2 Done\n");
	}
}
