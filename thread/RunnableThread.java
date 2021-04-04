package ces_java.thread;

class RunnableThread implements Runnable{
	String name;
	public RunnableThread(String name) {
		this.name = name;
	}
	
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println(i + " "+name);
		}
		System.out.println(name+" 쓰레드 종료");
	}
}

