package com.lec.sts19_rest.myBoard.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lec.sts19_rest.board.C;
import com.lec.sts19_rest.myBoard.beans.AjaxMyBoardList;
import com.lec.sts19_rest.myBoard.beans.MyBoardDAO;
import com.lec.sts19_rest.myBoard.beans.MyBoardDTO;

@RestController
@RequestMapping(value = "/myBoard")
public class MyBoardRESTController {
	private SqlSession sqlsession;
	
	public MyBoardRESTController() {
		super();
	}
	
	@Autowired
	public void setSqlsession(SqlSession sqlSession) {
		this.sqlsession = sqlSession;
		C.sqlSession = sqlSession;
	}
	
	@RequestMapping("/list/{page}/{pageRows}")
	public AjaxMyBoardList list(
			@PathVariable int page,
			@PathVariable int pageRows) {

		// MyBatis 사용
		MyBoardDAO dao = C.sqlSession.getMapper(MyBoardDAO.class);
		
		AjaxMyBoardList ajaxMyBoardList = new AjaxMyBoardList();
		List<MyBoardDTO> list = null;
		
		// Ajax response 에 필요한 값들
		StringBuffer message = new StringBuffer();
		String status = "FAIL";   // 기본 FAIL
		
		// 페이징 관련 세팅값들
		int writePages = 10;  // 한 [페이징] 에 몇개의 '페이지' 를 표시? (디폴트 10)
		int totalCnt = 0;    // 글은 총 몇개인지?
		int totalPage = 0;   // 총 몇 '페이지' 분량인지?
		int count = 0;
		
		String param;
		
		// page 값 : 현재 몇 페이지?
		param = Integer.toString(page);
		if(param != null && param.trim().length() != 0) {
			try {				
				page = Integer.parseInt(param);
			} catch(NumberFormatException e) {
				// 예외 처리 안함
			}
		}
		
		// pageRows 값 : '한 페이지' 에 몇개의 글?
		param = Integer.toString(pageRows);
		if(param != null && param.trim().length() != 0) {
			try {				
				pageRows = Integer.parseInt(param);
			} catch(NumberFormatException e) {
				// 예외 처리 안함
			}
		}
		
		try {
			// 글 전체 개수 구하기
			totalCnt = dao.countAll();
			
			// 총 몇 페이지 분량인가?
			totalPage = (int)Math.ceil(totalCnt / (double)pageRows);
			
			// 몇번재 row 부터 ?
			int fromRow = (page - 1) * pageRows + 1;  // ORACLE 은 1부터 ROWNUM시작
			//int fromRow = (page - 1) * pageRows;  // MySQL 은 0부터 시작
			
			list = dao.selectFromRow(fromRow, pageRows);
			
			if(list == null) {
				message.append("[리스트할 데이터가 없습니다]");
			} else {
				count = list.size();
				status = "OK";
			}
			
		} catch(Exception e) {
			//e.printStackTrace();
			message.append("[트랜잭션 에러:" + e.getMessage()+ "]");
		} // end try
		
		ajaxMyBoardList.setCount(count);
		ajaxMyBoardList.setStatus(status);
		ajaxMyBoardList.setMessage(message.toString());
		ajaxMyBoardList.setPage(page);
		ajaxMyBoardList.setList(list);
		ajaxMyBoardList.setTotalPage(totalPage);
		ajaxMyBoardList.setTotalCnt(totalCnt);
		ajaxMyBoardList.setWritePages(writePages);
		ajaxMyBoardList.setPageRows(pageRows);
		
		return ajaxMyBoardList;
	}
	
	@RequestMapping("/view/{uid}")
	public AjaxMyBoardList view(@PathVariable int uid) {
		// MyBatis 사용
		MyBoardDAO dao = C.sqlSession.getMapper(MyBoardDAO.class);
		
		AjaxMyBoardList ajaxMyBoardList = new AjaxMyBoardList();
		List<MyBoardDTO> list  = null;
		
		// ajax response 에 필요한 값들
		StringBuffer message = new StringBuffer();
		String status = "FAIL";   // 기본 FAIL
		
		String param = Integer.toString(uid);
		
		// 유효성 검사
		if(param == null) {
			message.append("[유효하지 않은 parameter 0 or null]");
		} else {			
			try {
				uid = Integer.parseInt(param);
				
				dao.incViewCnt(uid); // 조회수 증가
				list = dao.selectByUid(uid); // 읽기
				
				if(list == null) {
					message.append("[해당 데이터가 없습니다]");
				} else {
					status = "OK";
				}
				
			} catch (Exception e) {  
				message.append("[예외발생:" + e.getMessage() + "]");
			}
		}
		
		ajaxMyBoardList.setStatus(status);
		ajaxMyBoardList.setMessage(message.toString());
		ajaxMyBoardList.setList(list);
		
		return ajaxMyBoardList;
	}
	
