package com.application.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.application.model.Student;
import com.application.model.StudentMap;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class StudentDAO {
	RestAPIJavaNetURL restAPIJavaNetURL = new RestAPIJavaNetURL();
	private ObjectMapper mapper = new ObjectMapper();
	public StudentMap getAll() {
		JsonNode node = restAPIJavaNetURL.get(null);
		return mapper.convertValue(node,StudentMap.class);
	}
	public Student getByKey(String key) {
		JsonNode node = restAPIJavaNetURL.get(key);
		return mapper.convertValue(node,Student.class);
	}
	public String create(Object data) { // return key 
		JsonNode node = restAPIJavaNetURL.post(data);
		return node.get("name").asText();
	}
	public Student update(Object data,String key) { // return key 
		JsonNode node = restAPIJavaNetURL.put(key,data);
		return mapper.convertValue(node,Student.class);
	}
	public void delete(String key) { // return key 
		restAPIJavaNetURL.delete(key);
	}
}
