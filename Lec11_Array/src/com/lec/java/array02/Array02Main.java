package com.lec.java.array02;
/*  배열의 선언과 초기화
 	
 	배열 선언 따로, 초기화 따로
		타입[] 이름 = new 타입[배열의 길이];
		
	배열을 선언과 동시에 초기화 1
		타입[] 이름 = new 타입[] {a, b, c, ...};
		
	배열을 선언과 동시에 초기화 2
		타입[] 이름 = {a, b, c, ...};
		
	배열의 길이를 자동으로 알 수 있는 방법
		배열이름.length 
 */
public class Array02Main {

	public static void main(String[] args) {
		System.out.println("배열의 선언과 초기화");
		
		// 1.
		int [] korean = new int[3];
		//int korean2[];
		
		korean[0] = 100;
		korean[1] = 90;
		korean[2] = 80;
		
		
		// 2.
		int [] english = new int[] {30, 20, 40};
		for (int i = 0; i < english.length; i++) {
			System.out.println("영어" + i + " : " + english[i]);
		}
		
		// 3.
		int [] math = {99, 88, 77, 66};   // ↔ new int[]{99, 88, 77, 66}
		for (int i = 0; i < math.length; i++) {
			System.out.println("수학" + i + " : " + math[i]);
		}
		
		// 국어 점수들의 총점과 평균 계산 (for 사용)
		int total = 0;
		for(int n = 0; n < korean.length; n++) {
			total += korean[n];
		}
		
		System.out.println("국어총점: " + total);
		System.out.println("국어평균: " + (double)total / korean.length);
		
		// 수학점수들의 총점과 평균 계산 : while 사용
		total = 0;
		int n = 0; // 배열 인덱스를 위한 변수
		while (n < math.length) {
			total += math[n];
			n++;
		}
		System.out.println("수학 총점: " + total);
		System.out.println("수학 평균: " + (double) total / math.length);	
		
		
		// 배열 변수 자체를 출력하면!?
		System.out.println();
		System.out.println(korean);
		System.out.println(english);
		System.out.println(math);
		
		
		
		
	} // end main()

} // end class Array02Main



















