package common;

/*
 * DB 접속 정보, 쿼리문, 테이블명, 컬럼명 등은
 * 별도로 관리하든지
 * XML, 초기화 파라미터 등에서 관리하는 것이 좋다.
 */
public class D {
	public static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	public static final String USERID = "scott0316";
	public static final String USERPW = "tiger0316";

	// depth 가 1인 카테고리들 읽어오기
	public static final String SQL_GET_FIRST_CATEGORY
		= "SELECT ca_uid \"uid\", ca_name \"name\", ca_depth \"depth\", ca_parent \"parnet\", ca_order \"order\" " +
				"FROM TEST_CATEGORY " +
				"WHERE CA_DEPTH = 1 " +
				"ORDER BY CA_ORDER ASC";
	
	// 특정 depth 의 특정 parent 인 카테고리들 읽어오기
	public static final String SQL_CATEGORY_BY_DEPTH_N_PARENT
		= "SELECT ca_uid \"uid\", ca_name \"name\", ca_depth \"depth\", ca_parent \"parent\", ca_order \"order\" " + 
				"FROM test_category " + 
				"WHERE ca_depth = ? AND ca_parent = ? " + 
				"ORDER BY ca_order ASC";
}
