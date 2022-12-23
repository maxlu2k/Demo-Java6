package com.application.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.application.models.Student;

@Controller
public class HomeController {
	@RequestMapping(path="/form",method = RequestMethod.GET)
	public String form(Model model ) {
		Student student = new Student();
		student.setGender(true);
		model.addAttribute("student", student);
		return "/form";
	}
	@RequestMapping(path="/form",method = RequestMethod.POST)
	public String formHandler(@Validated @ModelAttribute("student") Student student,Errors errors,Model model ) {
		System.err.println("Run");
		if(errors.hasErrors()) {
			System.err.println("Has errors");
			return "/form";		
		}
		model.addAttribute("student", student);
		return "/infor";
	}
	@RequestMapping(path="/home",method = RequestMethod.GET)
	public String home(Model model ) {
		return "/home/index";
	}
	@RequestMapping(path="/about",method = RequestMethod.GET)
	public String about(Model model ) {
		return "/home/about";
	}
	@ModelAttribute("countries")
	public Map<String, String> getCountry(Model model ) {
		Map<String, String> map = new HashMap<>();
		map.put("VN", "Việt Nam");
		map.put("Lao", "Lào");
		map.put("Rusian", "Nga");
		map.put("Japan", "Nhật Bản");
		return map;
	}
}
