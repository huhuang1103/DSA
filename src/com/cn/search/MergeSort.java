package com.cn.search;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import org.junit.Test;

public class MergeSort {
	static ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(1);

	public static int[] merge(int[] A, int lo, int mid, int hi) {
		int lb = mid - lo;
		int[] B = new int[lb];
		for (int i = 0; i < lb; i++) {
			B[i] = A[i];
		}
		int lc = hi - mid;
		int[] C = new int[lc];
		for (int i = 0; i < lc; i++) {
			C[i] = A[mid++];
		}
		for (int i = 0, j = 0, k = 0; (j < lb) || (k < lc);) {
			if ((j < lb) && (!(k < lc) || (B[j] <= C[k])))
				A[i++] = B[j++];
			if ((k < lc) && (!(j < lb) || (C[k] < B[j])))
				A[i++] = C[k++];
		}
		return A;

	}

	public static void main(String[] args) {

		int[] A = { 1, 2, 4, 7, 3, 5, 6, 13 };
		int[] merge = merge(A, 0, A.length / 2, A.length);
		for (int i : merge) {
			System.out.println(i);
		}
	}

	@Test
	public void test1() throws InterruptedException {
		Runnable t = new Runnable() {
			@Override
			public void run() { 
				try {
					Thread.sleep(100);
					System.out.println("thread interrupt");
					Thread.currentThread().interrupt();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().isInterrupted());
			}
		};
		
		Callable<String> callable = new Callable<String>() {

			@Override
			public String call() throws Exception {
				Thread.sleep(100);
				System.out.println("thread interrupt");
				Thread.currentThread().interrupt();
				// TODO Auto-generated method stub
				return "callable";
			}
		};
		
		Thread.sleep(1000);
		System.out.println("11"+Thread.currentThread().isInterrupted());
	}

}
