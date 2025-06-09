<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
String id = request.getParameter("id");
String password = request.getParameter("password");
if(id.equals("admin") && password.equals("1234")){
	//범위에 대한 차이
	request.setAttribute("id", "admin"); //해당 페이지에서만 값을 전달
	request.getSession().setAttribute("id","admin"); //페이지가 달라도 값을 전달(하나의 프로그램에 한정)
	request.getServletContext().setAttribute("id", "admin"); //프로그램이 달라도 값을 전달
	System.out.println("로그인성공!!");
} else{
	//로그인이 실패할 경우 getAttribute("id")의 값은 null값인 상태가 됨.
	System.out.println("로그인실패!!");
}
//로그인의 결과를 저장하고 result.jsp 에서 결과 확인
response.sendRedirect("/result.jsp");
//request.getRequestDispatcher("result.jsp").forward(request, response);
%>
<%=id %><br>
<%=password %><br>
</body>
</html>