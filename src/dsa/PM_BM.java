package dsa;
/******************************************************************************************
 * Data Structures in C++
 * ISBN: 7-302-33064-6 & 7-302-33065-3 & 7-302-29652-2 & 7-302-26883-3
 * Junhui DENG, deng@tsinghua.edu.cn
 * Computer Science & Technology, Tsinghua University
 * Copyright (c) 2006-2013. All rights reserved.
 ******************************************************************************************/

/*
 * ???????Boyer-Moore??
 * ??????¦Ë??i > length(T) - length(P)??????????
 * ????i????¦Ë??
 */
import dsa.*;
import java.io.*;

public class PM_BM {
   final static int CARD_CHAR_SET = 256;//????????
   //////////////////////////////////////////////////////////////////////////
   // T: 0     1     .     .     .     i     i+1   .     .     .     i+j   .     .     n-1
   //    --------------------|-------------------|------------
   // P:                               0     1     .     .     .     j     .     .
   //                                  |-------------------|
   //////////////////////////////////////////////////////////////////////////
   public static int PM(String T, String P) {
      //?????
      int[]    BC = BuildBC(P);
      int[]    GS = BuildGS(P);
      //???????
      int i = 0;//???????????????????¦Ë???????????????????
      while (T.length() - P.length() >= i) { //?????????????????????????
         int j = P.length() - 1;//?????????¦Â????????
         while (P.charAt(j) == T.charAt(i + j)) //??????????
            if (0 > --j)   break;
         ShowProgress(T, P, i, j);  System.out.print("\n");
         if (0 > j)//??????????? == ??????????????????????
            break;//???????¦Ë??
         else//????
            i += MAX(GS[j], j - BC[T.charAt(i+j)]);//??¦Ë????BC??GS??????????????????????
      }
      return(i);
   }

   /*
    * ????Bad Charactor Shift??BC[]
    *
    *    0                                   BC['X']                                                  m-1
    *    |                                   |                                                           |
    *    ........................X****************************************
    *                                        |<------------ ???????'X' ------------>|
    *
    * ????? = O(m + CARD_CHAR_SET)
    ******************************************************************************************/
   protected static int[] BuildBC(String P) {
      //?????
      int[] BC = new int[CARD_CHAR_SET];//BC[]??
      int   j;
      for (j = 0; j < CARD_CHAR_SET; j++)
         BC[j] = -1;//????????????????P?§Ô???
      //???????????????????????BC[]?
      for (j = 0; j < P.length(); j++)
         BC[P.charAt(j)] = j;//P[j]????????¦Ë??j??????????????????????????????¡À??????????????????ch??P?§Ô??????BC[ch]??????????§Ö?????????¦Ë??
      System.out.println("-- BC[] Table ---------------");
      for (j = 0; j < CARD_CHAR_SET; j++)
         if (0 <= BC[j])   System.out.print("\t" + (char)j);
      System.out.println();
      for (j = 0; j < CARD_CHAR_SET; j++)
         if (0 <= BC[j])   System.out.print("\t" + BC[j]);
      System.out.println("\n");
      return(BC);
   }

   /*
    * ????P???????P????????????????
    * ????P??????P[0..j]??SS[j] = max{s | P[j-s+1..j] = P[m-s..m-1]}
    *
    *    0                                   m-SS[j]                          m-1
    *    |                                   |                                   |
    *    ........................*************************
    *                                        |                                   |
    *                                        <-------- SS[j] -------->
    *                                        |                                   |
    *                      ............*************************..................
    *                      |                 |                                   |                          |
    *                      0                 j-SS[j]+1                        j                          m-1
    *
    * ????? = O(m)
    ******************************************************************************************/
   protected static int[] ComputeSuffixSize(String P) {
      int      m = P.length();
      int[] SS = new int[m];//Suffix Size Table
      int      s, t;//???P[s+1, ..., t]????P[m+s-t, ..., m-1]???
      int      j;//????????¦Ë??
      // ????????????????????????????????????P??????...
      SS[m-1]  =  m;
      // ??????????????????????????P?????¦Ì????SS[]???????
      s  =  m - 1;  t = m - 2;
      for (j = m - 2; j >= 0; j--) {
         if ((j > s) && (j - s > SS[(m-1-t)+j]))
            SS[j] =  SS[(m-1-t)+j];
         else {
            t = j;//?????????????????????????
            s = MIN(s, j);//????????????????
            while ((0 <= s) && (P.charAt(s) == P.charAt((m - 1 - t) + s)))
               s--;//????????????????????????????????
            SS[j] = t - s; //??????????????????
         }
      }
      System.out.println("-- SS[] Table -------");
      for (j = 0; j < m; j++)  System.out.print("\t" + P.charAt(j));    System.out.println();
      for (j = 0; j < m; j++)  System.out.print("\t" + SS[j]);             System.out.println("\n");
      return(SS);
   }

