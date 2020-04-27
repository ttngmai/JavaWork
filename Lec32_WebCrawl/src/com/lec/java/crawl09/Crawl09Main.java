package com.lec.java.crawl09;

import java.io.IOException;
import java.net.URLEncoder;

import org.jsoup.Jsoup;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

// 연습
// 네이버 '검색어'
// 블로그
// - post title
// - post url
// - blog title

// 페이징 구현!

public class Crawl09Main {

	public static void main(String[] args) throws IOException {
		System.out.println("네이버 검색 페이징");
		
		for(int i = 1; i <= 10; i++) {
			crawlNaverBlog("자바", i);
		}
		
		System.out.println("\n프로그램 종료");
	} // end main()
	
	public static void crawlNaverBlog(String search, int page) throws IOException {
		
		if(search == null || search.trim().length() == 0 || page < 1) return;
		
		String url;
		Document doc;
		Response response;
		Elements elements;
		
		System.out.println(page + " 페이지]");
		
		url = String.format("https://search.naver.com/search.naver?date_from=&date_option=0&date_to=&dup_remove=1&nso=&post_blogurl=&post_blogurl_without=&query=%s&sm=tab_pge&srchby=all&st=sim&where=post&start=%d",
				URLEncoder.encode(search, "utf-8"), (10 * (page - 1) + 1));
		//System.out.println(url); // 확인용
		
		doc = Jsoup.connect(url).execute().parse();
		
		elements = doc.select("#elThumbnailResultArea li");
		//System.out.println(elements.size()); // 확인용
		
		for(Element e : elements) {
			String postTitle = e.selectFirst(".sh_blog_title").text().trim();
			String blogTitle = e.selectFirst(".inline a").text().trim();
			String postUrl = e.select(".inline a:nth-child(2)").attr("href").trim();
			
			System.out.println(postTitle + " : " + blogTitle + " : " + postUrl);
		}
		
		System.out.println();
	} // end crawlNaverBlog

} // end class
