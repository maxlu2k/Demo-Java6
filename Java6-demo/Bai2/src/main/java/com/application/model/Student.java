package com.application.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
	private String name;
	private Integer age;
	private Boolean gender;
}
