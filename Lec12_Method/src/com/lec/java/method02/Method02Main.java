package com.lec.java.method02;

/* return 의 믜미
 * 
 *   1. 메소드를 호출한 곳으로 값을 리턴한다.
 *   2. 메소드 종료
 *   3. 메소드 정의시 명시한 리턴타입의 값이 '반드시' 리턴되어야 한다
 *          (혹은 리턴타입으로 형변환 가능한 값이)
 */

public class Method02Main {

	public static void main(String[] args) {
		System.out.println("메소드의 리턴 타입");
		int sum = add(100, 200);
		System.out.println("sum = " + sum);

		// 메소드의 매개변수로 정수 두 개를 넘겨주면
		// 그 결과로 앞의 수에서 뒤의 수를 뺀 값을 되돌려 싶다.
		int result = sub(100, 10);
		System.out.println("result = " + result);

		System.out.println();
		// 곱하기
		result = multiply(123, 321);
		System.out.println("result = " + result);

		System.out.println();

		// 나누기
		result = divide(25, 3);
		System.out.println("result = " + result);
		
//		result = divide(10, 0);  // Exception
		
		

		System.out.println("\n프로그램 종료");
	} // end main()

	// 메소드 이름 : add
	// 매개변수
	// 1) int x
	// 2) int y
	// 리턴타입 : int
	public static int add(int x, int y) {
		int result = x + y;
		return result; // return [값] 키워드 사용하여 리턴함.
	} // end add()

	// 리턴타입: int
	// 메소드 이름: sub
	// 매개변수:
	// 1) int x
	// 2) int y
	public static int sub(int x, int y) {
		int result = x - y;
		return result;
	} // end sub()

	// 리턴타입: int
	// 메소드 이름: multiply
	// 매개변수:
	// 1) int x
	// 2) int y
	public static int multiply(int x, int y) {
		return x * y;
	} // end multiply()

	// 리턴타입: int
	// 메소드 이름: divide
	// 매개변수:
	// 1) int x
	// 2) int y
	// 기능: x를 y로 나눈 몫을 리턴하는 메소드
	public static int divide(int x, int y) {
		return x / y;
	} // end divide()

} // end class











