package com.lec.java.crawl07;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/*
 * '검색어' 입력받아서 
 * 첫페이지의 '국내도서' 첫페이지 20개 아이템 크롤링
 *    책이름 / 책가격 / 상세페이지 url  / 썸네일 url
 *    
 * yes24.com 검색페이지는  euc-kr 로 URL 인코딩 되어 있다.
 *    한글 1글자당 2byte 인코딩   
 *    
 */
public class Crawl07Main {

	private static final String PATH = "books";
	
	public static void main(String[] args) throws IOException {
		System.out.println("인터파크 검색결과 페이지");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("검색어를 입력하세요: ");
		String search = sc.nextLine(); 
		sc.close();
		
		Crawl07Main app = new Crawl07Main();
		ArrayList<InfoBook> list = app.crawlInterPark(search);
		
		// 썸네일 이미지 다운로드 받아서
		// thumb001.jpg ~ thumb020.jpg ...
		
		int fileIndex = 1;
		for(InfoBook e : list) {
			System.out.println(e);  // 크롤링 정보 출력
			
			// 썸네일 이미지 다운로드
			String fileName = String.format(PATH + File.separator + "thumb%03d.jpg", fileIndex);
			URL imgUrl = new URL(e.getImgUrl());
			
			BufferedImage imgData = ImageIO.read(imgUrl);
			File file = new File(fileName);
			ImageIO.write(imgData, "jpg", file);			
			
			System.out.println(fileName + " 이 저장되었습니다");
			fileIndex++;
		}
		
		System.out.println("\n프로그램 종료");
	} // end main()

	
	private ArrayList<InfoBook> crawlInterPark(String search) throws IOException {
		ArrayList<InfoBook> list = new ArrayList<InfoBook>();
		
		String url;
		Document doc;
		Response response;
		Elements elements;
		
		// TODO
		// http://book.interpark.com/
		url = "http://bsearch.interpark.com/dsearch/book.jsp?sch=all&sc.shopNo=&bookblockname=s_main&booklinkname=s_main&bid1=search_auto&bid2=product&bid3=000&bid4=001&query=" + URLEncoder.encode(search, "euc-kr");

		doc = Jsoup.connect(url).execute().parse();
		
		elements = doc.select("#bookresult div.list_wrap");
		//System.out.println(elements.size() + "개"); // 20개 나옴
		
		for(Element e : elements) {
			
			// 책이름
			String bookTitle = e.selectFirst("p.tit a").text().trim();
			
			// 책가격
			double price = Double.parseDouble(
					e.selectFirst("div.price span.nowMoney").text().split("원")[0].trim().replace(",", "")
					);
			
			// 상세페이지 url
			String linkUrl = e.selectFirst("p.tit a").attr("href").trim();
			
			// 썸네일 url
			String imgUrl = e.selectFirst("div.bimgWrap img").attr("src").trim();
			
			list.add(new InfoBook(bookTitle, price, linkUrl, imgUrl));
		} 
		
		return list;
	}
	
	
	
} // end class














