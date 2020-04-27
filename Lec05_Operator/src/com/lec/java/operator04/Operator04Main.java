package com.lec.java.operator04;

/* 증감 연산자(++, --) Increment / Decrement Operator
 *  	++변수: 변수의 값을 1 증가시켜서 저장
 *   	--변수: 변수의 값을 1 감소시켜서 저장
 *  
 *   증감연산자: prefix(접두사), postfix(접미사)
 *   	접두사(prefix)인 경우에는, 증감(++, --)이 먼저 된 후 다른 연산자가 동작
 *   	접미사(postfix)인 경우에는, 다른 연산자 먼저 실행된 후 증감(++, --)가 동작
 */
public class Operator04Main {

	public static void main(String[] args) {
		System.out.println("연산자 4 - 증감 연산자(++, --) Increment / Decrement Operator");
		
		int num1 = 100;
		System.out.println("num1 = " + num1);
		
		++num1;
		// num = num + 1 와 동일한 결과
		// num += 1  와 동일한 결과
		System.out.println("num1 = " + num1);
		
		int num2 = 100;
		--num2;
		System.out.println("num2 = " + num2);
		
		
		System.out.println("\n\n======================");
		System.out.println("증감연산자: prefix(접두사), postfix(접미사)");
		
		int num3 = 100;
		
		++num3;  // prefix
		num3++;  // postfix
		
		System.out.println("num3 = " + num3);
		
		// prefix 방식의 경우, 증감연산자가 '먼저' 수행된후 다른 연산자 동작
		int num4 = 100;
		int num5 = ++num4;  // prefix
		System.out.println("num4 = " + num4);
		System.out.println("num5 = " + num5);
		
		// postfix 방식, 증감연산자는 다른 연산자가 먼저 실행된 후 증감연산자 동작 
		int num6 = 100;
		int num7 = num6++;  // postfix
		System.out.println("num6 = " + num6);
		System.out.println("num7 = " + num7);
		
		System.out.println();
		int num8 = 10;
		int num9 = --num8 + 5;
		System.out.println("num8 = " + num8);
		System.out.println("num9 = " + num9);
		
		int num10 = 10;
		int num11 = num10-- + 5;
		System.out.println("num10 = " + num10);
		System.out.println("num11 = " + num11);
		
		// 실무에서는 위와 같이 수식안에 증감연산자 사용하지 않기를 ㅊㅊ
		num10--;
		int num12 = num10 + 5;
		
		
		
		System.out.println("\n프로그램 종료");
	} // end main

} // end class























