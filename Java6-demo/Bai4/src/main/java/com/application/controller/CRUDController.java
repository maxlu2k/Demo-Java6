package com.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.application.model.Student;
import com.application.model.StudentMap;
import com.application.repository.StudentDAO;

@Controller
public class CRUDController {
	@Autowired
	private StudentDAO studentDAO;
	@RequestMapping("/student/index")
	public String home(Model model, @ModelAttribute("student") Student student) {
		student.setGender(true);
		StudentMap studentMap = studentDAO.findAlMap();
		model.addAttribute("items", studentMap);
		return "/view/index";
	}
	@PostMapping("/student/save")
	public String create(Model model, @ModelAttribute("student") Student student) {
		String name = studentDAO.create(student);
		System.err.println("value : "+name);
		return "redirect:/student/index";
	}
	@GetMapping("/student/edit/{id}")
	public String edit(Model model,@PathVariable("id")String id) {
		Student student = studentDAO.findByKey(id);
		model.addAttribute("key", id);
		model.addAttribute("student", student);
		StudentMap studentMap = studentDAO.findAlMap();
		model.addAttribute("items", studentMap);
		return "/view/index";
	}
	@PostMapping("/student/update/{id}")
	public String update(Model model, @ModelAttribute("student") Student student,@PathVariable("id")String id) {
		if(studentDAO.findByKey(id) == null) {
			return "redirect:/student/index";		
		}
		Student name = studentDAO.update(student,id);
		System.err.println(name);
		return "redirect:/student/edit/"+id;
	}
	@RequestMapping("/student/delete/{id}")
	public String update(Model model,@PathVariable("id")String id) {
		studentDAO.delete(id);
		return "redirect:/student/index";
	}
}
