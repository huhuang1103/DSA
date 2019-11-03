package com.cn.search;

public class InsertSort {

	public static int[] sort(int [] arr) {
		for (int i = 1; i < arr.length; i++) {
			int temp = arr[i];
			int j;
			for(j=i; j>0 && arr[j-1]>temp; j--){//这个较上面有一定的优化
				arr[j] = arr[j-1];//把大于需要插入的数往后移动。最后不大于temp的数就空出来j
			}
			arr[j] = temp;//将需要插入的数放入这个位置
		}
		return arr;
	}
	
	
	public static int[] sort1(int[] ins){
		
		for(int i=1; i<ins.length; i++){
			for(int j=i; j>0; j--){
				if(ins[j]<ins[j-1]){
					int temp = ins[j-1];
					ins[j-1] = ins[j];
					ins[j] = temp;
				}
			}
		}
		return ins;
	}
	
	 public static int [] doInsertSort(int [] array){
	        for(int index = 1; index<array.length; index++){//外层向右的index，即作为比较对象的数据的index
	            int temp = array[index];//用作比较的数据
	            int leftindex = index-1;
	            while(leftindex>=0 && array[leftindex]>temp){//当比到最左边或者遇到比temp小的数据时，结束循环
	                array[leftindex+1] = array[leftindex];
	                leftindex--;
	            }
	            array[leftindex+1] = temp;//把temp放到空位上
	        }
	        
	        return array;
	    }
	public static void main(String[] args) {
		int array[] = {11,2,3,5,23,8,78,9};
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		
//		int [] temp = doInsertSort(array);
//		int [] temp = sort(array);
		int [] temp = sort1(array);
		System.out.println("插入排序后：");
		for (int i = 0; i < temp.length; i++) {
			System.out.println(temp[i]);
		}
	}
}
