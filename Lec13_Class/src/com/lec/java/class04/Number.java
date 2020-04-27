package com.lec.java.class04;

public class Number {
	// 멤버변수
	private int num = 100;  // 멤버변수 선언시 초깃값 명시 가능
	
	// 생성자
	// 디폴트 생성자
	public Number() {}
	
	// 매개변수 받는 생성자
	public Number(int num) {
		this.num = num;  // this : 자기자신 을 가리킴
	}
	
	// 메소드
	// getter : 멤버변수의 값을 리턴해주는 메소드
	// setter : 멤버변수의 값을 변경해주는 메소드
	public int getNum() {
		return num;
	}
	
	public void setNum(int num) {
		this.num = num;
	}
	
	public Number add(Number x) {
		this.num += x.num;
		return this;  // 메소드 체이닝
	}
	
	public Number sub(Number x) {
		this.num -= x.num;
		return this;
	}
	
	
	
	
}



















