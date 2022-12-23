package com.application.services;

import java.util.Map.Entry;
import java.util.Scanner;

import com.application.model.Student;
import com.application.model.StudentMap;

public class RestJavaNetMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		StudentDAO dao = new StudentDAO();
		String key = "";
		while (true) {
			switch (scanner.nextInt()) {
			case 1:
				StudentMap map = dao.getAll();
				for (Entry<String, Student> item : map.entrySet()) {
					System.err.println(item.getKey()+" : " + item.getValue());
				}
				break;
			case 2:
				Student st = dao.getByKey("-NGCI7QgMSzzphk8fU1H");
				System.err.println(st);
				
				break;

			case 3:
				Student st2 = new Student("chí", 20, 59.3f, true);
				String name = dao.create(st2);
				key = name;
				System.err.println(name);
				break;
			case 4:
				key = key.equals("")?"-NGCI7QgMSzzphk8fU1H":key;
				Student st3 = new Student("Chí Phèo", 20, 55.3f, true);
				Student objectUpdated = dao.update(st3,key);
				break;
			case 5:
				dao.delete(key);
				break;
			default:
				break;
			}
		}
	}
}
