package com.lec.java.inner08;

public class Anonymous02Main {

	public static void main(String[] args) {
		System.out.println("익명 내부 클래스 활용");
		
		System.out.println("1. 클래스에서 implement 하여 사용 (익명클래스 사용하지 않는 방법)");
		Calculable c1 = new TestMyMath();
		double result = c1.operate(1.0, 2.0);
		System.out.println("result = " + result);
		
		System.out.println();
		System.out.println("2. 익명클래스 사용하는 방법");
		Calculable c2 = new Calculable() {
			@Override
			public double operate(double x, double y) {
				return x * y;
			}
		};
		System.out.println("result = " + c2.operate(2.3, 3.0));
		
		System.out.println();
		result = new Calculable() {
			@Override
			public double operate(double x, double y) {
				return Math.pow(x, y);
			}
		}.operate(2.0, 3.0);
		System.out.println("result = " + result);
		
		System.out.println();
		System.out.println("result = " + new Calculable() {
			
			@Override
			public double operate(double x, double y) {
				return x / y;
			}
		}.operate(20, 30));
		
		
	} // end main()

} // end class Anonymous02Main

interface Calculable {
	public abstract double operate(double x, double y);
}

class TestMyMath implements Calculable{

	@Override
	public double operate(double x, double y) {
		return x + y;
	}
	
}


















