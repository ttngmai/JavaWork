package com.lec.java.collection09;

import java.util.HashSet;
import java.util.Iterator;

public class Collection09Main {

	public static void main(String[] args) {
		System.out.println("HashSet 연습");

		// TODO
		// String 타입을 저장할 수 있는 HashSet 를 생성하고
		// 5개 이상의 데이터는 저장, 수정, 삭제 등의 동작을 해보고,
		// iterator, enhanced-for 문을 사용해서 출력해보기

		HashSet<String> set = new HashSet<String>();

		// 데이터 저장
		System.out.println("add 결과: " + set.add("One"));
		System.out.println("add 결과: " + set.add("Two"));
		System.out.println("add 결과: " + set.add("Three"));
		System.out.println("add 결과: " + set.add("Four"));
		System.out.println("add 결과: " + set.add("Five"));
		System.out.println("add 결과: " + set.add(new String("Two")));
		System.out.println("add 결과: " + set.add(new String("Three")));
		System.out.println("add 결과: " + set.add(new String("Two")));
		System.out.println("add 결과: " + set.add(new String("Three")));
		System.out.println("add 결과: " + set.add(new String("Two")));
		System.out.println("add 결과: " + set.add(new String("Three")));

		System.out.println();
		System.out.println("데이터 저장");
		System.out.println("데이터 개수: " + set.size());

		System.out.println();

		// 데이터 검색 - Iterator 사용
		Iterator<String> itr = set.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

		System.out.println();
		// 데이터 삭제
		set.remove("Five");

		System.out.println("삭제 후:");
		itr = set.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

		System.out.println();
		// enhanced for는 인덱스가 필요 없는 for문이기 때문에
		// Set 타입의 자료형에서도 사용 가능
		System.out.println("enhanced for 사용");
		for (String str : set) {
			System.out.println(str);
		}

		// hashCode()
		HashSet<Object> set3 = new HashSet<Object>();
		
		MyClass mc1 = new MyClass();
		MyClass mc2 = new MyClass();
		String s1 = new String("abcd");
		String s2 = new String("abcd");
		
		System.out.println("mc1 hashCode = " + mc1.hashCode());
		System.out.println("mc2 hashCode = " + mc2.hashCode());
		System.out.println("s1 hashCode = " + s1.hashCode());
		System.out.println("s2 hashCode = " + s2.hashCode());
		
		set3.add(mc1);
		set3.add(mc2);
		set3.add(s1);
		set3.add(s2);
		
		System.out.println("set3.size() = " + set3.size());
		
		System.out.println();
		HashSet<Object> set4 = new HashSet<Object>();
		MyNumber mn1 = new MyNumber(100, 5);
		MyNumber mn2 = new MyNumber(100, 9);
		MyNumber mn3 = new MyNumber(200, 5);
		System.out.println("mn1 hashCode() = " + Integer.toHexString(mn1.hashCode()));
		System.out.println("mn2 hashCode() = " + Integer.toHexString(mn2.hashCode()));
		System.out.println("mn3 hashCode() = " + Integer.toHexString(mn3.hashCode()));
		System.out.println(mn1);
		System.out.println(mn2);
		System.out.println(mn3);
		
		set4.add(mn1);
		set4.add(mn2);
		set4.add(mn3);
		
		System.out.println("set4.size() = " + set4.size());  // 몇개?
		
		
		System.out.println("\n프로그램 종료");
	} // end main()
	
} // end class Collection09Main


class MyClass{}


//Set 에서 같은지 다른지, 식별 가능하려면
//hashCode 와 equals 가 오버라이딩 되어야 한다
//hashCode() 값이 같고 equals() 결과가 true 이어야만 같은 객체로 판정한다.
class MyNumber{
	int a, b;
	
	public MyNumber(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	@Override
	public int hashCode() {
		return a;
	}
	
	@Override
	public boolean equals(Object obj) {
		return this.a == ((MyNumber)obj).a;
	}
	
}
















