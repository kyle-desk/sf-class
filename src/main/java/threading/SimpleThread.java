package threading;

public class SimpleThread {

	static class MyRunnable implements Runnable {
		private int i = 0;
		public void run() {
			for (; i < 10_000; i++) {
				System.out.println(Thread.currentThread().getName() + " - " + i);
			}
		}
	}
	public static void main(String[] args) {
		Runnable r = new MyRunnable();
		Thread t = new Thread(r);
		Thread t2 = new Thread(r);
//		t.setDaemon(true);
		t.start();
		t2.start();
		System.out.println("Thread started");
	}

}
