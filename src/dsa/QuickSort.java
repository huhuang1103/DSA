package dsa;

import java.util.Random;

public class QuickSort {
    public  static  void  quickSort(int A[],int lo,int hi){
        if (lo >= hi)  return;
//        int povit = partition(A, lo, hi);
        int povit = partitionVarietas(A, lo, hi);
        quickSort(A,lo,povit);
        quickSort(A,povit+1,hi);


    }

    /**
     * 快排（变种）
     * @param A
     * @param lo
     * @param hi
     * @return
     */
    public static int partitionVarietas (int [] A,int lo,int hi){
        int random = (int) Math.random();
        swap(A, lo, lo+(hi-lo+1)*random);
    int poivt = A[lo];
    int mid = lo;
    for (int k = lo +1;k<=hi;k++){
        if (A[k]<poivt){
            swap(A,++mid,k);
        }
    }
    swap(A,lo,mid);
    return  mid;
    }

    public static int partition(int [] A,int lo,int hi){
        int pivot = A[lo];
        while (lo < hi) { //从向量癿两端交替地向中间扫描
            while (lo < hi){
                if (pivot < A[hi]){
                    hi--;
                } else {
                    swap(A, lo, hi);
                    break;
                }
            }
            while (lo < hi){
                if (A[lo] < pivot){
                    lo++;
                } else {
                    swap(A, lo, hi);
                    break;
                }
            }
        }

        System.out.print("lo="+lo+",hi="+hi+":");
        printArray(A);
        return lo;
}

  /*  public static int partition(int [] A,int lo,int hi){
        while (lo < hi) {
            while((lo < hi) && (A[lo] <= A[hi])) hi--;
            swap(A, lo, hi);
            while((lo < hi) && (A[lo] <= A[hi])) lo++;
            swap(A, lo, hi);
            System.out.print("lo="+lo+",hi="+hi+":");
            printArray(A);
        }

        return lo;
    }*/

    public  static  void swap(int [] A,int lo,int hi){

        int temp = A[lo];
        A[lo] = A[hi];
        A[hi] = temp;

    }

    public static void printArray(int [] array){
        for (int i:
             array) {
            System.out.print(i+",");
        }
        System.out.println(" ");
    }
    public static void main(String [] args){
//        int [] A ={3,23,1,4,32,8,7,11,66};
        int [] A ={6,3,8,1,5,9,8,4,5,7,2};
        printArray(A);
        quickSort(A,0,A.length-1);
        System.out.println("after");
        printArray(A);
    }
}
