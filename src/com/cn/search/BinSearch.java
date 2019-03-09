package com.cn.search;

public class BinSearch {
	public static int binarySearch(int [] array,int e,int lo, int hi) {
	    while(1<hi -lo) {
	    int mi =(lo+hi)>>1;
	    if(e < array[mi]) {
	    	hi = mi;
	    }else { 
	    	lo=mi;
	    }
//	        (e < 1 ) ? hi = mi : lo=mi;
	    }
	    
		return e== array[lo] ? lo: -1;
	}
	
	public static int binarySearchImprove1(int [] array,int e,int lo, int hi) {
		int last = lo;
		
	    while(++lo < hi) {
	    	if(array[lo-1] > array[lo]) {
	    		last = lo;
	    		int temp = array[lo-1];
	    		array[lo-1] = array[lo];
	    		array[lo] = temp;
	    	}
	    }
	    
		return last;
	}
	public static void main(String[] args) {
		int [] array = {1,2,3,4,5,6};
		System.out.println(binarySearch(array, 6, 0, array.length));
		System.out.println(binarySearchImprove1(array, 6, 0, array.length));
	}
}
