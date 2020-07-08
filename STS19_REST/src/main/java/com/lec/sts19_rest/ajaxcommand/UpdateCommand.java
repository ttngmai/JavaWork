package com.lec.sts19_rest.ajaxcommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.sts19_rest.board.C;
import com.lec.sts19_rest.board.beans.IAjaxDAO;

public class UpdateCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		IAjaxDAO dao = C.sqlSession.getMapper(IAjaxDAO.class);
		int cnt = 0;
		
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
				
				cnt = dao.update(uid, subject, content);
				status = "OK";
				
				if(cnt == 0) {
					message.append("[0 update]");
				}
				
			} catch (NumberFormatException e) {
				message.append("[유효하지 않은 parameter] " + param);
			} catch (Exception e) {
				message.append("[트랜잭션 에러:" + e.getMessage() + "]");
			}
		} // end if

		request.setAttribute("result", cnt);
		request.setAttribute("status", status);
		request.setAttribute("message", message.toString());
	}

}










