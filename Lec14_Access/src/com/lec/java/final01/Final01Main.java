package com.lec.java.final01;

public class Final01Main {
	
	// final 멤버변수
	final int NUM = 1;
	//final int number;  // (주의) final 멤버변수는 반드시 선언과 동시에 초기화 해야 함
	
	public static void main(String[] args) {
		System.out.println("final: 변경할 수 없는 상수");
		
		final int num1 = 1;
		//num1 = 20;
		
		final int num2;
		num2 = 10;
		//num2 = 20;

	} // end main()

} // end class Final01Main










