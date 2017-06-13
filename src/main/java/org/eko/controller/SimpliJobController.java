package org.eko.controller;

import org.eko.entity.SimpliJob;
import org.eko.repository.SimpliJobRepository;
import org.eko.service.SimpliJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

public class SimpliJobController {
	
	@Autowired
	private SimpliJobService simpliJobService;
	
	@Autowired
	private SimpliJobRepository simpliJobRepository;
	
	@RequestMapping("/simplijob/unschedule/{id}")
	public String unscheduleSimpliJob(@PathVariable int id)
	{
		SimpliJob simpliJob=simpliJobRepository.findOne(id);
		return "index";
	}
	
	@RequestMapping("/simplijob/schedule/{id}")
	public String scheduleSimpliJob(@PathVariable int id)
	{
		SimpliJob simpliJob=simpliJobRepository.findOne(id);
		return "index";
	}

}
