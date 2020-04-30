package com.lec.java.inherit07;

public class BusinessPerson extends Person {
	private String company;

	public String getCompany() {return company;}
	public void setCompany(String company) {this.company = company;}

	// 메소드 오버라이딩 
	// @Override 라는 annotation 붙음 (삭제해도 무관)
	@Override
	public void showInfo() {
		super.showInfo();
		System.out.println("회사: " + company);
	}
	
//	public void whoAreYou() {
//		
//	}
	
	
	
}
