package com.application.demo;

import java.util.ArrayList;
import java.util.List;

import com.application.interfaces.MyFunctionalInterface;
import com.application.model.People;

public class LamdaExpression {
	private static List<People> list;
	static {
		list = new ArrayList<>();
		list.add(new People("Bình",19,true));
		list.add(new People("Ngọc",18,false));
		list.add(new People("Anh",23,true));
		list.add(new People("Hào",21,true));
		list.add(new People("Dương",19,true));
		
	}
	
	public static void main(String[] args) {
		demoFunctionalInterface2();
		
	}

	private static void demoFunctionalInterface2() {
		list.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
		list.forEach(sv->System.err.println(sv));
		System.err.println("------------------");
		list.sort((o1, o2) -> {
			return Integer.compare(o1.getAge(), o2.getAge());
		});
		list.forEach(sv->System.err.println(sv));
	}




	public static void demoFunctionalInterface() {
	// functionalinterface : interface chứa 1 phương thức trừu tượng thì có thể
	// truyền biểu thức lamda thay cho đối tượng đc tạo từ interface
		MyFunctionalInterface myFunctionalInterface = (input) ->{
			input = "Your name : "+input;
			return input;
		};
		System.err.println(myFunctionalInterface.getName("Thắng"));;
	}
}
