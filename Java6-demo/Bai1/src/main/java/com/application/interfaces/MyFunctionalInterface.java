package com.application.interfaces;

// chỉ định là functionalInterface : chỉ có 1 phương thwucs trừu tượng (>1 sẽ báo lỗi )
@FunctionalInterface
public interface MyFunctionalInterface {
	String getName(String input);
	static Integer getAge(int age) {
		return age;
	}
	default Boolean getGender(boolean gender) {
		return gender;
	}
}
