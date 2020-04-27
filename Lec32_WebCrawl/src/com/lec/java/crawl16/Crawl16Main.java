package com.lec.java.crawl16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

// https://www.yogiyo.co.kr/api/v1/restaurants-geo/?items=20&lat=37.5060498074729&lng=127.030615641625&order=rank&page=0&search=
public class Crawl16Main {

	public static void main(String[] args) throws IOException {
		System.out.println("요기요 맛집정보 : header 추가");
		
		String url = "https://www.yogiyo.co.kr/api/v1/restaurants-geo/?items=20&lat=37.5060498074729&lng=127.030615641625&order=rank&page=0&search=";
		
		StringBuffer sb = readFromUrl(url);
		
		ObjectMapper mapper = new ObjectMapper();
		
		Restaurant rst = mapper.readValue(sb.toString(), Restaurant.class);
		// 맛집 이름, 평점
		
		for(SubRow e : rst.getRestaurants()) {
			System.out.printf("%s : %.1f\n",
					e.getName(),
					e.getReview_avg());
		}
		
		System.out.println("\n프로그램 종료");
	} // end main()

	public static StringBuffer readFromUrl(String urlAddress) {
		
		StringBuffer sb = new StringBuffer();  // response 받은 데이터 담을 객체
		
		URL url = null;    // java.net.URL
		HttpURLConnection conn = null; // java.net.HttpURLConnection
		
		InputStream in = null;
		InputStreamReader reader = null;   // byte 스트림 --> 문자기반 Reader
		BufferedReader br = null; 
		
		char [] buf = new char[512];   // 문자용 버퍼
		
		// BufferedReader <- InputStreamReader <- InputStream <- HttpURLConnection 
		
		try {
			url = new URL(urlAddress);
			conn = (HttpURLConnection)url.openConnection();  // Connection 객체 생성
			
			if(conn != null) {
				conn.setConnectTimeout(2000);  // 2초이내에 '연결' 이 수립안되면
											// java.net.SocketTimeoutException 발생
				
				conn.setRequestMethod("GET");  // GET 방식 request
				// "GET", "POST" ...
				conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
				conn.setUseCaches(false);  // 캐시사용안함
				
				// 헤더 정보 추가
				conn.setRequestProperty("X-ApiKey", "iphoneap");
				conn.setRequestProperty("X-ApiSecret", "fe5183cc3dea12bd0ce299cf110a75a2");
				
				System.out.println("request 시작: " + urlAddress);
				conn.connect();    // request 발생 --> 이후 response 받을때까지 delay
				System.out.println("response 완료");
				
				// response 받은후 가장 먼저 response code 값 확인
				int responseCode = conn.getResponseCode();
				System.out.println("response code : " + responseCode);
				// 참조 : https://developer.mozilla.org/ko/docs/Web/HTTP/Status
				if(responseCode == HttpURLConnection.HTTP_OK) {
					
					in = conn.getInputStream();  // InputStream <- HttpURLConnection 
					reader = new InputStreamReader(in, "utf-8"); // InputStreamReader <- InputStream
					br = new BufferedReader(reader);  // BufferedReader <- InputStreamReader
					
					int cnt;  // 읽은 글자 개수
					while((cnt = br.read(buf)) != -1) {
						sb.append(buf, 0, cnt);  // response 받은 텍스트를 StringBuffer 에 추가
					}
					
				} else {
					System.out.println("response 실패");
					return null;
				}
			} else {
				System.out.println("conn null");
				return null;
			}
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(conn != null) conn.disconnect();   // 작업 끝나고 Connection 해제
		}
		
		return sb;
	}
	
} // end class

@JsonIgnoreProperties(ignoreUnknown = true)
class Restaurant {
	private List<SubRow> restaurants;

	// getter & setter
	public List<SubRow> getRestaurants() {return restaurants;}
	public void setRestaurants(List<SubRow> restaurants) {this.restaurants = restaurants;}
	
} // end Restaurant

@JsonIgnoreProperties(ignoreUnknown = true)
class SubRow {
	private String name;
	private double review_avg;
	
	// 기본 생성자
	public SubRow() {}

	// 매개변수 받는 생성자
	public SubRow(String name, double review_avg) {
		this.name = name;
		this.review_avg = review_avg;
	}

	// getter & setter
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public double getReview_avg() {return review_avg;}
	public void setReview_avg(double review_avg) {this.review_avg = review_avg;}
	
	
}