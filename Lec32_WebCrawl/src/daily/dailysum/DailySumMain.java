package daily.dailysum;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

/*
 * 연습 : 자치구단위 서울 생활인구 일별 집계표
 * ■자치구단위 서울 생활인구 일별 집계표
 * 	http://data.seoul.go.kr/dataList/datasetView.do?infId=OA-15379&srvType=S&serviceKind=1&currentPageNo=1
 * 	http://openapi.seoul.go.kr:8088/(인증키)/(요청파일타입)/SPOP_DAILYSUM_JACHI/(요청시작INDEX)/(요청종료INDEX)/(기준일ID)/(시군구코드)
 * 
 * 샘플url
 * 	XML 버젼
 * 	http://openapi.seoul.go.kr:8088/(인증키)/xml/SPOP_DAILYSUM_JACHI/1/5/
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/xml/SPOP_DAILYSUM_JACHI/1/5/
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/xml/SPOP_DAILYSUM_JACHI/1/5/20190101
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/xml/SPOP_DAILYSUM_JACHI/1/5/20190101/11000
 * 
 * 	JSON 버젼
 * 	http://openapi.seoul.go.kr:8088/(인증키)/json/SPOP_DAILYSUM_JACHI/1/5/
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/json/SPOP_DAILYSUM_JACHI/1/5/	
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/json/SPOP_DAILYSUM_JACHI/1/5/20190101
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/json/SPOP_DAILYSUM_JACHI/1/5/20190101/11000
 * 
 * ※ 한번에 1000개 까지의 데이터만 볼수 있슴
 * 
 */

/*  입력예]
 *  날짜입력: 20190101
 *  시작Index : 1
 *  끝Index: 5
 *  
 *  [XML]
 *  날짜             구ID        총생활인구수           일최대이동인구수
 *  ----------------------------------------------------------------------
 *  20190101	11000    11121182.98210      4764635.18080 
 *  20190101    11110    274919.65940        177877.95000 
 *  20190101    11140    267096.65940        149729.45840 
 *  20190101    11170    315220.18480        149329.14120 
 *  20190101    11200    351993.77950        153738.94490
 *   
 *  [JSON]
 *  날짜             구ID        총생활인구수           일최대이동인구수
 *  ----------------------------------------------------------------------
 *  20190101	11000    11121182.98210      4764635.18080 
 *  20190101    11110    274919.65940        177877.95000 
 *  20190101    11140    267096.65940        149729.45840 
 *  20190101    11170    315220.18480        149329.14120 
 *  20190101    11200    351993.77950        153738.94490 
 * 
 */

// ★ 주목 ★
// XML 은 Jsoup 를 활용하여 파싱하세요
// JSON 은  jackson 을 활용하여 파싱하세요


public class DailySumMain {
	
	public static final String API_KEY = "65416b73626d77653335644949457a";
	public static final String REQ_SERVICE = "SPOP_DAILYSUM_JACHI";
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		String date;
		int startIndex;
		int endIndex;
		
		System.out.print("날짜입력: ");
		date = sc.next();
		System.out.print("시작Index: ");
		startIndex = sc.nextInt();
		System.out.print("끝Index: ");
		endIndex = sc.nextInt();
		
		sc.close();
		
		// XML은 Jsoup 활용해서 파싱
		UsingJsoup(date, startIndex, endIndex);

		
		System.out.println();
		
