package com.lec.java.static03;

public class Test {
	
	private int num;
	
	// singleton 디자인패턴
	
	// private 생성자
	private Test() {
		System.out.println("Test() 생성");
		num = 100;
	}
	private static Test instance = null;
	
	public static Test getInstance() {
		if(instance == null) {
			instance = new Test();
		}
		return instance;
	}
	
	public int getNum() {
		return this.num;
	}
	
	public void setNum(int num) {
		this.num = num;
	}
	
}










