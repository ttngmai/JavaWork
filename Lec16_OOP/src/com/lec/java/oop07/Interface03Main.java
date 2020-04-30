package com.lec.java.oop07;

public class Interface03Main {

	public static void main(String[] args) {
		System.out.println("인터페이스와 다형성");
		
		TestImple t1 = new TestImple();
		t1.testAAA();
		t1.testBBB();
		
		System.out.println();
		InterfaceAAA t2 = new TestImple();
		t2.testAAA();
		
		
		
		System.out.println("\n 프로그램 종료");
	} // end main()

} // end class











































