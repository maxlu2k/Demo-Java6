package com.application.repository;

import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.application.model.Student;
import com.application.model.StudentMap;
import com.fasterxml.jackson.databind.JsonNode;

@Repository
public class StudentDAO {
	private RestTemplate restTemplate = new RestTemplate();
	private String url = "https://java6-demo-rest-default-rtdb.asia-southeast1.firebasedatabase.app/student.json";
	public String getURL(String key) {
		return url.replace(".json","/"+ key+".json");
	}
	public StudentMap findAlMap() {
		return restTemplate.getForObject(url, StudentMap.class);
	}
	public Student findByKey(String key) {
		System.err.println(getURL(key));
		return restTemplate.getForObject(getURL(key),Student.class);
	}
	public String create(Student data) {
		HttpEntity<Student> entity = new HttpEntity<>(data);
		JsonNode node = restTemplate.postForObject(url, entity, JsonNode.class);
		return node.get("name").asText();
	}
	public Student update(Student data,String key) {
		if(findByKey(key) == null) {
			return null;
		}
		HttpEntity<Student> entity = new HttpEntity<Student>(data);
		restTemplate.put(getURL(key), entity);
		return data;
	}
	public void delete(String key) {
		if(findByKey(key) != null) {
			System.err.println("demo");
			restTemplate.delete(getURL(key));
		}
	}
	
}
