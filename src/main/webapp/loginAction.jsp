<%@page import="com.poseidon.dto.MemberDTO"%>
<%@page import="com.poseidon.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	MemberDAO dao = new MemberDAO();
	MemberDTO dto = dao.login(id,pw);
	
	if (dto.getCount() == 1) {
		response.sendRedirect("./main.jsp");
	} else {
		response.sendRedirect("./login.html");
	}
	%>