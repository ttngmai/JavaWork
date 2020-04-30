package com.lec.java.loop04;

public class Loop04Main {

	public static void main(String[] args) {
		System.out.println("중첩 반복문과 break 연습");
		
		// 2단은 x2까지.. 9단은 x9까지 출력하기.   break 사용
		
		for(int dan = 2; dan < 10; dan++) {
			System.out.println(dan + "단");
			for(int n = 1; n < 10; n++) {				
				System.out.println(dan + " x " + n + " = " + (dan * n));
				if(dan == n) break;
			}
			System.out.println();
		}
		
		System.out.println("------------------------------------------");
		
		for(int dan = 2; dan < 10; dan++) {
			System.out.println(dan + "단");
			for(int n = 1; n <= dan; n++) {				
				System.out.println(dan + " x " + n + " = " + (dan * n));
			}
			System.out.println();
		}
		
		// 2단은 x2 부터, 3단은 x3 부터 출력  continue 사용
		System.out.println("--------------------------------------");
		int dan = 2;
		while (dan < 10) {
			System.out.println("구구단 " + dan + "단");
			int n = 0;
			while (n < 10) {
				n++;
				if(dan > n) {
					continue;					
				}
				
				System.out.println(dan + " x " + n + " = " + (dan * n));
			} // end while (n)
			System.out.println();

			dan++;
		} // end while (dan)
		
		

		System.out.println("\n프로그램 종료");
	} // end main()

} // end class

















