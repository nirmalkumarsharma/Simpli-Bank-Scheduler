package org.eko.service;

import java.util.List;

import org.eko.entity.SimpliJob;
import org.eko.repository.SimpliJobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SimpliJobService {

	@Autowired
	private SimpliJobRepository simpliJobRepository;
	
	public List<SimpliJob> getSimpliJobs()
	{
		return simpliJobRepository.findAll();
	}
}
