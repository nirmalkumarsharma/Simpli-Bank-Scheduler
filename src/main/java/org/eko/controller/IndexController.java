package org.eko.controller;

import org.eko.repository.SimpliJobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/* The following class defines the path of index.jsp page */
@Controller
public class IndexController {
	
	@Autowired
	private SimpliJobRepository simpliJobRepository;
	
	@RequestMapping("/index") 
	public String index(Model model)
	{
		model.addAttribute("simplijobs",simpliJobRepository.findAll()); //This will retrieve th jobs from the database and list them in index.jsp page
		return "/gui/index.jsp";
	}
}
