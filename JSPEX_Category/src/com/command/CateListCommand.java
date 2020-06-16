package com.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.CategoryDAO;
import com.lec.beans.CategoryDTO;

public class CateListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		CategoryDAO dao = new CategoryDAO();
		CategoryDTO[] category = null;
		
		StringBuffer message = new StringBuffer();
		String status = "FAIL"; // 기본 status 는 FAIL
		
		int depth; 
		int parent;
		
		if(request.getParameter("depth") == null || request.getParameter("parent") == null ||
				Integer.parseInt(request.getParameter("depth")) == 1 || Integer.parseInt(request.getParameter("parent")) == 0) {
			try {
				category = dao.selectFirstCate();
				if(category == null) {
					message.append("리스트할 카테고리가 없습니다.");
				} else {
					status = "OK";
				}
				
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
		} else {
			try {
				depth = Integer.parseInt(request.getParameter("depth"));
				parent = Integer.parseInt(request.getParameter("parent"));
				
				category = dao.selectChildCate(depth, parent);
				if(category == null) {
					message.append("리스트할 카테고리가 없습니다.");
				} else {
					status = "OK";
				}
				
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		request.setAttribute("status", status);
		request.setAttribute("message", message.toString());
		
		request.setAttribute("cateList", category);

	} // end execute()

} // end Command
