package com.application.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

	private Integer Id;
	private String name;
	private String email;
	private Integer age;
	private Boolean gender;
	private Float weight;
	
}
