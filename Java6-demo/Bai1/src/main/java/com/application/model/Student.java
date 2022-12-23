package com.application.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	private String name;

	private Boolean gender;

	private Integer age;

	private Contact contact;

	private List<String> subject;
}
