package com.lec.java.firstjava;

/*
	모든 자바 프로그램은 main() 메소드로부터 '시작'한다
	프로그램 실행순서는 '시작' 부터 한 문장(Statement) 씩 실행되는 것이 원칙
	문장의 끝은 반드시 세미콜론 ';' 으로 마무리 해야 한다
*/
public class FirstJava {

	public static void main(String[] args) { // main() 은 프로그램의 시작점 (entry point)
		// 주석 (comment)
		// 프로그램 실행과는 관계 없지만,
		// 개발자가 프로그램 작성시 설명을 달아 두는 것
		
		// line comment : 우측 한줄은 모두 주석처리
		
		// System.out.println(화면에 출력할 내용);   // <-- 화면출력 + 줄바꿈
		System.out.println("My First Java App");
		
		/*
		 * blcok comment 
		 * 여러줄의 주석 작성시 사용
		 * 
		 */
		
		System.out.println(123);   // 숫자 123
		System.out.println("123");  // " ~ " 문자열 인식
		
		System.out.println();   // 줄바꿈만 수행
		
		System.out.println(10 + 20);
		System.out.println("10 + 20");
		System.out.println("10" + "20");  // "문자열" + "문자열" --> "문자열연결결과"
//		System.out.println(안녕하세요);   // 문자열은 반드시 " ~ " 으로 감싸야 함
		
		System.out.println(3.141592 * 10 * 10);
		System.out.println(10 * 10 / 2);
		
		// + 연산자의 의미
		// 좌우 피연산자에 따라 동작 다름
		System.out.println("안녕하세요" + " + " + "자바입니다");
		System.out.println("결과:" + 10);  // 한쪽이 "문자열" 이면 다른 한쪽이 문자열로 변환된 뒤 + 수행
		
		System.out.println("결과:" + 10 + 20);
		System.out.println("결과:" + (10 + 20));
		System.out.println(10 + 20 + "결과:" + 10 + 20);
		
		// 사칙연산 보여주기
		System.out.println("10 + 20 = " + (10 + 20));
		System.out.println("10 - 20 = " + (10 - 20));
		System.out.println("10 * 20 = " + (10 * 20));
		System.out.println("10 / 20 = " + (10 / 20));
		
		// 정수 : 소숫점이 없는 숫자
		// 실수 : 소숫점이 있는 숫자
		// 정수 와 정수의 연산 결과는 언제나 정수
		// 실수 와 연산하는 경우는 언제나 결과는 실수

		System.out.println("10.0 + 20.0 = " + (10.0 + 20.0));
		System.out.println("10.0 - 20.0 = " + (10.0 - 20.0));
		System.out.println("10.0 * 20.0 = " + (10.0 * 20.0));
		System.out.println("10.0 / 20.0 = " + (10.0 / 20.0));
		
		System.out.println("10.0 / 20 = " + (10.0 / 20));
		System.out.println("10 / 20.0 = " + (10 / 20.0));
		
		// print() 출력만 하고 줄바꿈 안함
		System.out.print("안녕");   
		System.out.print("하세요");   
		System.out.println("She says hello");
		
		// She says "Hi"   <-- 출력하려면?
		System.out.println("She says \"Hi\"");
		
		// 이스케이프 문자(escape character)
		// 문자열 안에서 특수한 문자 출력시 사용
		// 백슬래시 + 문자  로 구성.
		
		//   \"  : 쌍따옴표
		//   \n  : 줄바꿈
		//   \t  : 탭문자
		//   \\  : 백슬래시 출력
		
		System.out.println("Avengers\n \\EndGame");
		System.out.println("\t1234\t5678");
		System.out.println("\t10\t4");
		
		

		 
	} // end main()

} // end class














