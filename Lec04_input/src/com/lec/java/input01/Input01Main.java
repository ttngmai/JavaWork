package com.lec.java.input01;

import java.util.Scanner;

/*
 * 표준입력 (standard input) : '키보드'로부터 입력
 * Scanner 객체 사용
 */
public class Input01Main {

	public static void main(String[] args) {
		System.out.println("표준입력 : Scanner 사용");
		
		int num1, num2;
		
		Scanner sc = new Scanner(System.in);  // import 필요, 이클립스 CTRL + SHIFT + O
		
		// 입력 수행..
		System.out.println("숫자1 을 입력하세요");
		num1 = sc.nextInt();  // 사용자로부터 (키보드로부터) 정수 하나 입력
		
		System.out.println("숫자2를 입력하세요");
		num2 = sc.nextInt();
		
		// nextInt() 에서 정수가 아닌 다른 것을 입력하면 InputMismatchException 발생
		
		System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
		
		
		sc.close();  // Scanner 객체를 사용한 뒤에는 반드시 close() 를 해주어야 한다
		
		// 각 primitive 타입에 대해 nextXXX() 메소드 제공
//		sc.nextByte();
//		sc.nextShort();
//		sc.nextLong();
//		sc.nextFloat();
//		sc.nextDouble();
//		sc.nextBoolean();
		// nextChar() <-- XXX 없다
		
		System.out.println("\n프로그램 종료");
		
	} // end main

} // end class















