package com.lec.java.array04;

import java.util.Scanner;

/* 연습
 * 길이 5개 int 형 배열을 선언하고
 * 사용자로부터 5개 정수를 입력받아 초기화 한뒤 
 * 
 * 총점, 평균, 최대값, 최소값  출력해보기
 */
public class Array04Main {

	public static void main(String[] args) {
		System.out.println("배열 연습");
		
		int [] score = new int[5];
		
		Scanner sc = new Scanner(System.in);
		
		int total = 0; // 총점
		double avg = 0.0; // 평균
		
		for (int i = 0; i < score.length; i++) {
			System.out.print("점수 입력: ");
			score[i] = sc.nextInt();
			total += score[i];
		}
		sc.close();
		
		avg = (double)total / score.length;
		System.out.println("총점: " + total);
		System.out.println("평균: " + avg);
		
		System.out.println();
		// 최댓값
		int max = score[0];
		for(int i = 1; i < score.length; i++) {
			if(score[i] > max) {
				max = score[i];
			}
		}
		System.out.println("최댓값 = " + max);
		
		// 최솟값
		int min = score[0];
		for (int i = 1; i < score.length; i++) {
			min = (score[i] < min) ? score[i] : min;
		} // end for
		System.out.println("최소값 = " + min);
		
		
	} // end main()

} // end class Array04Main








