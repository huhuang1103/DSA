package com.cn.demo.interview;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
//        A a1 = new A();
//        A a2 = new B();
//        B b = new B();
//        C c = new C();
//        D d = new D();
//        System.out.println(a1.show(b));
//        System.out.println(a1.show(c));
//        System.out.println(a1.show(d));
//        System.out.println(a2.show(b));
//        System.out.println(a2.show(c));
//        System.out.println(a2.show(d));
//        System.out.println(b.show(b));
//        System.out.println(b.show(c));
//        System.out.println(b.show(d));

//        A ab = new B();
//        ab = new B();

        String string1 = "hello";
        String string2 = "world";
        System.out.println(commonCharacters(string1, string2));
    }

    public static String commonCharacters(String string1, String string2) {
        HashSet<Character> set1 = new HashSet<>();
        for (char c : string1.toCharArray()) {
            set1.add(c);
        }
        StringBuilder sb = new StringBuilder();
        for (char c : string2.toCharArray()) {
            if (set1.contains(c)) {
                sb.append(c);
                set1.remove(c);
            }
        }
        return sb.toString();
    }
}
