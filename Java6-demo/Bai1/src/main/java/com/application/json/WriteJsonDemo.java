package com.application.json;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.application.model.Contact;
import com.application.model.Student;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class WriteJsonDemo {
	public static void main(String[] args) throws IOException {
		writeJsonUseNode();
		System.out.println("---");
		writeJsonUseMyObject();
		System.out.println("---");
		writeJsonUseMap();
	}

	private static void writeJsonUseNode() throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode objectNode = mapper.createObjectNode();
		objectNode.put("name", "Tèo");
		objectNode.put("age", 19);
		objectNode.put("gender", true);
		ObjectNode contact = objectNode.putObject("contact");
		contact.put("email", "teonv@gmail.com");
		contact.put("phone", "0123456789");
		
		ArrayNode subject = objectNode.putArray("subject");
		subject.add("Java");
		subject.add("C#");
		// viết ra chuỗi
		String json = mapper.writeValueAsString(objectNode);
		// viết ra console
		mapper.writerWithDefaultPrettyPrinter().writeValue(System.err, objectNode);
		//  viết ra file
//		mapper.writeValue(new File("path"), objectNode);
	}
	private static void writeJsonUseMyObject() throws IOException {
		Contact contact = new Contact("teong@gmail.com", "0123456789");
		List<String> subject = Arrays.asList("Java","C#");
		Student student2 = new Student("TÈO", true, 30, contact, subject);
		ObjectMapper mapper = new ObjectMapper();
		// viết ra chuỗi
		String json = mapper.writeValueAsString(student2);
		// viết ra console
		mapper.writerWithDefaultPrettyPrinter().writeValue(System.err, student2);
		//  viết ra file
//		mapper.writeValue(new File("path"), student2);
	}
	private static void writeJsonUseMap() throws IOException {
		
		Map<String, Object> contact = new HashMap<>();
		contact.put("email", "teonv@gmail.com");
		contact.put("phone", "0123456789");
		List<String> subject = Arrays.asList("Java","C#");
		Map<String, Object> student = new HashMap<>();
		student.put("name", "Tèo");
		student.put("age", 19);
		student.put("gender", true);
		student.put("contact", contact);
		student.put("subject", subject);

		ObjectMapper mapper = new ObjectMapper();
		// viết ra chuỗi
		String json = mapper.writeValueAsString(student);
		// viết ra console
		mapper.writeValue(System.out, student);
		//  viết ra file
//		mapper.writeValue(new File("path"), student);
	}
	
}
