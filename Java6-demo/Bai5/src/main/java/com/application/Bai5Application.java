package com.application;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.application.models.Student;

@SpringBootApplication
public class Bai5Application implements CommandLineRunner{
	public static Map<Integer,Student> map = new HashMap<>();
	public static void main(String[] args) {
		SpringApplication.run(Bai5Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		map.put(1, new Student(1, "Teo", "teonv@gmail.com", 20, true, 50.6f));
		map.put(2, new Student(2, "Chi", "chinv@gmail.com", 21, true, 56.6f));
		map.put(3, new Student(3, "no", "nonv@gmail.com", 20, false, 49.6f));
		map.put(4, new Student(4, "nguyen", "nguyennv@gmail.com", 20, true, 57.6f));
		map.put(5, new Student(5, "anh", "anhnv@gmail.com", 20, false, 50.6f));
		
	}

}
