package threading;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProdCons {

	public static void main(String[] args) {
		final BlockingQueue<String> q = new LinkedBlockingQueue<>();
		new Thread(new Runnable() {
			public void run() {
				while (true) {
					try {
						String s = q.take();
						System.out.println("            cons:" + s);
						Thread.sleep((int)Math.random() * 100);
					} catch (InterruptedException ie) {}
				}
			}
		}).start();

		new Thread(new Runnable() {
			public void run() {
				while (true) {
					try {
						Thread.sleep((int)Math.random() * 100);
						String s = "" + Math.random();
						q.put(s);
						System.out.println("prod: " + s);
					} catch (InterruptedException ie) {}
				}
			}
		}).start();
	}

}
