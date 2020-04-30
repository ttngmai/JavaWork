package com.lec.java.method03;

import java.util.Scanner;

public class Method03Main {
	
	public static void main(String[] args) {
		System.out.println("메소드 연습");
		
		int kor, eng, math;  // 국,영,수 점수
		Scanner sc = new Scanner(System.in);
		System.out.print("국,영,수 점수 입력하세요: ");
		kor = sc.nextInt();
		eng = sc.nextInt();
		math = sc.nextInt();
		sc.close();
		
		int total = calcTotal(kor, eng, math);
		System.out.println("총점: " + total);
		
		double avg = calcAvg(total);
		System.out.println("평균: " + avg);
		
		char grade = calcGrade(avg);
		System.out.println("학점: " + grade);

		System.out.println("\n프로그램 종료");
	} // end main()

	// calcTotal
	// 기능: 국어, 영어, 수학 점수를 입력 받아서 총점을 리턴하는 메소드
	// return: int
	// method name: calcTotal
	// arguments:
	//   1) int kor: 국어 점수
	//   2) int eng: 영어 점수
	//   3) int math: 수학 점수
	public static int calcTotal(int kor, int eng, int math) {
					// calcTotal(int, int, int)
		return kor + eng + math;
	}
	
	// calcAvg
	// 기능: 총점을 입력받아서 평균을 리턴하는 메소드
	// return: double
	// method name: calcAvg
	// arguments: int total - 총점
	public static double calcAvg(int total) {
		return (double)total / 3;
	} // end calcAvg
	
	
	// calcGrade
	// 기능: 평균을 받아서 등급을 리턴하는 메소드
	//      평균 90 이상이면 'A', 80 이상이면 'B', 70 이상이면 'C', 60 이상이면 'D'
	//      나머지는 'F' 리턴
	// return: char
	// method name: calcGrade
	// arguments: double avg - 평균
	public static char calcGrade(double avg) {
//		char grade;
//		if (avg >= 90) {
//			grade = 'A';
//		} else if (avg >= 80) {
//			grade = 'B';
//		} else if (avg >= 70) {
//			grade = 'C';
//		} else if (avg >= 60) {
//			grade = 'D';
//		} else {
//			grade = 'F';
//		}
//		return grade;
		
		if(avg >= 90) return 'A';
		if(avg >= 80) return 'B';
		if(avg >= 70) return 'C';
		if(avg >= 60) return 'D';
		return 'F';
		
		//System.out.println("헐");  // return 이후 코드 실행 불가
		
	}
	
	
	
} // end class








