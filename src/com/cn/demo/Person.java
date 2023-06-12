package com.cn.demo;

public class Person extends People {
	static {
		System.out.println("person");
	}

	public Person() {
		super();
		System.out.println("Person Construtor");
	}
	
	
}
