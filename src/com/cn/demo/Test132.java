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
		UNREACHABLE: //�޷��ִ�mת���־
		for ( int i = 0; i < n; i += 1 + n/2013) {
				 if (1 + 1 != 2) continue UNREACHABLE; //��֧���������ǣ�ת����Ч
				 if (n * n < 0) /*doSomething(n)*/System.out.println(n); //��֧���������ǣ�������Ч
				 if ((n + i) * (n + i) < 4 * n * i) /*doSomething(n)*/System.out.println(n); //��֧���������ǣ�������Ч
				 if (2 == (n * n) % 5) O1(n + 1); //��֧���������ǣ��Ϗ���Ч
				// int f = fib(n); if ((12 < n) && (Math.sqrt(f) * Math.sqrt(f) == f)) O1(n - 1); //��֧�������� 
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
