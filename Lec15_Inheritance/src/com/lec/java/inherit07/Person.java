package com.lec.java.inherit07;

public class Person {
	private String name;

	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
	public void showInfo() {
		System.out.println("이름: " + name);
	}
	
	// final 이 메소드 앞에 붙으면 
	// 더이상 오버라이딩 불가!
	public final void whoAreYou() {
		System.out.println("이름: " + name);
	}
}

// final 이 붙은 클래스는  더이상 상속 불가
final class PostPerson extends Person {
	
}

//class PostBoy extends PostPerson {
//	
//
//}












