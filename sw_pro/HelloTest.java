package ces_java.sw_pro;

import java.util.Scanner;

public class HelloTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println("Hello World");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long result = 1;
		
		if(n==0) n =1;
		
		for(int a=n; a>=1;a--) {
			result = result*a;
		}
		
		System.out.print(result);

	}

}
