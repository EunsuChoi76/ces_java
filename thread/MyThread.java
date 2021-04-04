package ces_java.thread;

class MyThread extends Thread{
	String name;
	
	public MyThread(String name) { //생성자 정의
		this.name = name;
	}
	
	public void run() { //run() 메서드를 오버라이딩하여 수행하고 싶은 작업을 정의한다. 1~5를 쓰레드이름과 함께 출력하는 메서드
		for(int i=1;i<=5;i++) {
			System.out.println(i + " "+name);
		}
		System.out.println(name+" 쓰레드 종료");
	}	
}


