package practice.prime1;

import java.util.Scanner;

public class PrimeNumber1 {

	public static void main(String[] args) {
		System.out.println("소수 판별");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int i;
		for(i = 2; i < n; i++) {
			if(n % i == 0) {  // 중간에 나누어 떨어지는 수가 발견되면 소수 아님!
				break;
			}
		}
		sc.close();
		
		if(i == n) 
			System.out.println("true");
		else
			System.out.println("false");

	}

}
