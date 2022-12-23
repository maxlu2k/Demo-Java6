package com.application.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.application.model.People;

public class StreamAPI {

	private static List<People> list;
	static {
		list = new ArrayList<>();
		list.add(new People("Bình", 19, true));
		list.add(new People("Ngọc", 18, false));
		list.add(new People("Anh", 23, true));
		list.add(new People("Hào", 21, true));
		list.add(new People("Dương", 19, false));

	}

	public static void main(String[] args) {
		demo1();
		referenceMethod();
	}
	// stream API : Intermidiate Operations(Hoạt động trung gian) và Terminal
	// Operation(Hoạt động kết thúc)
	// Intermidiate Operations
	// filter (T -> boolean): lọc các phần tử thỏa mãn điều kiện
	// map (T -> R) : chuyển đổi đầu vào thành đầu ra khác
    // peek : đươc su dung de in (== foreach) hay thay doi gia tri(== map) . Nhưng nó thương dung đê debug

	// Terminal Operation
	// forEach : duyệt qua stream
	// collect() : thu thập các phần tử trong stream
	// reduce (initial,(temp,item)->newTemp) : tính giá trị tích lũy trong stream
	// allMatch (T -> boolean) : tất cả thỏa mãn
	// anyMatch (T -> boolean) : bất kì thỏa mãn
	// noneMatch (T -> boolean) : tất cả ko thỏa mãn

	// sum(), count() , min() , max() , average() : thực hiện trên stream số nền cần
	// chuyển sang stream số
	// mapToInt(), mapToDouble,mapToLong();
	
	// Reference method
	private static void demo1() {
		// TODO Auto-generated method stub
		// 10 % Tuổi tb của nam
//		double avg = list.stream().filter(sv -> sv.getGender()).mapToDouble((sv) -> sv.getAge()).reduce(0,
//				(tmp, item) -> {
//					System.err.println("tmp : " + tmp);
//					System.err.println("item : " + item);
//					return tmp + item * 0.1;
//				});
//		System.err.println(avg);
		List<People> list2 = list.stream().peek((a)->a.setAge(a.getAge()+10)).peek(a->System.err.println(a)).collect(Collectors.toList());
		list2.forEach(System.out::println);
		People minAge = list2.stream().reduce(list2.get(0),(min,sv)->sv.getAge()<min.getAge()?sv:min);
	}
	private static void referenceMethod() {
		list.stream().forEach(s->System.err.println(s));
		list.stream().forEach(System.out::println);
		list.stream().map(s->s.getName().toUpperCase()).forEach(System.out::println);
	}
	private static void createStream() {
		Stream<People> stream = list.stream();
		Stream<People> stream2 = Stream.of(new People("Bình", 19, true), new People("Ngọc", 18, false),
				new People("Anh", 23, true));

	}
}
