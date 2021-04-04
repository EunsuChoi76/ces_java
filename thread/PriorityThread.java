package ces_java.thread;

public class PriorityThread extends Thread {
	
	String name;
	
	public PriorityThread(String name) {
		this.name = name;
	}
	
	public void run() {
		for(int i=0;i<10000;i++) {
			System.out.println(i+" "+name);
		}
	}

}
