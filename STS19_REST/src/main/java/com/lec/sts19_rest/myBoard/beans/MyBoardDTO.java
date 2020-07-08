package com.lec.sts19_rest.myBoard.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MyBoardDTO {
	private int uid; // wr_uid
	private String subject; // wr_subject
	private String content; // wr_content
	private String name; // wr_name
	@JsonProperty("viewcnt")
	private int viewCnt; // wr_viewcnt
	@JsonProperty("regdate")
	private String regDate; // wr_regdate
	
	// 개발시..
	// 다음 3가지 네이밍은 일치시켜주는 것이 좋다 .
	// 클래스 필드명 = DB 필드명  = form 의 name명
	
	// 기본생성자, 매개변수 생성자
	public MyBoardDTO() {
		super();
	}
	public MyBoardDTO(int uid, String subject, String content, String name, int viewCnt) {
		super();
		this.uid = uid;
		this.subject = subject;
		this.content = content;
		this.name = name;
		this.viewCnt = viewCnt;
	}
	
	// getter & setter
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
} // end DTO

















