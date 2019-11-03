package com.cn.search;

public class InsertSort {

	public static int[] sort(int [] arr) {
		for (int i = 1; i < arr.length; i++) {
			int temp = arr[i];
			int j;
			for(j=i; j>0 && arr[j-1]>temp; j--){//�����������һ�����Ż�
				arr[j] = arr[j-1];//�Ѵ�����Ҫ������������ƶ�����󲻴���temp�����Ϳճ���j
			}
			arr[j] = temp;//����Ҫ��������������λ��
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
	        for(int index = 1; index<array.length; index++){//������ҵ�index������Ϊ�Ƚ϶�������ݵ�index
	            int temp = array[index];//�����Ƚϵ�����
	            int leftindex = index-1;
	            while(leftindex>=0 && array[leftindex]>temp){//���ȵ�����߻���������tempС������ʱ������ѭ��
	                array[leftindex+1] = array[leftindex];
	                leftindex--;
	            }
	            array[leftindex+1] = temp;//��temp�ŵ���λ��
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
		System.out.println("���������");
		for (int i = 0; i < temp.length; i++) {
			System.out.println(temp[i]);
		}
	}
}
