package com.cn.demo;

import java.util.Scanner;

public class LCSTest {
	 static int LCS_LENGTH(int[][] c, char a[], char[] b, int m, int n) {
	  if (m == 0 || n == 0) {
	   //有一个为0说明前面不可能有匹配相等的，因此c[m][n] = 0
	   c[m][n] = 0;
	  } else {
	   if (a[m - 1] == b[n - 1]) {
	    //相等说明这个字符匹配成功，在往前递归
	    c[m][n] = LCS_LENGTH(c, a, b, m - 1, n - 1) + 1;
	   } else {//本字符没匹配成功，看看哪一个字符串需要前移
	    int i1 = LCS_LENGTH(c, a, b, m - 1, n);
	    int i2 = LCS_LENGTH(c, a, b, m, n - 1);
	    c[m][n] = i1 > i2 ? i1 : i2;// 三元表达式
	   }
	  }
	  return c[m][n];
	 }
	 static void LCS_RESULT(int[][] c, int length, char a[], int m, int n,
	   char[] str) {
	  if (m == 0 || n == 0) {
	   return;
	  } else {
	   if (c[m][n] == c[m][n - 1]) {
	//如果才c[m][n] == c[m][n - 1]说明不包括c[m][n]，往前递归
	    LCS_RESULT(c, length, a, m, n - 1, str);
	   } else if (c[m][n] == c[m - 1][n]) {
	    //如果才c[m][n] == c[m - 1][n]说明不包括c[m][n]，往前递归
	    LCS_RESULT(c, length, a, m - 1, n, str);
	   } else {
	    //说明包括c[m][n]，将这个位置的字符赋给str[]
	    str[length - 1] = a[m - 1];
	    LCS_RESULT(c, length - 1, a, m - 1, n - 1, str);
	   }
	  }
	 }
	 public static void main(String[] args) {
	  Scanner scanner = new Scanner(System.in);
	  String s1 = scanner.nextLine();
	  String s2 = scanner.nextLine();
	  char[] a = s1.toCharArray();//第一个字符串
	  char[] b = s2.toCharArray();//第二个字符串
	  int m = a.length;//第一个字符串长度
	  int n = b.length;//第二个字符串长度
	  int c[][] = new int[m + 1][n + 1];//记录第c[m][n]之前的最大长度
	  int k = LCS_LENGTH(c, a, b, m, n);//最大长度
	  char str[] = new char[k];//最长公共字符序列
	  LCS_RESULT(c, k, a, m, n, str);
	  for (char cr : str) {
	   System.out.print(cr);
	  }
	  System.out.println();
	  for (int c1[] : c) {
	   for (int c2 : c1) {
	    System.out.print(c2);
	   }
	   System.out.println();
	  }
	 }
	}
