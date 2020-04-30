package com.lec.java.file02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* FileIO
 Program <=== InputStream <=== Source
 Program ===> OutputStream ===> Source
 Program <=== FileInputStream <=== File
 Program ===> FileOutputStream ===> File

 java.io.InputStream
  |__ java.io.FileInputStream: 파일로부터 데이터를 읽어오는 통로
 java.io.OutputStream
  |__ java.io.FileOutputStream: 파일로 데이터를 쓰는 통로
*/

public class File02Main {

	public static void main(String[] args) {
		System.out.println("File IO");

		InputStream in = null;
		OutputStream out = null;
		
		try {
			in = new FileInputStream("temp/big_text.txt");
			out = new FileOutputStream("temp/copy_big_text.txt");
			
			int dataRead;
			int bytesCopied = 0;
			
			long startTime = System.currentTimeMillis();   // 현재 시간
			// 파일복사
			while(true) {				
				// 데이터 읽기 : InputStream 에 있는 read() 메소드 사용
				// read() 는 InputStream 으로부터
				// 1byte 씩 읽어서 int(4byte) 에 담아 리턴한다
				// [...][...][...][1byte]
				dataRead = in.read();
				if(dataRead == -1) {  // 더이상 읽을 것이 없으면 read() 는 -1 리턴
					break;
				}
				// 데이터 쓰기: OutputStream에 있는 write() 메소드 사용
				// write() 는 
				// int(4byte)에 1byte씩 담아 OutputStream에 쓴다
				// [ ... ][ ... ][ ... ][ 1byte ]
				out.write(dataRead);
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
				if(out != null) out.close();
				if(in != null) in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
	} // end main()

} // end class















