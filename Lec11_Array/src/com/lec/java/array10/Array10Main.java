package com.lec.java.array10;

/* Enhanced for (향상된 for) 문
 	
 	for (배열타입 변수 : 배열이름) { ... }
 	
 */
public class Array10Main {

	public static void main(String[] args) {
		System.out.println("Enhanced for (향상된 for) 문");
		
		int [] arr = {11, 22, 33, 44, 55};
		
		for(int n : arr) {
			System.out.println(n);
		}
		
		
		int [][] arr2 = {
				{1, 2},
				{3, 4, 5, 6},
				{7}
		};
		
		for(int[] row : arr2) {
			
			for(int x : row) {
				System.out.print(x + " ");
			}
			System.out.println();
			
		}
		
		
		
		
		
		
		
	} // end main()

} // end class Array10Main









