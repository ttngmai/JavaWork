package com.lec.java.class03;

public class Number {
	// 멤버변수
	private int num;
	
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
		if(num <= 0) return;
		this.num = num;
	}
	// 작명 관례
	// get + 변수이름()
	// set + 변수이름()
	
	// 멤버변수 : height
	// getter -> getHeight
	// settter -> setHeight
	
}








