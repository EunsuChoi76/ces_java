package ces_java.sw_pro;

import java.util.Scanner;

public class Recursive_10872_Factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		long result = factorial(n);
		System.out.print(result);
		

	}
	
	public static int factorial(int f) {
		if (f<=0) return 1;
		else return f * factorial(f-1);
	}

}