   /*
    * ????Good Suffix Shift??GS[]
    * ????? = O(m)
    ******************************************************************************************/
   protected static int[] BuildGS(String P) {
      int      m = P.length();
      int[] SS = ComputeSuffixSize(P);//????????????????????????
      int[] GS = new int[m];//Good Suffix Index
      int      j;
      for (j = 0; j < m; j++) GS[j] = m;
      /*
       *                      i < m-j-1?????¦Ë???
       *                      |
       *    0                 |              m-j-1                         m-1
       *    |                 |              |                                |
       *    ............A#########***********************
       *                      |              |                                |
       *                      |              <---- Suffix Size ----><------ GS Shift ------>
       *                      |              <---- SS[j] = j+1 ----><-------- m-j-1 ------->
       *                      |              |                                |                                   |
       *                                     ***********************........................
       *                                     |                                |                                   |
       *                                     0                                j                                   m-1
       *                                     <--<--<--<--<--<--< ????????? <--<--<--<--<--<
       *
       ******************************************************************************************/
      int   i = 0;
      for (j = m - 1; j >= -1; j--) //???????????????????????????????????
         if (-1 == j || j + 1 == SS[j]) //??????SS[-1] = 0??????????if (j+1 == SS[j])
            for (; i < m - j - 1; i++) //????????????????????????????????
               if (GS[i] == m)
                  GS[i] = m - j - 1;
      /*
       *                        m-SS[j]-1?????¦Ë???
       *                        |
       *    0                   |m-SS[j]              m-1
       *    |                   ||                    |
       *    ....................A**********************
       *                        ||                    |
       *                        |<--- Suffix Size ----><-- GS Shift ->
       *                        |<------- SS[j] ------><--- m-j-1 --->
       *                        ||                    |              |
       *                   .....B**********************...............
       *                   |     |                    |              |
       *                   0     j-SS[j]+1            j              m-1
       *                   >-->-->-->-->--> ??????????? --->-->-->-->
       *
       ******************************************************************************************/
      for (j = 0; j < m - 1; j++) //??????????????????????????????????
         GS[m-SS[j] - 1] = m - j - 1;
      System.out.println("-- GS[] Table ---------------");
      for (j = 0; j < m; j++)  System.out.print("\t" + P.charAt(j));    System.out.println();
      for (j = 0; j < m; j++)  System.out.print("\t" + GS[j]);             System.out.println("\n");
      return(GS);
   }

   protected static void ShowProgress(//???????????
      String   T,//?????
      String   P,//????
      int         i,//???????????????????¦Ë??
      int         j) { //???????????
      int         t;
      System.out.println("-------------------------------------------");
      for (t = 0; t < T.length(); t++)  System.out.print("\t" + T.charAt(t)); System.out.print("\n");
      if (0 <= i + j) {
         for (t = 0; t < i + j; t++)  System.out.print("\t");
         System.out.print("\t|");
      }
      System.out.println();
      for (t = 0; t < i; t++) System.out.print("\t");
      for (t = 0; t < P.length(); t++)  System.out.print("\t" + P.charAt(t)); System.out.print("\n");
      System.out.println();
   }

   protected static int MAX(int a, int b)
   {  return (a > b) ? a : b; }

   protected static int MIN(int a, int b)
   {  return (a < b) ? a : b; }
}
