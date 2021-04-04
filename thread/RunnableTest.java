package ces_java.thread;


public class RunnableTest {
	public static void main(String[] args) {
		MyThread t1 = new MyThread("T1"); //Thread를 상속하여 만든 클래스
		
		RunnableThread runnable = new RunnableThread("T2"); //Runnable 인터페이스를 구현한 객체
		Thread t2 = new Thread(runnable);  //Runnable 객체를 t2에 넘겨준다. (묵시적 형변환)
		
		t1.start();
		t2.start();
	}
}


