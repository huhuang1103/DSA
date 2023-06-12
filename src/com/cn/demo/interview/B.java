package com.cn.demo.interview;

public class B extends A {
    static {
        System.out.println("a");
    }
    public B(){
        System.out.println("b");
    }
    public String show(B obj){
        return ("B and B");
    }

    public String show(A obj){
        return ("B and A");
    }
}
