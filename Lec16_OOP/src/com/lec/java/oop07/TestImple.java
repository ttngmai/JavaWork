package com.lec.java.oop07;

// 인터페이스를 구현(implements)하는 클래스에서
// 인퍼페이스에 선언만 돼있는 메소드들을 구현(정의)해야 함

public class TestImple implements InterfaceAAA, InterfaceBBB{

	@Override
	public void testBBB() {
		System.out.println("InterfaceBBB: test 구현");
	}

	@Override
	public void testAAA() {
		System.out.println("InterfaceAAA: test 구현");
	}


} // end class TestImple



