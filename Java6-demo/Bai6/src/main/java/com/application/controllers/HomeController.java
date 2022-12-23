package com.application.controllers;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@Autowired
	HttpServletRequest request;

	@RequestMapping("/home/index")
	public String home(Model model) {
		model.addAttribute("mes", "home");
		System.err.println(request.getRemoteUser());
		return "/index";
	}

	@RequestMapping("/home/page")
	public String page(Model model) {
		model.addAttribute("mes", "Page");
		System.err.println("1");
		System.err.println(request.getRemoteAddr() + " - "+ request.getRemotePort());
		Principal a = request.getUserPrincipal();
		return "/index";

	}
	@RequestMapping("/home/about")
	public String about(Model model) {
		model.addAttribute("mes", "About");
		System.err.println("1");
		System.err.println(request.getRemoteAddr() + " - "+ request.getRemotePort());
		Principal a = request.getUserPrincipal();
		return "/index";

	}
	@RequestMapping("/home/logout")
	public String logout(Model model) {
		model.addAttribute("mes", "logout");
		System.err.println(request.getRemoteAddr() + " - "+ request.getRemotePort());
		Principal a = request.getUserPrincipal();
		return "/index";

	}
	@RequestMapping("/access-denied")
	public String accessDenied(Model model) {

		model.addAttribute("mes", "Access denied ");
		return "/index";
	}
	@RequestMapping("/home/admin")
	public String admin(Model model) {

		model.addAttribute("mes", "admin");
		return "/index";
	}
	@RequestMapping("/home/user")
	public String user(Model model) {

		model.addAttribute("mes", "user");
		return "/index";
	}
	@RequestMapping("/home/authenticated")
	public String authenticated(Model model) {
		model.addAttribute("mes", "authenticated");
		return "/index";
	}
	@RequestMapping("/home/login")
	public String formLogin(Model model) {
//		model.addAttribute("_csrf", model);
		return "/login";
	}
	@PostMapping("/security/login")
	public String checkLogin(Model model) {
		System.err.println("success");
		return "/index";
	}
	@PostMapping("/form/login")
	public String check(Model model) {
		System.err.println("success");
		return "/index";
	}
}
