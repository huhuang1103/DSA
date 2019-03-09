package com.cn.enumtest;

public class TestEunum {
	public static void main(String[] args) {

		 for(int x=0;x<100;x++) {
			 for(int y =0;y<100-x;y++) {
				 
				 int z =100-x-y;
				 if(z%3==0) {
					 if(5*x+3*y+z/3==100) {
						 System.out.println("x="+x+",y="+y+",z="+z);
					 }
				 }
			 }
		 }

	}
}
