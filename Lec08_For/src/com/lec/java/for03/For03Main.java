package com.lec.java.for03;

public class For03Main {

	public static void main(String[] args) {
		System.out.println("for 연습");
		
		// 1 ~ 10 사이의 정수중 짝수만 출력
		for(int i = 1; i <= 10; i++) {
			if(i % 2 == 0) 
				System.out.println(i);
		} // end for
		
		System.out.println();
		
		for(int i = 2; i <= 10; i += 2) {
			System.out.println(i);
		}
		
		

	} // end main()

} // end class For03Main




