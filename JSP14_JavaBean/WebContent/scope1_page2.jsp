<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:useBean id="cnt" class="com.lec.beans.CountBean" scope="page"/>

<h3>page2<br>cnt 의 getCount 호출</h3>

<jsp:getProperty name="cnt" property="count"/><br>

<a href="scope1_page1.jsp">page1 으로..</a>