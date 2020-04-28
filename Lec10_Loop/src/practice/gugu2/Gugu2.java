package practice.gugu2;

public class Gugu2 {
	
	public static void main(String[] args) {
	
		for(int i = 2; i <= 9; i += 3) {
			
			for(int n = 1; n <= 9; n++) {
				
				for(int dan = i; dan <= i+2; dan++) {
					if(dan > 9) break;
					System.out.printf("%d x %d = %-5d", dan, n, (dan * n));
				}
				System.out.println();
				
			}
			System.out.println();
			
		}
		
	}
	
}
