package com.lec.java.wrapper05;

/* Wrapper 클래스의 유용성
 * 1. Object 타입이 모~든 (심지어 primitive) 타입도 받을수 있다.
 * 2. Collection 과 같은 Generic 클래스에선
 *     primitive 타입을 담을수 없다. 그러나 ,Wrapper 를 통해 가능하다.
 */
public class Wrapper05Main {

	public static void main(String[] args) {
		System.out.println("Wrapper 클래스의 유용성");
		
		Object [] obj = new Object[5];
		
		obj[0] = method1(new Wrapper05Main());
		obj[1] = method1(new A());
		obj[2] = method1(new A2());
		obj[3] = method1(new B());
		obj[4] = method1(123);  // Object 가 primitive type 을 담을수 있다!?
						// ↑ Auto-Boxing + Polymorphism
		 				// Object <- Integer <- int
		
		for(Object e : obj) {
			System.out.println(e);
		}
		
		

		System.out.println("\n프로그램 종료");
	} // end main()

	public static Object method1(Object arg) { return arg; }
	
} // end class

class A{}
class A2 extends A{}
class B{}



























