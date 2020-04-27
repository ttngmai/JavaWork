package com.lec.java.static02;

public class Test {
	// 멤버변수
	int num;  // 인스턴스 변수
	static int sNum;  // 클래스변수 (static 변수)
	
	// 메소드
	public void show() {  // 인스턴스 메소드
		System.out.println("인스턴스 num = " + num);
		System.out.println("클래스(static) sNum = " + sNum);
	} 
	
	public static void show2() {  // 클래스 메소드
		//System.out.println("인스턴스 num = " + num); // 에러
		System.out.println("클래스(static) sNum = " + sNum);		
	}
	
}







