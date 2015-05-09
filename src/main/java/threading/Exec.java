package threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exec {

	public static void main(String[] args) {
		ExecutorService ex = Executors.newFixedThreadPool(2);
		
		Runnable r = new Runnable(){

			@Override
			public void run() {
				System.out.println("Thead " + Thread.currentThread().getName() 
						+ " started a job ");
				try {
					Thread.sleep((int)(Math.random() * 4000));
				} catch (InterruptedException ie) {}
				System.out.println("Thead " + Thread.currentThread().getName() 
						+ " finishing a job ");
			}
			
		};
		ex.execute(r);
		ex.execute(r);
		ex.execute(r);
		ex.execute(r);
		ex.execute(r);
		ex.execute(r);
		
		ex.shutdown();
		
	}

}
