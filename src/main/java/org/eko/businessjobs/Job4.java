package org.eko.businessjobs;

import org.eko.entity.SimpliJob;
import org.eko.repository.SimpliJobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/* The Class with Jobs performed by Business Job objects */
@Service
public class Job4 {

	@Autowired
	private SimpliJobRepository simpliJobRepository;
	
	public void doPerform()
	{
		System.out.println("\nJob4 Performing");

		SimpliJob simpliJob=simpliJobRepository.findTopByOrderByNameDesc();
		System.out.println(simpliJob);
		System.out.println("\nJob2 Done\n");
	}
}