		// JSON은 jackson 활용해서 파싱
		UsingJackson(date, startIndex, endIndex);

		
	} // end main
	
	public static String buildUrlXml (String date, int startIndex, int endIndex) {
		
		String url_adress = String.format("http://openapi.seoul.go.kr:8088/%s/xml/%s/%d/%d/%s",
				API_KEY, REQ_SERVICE, startIndex, endIndex, date);
		
		return url_adress;
	} // end buildUrlXml
	
	public static String buildUrlJson (String date, int startIndex, int endIndex) {
		
		String url_adress = String.format("http://openapi.seoul.go.kr:8088/%s/json/%s/%d/%d/%s",
				API_KEY, REQ_SERVICE, startIndex, endIndex, date);
		
		return url_adress;
	} // end buildUrlJson

	public static void UsingJsoup (String date, int startIndex, int endIndex) throws IOException {
		String url = buildUrlXml(date, startIndex, endIndex);
		Document doc = Jsoup.connect(url).parser(Parser.xmlParser()).get();
		Elements elements = doc.select("row");
		
		System.out.println("[XML]");
		System.out.printf("%-18s%-8s%-23s%-18s\n", "날짜", "구ID", "총생활인구수", "일최대이동인구수");
		System.out.println("--------------------------------------------------------");
		
		for(Element e : elements) {
			String STDR_DE_ID = e.selectFirst("STDR_DE_ID").text().trim(); // 날짜
			String SIGNGU_CODE_SE = e.selectFirst("SIGNGU_CODE_SE").text().trim(); // 구ID
			String TOT_LVPOP_CO = e.selectFirst("TOT_LVPOP_CO").text().trim(); // 총생활인구수
			String DAIL_MXMM_LVPOP_CO = e.selectFirst("DAIL_MXMM_LVPOP_CO").text().trim(); // 일최대이동인구수
			
			System.out.printf("%-12s%-9s%-18s%-17s\n",
					STDR_DE_ID, SIGNGU_CODE_SE, TOT_LVPOP_CO, DAIL_MXMM_LVPOP_CO);
		}
		
	} // end UsingJson

	public static void UsingJackson (String date, int startIndex, int endIndex) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		URL url = new URL (buildUrlJson(date, startIndex, endIndex));
		
		DailySum dailySum = mapper.readValue(url, DailySum.class);
		
		System.out.println("[JSON]");
		System.out.printf("%-18s%-8s%-23s%-18s\n", "날짜", "구ID", "총생활인구수", "일최대이동인구수");
		System.out.println("--------------------------------------------------------");
		
		for(JachiRow e : dailySum.getSpopDailySumJachi().getRow()) {
			System.out.printf("%-12s%-9s%-18s%-17s\n",
					e.getStdrDeId(),
					e.getSignguCodeSe(), 
					e.getTotLvpopCo(),
					e.getDailMxmmLvpopCo());	
		}
		
	} // end UsingJackson
	
} // end class

@JsonIgnoreProperties(ignoreUnknown = true)
class DailySum {
	
	@JsonProperty("SPOP_DAILYSUM_JACHI")
	private Jachis spopDailySumJachi;

	// getter & setter
	public Jachis getSpopDailySumJachi() {return spopDailySumJachi;}
	public void setSpopDailySumJachi(Jachis spopDailySumJachi) {this.spopDailySumJachi = spopDailySumJachi;}

} // end DailySum

@JsonIgnoreProperties(ignoreUnknown = true)
class Jachis {
	private List<JachiRow> row;

	// getter & setter
	public List<JachiRow> getRow() {return row;}
	public void setRow(List<JachiRow> row) {this.row = row;}
	
} // end Jachis

@JsonIgnoreProperties(ignoreUnknown = true)
class JachiRow {
	
	@JsonProperty("STDR_DE_ID")
	private String stdrDeId;
	
	@JsonProperty("SIGNGU_CODE_SE")
	private String signguCodeSe;
	
	@JsonProperty("TOT_LVPOP_CO")
	private String totLvpopCo;
	
	@JsonProperty("DAIL_MXMM_LVPOP_CO")
	private String dailMxmmLvpopCo;
	
	// 기본 생성자
	public JachiRow() {}

	// 매개변수 받는 생성자
	public JachiRow(String stdrDeId, String signguCodeSe, String totLvpopCo, String dailMxmmLvpopCo) {
		super();
		this.stdrDeId = stdrDeId;
		this.signguCodeSe = signguCodeSe;
		this.totLvpopCo = totLvpopCo;
		this.dailMxmmLvpopCo = dailMxmmLvpopCo;
	}

	// getter & setter
	public String getStdrDeId() {return stdrDeId;}
	public void setStdrDeId(String stdrDeId) {this.stdrDeId = stdrDeId;}
	public String getSignguCodeSe() {return signguCodeSe;}
	public void setSignguCodeSe(String signguCodeSe) {this.signguCodeSe = signguCodeSe;}
	public String getTotLvpopCo() {return totLvpopCo;}
	public void setTotLvpopCo(String totLvpopCo) {this.totLvpopCo = totLvpopCo;}
	public String getDailMxmmLvpopCo() {return dailMxmmLvpopCo;}
	public void setDailMxmmLvpopCo(String dailMxmmLvpopCo) {this.dailMxmmLvpopCo = dailMxmmLvpopCo;}
	
} // end JachiRow
