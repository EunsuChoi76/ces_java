package ces_java.thread;


public class RunnableTest {
	public static void main(String[] args) {
		MyThread t1 = new MyThread("T1"); //Thread�� ����Ͽ� ���� Ŭ����
		
		RunnableThread runnable = new RunnableThread("T2"); //Runnable �������̽��� ������ ��ü
		Thread t2 = new Thread(runnable);  //Runnable ��ü�� t2�� �Ѱ��ش�. (������ ����ȯ)
		
		t1.start();
		t2.start();
	}
}


