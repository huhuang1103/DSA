package com.cn.demo;

import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.util.concurrent.CompletableFuture;

public class Test {
	public Test() {
		this(1);
		// TODO Auto-generated constructor stub
	}

	static int total=10;
	public static void main(String[] args) throws FileNotFoundException, NoSuchMethodException, SecurityException {

//		YearMonth ymMonth1 = YearMonth.now();
//		YearMonth ymMonth2 = YearMonth.of(2016,Month.FEBRUARY);
//		System.out.println(ymMonth2.until(ymMonth1,ChronoUnit.MONTHS));
//		BufferedReader bufferedReader = new BufferedReader(new FileReader(""));
//		String concat = "first".concat("second");
//		System.out.println(concat);
//		Double d = null;
//		Class ss= new Test().getClass();
//		Method declaredMethod = ss.getDeclaredMethod("setName", null);
//		System.out.println(declaredMethod.toString());
//		Test t= new Test();
//		t.setName(1);
//		
//		total = 0;
		
		
		System.out.println("123");
		Person person = new Person();
		System.out.println("1233");
		System.out.println(Math.floor(10.99));
		System.out.println(Math.round(10.55));
		System.out.println(Math.nextUp(10.22));
		System.out.println(String.class);
	}
	
	public void setName(Integer e) {
		int total =4;
		System.out.println(this.total);
	}

	
	
	public Test(Integer i) {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
