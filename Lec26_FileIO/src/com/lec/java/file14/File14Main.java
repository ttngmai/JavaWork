package com.lec.java.file14;

import java.io.File;
import java.io.IOException;

public class File14Main {

	public static final String TEST_DIRECTORY = "test";
	public static final String TEMP_DIR = "temp";
	public static final String TEST_FILE = "dummy.txt";
	public static final String TEST_RENAME = "re_dummy.txt";
	
	public static void main(String[] args) {
		System.out.println("폴더/파일 생성, 이름변경, 삭제");
		
		System.out.println();
		
		String path = System.getProperty("user.dir")    // current working directory
					+ File.separator  // Windows ( \ ),  UNIX ( / )
					+ TEST_DIRECTORY;
		System.out.println("절대경로 : " + path);
		
		// 위 경로를 사용해서 File 객체 생성 (명심! File 객체 생성한다고 물리적으로 만들어지는게 아.니.다!)
		File f = new File(path);
		
		// 디렉토리(폴더) 생성: mkdir()   make directory
		if(!f.exists()) {  // 디렉토리가 존재하는지 체크
			// 디렉토리가 존재하지 않는다면, 생성
			if(f.mkdir()) {
				System.out.println("폴더 생성 성공");
			} else {
				System.out.println("폴더 생성 실패!");
			}
		} else {
			// 디렉토리가 이미 존재한다면
			System.out.println("폴더가 이미 존재합니다");
		}
		
		System.out.println();
		
		// 파일 생성
		// createNewFile()
		// f2 <-- D:\java2001\JavaWork\Lec26_FileIO\test\dummy.txt
		File f2 = new File(f, TEST_FILE); // File(디렉토리 File 객체, 파일명)
		System.out.println(f2.getAbsolutePath());  // 절대경로 
		
		if(!f2.exists()) {  // 파일이 존재하는지 여부 체크
			// 파일이 존재하지 않는다면 새로 생성
			
			try {
				if(f2.createNewFile()) {  // 파일 생성
					System.out.println("파일 생성 성공!");
				} else {
					System.out.println("파일 생성 실패!");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} else {
			// 파일이 이미 존재한다면
			System.out.println("파일이 이미 존재합니다");
		}
		
		
		// 이름변경 : renameTo()
		//   (혹은 이동)
		// D:\java2001\JavaWork\Lec26_FileIO\test\re_dummy.txt
		File f3 = new File(f, TEST_RENAME); // 변경할 이름 을 File 객체로 생성
		System.out.println(f3.getAbsolutePath());
		
		if(f2.exists()) {  // 파일 존재 여부 확인
			// 파일이 존재하면 renameTo 수행
			if(f2.renameTo(f3)) {
				System.out.println("파일 이름 변경 성공");
			} else {
				System.out.println("파일 이름 변경 실패");  // 이미 re_dummy.txt 가 있으면 실패
			}
			
		} else {
			System.out.println("변경할 파일이 없습니다");
		}
		
		
		System.out.println();
		// 파일 삭제 : delete()
		File f4 = new File("test/re_dummy.txt");
		System.out.println(f4.getAbsolutePath());

		if(f4.exists()) {
			// 파일이 존재하면 삭제
			if(f4.delete()) {
				System.out.println("파일 삭제 성공!");
			} else {
				System.out.println("파일 삭제 실패!");
			}
		} else {
			System.out.println("삭제할 파일이 없습니다");
		}
		
		
		
		
		
		
		

	} // end main()

} // end class File12Main














