package com.application.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@AllArgsConstructor @NoArgsConstructor
public class Student {
	@NotBlank
	private String name;
	@NotBlank
	@Email
	private String email;
	@NotBlank
	private String country;
	@NotNull
	@Min(0)
	@Max(10)
	private Double marks;
	@NotNull
	private Boolean gender;
	
}
