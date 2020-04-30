package com.lec.java.method11;

/* 재귀 호출 (recursive call)
 * 메소드(혹은 함수) 내부에서 메소드가 자기 자신을 또다시 호출하는 것.
 * 
 * 장점:
 * 	복잡한 문제를 간단하고 논리적으로 기술 가능.
 * 
 * 단점 & 주의 :
 *  메모리 부담 발생 
 * 	무한히 재귀호출 할수 없다. --> Stack Overflow 발생
 *  따라서 재귀호출이 종료되는 조건이 반드시 필요하다.
 * 
 * 
 */
public class Method11Main {

	public static void main(String[] args) {
		System.out.println("재귀 호출 (recursive call)");
		System.out.println("재귀 메소드(recursive method)");
		
		//showNumber(0);  // StackOverFlowError : Stack 메모리 용량 초과
		
//		int n = Integer.MAX_VALUE;  
//		double [] arr = new double[n]; // OutOfMemoryError : Heap 메모리 용량 초과
		
		for(int n = 0; n <= 10; n++) {
			System.out.println(n + "! = " + calcFactorial(n));
		}
		
		

		System.out.println("\n프로그램 종료");
	} // end main()
	
	// n! = n * (n - 1) * (n - 2) ... * 1
	//    = n * (n - 1)!
	//
	//          (n - 1) * (n - 2)!
	
	/**
	 * num 의 팩토리얼을 계산해서 리턴
	 * @param num
	 * @return
	 * 기능:
	 * 	    n == 0  -->  0! = 1 리턴
	 *      n > 0   -->  n * (n - 1)! 리턴
	 *      n < 0   --> 계산 불가 
	 */
	public static long calcFactorial(long num) {
		long result = 0L;
		
		if(num == 0) {  // 재귀호출 은 반드시 종료조건이 있어야 한다.
			result = 1L;  // 
		} else if(num > 0) {
			result = num * calcFactorial(num - 1);   // 재귀호출
		} else {
			System.out.println("음수 팩토리얼은 계산 불가");
		}
		
		return result;
	}
	
	
	
	
	
	
	
	// 무한정 재귀 호출 불가
	public static void showNumber(int n) {
		System.out.println(n);
		showNumber(n + 1);
	}
	
	
	
} // end class










