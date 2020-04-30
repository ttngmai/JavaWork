package com.lec.java.method07;

import java.util.Random;

/* Math 클래스의 메소드
 */
public class Method07Main {

	public static void main(String[] args) {
		System.out.println("Math 객체의 메소드");
		
		System.out.println(Math.random());  // 0.0 <= r < 1.0 사이의 난수 발생
		
		System.out.println(Math.floor(2.7));  // floor(num) num을 넘지 않는 가장 큰 정수
		System.out.println(Math.ceil(2.7));   // ceil(num) num보다 큰 가장 작은 정수
		System.out.println(Math.round(2.7));  // round(num) num에서 사사오입(반올림)
		
		System.out.println(Math.floor(-1.2));  // floor(num) num을 넘지 않는 가장 큰 정수
		System.out.println(Math.ceil(-1.2));   // ceil(num) num보다 큰 가장 작은 정수
		System.out.println(Math.round(-1.2));  // round(num) num에서 사사오입(반올림)

		System.out.println(Math.floor(-2.7));  // floor(num) num을 넘지 않는 가장 큰 정수
		System.out.println(Math.ceil(-2.7));   // ceil(num) num보다 큰 가장 작은 정수
		System.out.println(Math.round(-2.7));  // round(num) num에서 사사오입(반올림)
		
		
		System.out.println();
		System.out.println("1, 2, 3 범위중 난수 발생시키기");
		for(int i = 0; i < 5; i++) {
			double num;
			num = Math.random();     // 0.0 <= num < 1.0
			num *= 3;                // 0.0 <= num < 3.0
			num += 1;                // 1.0 <= num < 4.0
			
			System.out.printf("%d ", (int)num);
		}
		System.out.println();
		
		System.out.println("1 ~ 45 숫자중 랜덤으로 6개 출력, 중복허용");
		for(int i = 0; i < 6; i++) {
//			double num;
//			num = Math.random();     // 0.0 <= num < 1.0
//			num *= 45;                // 0.0 <= num < 45.0
//			num += 1;                // 1.0 <= num < 46.0			
			System.out.printf("%d ", (int)(Math.random() * 45 + 1));
		}
		System.out.println();
		
		
		System.out.println("Random 객체 사용하여 난수 출력");
		Random rand = new Random();
		for(int i = 0; i < 5; i++) {
			System.out.printf("%d ", rand.nextInt(3) + 1);  // 0 ~ 2 사이의 정수 난수 발생
		}
		System.out.println();
		
		
		// 제곱근 구하기
		System.out.println(Math.sqrt(2));
		System.out.println(Math.sqrt(9));
		
		// 제곱
		System.out.println(Math.pow(2, 4));
		System.out.println(Math.pow(10, -1));
		
		
		
		
		System.out.println("\n프로그램 종료");
	} // end main()
	
	// TODO

} // end class









