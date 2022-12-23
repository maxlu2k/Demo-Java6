package com.application.json;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.application.model.Student;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonDemoWithObject {
	public static void main(String[] args) throws IOException {
		readJsonWithMap();
		System.out.println("------------");
		readJsonWithMap2();
		readJsonWithObject();
		readJsonWithObject2();
	}

	private static void readJsonWithObject() throws StreamReadException, DatabindException, IOException {
		System.err.println("readJsonWithObject");
		ObjectMapper mapper = new ObjectMapper();
		String json = "{\r\n"
				+ "            \"name\":\"TÈO\",\r\n"
				+ "            \"age\":20,\r\n"
				+ "            \"gender\":true,\r\n"
				+ "            \"contact\":{\r\n"
				+ "                \"email\":\"teonv@gmai.com\",\r\n"
				+ "                \"phone\":\"0123456789\"\r\n"
				+ "            },\r\n"
				+ "            \"subject\":[\"Java\",\"PHP\",\"Javascript\"]\r\n"
				+ "        };";
		Student student =  mapper.readValue(json,Student.class);
			System.err.println(student.getName());
			System.err.println(student.getAge());
			System.err.println(student.getGender());
			System.err.println(student.getContact().getEmail());
			System.err.println(student.getContact().getPhone());
			student.getSubject().forEach(System.err::println);
			System.out.println("--");
	}
	private static void readJsonWithObject2() throws StreamReadException, DatabindException, IOException {
		System.err.println("readJsonWithObject2");
		ObjectMapper mapper = new ObjectMapper();
		String path = "D:\\Java6\\Bai1\\src\\main\\resources\\students.json";
			TypeReference<List<Student>> type =  new TypeReference<List<Student>>() {};
			List<Student> students = mapper.readValue(new File(path), type);
			for (Student student : students) {
				
			System.err.println(student.getName());
			System.err.println(student.getAge());
			System.err.println(student.getGender());
			System.err.println(student.getContact().getEmail());
			System.err.println(student.getContact().getPhone());
			student.getSubject().forEach(System.err::println);
			System.out.println("--");
			}
	}

	private static void readJsonWithMap() throws StreamReadException, DatabindException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		String json = "{\r\n"
				+ "            \"name\":\"TÈO\",\r\n"
				+ "            \"age\":20,\r\n"
				+ "            \"gender\":true,\r\n"
				+ "            \"contact\":{\r\n"
				+ "                \"email\":\"teonv@gmai.com\",\r\n"
				+ "                \"phone\":\"0123456789\"\r\n"
				+ "            },\r\n"
				+ "            \"subject\":[\"Java\",\"PHP\",\"Javascript\"]\r\n"
				+ "        };";
		Map<String, Object> map = mapper.readValue(json,Map.class);
		System.err.println(map.get("name"));
		System.err.println(map.get("age"));
		System.err.println(map.get("gender"));
		Map<String , Object> map2 = (Map<String, Object>) map.get("contact");
		System.err.println(map2.get("email"));
		System.err.println(map2.get("phone"));
		List<String> list = (List<String>) map.get("subject");
		list.forEach(System.err::println);
		
	}
	private static void readJsonWithMap2() throws StreamReadException, DatabindException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		String path = "D:\\Java6\\Bai1\\src\\main\\resources\\students.json";
		List<Map<String, Object>> list = (List<Map<String, Object>>) mapper.readValue(new File(path),List.class);
		for (Map<String, Object> map : list) {
			System.err.println(map.get("name"));
			System.err.println(map.get("age"));
			System.err.println(map.get("gender"));
			Map<String , Object> map2 = (Map<String, Object>) map.get("contact");
			System.err.println(map2.get("email"));
			System.err.println(map2.get("phone"));
			List<String> list2 = (List<String>) map.get("subject");
			list2.forEach(System.err::println);
			System.out.println("--");
		}
		
	}

	private static void demo2() throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		String path = "D:\\Java6\\Bai1\\src\\main\\resources\\students.json";
		JsonNode node = mapper.readTree(new File(path));
		node.iterator().forEachRemaining((item)->System.err.println(item.get("name").asText()));
		
	}

	private static void demo1() throws JsonMappingException, JsonProcessingException {
		String json = "{\r\n"
				+ "            \"name\":\"TÈO\",\r\n"
				+ "            \"age\":20,\r\n"
				+ "            \"gender\":true,\r\n"
				+ "            \"contact\":{\r\n"
				+ "                \"email\":\"teonv@gmai.com\",\r\n"
				+ "                \"phone\":\"0123456789\"\r\n"
				+ "            },\r\n"
				+ "            \"subject\":[\"Java\",\"PHP\",\"Javascript\"]\r\n"
				+ "        };";
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = mapper.readTree(json);
		String name = node.get("name").asText();
		Integer age = node.get("age").asInt();
		Boolean gender = node.get("gender").asBoolean();
		String email = node.get("contact").get("email").asText();
		String phone = node.findValue("phone").asText();
		List<String> arr = new ArrayList<>();
		node.get("subject").iterator().forEachRemaining(item->arr.add(item.asText()));
		System.err.println(name);
		System.err.println(age);
		System.err.println(gender);
		System.err.println(email);
		System.err.println(phone);
		arr.forEach(System.out::println);
		
	}
}
