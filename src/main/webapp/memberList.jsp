<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.poseidon.dto.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.poseidon.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
MemberDAO dao = new MemberDAO();
ArrayList<MemberDTO> list = dao.memberList();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 리스트</title>
</head>
<body>
	<h1>회원 정보 보기</h1>
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>가입일</th>
				<th>등급</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (MemberDTO memberDTO : list) {
			%>
			<tr>
				<td><%=memberDTO.getMno() %></td>
				<td><%=memberDTO.getMname() %></td>
				<td><%=memberDTO.getMid() %></td>
				<td><%=memberDTO.getMpw() %></td>
				<td><%=memberDTO.getMjoindate() %></td>
				<td><%=memberDTO.getMgrade() %></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
</body>
</html>