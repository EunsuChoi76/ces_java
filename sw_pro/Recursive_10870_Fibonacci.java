package ces_java.sw_pro;

import java.util.Scanner;

//¹®Á¦: https://www.acmicpc.net/problem/10870
public class Recursive_10870_Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int result = 0 ;
		result = fibo(n);
		
		System.out.print(result);

	}
	
	public static int fibo(int n) {
		if(n==0) return 0;
		if(n==1) return 1;

        return fibo(n-2)+fibo(n-1);
		
	}

}
