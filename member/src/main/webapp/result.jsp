<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
request:<%= request.getAttribute("id") %><br>
session:<%= request.getSession().getAttribute("id") %><br>
cotext(application):
<%=request.getServletContext().getAttribute("id") %>
<a href="/login.jsp">로그인페이지이동</a>