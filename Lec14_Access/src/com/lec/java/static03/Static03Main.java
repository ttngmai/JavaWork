package com.lec.java.static03;

public class Static03Main {

	public static void main(String[] args) {
		System.out.println("Singleton 디자인 패턴");
		// 반드시 인스턴스가 최대1개까지만 생성되게 하는 설계
		
//		Test t1 = new Test();
//		Test t2 = new Test();
		
		Test t1 = Test.getInstance();
		System.out.println("t1: num = " + t1.getNum());
		t1.setNum(123);
		System.out.println("t1: num = " + t1.getNum());
		
		Test t2 = Test.getInstance();
		System.out.println("t2: num = " + t2.getNum());
		
		
	} // end main()

} // end class Static03Main











