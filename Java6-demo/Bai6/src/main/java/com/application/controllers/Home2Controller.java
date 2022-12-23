package com.application.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Home2Controller {
	@PreAuthorize("isAuthenticated()")
	@RequestMapping("/home/data")
	public String data(Model model) {
		model.addAttribute("mes", "data");
		return "/index";
	}
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping("/home/data/admin")
	public String dataAdmin(Model model) {

		model.addAttribute("mes", "data -admin");
		return "/index";
	}

	@PreAuthorize("hasAnyRole('ADMIN','USER')")
	@RequestMapping("/home/data/user")
	public String dataUser(Model model) {

		model.addAttribute("mes", "data -user ");
		return "/index";
	}
}
