package com.lec.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.D;

public class CategoryDAO {
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public CategoryDAO() {
		try {
			Class.forName(D.DRIVER);
			conn = DriverManager.getConnection(D.URL, D.USERID, D.USERPW);
			System.out.println("WriteDAO 생성, 데이터 베이스 연결!");
		} catch(Exception e) {
			e.printStackTrace();
		}		
	} // 생성자
	
	// DB 자원 반납 메소드,
	public void close() throws SQLException {
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(stmt != null) stmt.close();
		if(conn != null) conn.close();
	} // end close()
	
	public CategoryDTO[] selectFirstCate() throws SQLException {
		CategoryDTO[] arr = null;
		
		try {
			pstmt = conn.prepareStatement(D.SQL_GET_FIRST_CATEGORY);
			rs = pstmt.executeQuery();
			arr = createArray2(rs);
		} finally {
			close();
		}
		
		return arr;
	} // end selectFirstCate()
	
	public CategoryDTO[] selectChildCate(int depth, int parent) throws SQLException {
		CategoryDTO[] arr = null;
		
		try {
			pstmt = conn.prepareStatement(D.SQL_CATEGORY_BY_DEPTH_N_PARENT);
			pstmt.setInt(1, depth);
			pstmt.setInt(2, parent);
			rs = pstmt.executeQuery();
			arr = createArray(rs);
		} finally {
			close();
		}
		
		return arr;
	} // end selectChildCate()
	
	public CategoryDTO[] createArray(ResultSet rs) throws SQLException {
		CategoryDTO[] arr = null;
		
		ArrayList<CategoryDTO> cateList = new ArrayList<CategoryDTO>();
		
		while(rs.next()) {
			int uid = rs.getInt("uid");
			String name = rs.getString("name");
			int depth = rs.getInt("depth");
			int parent = rs.getInt("parent");
			int order = rs.getInt("order");
			
			CategoryDTO dto = new CategoryDTO(uid, name, depth, parent, order);
			cateList.add(dto);
		} // end while
		
		int size = cateList.size();
		
		if(size == 0) return null;
		
		arr = new CategoryDTO[size];
		cateList.toArray(arr);	
		return arr;
	} // end createArray()
	
	public CategoryDTO[] createArray2(ResultSet rs) throws SQLException {
		CategoryDTO[] arr = null;
		
		ArrayList<CategoryDTO> cateList = new ArrayList<CategoryDTO>();
		
		while(rs.next()) {
			int uid = rs.getInt("uid");
			String name = rs.getString("name");
			int depth = rs.getInt("depth");
			int order = rs.getInt("order");
			
			CategoryDTO dto = new CategoryDTO(uid, name, depth, order);
			cateList.add(dto);
		} // end while
		
		int size = cateList.size();
		
		if(size == 0) return null;
		
		arr = new CategoryDTO[size];
		cateList.toArray(arr);	
		return arr;
	} // end createArray()
	
}
