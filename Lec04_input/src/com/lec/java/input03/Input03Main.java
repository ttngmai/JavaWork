package com.lec.java.input03;

import java.util.Scanner;

/*
 * 웹, 앱 .. 사용자 입력 ---> String(문자열) 로 처리된다.
 * 
 * 숫자타입으로 변환해야 산술 연산이 가능해진다.
 * 
 * ex) 문자열 "24" --> int 타입 24 로 변환
 * 
 * Integer.parseInt(문자열)  --> int 타입으로 변환
 * Double.parseDouble(문자열) --> double 타입으로 변환
 * ...
 * ...
 * 
 */
public class Input03Main {

	public static void main(String[] args) {
		System.out.println("입력 문자열 --> 숫자 변환");
		
		Scanner sc = new Scanner(System.in);
		
		//int n1 = sc.next();    // 불가!
		
		String in1 = sc.next();
		int n1 = Integer.parseInt(in1);  // 문자열 in1 --> int 로 변환
		
		int n2 = Integer.parseInt(sc.next());
		int n3 = Integer.parseInt(sc.next());
		
		
		System.out.println("합:" + (n1 + n2 + n2));
		
		
		//System.out.println("3.14" * 2);
		System.out.println(Double.parseDouble("3.14") * 2);
		
		
		sc.close();
		
		System.out.println("프로그램 종료");
	}

}










