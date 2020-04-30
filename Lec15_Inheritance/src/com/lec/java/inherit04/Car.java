package com.lec.java.inherit04;

public class Car extends Vehicle {

	int oil;
	
	public Car() {
		System.out.println("Car() 생성");
	}
	
	public Car(int oil) {
		//super();
		this.oil = oil;
		System.out.println("Car(int) 생성 : oil = " + oil);
	}
	
	public Car(int speed, int oil) {		
		super(speed); // 부모의 생성자 명시적으로 호출
					// super() 는 반드시 첫번째 문장이어야 함
					
		this.oil = oil;
		System.out.println("Car(int, int) 생성 : speed = " + speed 
				+ "oil = " + oil);
	}
	
}









