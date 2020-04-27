package com.lec.java.class02;


public class Class02Main {

	public static void main(String[] args) {
		System.out.println("클래스 연습");		
		
		Circle c1 = new Circle();
		Circle c2 = new Circle(3);
		
		double perimeter = c1.calcPerimeter();
		double area = c1.calcArea();
		
		System.out.println("c1의 둘레:" + perimeter);
		System.out.println("c1의 넓이:" + area);

		perimeter = c2.calcPerimeter();
		area = c2.calcArea();
		
		System.out.println("c2의 둘레:" + perimeter);
		System.out.println("c2의 넓이:" + area);
		
		System.out.println();
		System.out.println("==================");
		Rectangle r1 = new Rectangle();
		perimeter = r1.calcPerimeter();
		System.out.println("사각형1의 둘레: " + perimeter);
		area = r1.calcArea();
		System.out.println("사각형1의 넓이: " + area);
		
		Rectangle r2 = new Rectangle(2, 3);
		perimeter = r2.calcPerimeter();
		System.out.println("사각형2의 둘레: " + perimeter);
		area = r2.calcArea();
		System.out.println("사각형2의 넓이: " + area);
		
		
		
		
		
		
		
		System.out.println("프로그램 종료");
	} // end main()

} // end class Class02Main










