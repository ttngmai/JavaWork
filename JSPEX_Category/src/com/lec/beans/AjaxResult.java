package com.lec.beans;

public class AjaxResult {
	
	private int count;   // 데이터 개수
	private String status;  // 처리 결과
	private String message;  // 결과 메세지
	
	public AjaxResult() {}
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
