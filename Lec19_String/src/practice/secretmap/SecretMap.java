package practice.secretmap;

import java.util.Scanner;

/*
 [입력예1]
5
9 20 28 18 11
30 1 21 17 28
 
 [출력예1]
 [#####, # # #, ### #, #  ##, #####]
 
 
[입력예2]
6
46 33 33 22 31 50
27 56 19 14 14 10
 
[출력예2]
["######", "###  #", "##  ##", " #### ", " #####", "### # "]
 
 
 ★선행★
 bit 연산자
 Integer.toBinaryString();
 String.format();
 */

public class SecretMap {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("n입력 1 <= n <= 16 : ");
		int n = sc.nextInt();   // n x n 크기의 지도
		
		// 두장의 지도 입력
		int [] arrA = new int[n];
		int [] arrB = new int[n];
		
		System.out.print("지도 A 입력 : ");
		for(int i = 0; i < arrA.length; i++) {
			arrA[i] = sc.nextInt();
		}
		System.out.print("지도 B 입력 : ");
		for(int i = 0; i < arrB.length; i++) {
			arrB[i] = sc.nextInt();
		}
		
		for(int i = 0; i < n; i++) {
			String result;
			result = String.format("%" + n + "s", Integer.toBinaryString(arrA[i] | arrB[i]));
			result = result.replace(' ', '0').replace('1', '#').replace('0', ' ');
			System.out.println(result);
		}
		
		sc.close();
		System.out.println("\n프로그램 종료");
	}

}












