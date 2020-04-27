package com.lec.java.input02;

import java.util.Scanner;

/*
 * 문자열(String ) 입력
 * char 입력
 */
public class Input02Main {

	public static void main(String[] args) {
		System.out.println("표준입력: String, char");
		
		Scanner sc = new Scanner(System.in);
		
		// String 입력
//		System.out.print("이름을 입력하세요 : ");
//		String name = sc.nextLine();   // 엔터 입력할때까지의 모든 문자열
//		
//		System.out.print("별명을 입력하세요 : ");
//		String nick = sc.nextLine();
//
//		System.out.println("이름은: " + name + "\n별명은: " + nick);
//		
//		System.out.println();
//		System.out.println("next() : 토큰(token) 단위로 입력");
//		
//		String tok1 = sc.next();
//		String tok2 = sc.next();
//		String tok3 = sc.next();
//		
//		System.out.println("tok1 : " + tok1);
//		System.out.println("tok2 : " + tok2);
//		System.out.println("tok3 : " + tok3);
		
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		int n3 = sc.nextInt();
		
		System.out.println("n1 : " + n1);
		System.out.println("n2 : " + n2);
		System.out.println("n3 : " + n3);
		
		// 숫자를 입력받은 뒤에 문자열 입력시에는 반드시 nextLine() 을 해줌으로
		// '\n' 을 비워주어야 한다
		sc.nextLine();
		
		System.out.print("주소를 입력하세요: ");
		String addr = sc.nextLine();
		System.out.println("주소: " + addr);
		
		
		
		
		sc.close(); // 시스템 '자원' 반납.
		
		
		System.out.println("\n프로그램 종료");
	}

}










