package com.application.json;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonDemoWithJsonNode {
	public static void main(String[] args) throws IOException {
		try {
			demo1();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.err.println("\n---------");
		demo2();

		System.err.println("\n---------");
		readJsonWithMap();
	}

	private static void readJsonWithMap() throws StreamReadException, DatabindException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		String path = "D:\\Java6\\Bai1\\src\\main\\resources\\students.json";
		Map<String, Object> map = mapper.readValue(new File(path),Map.class);
		
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
