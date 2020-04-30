package com.lec.java.file15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/* HTML 데이터, 웹데이터 (텍스트)
 * Java 에서 웹 연결을 위한 객체 두가지
 * 	URL : 웹 상의 주소, 
 * 	HttpURLConnection : 웹연결
 * 		URLConnection
 * 		 └─ HttpURLConnection
 * 
 * 	java.io.Reader    프로그램이 '문자 단위' 데이터를 읽어들이는(read) 통로
 * 		├─ java.io.InputStreamReader    // 스트림 기반의 reader
 * 		└─ java.io.BufferedReader 		// 문자(character) 기반 reader
 */
public class File15Main {

	public static void main(String[] args) {
		System.out.println("웹 데이터 가져오기(텍스트)");
		
		StringBuffer sb = readFromUrl("https://www.daum.net");
		System.out.println(sb.toString().substring(0, 200));
		
		System.out.println("\n프로그램 종료");
	} // end main
	
	public static StringBuffer readFromUrl(String url_address) {
		
		URL url = null;  // java.net.URL
		HttpURLConnection conn = null;   // java.net.HttpURLConnection
		
		InputStream in = null;
		InputStreamReader reader = null;   // 스트림 기반의 reader
		BufferedReader br = null;  // 버퍼 제공 reader
		
		char [] buf = new char[512];   // 입출력욕 문자 버퍼
		
		StringBuffer sb = new StringBuffer();
		
		//----------------------------------------------------
		try {
			url = new URL(url_address);
			conn = (HttpURLConnection)url.openConnection();
			
			if(conn != null) {
				
				conn.setConnectTimeout(2000);  // 2초내에 '연결' 수립 안되면 java.net.SocketTimeoutException 발생
				conn.setRequestMethod("GET");  // 웹서비스 요청방식
				conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
				conn.setUseCaches(false);   // 캐시 사용 안함
				
				System.out.println("request 시작 " + url_address);
				conn.connect();      // request 발생 --> response 받을때까지 delay 발생
				System.out.println("response 완료");
				
				int responseCode = conn.getResponseCode();   // response code 값 부터 확인해야 한다, 200일때 OK
				if(responseCode == HttpURLConnection.HTTP_OK) {
					
					in = conn.getInputStream(); // HttpURLConnection 으로부터 받기 위해 InputStream 추출
					reader = new InputStreamReader(in, "utf-8");   // 문자 reader <-- byte stream
					br = new BufferedReader(reader);
					
					int cnt;  // 읽어들인 문자의 개수
					while((cnt = br.read(buf)) != -1) {
						sb.append(buf, 0, cnt);
					}
					
					
				} else {
					System.out.println("response 실패");
					return null;
				}
				
			} else {
				System.out.println("conn NULL!");
				return null;
			}
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(br != null) br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			if(conn != null) conn.disconnect();   // 연결 끊기
		}
		
		return sb;
	}
	
	
	

} // end class









