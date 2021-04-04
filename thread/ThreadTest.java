package ces_java.thread;

public class ThreadTest {
	
	public static void main(String[] args) {
		MyThread t1 = new MyThread("t1");       //t1 쓰레드 생성
		MyThread t2 = new MyThread("t2");      //t2 쓰레드 생성
		
		t1.start();        //t1을 실행 대기 큐로 보낸다.
		t2.start();        //t2를 실행 대기 큐로 보낸다.
		for(int i=1;i<=5;i++) {
            //현재 작업하고 있는 쓰레드 이름을 이렇게 불러올 수도 있음.
			System.out.println(i +" "+ Thread.currentThread().getName()); 
		}
		
		System.out.println("main 쓰레드 종료");
	}
}
