package com.lec.java.if03;

import java.util.Scanner;

/* if 조건문 연습 : 간단한 성적 처리 프로그램
 * 사용자로부터 국어,영어,수학 점수 (정수) 를 입력 받은뒤
 * 우선 '총점' 과 '평균' 을 계산해서 출력하고
 * 
 * '학점'을 아래와 같이 출력하세요
 * 	평균이 90점 이상이면 "A학점" 출력 (평균: 90 ~ 100)
 * 	평균이 80점 이상이면 "B학점" 출력 (평균: 80 ~ 89)
 * 	평균이 70점 이상이면 "C학점" 출력 (평균: 70 ~ 79)
 * 	평균이 60점 이상이면 "D학점" 출력 (평균: 60 ~ 69)
 * 	평균이 60점 미만이면 "F학점" 출력
 */

public class If03Main {

	public static void main(String[] args) {
		System.out.println("간단한 성적 처리 프로그램");

		// 입력 받을 준비 - Scanner
		Scanner sc = new Scanner(System.in);

		// 국어 점수를 입력받아서 저장
		int korean;
		System.out.println("국어 점수 입력:");
		korean = sc.nextInt();

		// 수학 점수를 입력받아서 저장
		int math;
		System.out.println("수학 점수 입력:");
		math = sc.nextInt();

		// 영어 점수를 입력받아서 저장
		int english;
		System.out.println("영어 점수 입력:");
		english = sc.nextInt();

		// 사용이 끝난 Scanner를 닫아줌
		sc.close();

		// 입력받은 점수들 확인
		System.out.println("----- 입력한 점수 -----");
		System.out.println("국어: " + korean);
		System.out.println("수학: " + math);
		System.out.println("영어: " + english);

		// 총점 계산
		int total = korean + math + english;
		System.out.println("총점: " + total);

		// 평균 계산
		double average = (double) total / 3;
		System.out.println("평균: " + average);

		// 1. 평균이 90점 이상이면 A학점 (평균: 90 ~ 100)
		// 2. 평균이 80점 이상이면 B학점 (평균: 80 ~ 89)
		// 3. 평균이 70점 이상이면 C학점 (평균: 70 ~ 79)
		// 4. 평균이 60점 이상이면 D학점 (평균: 60 ~ 69)
		// 5. 평균이 60점 미만이면 F학점
		if (average >= 90) {
			System.out.println("학점: A");
		} else if (average >= 80) {
			System.out.println("학점: B");
		} else if (average >= 70) {
			System.out.println("학점: C");
		} else if (average >= 60) {
			System.out.println("학점: D");
		} else {
			System.out.println("학점: F");
		} // end else

		System.out.println("\n프로그램 종료");
	} // end main()

} // end class
