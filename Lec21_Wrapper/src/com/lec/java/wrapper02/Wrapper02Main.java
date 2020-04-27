package com.lec.java.wrapper02;

/* Java 5부터 wrapper 클래스의 auto-boxing/unboxing 기능 제공
 * 	boxing(포장): 기본자료형의 값을 wrapper 클래스에 저장하는 것
 * 	unboxing(개봉): wrapper 클래스에 저장된 기본자료형 값을 꺼내는 것
 */
public class Wrapper02Main {

	public static void main(String[] args) {
		System.out.println("auto-boxing, auto-unboxing");

		Integer num1 = 10;  // Integer.valueOf(10);    // auto-boxing
		Integer num2 = 20;
		Integer num3 = num1 + num2;
		//num1.intValue();  // unboxing
		
		Integer num30 = Integer.valueOf(num1.intValue() + num2.intValue());
		
		System.out.println("num1 = " + num1 + ", " + num1.intValue());
		System.out.println("num2 = " + num2 + ", " + num2.intValue());
		System.out.println("num3 = " + num3 + ", " + num3.intValue());
		 
		
		
		System.out.println();
		System.out.println("boxing/unboxing");
		// boxing(포장): 기본자료형의 값을 wrapper 클래스에 저장하는 것
		// unboxing(개봉): wrapper 클래스에 저장된 기본자료형 값을 꺼내는 것
		
		// TODO
		
		
		System.out.println();
		System.out.println("auto-boxing/auto-unboxing");

		// TODO
		
		System.out.println();
		System.out.println("wrapper 클래스들");
		
		Long num100 = Long.valueOf(1000000000L);  // boxing
		long n100 = num100.longValue(); // unboxing
		
		Double num200 = Double.valueOf(3.14);  // boxing
		double n200 = num200.doubleValue();  // unboxing
		
		
		
		// primitive 와 wrapper 가 비교 연산 하면???  auto-unboxing 발생!
		//    ※ wrapper 끼리 비교하면, 주소비교임
		if(num1 == 10) {
			System.out.println("같다");  // 같다
		} else {
			System.out.println("다르다");
		}
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class