	@RequestMapping(value="/writeOk", method = RequestMethod.POST)
	public AjaxMyBoardList write(HttpServletRequest request) {
		// MyBatis 사용
		MyBoardDAO dao = C.sqlSession.getMapper(MyBoardDAO.class);
		
		AjaxMyBoardList ajaxMyBoardList = new AjaxMyBoardList();
		
		int cnt = 0;
		
		// ajax response 에 필요한 값들
		StringBuffer message = new StringBuffer();
		String status = "FAIL";   // 기본 FAIL
		
		// 매개변수 받아오기
		String name = request.getParameter("name");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		// 유효성 체크
		if(name == null || name.trim().length() == 0) {
			message.append("[유효하지 않은 parameter : 작성자 필수]");
		} else if (subject == null || subject.trim().length() == 0) {
			message.append("[유효하지 않은 parameter : 글제목 필수]");
		} else {
			try {
				cnt = dao.insert(subject, content, name);
				if(cnt == 0) {
					message.append("[트랙잭션 실패: 0 insert");
				} else {
					status = "OK";
				}				
			} catch(Exception e) {
				//e.printStackTrace();
				message.append("[트랜잭션 에러:" + e.getMessage() + "]");
			}
			
		} // end if
			
		ajaxMyBoardList.setStatus(status);
		ajaxMyBoardList.setMessage(message.toString());
		
		return ajaxMyBoardList;
	}
	
	@RequestMapping(value="/updateOk", method = RequestMethod.POST)
	public AjaxMyBoardList update(HttpServletRequest request) {
		// MyBatis 사용
		MyBoardDAO dao = C.sqlSession.getMapper(MyBoardDAO.class);
		
		AjaxMyBoardList ajaxMyBoardList = new AjaxMyBoardList();
		
		int count = 0;
		
		// ajax response 에 필요한 값들
		StringBuffer message = new StringBuffer();
		String status = "FAIL";   // 기본 FAIL

		//입력한 값을 받아오기
		String param = request.getParameter("uid");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		if(param == null) {
			message.append("[유효하지 않은 parameter 0 or null]");
		} else if (subject == null || subject.trim().length() == 0) {
			message.append("[유효하지 않은 parameter : 글 제목 필수]");
		} else {
			try {			
				int uid = Integer.parseInt(param);
				
				count = dao.update(uid, subject, content);
				status = "OK";
				
				if(count == 0) {
					message.append("[0 update]");
				}
				
			} catch (Exception e) {
				message.append("[유효하지 않은 parameter] " + param);
			}

		} // end if

		ajaxMyBoardList.setCount(count);
		ajaxMyBoardList.setStatus(status);
		ajaxMyBoardList.setMessage(message.toString());
		
		return ajaxMyBoardList;
	}
	
	@RequestMapping(value="/deleteOk", method = RequestMethod.POST)
	public AjaxMyBoardList delete(HttpServletRequest request) {
		// MyBatis 사용
		MyBoardDAO dao = C.sqlSession.getMapper(MyBoardDAO.class);
				
		AjaxMyBoardList ajaxMyBoardList = new AjaxMyBoardList();
		
		int count = 0;
		
		// ajax response 에 필요한 값들
		StringBuffer message = new StringBuffer();
		String status = "FAIL";   // 기본 FAIL

		// 유효성 검증
		String[] params = request.getParameterValues("uid");
		int[] uids = null;
		
		if(params == null || params.length == 0) {
			message.append("[유효하지 않은 parameter 0 or null]");
		} else {
			uids = new int[params.length];
			try {			
				for(int i = 0; i < params.length; i++) {
					uids[i] = Integer.parseInt(params[i]);
				}
				count = dao.deleteByUid(uids);
				status = "OK";
				
			} catch (Exception e) {
				message.append("[유효하지 않은 parameter]" + Arrays.toString(params));
			}
		}
		
		ajaxMyBoardList.setCount(count);
		ajaxMyBoardList.setStatus(status);
		ajaxMyBoardList.setMessage(message.toString());
		
		return ajaxMyBoardList;
	}
	
}
