package com.lec.java.for04;

public class For04Main {

	public static void main(String[] args) {
		System.out.println("for문 연습");
		
		// 1 ~ 100 수 중에서 2와 7의 공배수만 출력
		// 2와 7의 공배수: 2의 배수 && 7의 배수
		for(int i = 1; i <= 100; i++) {
			if( (i % 2 == 0) && (i % 7 == 0) )
				System.out.println(i);
		} // end for
		
		System.out.println("\n 1 ~ 10 까지의 합");
		int sum = 0;   // 합계를 저장할 변수 (누적)
		for(int i = 1; i <= 10; i++) {
			sum += i;   // 합계에 누적 덧셈
		}
		System.out.println("sum = " + sum);
		
		
		
		
		
	} // end main ()

} // end class For04Main










