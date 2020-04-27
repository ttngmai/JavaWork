package com.lec.java.static01;

import java.util.Scanner;

// 클래스에 선언된 멤버 변수/멤버 메소드는
// static 여부에 따라 아래와 같이 불려진다

// 인스턴스 변수: 
//   static 이 안붙은 변수
//   인스턴스를 생성한 다음에(new 생성자(); 호출된 다음에)
//   사용할 수 있는 변수
// 인스턴스 메소드:
//   static 이 안 붙은 메소드
//   인스턴스를 생성한 다음에(new 생성자(); 호출된 다음에)
//   사용할 수 있는 메소드

// 클래스 변수(static 변수):
//   클래스의 멤버 변수들 중에서,
//   인스턴스를 생성하지 않아도 사용할 수 있는 변수
// 클래스 메소드(static 메소드):
//   인스턴스를 생성하지 않아도 사용할 수 있는 메소드


public class Static01Main {

	int n = 100;
	
	public static void test() {}
	public void test2() {}
	
	public static void main(String[] args) {
		System.out.println("인스턴스 변수/메소드 vs 클래스 변수/메소드");
		
		// static 안에선 static 이 아닌거 사용 불가
		test();
		//test2();
		
		// 인스턴스 생성
		Static01Main m = new Static01Main();
		m.test2();  // static 이 아닌건 인스턴스 생성후 사용 가능!
		
		//System.out.println(n);
		System.out.println(m.n);
		
	} // end main()

} // end class Static01Main











