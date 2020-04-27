package com.lec.java.wrapper03;

import java.util.Scanner;

public class Wrapper03Main {

	public static void main(String[] args) {
		System.out.println("Wrapper의 parseXXX() 사용");
		
		Integer num1 = 100;
		//Integer num2 = "100";  // 불가
		
		String str = "100";
		int n = Integer.parseInt(str);  //  int <-- String
		
		System.out.println(n * 2);
		
		str = "3.14";
		double d = Double.parseDouble(str);  // double <-- String
		System.out.println(d * 2);
		
		str = "aaa";
		//n = Integer.parseInt(str);  // NumberFormatException 발생
		
		

	} // end main()

} // end clsss









