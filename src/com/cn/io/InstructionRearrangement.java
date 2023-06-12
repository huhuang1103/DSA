package com.cn.io;

/**
 * 指令重排
 *
 * @author tyz
 */
public class InstructionRearrangement {
    static int x = 0;
    static int y = 0;
    static int a = 0;
    static int b = 0;


    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 20000000; i++) {
            run(i);
        }
    }

    private static void run(int i) throws InterruptedException {
        x = 0;
        y = 0;
        a = 0;
        b = 0;
        Thread one = new Thread(() -> {
            a = 1;
            x = b;
        });
        Thread two = new Thread(() -> {
            b = 1;
            y = a;
        });
        one.start();
        two.start();
        one.join();
        two.join();
        //System.out.println("(" + x + "," + y + ")");
        if (x == 0 && y == 0) {
            System.out.println("第" + (i + 1) + "次出现 x = 0 y = 0");
        }
    }

}
