package com.application.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.catalina.valves.StuckThreadDetectionValve;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.application.model.Student;

@Controller
public class HelloController {
	@GetMapping("/hello")
	public String sayHello(Model model) {
		model.addAttribute("hello", "HELLO <b>WORLD</b>");
		return "/home";
	}
	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("hello", "Welcome to Thymeleaf");
		model.addAttribute("student", new Student("Tèo",20,!true));
		return "/home/index";
	}
	@GetMapping("/page1/index/demo")
	public String index(Model model) {
		model.addAttribute("hello", "Welcome to Thymeleaf");
		model.addAttribute("student", new Student("Tèo",20,!true));
		return "/home/index2";
	}
	@GetMapping("/demo")
	public String demo(Model model) {
		List<Student> list = new ArrayList<>();
		list.add(new Student("trần văn an",20, true));
		list.add(new Student("trần văn bình",20, true));
		list.add(new Student("nguyễn Minh ngọc",20, false));
		list.add(new Student("trần văn an",20, true));
		model.addAttribute("hello", "Welcome to Thymeleaf");
		model.addAttribute("list", list);
		model.addAttribute("pi", 3.1424);
		model.addAttribute("now", new Date());
		model.addAttribute("student", new Student("tèo nguyễn văn",20,!true));
		return "/home/index3";
	}
}
