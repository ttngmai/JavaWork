package com.lec.java.crawl03;

import java.io.IOException;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawl03Main {

	public static void main(String[] args) throws IOException {
		System.out.println("Daum 실시간 검색어");
		
		// TODO
		// https://www.daum.net
		// 15개
		String url = "https://www.daum.net";
		Response response = Jsoup.connect(url).execute();
		Document doc = response.parse();
		
		System.out.println(response.statusCode());
		
		System.out.println();
		
		Elements elements = doc.select("div.slide_favorsch > ul > li > a");
		System.out.println(elements.size() + "개");
		
		for(Element e : elements) {
			System.out.println(e.text().trim());
			System.out.println(e.attr("href"));
		}
		
		System.out.println("\n프로그램 종료");
	}

}
