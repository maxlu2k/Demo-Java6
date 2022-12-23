package com.application.services;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ConnectServices {
	private ObjectMapper mapper = new ObjectMapper();
	public JsonNode request(String method,Object data,String uri) throws IOException {
		URL url = new URL(uri);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestProperty("Accept", "application/json");
		connection.setRequestMethod(method);
		// with POST or PUT
		if(method.equalsIgnoreCase("PUT") || method.equalsIgnoreCase("POST")) {
			connection.setDoOutput(true); // có cho dữ liệu đầu vào không ?
			mapper.writeValue(connection.getOutputStream(), data);
		}
		// response
		int responseCode = connection.getResponseCode();
		if(responseCode == 200) { // 200 là ok
			return mapper.readTree(connection.getInputStream());
		}
		connection.disconnect();
		return null;
	}
}
