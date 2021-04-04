package ces_java.thread;

public class PriorityTest {
	
	public static void main(String[] args) {
		PriorityThread t1 = new PriorityThread("t1");
		PriorityThread t2 = new PriorityThread("t2");
		PriorityThread t3 = new PriorityThread("t3");
		
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.NORM_PRIORITY);
		t3.setPriority(Thread.MIN_PRIORITY);
		t1.start();
		t2.start();
		t3.start();
	}

}
