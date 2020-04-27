package phonebook01.class01;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PhonebookModel {
	// 멤버변수
	private int uid; // unique id
	private String name; // 이름
	private String phoneNum; // 전화번호
	private String email; // 이메일
	private Date regDate; // 등록일시
	
	// 기본 생성자
	public PhonebookModel() {
		this.name = "";
		this.phoneNum = "";
		this.email = "";
		this.regDate = new Date(); // 생성되는 현재시간
	}
	

	// 매개변수 받는 생성자
	public PhonebookModel(String name, String phoneNum, String email) {
		this();
		this.name = name;
		this.phoneNum = phoneNum;
		this.email = email;
	}
	
	public PhonebookModel(int uid, String name, String phoneNum, String email, Date regDate) {
		super();
		this.uid = uid;
		this.name = name;
		this.phoneNum = phoneNum;
		this.email = email;
		this.regDate = regDate;
	}
	
	// getter & setter
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
	public String getPhoneNum() {return phoneNum;}
	public void setPhoneNum(String phoneNum) {this.phoneNum = phoneNum;}
	
	public String getEmail() {return email;}
	public void setEmail(String email) {this.email = email;}
	
	public int getUid() {return uid;}
	public void setUid(int uid) {this.uid = uid;}

	public Date getRegDate() {return regDate;}
	public void setRegDate(Date regDate) {this.regDate = regDate;}

	@Override
	public String toString() {
		String str = String.format("%3d|%s|%s|%s|%20s",
				uid, name, phoneNum, email,
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(regDate));
		return str;
	}
	
}
