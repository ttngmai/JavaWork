package com.lec.java.oop02;

/* 다형성의 유용성
	다형성에 의해서, 자식타입 객체가 부모타입으로 자동 형변환 가능!
	부모타입 만으로도 상속된 모~든 자손 타입들을 담을수 있다.
*/

public class Polymorphism02Main {

	public static void main(String[] args) {
		System.out.println("다형성의 사용 (유용성)");

		
		Vehicle car1 = new Vehicle();
		Vehicle car2 = new Car();
		Vehicle car3 = new HybridCar();
		
		// 다형성의 유용성1
		// 부모타입으로 모~든 자손 타입을 담을수 있다.
		Vehicle [] car = new Vehicle[3];
		car[0] = new Vehicle();
		car[1] = new Car();
		car[2] = new HybridCar();
		
		for (int i = 0; i < car.length; i++) {
			car[i].displayInfo();
		}
		
		// 다형성의 유용성 2
		// 매개변수, 리턴타입에도 적용된다.
		for (int i = 0; i < car.length; i++) {
			System.out.println(car[i]);
		}
		
		Vehicle car4 = new Vehicle();
		Car car5 = new Car();
		HybridCar car6 = new HybridCar();
		
		driveCar(car4);
		driveCar(car5);
		driveCar(car6);
		
		
		// instanceof 연산자
		//    변수/값  instanceof 클래스
		//    결과: true / false
		System.out.println();
		System.out.println(car1 instanceof Vehicle);
		System.out.println(car1 instanceof Car);
		System.out.println(car2 instanceof Vehicle);
		
		
		System.out.println("\n 프로그램 종료");
	} // end main()
	
	
	public static void driveCar(Vehicle v) {
		v.setSpeed(100);
		v.displayInfo();
	}
	
	

} // end class












































