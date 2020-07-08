package com.lec.sts19_rest.myBoard.beans;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

@MapperScan
public interface MyBoardDAO {
	public List<MyBoardDTO> select();
//	public int insert(final MyBoardDTO dto);
	public int insert(String subject, String content, String name);
	public List<MyBoardDTO> selectByUid(final int uid);
//	public int update(final MyBoardDTO dto);
	public int update(int uid, String content, String name);
	public int deleteByUid(int[] uids);
	
	public int incViewCnt(int uid);
	
	public int countAll();
	public List<MyBoardDTO> selectFromRow(int fromRow, int pageRows);
}
