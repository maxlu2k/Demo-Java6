package com.application.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.Bai5Application;
import com.application.models.Student;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class StudentRestController {
	@GetMapping("/student")
	public ResponseEntity<Collection<Student>> getStudent() {
//		List<Student> list = 
		if (Bai5Application.map.size() == 0) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(new ArrayList<Student>(Bai5Application.map.values()));
	}

	@GetMapping("/student/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("id") Integer id) {
		if (Bai5Application.map.get(id) == null) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(Bai5Application.map.get(id));
	}

	@PostMapping("/student")
	public ResponseEntity<Student> newStudent(@RequestBody Student object) {
		return ResponseEntity.ok(Bai5Application.map.put(Bai5Application.map.size(), object));
	}

	@PutMapping("/student/{id}")
	public ResponseEntity<Student> update(@RequestBody Student object, @PathVariable("id") Integer id) {
		if(Bai5Application.map.get(id)==null) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(Bai5Application.map.put(id, object));
	}

	@DeleteMapping("/student/{id}")
	public ResponseEntity<Void> deleteStudent(@PathVariable("id") Integer id) {
		Bai5Application.map.remove(id);
		return ResponseEntity.ok().build();
	}
}
