package com.lec.java.if02;
/* if ~ else if ~ else조건식
 * 
 *  구문3:
 *  if (조건식1) {
 *		조건식1 이 true 일때 실행되는 문장(들)
 *		...
 *  } else if (조건식2) {
 *  	조건식1 이 false 이고
 *		조건식2 이 true 일때 실행되는 문장(들)
 *		...
 *  } else if (조건식3) {
 *  	조건식2 가 false 이고
 *		조건식3 이 true 일때 실행되는 문장(들)
 *		...
 *  } else {
 *  	위의 모든 조건식 모두 false 일때 수행하는 문장(들)
 *  	..
 *  }
 * 
 */

public class If02Main {

	public static void main(String[] args) {
		System.out.println("if - else if - else");
		
		int kor = 78;
		int eng = 70;
		int math = 73;
		int total = kor + eng + math;  // 총점
		double avg = total / 3.0;  // 평균
		
		System.out.printf("평균 : %.2f\n", avg);
		
		// 1. 평균이 90점 이상이면 A학점 (평균: 90 ~ 100)
		// 2. 평균이 80점 이상이면 B학점 (평균: 80 ~ 89)
		// 3. 평균이 70점 이상이면 C학점 (평균: 70 ~ 79)
		// 4. 평균이 60점 이상이면 D학점 (평균: 60 ~ 69)
		// 5. 평균이 60점 미만이면 F학점
		
		if(avg >= 90) {
			System.out.println("학점: A");
		} else if(avg >= 80) {
			System.out.println("학점: B");
		} else if(avg >= 70) {
			System.out.println("학점: C");
		} else if(avg >= 60) {
			System.out.println("학점: D");
		} else {
			System.out.println("학점: F");
		}
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class










