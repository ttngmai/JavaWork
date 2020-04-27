package com.lec.java.wrapper01;

/* Wrapper 클래스: 기본 자료형(primitive type)의 데이터를 감싸는 클래스
 * 기본 자료형: boolean, char, byte, short, int, long, float, double
 * Wrapper: Boolean, Character, Byte, Short, Integer, Long, Float, Double
 */

public class Wrapper01Main {

	public static void main(String[] args) {
		System.out.println("Wrapper 클래스");
		System.out.println("wrapper 클래스에 값을 저장하는 방법");
		System.out.println();

		Integer i1 = 100;  // reference <= primitive ?!
		i1 = i1 + 200;  // reference 가 산술연산?!
		System.out.println("i1 = " + i1);
		// ★Wrapper 클래스는 마치 primitive 타입 처럼 동작한다!★
		
		
		// 1. 생성자 이용
		Integer num1 = new Integer(123);
		System.out.println("num1 = " + num1);
		
		// 2. wrapper 클래스의 static 메소드인 valueOf() 메소드를 사용
		Integer num2 = Integer.valueOf(123);
		System.out.println("num2 = " + num2);
		
		if(num1 == num2) {
			System.out.println("== 같다");
		} else {
			System.out.println("== 다르다");
		}

		if(num1.equals(num2)) {
			System.out.println("equals 같다");
		} else {
			System.out.println("equals 다르다");
		}
		
		// 3. new Integer() VS Integer.valueOf()
		Integer num3 = new Integer(123);  // new 는 새로운 instance 생성
		Integer num4 = Integer.valueOf(123); // valueOf() 는 Object 를 cache 해둔다.
										// 같은 literal 로 생성하면, 기존에 생성된 Object 리턴
										// 메모리 절약 차원
		
		if(num1 == num3) {
			System.out.println("생성자: 같은 참조");
		} else {
			System.out.println("생성자: 다른 참조"); // 다르다!
		}
		
		if(num2 == num4) {
			System.out.println("valueOf() : 같은 참조");
		} else {
			System.out.println("valueOf() : 다른 참조");
		}
		
		
		// 4. literal 상수로 생성
		System.out.println();
		Integer num5 = 123;    // Integer.valueOf(123) 이 동작함
								// Auto-Boxing 동작
		
		
		// 5. valueOf(문자열) 가능!
		System.out.println();
		Integer num6 = Integer.valueOf("123");
							// num5, num4 와  == 결과 같다
		
		if(num5 == num6) {
			System.out.println("같다");
		} else {
			System.out.println("다르다");
		}
		
		// 6. 산술 연산 가능
		num6 *= 2;
		System.out.println(num6);

		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class
















