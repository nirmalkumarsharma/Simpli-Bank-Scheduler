package org.eko.controller;

import org.eko.repository.SimpliJobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@Autowired
	private SimpliJobRepository simpliJobRepository;
	
	@RequestMapping("/index")
	public String index(Model model)
	{
		model.addAttribute("simplijobs",simpliJobRepository.findAll());
		return "/gui/index.jsp";
	}
}
