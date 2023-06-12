package com.cn.demo.interview;

public class A {
    static {
        System.out.println("1");
    }
    public A(){
        System.out.println("2");
    }
    public String show(D obj){
        return ("A and D");
    }

    public String show(A obj){
        return ("A and A");
    }
}
