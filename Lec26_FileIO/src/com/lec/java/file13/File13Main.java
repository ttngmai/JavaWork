package com.lec.java.file13;

import java.io.File;

public class File13Main {

	public static void main(String[] args) {
		System.out.println("디렉토리 정보 확인");
		System.out.println();
		
		String curWorkingDir = System.getProperty("user.dir");
		System.out.println("현재 작업 폴더 : " + curWorkingDir);
		
		// 현재 작업 디렉토리 의 파일 리스트 출력
		// File 클래스 : '파일'객체  또는 '디렉토리' 객체
		File curDir = new File(curWorkingDir);  // 현재 작업 '디렉토리 객체'
		File [] list = curDir.listFiles();   // 디렉토리 안에 있는 '파일' 과 '디렉토리' 들을 File배열로 리턴
		
		for(int i = 0; i < list.length; i++) {
			if(list[i].isDirectory()) {   // File 객체가 Directory 라면?
				System.out.print("DIR" + "\t");				
			} else {  // File 객체가 '파일' 이라면
				System.out.print("FILE" + "\t");
			}
			System.out.print(list[i].getName() + "\t");   // 파일/디렉토리 이름
			System.out.println(list[i].length());    // '파일'인 경우 크기 (byte)
		}
		System.out.println();
		
		// temp 디렉토리의 내용 출력
		File tempDir = new File("temp");  // 상대경로를 이용한 File 객체 생성
		File [] list2 = tempDir.listFiles();   // 디렉토리 안에 있는 '파일' 과 '디렉토리' 들을 File배열로 리턴
		
		for(int i = 0; i < list2.length; i++) {
			if(list2[i].isFile()) {   // File 객체가 '파일' 이라면?
				System.out.print("FILE" + "\t");
			} else {  // File 객체가 '파일' 이라면
				System.out.print("DIR" + "\t");				
			}
			System.out.print(list2[i].getName() + "\t");   // 파일/디렉토리 이름
			System.out.println(list2[i].length());    // '파일'인 경우 크기 (byte)
		}
		System.out.println();
		
		
		
	} // end main()

} // end File11Main

















