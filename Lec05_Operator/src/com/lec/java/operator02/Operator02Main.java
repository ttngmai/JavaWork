package com.lec.java.operator02;

/* 복합 대입 연산자 compound assignment operators
 * 
 * 		+=, -=, *=, /=, %=, ...
 */
public class Operator02Main {

	public static void main(String[] args) {
		System.out.println("연산자(Operator) 2 - 복합 대입 연산자 compound assignment operators");
		System.out.println("+=, -=, *=, /=, %=, ...");

		int num1 = 10;
		System.out.println("num1 = " + num1);
		num1 = num1 + 1;
		System.out.println("num1 = " + num1);
		num1 += 1;
		System.out.println("num1 = " + num1);
		
		int num2 = 100;
		num2 += 20;
		System.out.println("num2 = " + num2);
		
		
		double num4 = 3.14;
		num4 *= 2;
		System.out.println("num4 = " + num4);
		
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class










