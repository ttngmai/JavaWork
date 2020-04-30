package com.lec.java.inherit10;

/*
	final 메소드 
		더이상 오버라이딩 될수 없는 메소드
 */
/*
메소드 오버라이딩(Overriding), 재정의
부모 클래스에 있는 메소드를
자식 클래스에서 리턴 타입, 매개변수 모두 동일하게 유지하면서
메소드의 본체를 다시 정의하는 것
접근권한(private, (default), protected, public)도 동일하게 유지하는 것이
일반적이지만,
접근 범위를 더 넓게 변경하는 것은 가능. 하지만 좁히는 것은 허용 안됨.
*/

public class Inherit10Main {

	public static void main(String[] args) {
		System.out.println("final 메소드");
		
		TestSuper t1 = new TestSuper();
		System.out.println(t1);
		
		System.out.println("\n프로그램 종료");
	} // end main()
} // end class

class TestSuper{
	
	@Override
	public String toString() {
		return "TestSuper 인스턴스";
	}
	
	private void test1() {
		System.out.println("부모 private 메소드");
	}
	
	void test2() {
		System.out.println("부모 default 메소드");
	}
	
	protected void test3() {
		System.out.println("부모 protected 메소드");
	}
	
	public void test4() {
		System.out.println("부모 public 메소드");
	}
	
	public final void testFinal() {
		System.out.println("부모 final 메소드");
	}
	
}

class TestSub extends TestSuper {
	
	 // ALT + SHIFT + S, V  : Override

	@Override
	public String toString() {
		return "TestSub 인스턴스";
	}

	@Override
	void test2() {
		System.out.println("자식클래스 test2");
	}

	// 접근권한이 더 넓어지는 방향으로 오버라이딩 은 가능!
	@Override
	public void test3() {
		System.out.println("자식클래스 test3");
	}

	@Override
	public void test4() {
		System.out.println("자식클래스 test4");
	}
	
	// 오버로딩
	protected void test4(int n) {
		
	}
	
	
}















