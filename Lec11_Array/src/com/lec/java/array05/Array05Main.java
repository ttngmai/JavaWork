package com.lec.java.array05;

import java.util.Scanner;

/* 2차원 배열 (2-dimensional array)
 * 	직전의 예제와 같이 같이 배열 첨자를 하나만 쓰는 배열을 
 * 1차원 배열 (one-dimensional array) 이라고 함
 *   배열원소가 '1차원 배열' 들로 이루어진 배열을 2차원 배열 이라 한다
 *   배열원소가 '2차원 배열' 들로 이루어진 배열을 3차원 배열 이라 한다
*/
public class Array05Main {

	public static void main(String[] args) {
		System.out.println("2차원 배열");
		
		// 3개의 1차원 배열을 담고 있는 2차원 배열
		int[][] array = {
				{1, 2},   // <-- array[0]
				{3, 4},   // <-- array[1]
				{5, 6}    // <-- array[2]
		};
		
		System.out.println(array[0][0]);
		System.out.println(array[0][1]);
		System.out.println(array[1][0]); // 3 출력
		System.out.println(array[1][1]);
		System.out.println(array[2][0]);
		System.out.println(array[2][1]); // 6 출력
		//System.out.println(array[2][2]);  // Exception
		
		
		System.out.println("array.length = " + array.length); // 1차원 배열의 개수
		
		// array --> int[][]
		// array[0] --> int[]
		// array[0][0] --> int
		
		System.out.println("array[0].length = " + array[0].length);
		
		System.out.println();
		for(int row = 0; row < array.length; row++) {
			for(int col = 0; col < array[row].length; col++) {
				System.out.print(array[row][col] + "\t");
			}
			System.out.println();
		}
		
		System.out.println();
		
		int [][] arr44 = {
				{1, 2, 3, 4},
				{5, 6, 7, 8}
		};
		
		// TODO: arr4 의 int 값들 출력, for 사용
		for(int x = 0; x < arr44.length; x++) {
			for(int y = 0; y < arr44[x].length; y++) {
				System.out.print(arr44[x][y]  + "\t");
			}
			System.out.println();
		} // end for
		
		
		System.out.println(arr44);
		System.out.println(arr44[0]);
		
		
		
		
	} // end main()

} // end class Array05Main









