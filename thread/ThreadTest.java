package ces_java.thread;

public class ThreadTest {
	
	public static void main(String[] args) {
		MyThread t1 = new MyThread("t1");       //t1 ������ ����
		MyThread t2 = new MyThread("t2");      //t2 ������ ����
		
		t1.start();        //t1�� ���� ��� ť�� ������.
		t2.start();        //t2�� ���� ��� ť�� ������.
		for(int i=1;i<=5;i++) {
            //���� �۾��ϰ� �ִ� ������ �̸��� �̷��� �ҷ��� ���� ����.
			System.out.println(i +" "+ Thread.currentThread().getName()); 
		}
		
		System.out.println("main ������ ����");
	}
}
