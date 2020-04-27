package com.lec.java.crawl15;

import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

/* XML, JSON 파싱 연습
 * 
 * ■서울시 지하철 역사 정보
http://data.seoul.go.kr/dataList/datasetView.do?infId=OA-12753&srvType=A&serviceKind=1&currentPageNo=1

샘플url

XML 버젼
http://swopenAPI.seoul.go.kr/api/subway/4d46796d7366726f3833774a774955/xml/stationInfo/1/5/서울

JSON 버젼
http://swopenAPI.seoul.go.kr/api/subway/4d46796d7366726f3833774a774955/json/stationInfo/1/5/서울

 */

public class Crawl15Main {

	public static final String API_KEY = "4d46796d7366726f3833774a774955";
	
	public static void main(String[] args) throws IOException {
		System.out.println("jackson-databind 연습2");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("역이름을 입력하세요: ");
		String inputStationName = sc.nextLine();
		
		ObjectMapper mapper = new ObjectMapper();
		
		URL url = new URL(String.format("http://swopenAPI.seoul.go.kr/api/subway/%s/json/stationInfo/1/5/%s",
				API_KEY, URLEncoder.encode(inputStationName, "utf-8")));

		Subway subway = mapper.readValue(url, Subway.class);
		
		for(SubRow e : subway.getStationList()) {
			System.out.printf("%8s : %6d : %8s\n",
					e.getStatnNm(),
					e.getSubwayId(),
					e.getSubwayNm());
		}
		
		sc.close();
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class

@JsonIgnoreProperties(ignoreUnknown = true)
class Subway {
	private List<SubRow> stationList; // stationList 는 배열이므로 List를 생성해서 받는다 (property 이름은 같게 해야한다)

	// getter & setter
	public List<SubRow> getStationList() {return stationList;}
	public void setStationList(List<SubRow> stationList) {this.stationList = stationList;}
	
} // end Subway

@JsonIgnoreProperties(ignoreUnknown = true)
class SubRow {
	private String statnNm;
	private int subwayId;
	private String subwayNm;
	
	// 기본 생성자
	public SubRow() {}

	// 매개변수 받는 생성자
	public SubRow(String statnNm, int subwayId, String subwayNm) {
		super();
		this.statnNm = statnNm;
		this.subwayId = subwayId;
		this.subwayNm = subwayNm;
	}

	// getter & setter
	public String getStatnNm() {return statnNm;}
	public void setStatnNm(String statnNm) {this.statnNm = statnNm;}
	public int getSubwayId() {return subwayId;}
	public void setSubwayId(int subwayId) {this.subwayId = subwayId;}
	public String getSubwayNm() {return subwayNm;}
	public void setSubwayNm(String subwayNm) {this.subwayNm = subwayNm;}
	
} // end SubRow