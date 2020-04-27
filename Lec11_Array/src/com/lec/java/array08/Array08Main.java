package com.lec.java.array08;

public class Array08Main {

	public static void main(String[] args) {
		System.out.println("2차원 배열 연습");
		
		int [][] array = new int[10][10];
		System.out.println(array[2][3]);
		
		for(int x = 0;  x < array.length; x++) {
			for(int y = 0; y < array[x].length; y++) {
				array[x][y] = x * y;
			}
		}

		for(int x = 0;  x < array.length; x++) {
			for(int y = 0; y < array[x].length; y++) {
				System.out.print(array[x][y] + "\t");
			}
			System.out.println();
		}
		
		
		
	} // end main()

} // end class Array08Main









