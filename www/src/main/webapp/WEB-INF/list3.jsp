<%@page import="java.util.ArrayList"%>
<%@page import="phonebook.Phonebook"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- 획득한 데이터를 화면에 표시 view 처리 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
<thead>
<tr>
	<th>아이디</th>
	<th>이름</th>
	<th>전화번호</th>
	<th>이메일</th>
	<th>메모</th>
</tr>
</thead>
<tbody> 

<%
List<Phonebook> list = (List<Phonebook>) request.getAttribute("list");
for(Phonebook pb: list){
%>

<tr>
	<td><%= pb.getId()%></td>
	<td><%= pb.getName()%></td>
	<td><%= pb.getHp()%></td>
	<td><%= pb.getEmail()%></td>
	<td><%= pb.getMemo()%></td>
</tr>
<%
}
%>
</tbody>
</table>
</body>
</html>