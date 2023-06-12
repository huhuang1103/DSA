package com.cn.demo;

public class Tets {
        public Tets() {
            System.out.print("1");
        }
        static {
            System.out.print("2");
        }
        public static void main(String[] args) {
            System.out.print("3");
            new Tets().print();
        }
        public void print() {
            System.out.print("4");
        }

}
