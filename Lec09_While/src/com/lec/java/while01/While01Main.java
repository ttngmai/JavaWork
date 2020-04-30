package com.lec.java.while01;

/*
 	조건식이 true 인 동안 while 블럭 반복
 	
 	while(조건식 true / false){
 		.. 
 		..
 	}
 
 */
public class While01Main {

	public static void main(String[] args) {
		System.out.println("while 반복문");
		
		int num = 1;
		while(num <= 10) {
			System.out.println(num);
			num++;
		} // end while
		System.out.println("while 종료후 num = " + num);
		
		System.out.println();
		// 10, 9, 8 ... 1 
		num = 10;
		while(num > 0) {
			System.out.println(num);
			num--;
		}
		System.out.println("while 종료후 num = " + num);
		
 
	} // end main()
	
} // end class While01Main























