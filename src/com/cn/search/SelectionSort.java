package com.cn.search;

public class SelectionSort {
 public static int[] selectionSort(int [] arr) {
	    int len = arr.length;
	    int minIndex, temp;
	    for (int i = 0; i < len - 1; i++) {
	        minIndex = i;
	        for (int j = i + 1; j < len; j++) {
	            if (arr[j] < arr[minIndex]) {     // 寻找最小的数
	                minIndex = j;                 // 将最小数的索引保存
	            }
	        }
	        temp = arr[i];
	        arr[i] = arr[minIndex];
	        arr[minIndex] = temp;
	    }
	    return arr;
	} 
 
 public static int[] sort(int [] arr) {
	 int len = arr.length;
	    int maxIndex, temp;
	    for (int i = 0; i < arr.length; i++) {
	    	maxIndex = i;
	    	for (int j = i +1; j < arr.length; j++) {
	    		if (arr[j] > arr[maxIndex]) {     // 寻找最小的数
	    			maxIndex = j;                 // 将最小数的索引保存
	            }
			}
	    	
	    	temp = arr[i];
	        arr[i] = arr[maxIndex];
	        arr[maxIndex] = temp;
		}
	 return arr;
	 
 }
 
 public static void main(String[] args) {
	int arr [] = {1,23,12,4,3,231,21};
	for (int i : arr) {
		System.out.println(i);
	}
	System.out.println("fa");
	int[] selectionSort = sort(arr);
	for (int i : selectionSort) {
		System.out.println(i);
	}
}
}
