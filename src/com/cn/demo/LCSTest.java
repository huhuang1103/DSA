package com.cn.demo;

import java.util.Scanner;

public class LCSTest {
	 static int LCS_LENGTH(int[][] c, char a[], char[] b, int m, int n) {
	  if (m == 0 || n == 0) {
	   //��һ��Ϊ0˵��ǰ�治������ƥ����ȵģ����c[m][n] = 0
	   c[m][n] = 0;
	  } else {
	   if (a[m - 1] == b[n - 1]) {
	    //���˵������ַ�ƥ��ɹ�������ǰ�ݹ�
	    c[m][n] = LCS_LENGTH(c, a, b, m - 1, n - 1) + 1;
	   } else {//���ַ�ûƥ��ɹ���������һ���ַ�����Ҫǰ��
	    int i1 = LCS_LENGTH(c, a, b, m - 1, n);
	    int i2 = LCS_LENGTH(c, a, b, m, n - 1);
	    c[m][n] = i1 > i2 ? i1 : i2;// ��Ԫ���ʽ
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
	//�����c[m][n] == c[m][n - 1]˵��������c[m][n]����ǰ�ݹ�
	    LCS_RESULT(c, length, a, m, n - 1, str);
	   } else if (c[m][n] == c[m - 1][n]) {
	    //�����c[m][n] == c[m - 1][n]˵��������c[m][n]����ǰ�ݹ�
	    LCS_RESULT(c, length, a, m - 1, n, str);
	   } else {
	    //˵������c[m][n]�������λ�õ��ַ�����str[]
	    str[length - 1] = a[m - 1];
	    LCS_RESULT(c, length - 1, a, m - 1, n - 1, str);
	   }
	  }
	 }
	 public static void main(String[] args) {
	  Scanner scanner = new Scanner(System.in);
	  String s1 = scanner.nextLine();
	  String s2 = scanner.nextLine();
	  char[] a = s1.toCharArray();//��һ���ַ���
	  char[] b = s2.toCharArray();//�ڶ����ַ���
	  int m = a.length;//��һ���ַ�������
	  int n = b.length;//�ڶ����ַ�������
	  int c[][] = new int[m + 1][n + 1];//��¼��c[m][n]֮ǰ����󳤶�
	  int k = LCS_LENGTH(c, a, b, m, n);//��󳤶�
	  char str[] = new char[k];//������ַ�����
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
