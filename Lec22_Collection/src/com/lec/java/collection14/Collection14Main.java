package com.lec.java.collection14;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeMap;

// Hash: 검색을 빠르게 하기 위한 용도
// Tree: 데이터 정렬을 하기 위한 용도

public class Collection14Main {

	public static void main(String[] args) {
		System.out.println("TreeMap 클래스");
		
		// TreeMap<Integer, String> 타입 인스턴스 생성
		TreeMap<Integer, String> tmap = new TreeMap<Integer, String>();
		
		// 데이터 저장: put(key, value) 메소드 사용
		tmap.put(4, "zxcv");
		tmap.put(2, "qwer");
		tmap.put(1, "1234");
		tmap.put(3, "asdf");
		
		
		// values() : value 들로 이루어진 Collection 리턴
		System.out.println("values()");
		for(String value : tmap.values()) {
			System.out.println(value);
		}
		
		
		// 데이터 검색: get(key) 메소드를 사용
		// 1. 키값들로만 이루어진 Set을 만듬
		Set<Integer> kset = tmap.keySet();
		
		// 2. keySet을 가지고 iterator를 만듬
		Iterator<Integer> itr = kset.iterator();
		while(itr.hasNext()) {
			int key = itr.next();
			System.out.println(key + " : " + tmap.get(key));
		}

		System.out.println();
		
		
		// 역순 정렬
		// TreeMap에만 있는 KeySet을 만들어 내는 메소드
		NavigableSet<Integer> navi = tmap.navigableKeySet();
		Iterator<Integer> itr2 = navi.descendingIterator();
		while(itr2.hasNext()) {
			int key = itr2.next();
			System.out.println(key + " : " + tmap.get(key));
		}
		
		
		
		// HashMap --> TreeMap 전환하기
		System.out.println("HashMap() -> TreeMap() ");
		// TODO
		
		
		
		System.out.println("\n프로그램 종료");
	} // end main()
} // end class Collection14Main


















