package com.lec.java.class06;

import java.util.Scanner;

public class Class06Main {

	public static void main(String[] args) {
		System.out.println("클래스 연습 : 성적처리");
		
		// TODO : 사용자로부터 입력
		// 이름, 국어, 영어, 수학  입력받아서 -> Score 객체 생성
		// 총점, 평균 출력		
		// 이름, 국어점수, 영어점수, 수학점수를 입력(Scanner)
		Scanner sc = new Scanner(System.in);
		System.out.println("이름: ");
		String name = sc.nextLine();
		
		System.out.println("국어:");
		int kor = sc.nextInt();
		
		System.out.println("영어:");
		int eng = sc.nextInt();
		
		System.out.println("수학:");
		int math = sc.nextInt();
		
		sc.close();
		
		// Score 인스턴스(score3) 생성
		Score score1 = new Score(name, kor, eng, math);
		
		// 생성된 인스턴스의 내용을 확인
		score1.displayInfo();
		
		// 총점, 평균을 출력
		int total = score1.calcTotal();
		double avg = score1.calcAvg();
		System.out.println("총점: " + total);
		System.out.println("평균: " + avg);

		System.out.println("프로그램 종료");
	} // end main()

} // end class Clas06Main










