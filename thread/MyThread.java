package ces_java.thread;

class MyThread extends Thread{
	String name;
	
	public MyThread(String name) { //������ ����
		this.name = name;
	}
	
	public void run() { //run() �޼��带 �������̵��Ͽ� �����ϰ� ���� �۾��� �����Ѵ�. 1~5�� �������̸��� �Բ� ����ϴ� �޼���
		for(int i=1;i<=5;i++) {
			System.out.println(i + " "+name);
		}
		System.out.println(name+" ������ ����");
	}	
}


