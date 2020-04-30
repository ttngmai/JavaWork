package com.lec.java.collection05;

import java.util.ArrayList;
import java.util.Iterator;

public class Collection05Main {

	public static void main(String[] args) {
		System.out.println("ArrayList 연습");
		
		//TODO:
		// Student 타입을 담는 ArrayList를 만드고
		// 사용자로부터 3개의 Student 데이터 을 입력받아서
		// 3가지 방법으로 출력해보세요. 
		// for, Enhanced-for, Iterator
		
		// Student를 저장할 수 있는 ArrayList 인스턴스 생성
		ArrayList<Student> list = new ArrayList<Student>();
		
		// Student를 저장: add()
		Score score1 = new Score(100, 90, 80);
		Student stu1 = new Student(1, "김남승", score1);
		list.add(stu1);
		
		Score score2 = new Score(80, 100, 90);
		Student stu2 = new Student(2, "김동혁", score2);
		list.add(stu2);
		
		Score score3 = new Score(80, 90, 100);
		Student stu3 = new Student(3, "김병기", score3);
		list.add(stu3);
		
		
		// 검색: get()
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		} // end for
		
		
		// 삭제: remove()
		list.remove(1);
		System.out.println("삭제 후:");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		} // end for
		
		
		// 수정: set()
		Student stu = list.get(1);
		stu.setId(2);
		stu.getScore().setKorean(99);
		stu.getScore().setEnglish(99);
		stu.getScore().setMath(99);
		list.set(1, stu);
		System.out.println("수정 후:");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		} // end for
		
		
		System.out.println("Enhanced-for 를 사용한 출력");
		for(Student s:list) {
			System.out.println(s);
		}
		
		System.out.println("Iterator 를 사용한 출력");
		Iterator<Student> itr = list.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class Collection05Main









