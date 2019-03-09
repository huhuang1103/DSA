package com.cn.demo;

public class Test132 {
	public static int countOnes(int n) {
		int ones = 0;
		while(0<n) {
			ones+=(1&n);
			n>>=1;
		}
		return ones;
		
	}
	
	public void O1(int n) {
		UNREACHABLE: //无法抵达癿转向标志
		for ( int i = 0; i < n; i += 1 + n/2013) {
				 if (1 + 1 != 2) continue UNREACHABLE; //分支：条件永非，转向无效
				 if (n * n < 0) /*doSomething(n)*/System.out.println(n); //分支：条件永非，调用无效
				 if ((n + i) * (n + i) < 4 * n * i) /*doSomething(n)*/System.out.println(n); //分支：条件永非，调用无效
				 if (2 == (n * n) % 5) O1(n + 1); //分支：条件永非，逑弻无效
				// int f = fib(n); if ((12 < n) && (Math.sqrt(f) * Math.sqrt(f) == f)) O1(n - 1); //分支：条件永 
		}
	}
	int power2BF(int n) {
		int pow=1;
		while(0<n--)
		pow<<=1;
		return pow;
	}
public static void main(String[] args) {
	System.out.println(countOnes(441));
}
}
