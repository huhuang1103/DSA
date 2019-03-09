package com.cn.search;

public class InterruptionInJava implements Runnable {
	
	public static void main(String[] args) {
		Thread t = new Thread(new InterruptionInJava(),"InterruptionInJava");
		t.start();
		// interrupt
		t.interrupt();
		
        System.out.println("main end");
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(;;) {
			if(Thread.currentThread().isInterrupted()) {
				System.out.println(Thread.currentThread().getName()+" yes it's interrupt");
				return;
			}else{
                System.out.println("not yet interrupted");
            }
		}
		
	}

}

