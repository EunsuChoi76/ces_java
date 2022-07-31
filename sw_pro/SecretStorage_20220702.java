package ces_java.sw_pro;

import java.util.Scanner;

public class SecretStorage_20220702 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {4,3,6,1,3,1,5,3};
		
		Scanner sc = new Scanner(System.in);
		
		int input_num = sc.nextInt();
		int maxCnt = 0;
		
		for(int i=0;i<8; i++) {
			if(a[i]==input_num) {
				maxCnt++;
			}			
		}
		
		System.out.println("숫자"+input_num+"개수는"+maxCnt+"개");

	}

}