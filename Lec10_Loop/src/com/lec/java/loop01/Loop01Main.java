package com.lec.java.loop01;

/* break;
 * 순환문(for, while, do~while) 안에서 break를 만나면
 * break를 감싸는 가장 가까운 순환문 종료
 */
public class Loop01Main {

	public static void main(String[] args) {
		System.out.println("Break");
		
		for(int i = 1; i <= 10; i++) {
			if(i == 3) break;
			System.out.println(i);
		}
		
		System.out.println();
		// 2와 7의 최소공배수를 출력
		// 최소공배수: 공배수 중에서 가장 작은 수
		int num1 = 2, num2 = 7;
		int start = (num1 > num2) ? num1 : num2;
		
		for(;;start++) {
			if(start % 2 == 0 && start % 7 == 0) {
				System.out.println(start);
				break;
			}
		}
		
		

		System.out.println();
		System.out.println("무한 루프와 break;");

		int s = 1;
		for(;; s++) {
			System.out.println(s);
			if(s > 100) break;  // 무한루프 종료
		}
		
		
		System.out.println();
		// 2단은 x 2 까지 출력
		// 3단은 x 3 까지 출력
		
		// TODO

		
		System.out.println("\n프로그램 종료");
		
		
	
		
		
	} // end main()

} // end class


















