package com.lec.java.file04;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;
/* 보조스트림 (filter stream)
 Program <=== FilterInputStream <=== InputStream <=== Source
					↓ 상속					↓ 상속
 Program <=== BufferedInputStream <=== FileInputStream <=== File

 Program ===> FilterOutputStream ===> OutputStream ===> Source
					↓ 상속					↓ 상속
 Program ===> BufferedOutputStream ===> FileOutputStream ===> File

 java.io.InputStream
  |__ java.io.FilterInputStream
       |__ java.io.BufferedInputStream

 java.io.OutputStream
  |__ java.io.FilterOutputStream
       |__ java.io.BufferedOutputStream

 참고 ) 보조스트림 (filter stream)
 보조스트림(filter stream) 이란 다른 스트림과 연결되어 여러가지 편리한 기능을 제공해주는 스트림
*/

public class File04Main {

	public static void main(String[] args) {
		System.out.println("BufferedInputStream, BufferedOutputStream");

		System.out.println("File IO");

		InputStream in = null;
		BufferedInputStream bin = null;
		OutputStream out = null;
		BufferedOutputStream bout = null;
		
		try {
			in = new FileInputStream("temp/big_text.txt");
			bin = new BufferedInputStream(in);  // InputStream 에 장착!
			
			out = new FileOutputStream("temp/copy_big_text.txt");
			bout = new BufferedOutputStream(out);  // OutputStream 에 장착!
			
			int dataRead;
			int bytesCopied = 0;
			
			long startTime = System.currentTimeMillis();   // 현재 시간
			// 파일복사
			while(true) {				
				dataRead = bin.read();
				if(dataRead == -1) { 
					break;
				}
				bout.write(dataRead);
				bytesCopied++;				
			}
			long endTime = System.currentTimeMillis();
			long elapsedTime = endTime - startTime;  // 경과시간
			
			System.out.println("읽고 쓴 바이트: " + bytesCopied);
			System.out.println("경과 시간(ms): " + elapsedTime);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 리소스 해제
			try {
				if(bout != null) bout.close();  // bout 을 close() 하면 bout 을 만든 out 도 같이 close() 됨.
				if(bin != null) bin.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		
		
	} // end main()

} // end class














