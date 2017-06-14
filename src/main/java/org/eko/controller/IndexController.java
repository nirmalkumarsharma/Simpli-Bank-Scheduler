package org.eko.controller;

import org.eko.service.SimpliJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@Autowired
	private SimpliJobService simpliJobService;
	
	@RequestMapping("/")
	public String index(Model model)
	{
		model.addAttribute("simplijobs",simpliJobService.getSimpliJobs());
		return "/gui/index.jsp";
	}
}
