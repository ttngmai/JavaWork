package com.lec.java.while03;

public class While03Main {

	public static void main(String[] args) {
		System.out.println("while 연습");
		
		// while 사용해서 1 ~ 10 사이의 홀수 출력
		System.out.println("1 ~ 10 홀수 출력");
		int n = 1;
		while (n <= 10) {
			if (n % 2 == 1) {
				System.out.println(n);
			} // end if

			n++;
		} // end while
		
		
		System.out.println("if 사용 안하기");
		n = 1;
		while (n <= 10) {
			System.out.println(n);
			n += 2;
		} // end while

		
		

	} // end main()

} // end class While03Main









