package com.application.services;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RestAPIJavaNetURL {
	ConnectServices connectServices = new ConnectServices();
	private String uri = "https://java6-demo-rest-default-rtdb.asia-southeast1.firebasedatabase.app/student.json";
	
	// rest
	public JsonNode get(String key) {
		String url = key==null? uri:uri.replace(".json", "/")+key+".json";
		try {
			return connectServices.request("GET", null, url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public JsonNode put(String key,Object data) {

		String url = uri.replace(".json", "/")+key+".json";
		System.err.println(url);
		try {
			return connectServices.request("PUT", data, url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public JsonNode post(Object data) {
		String url = uri;
		try {
			return connectServices.request("POST", data, url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public void delete(String key) {
		String url = uri.replace(".json", "/")+key+".json";
		try {
			connectServices.request("DELETE", null, url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
