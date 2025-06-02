package www;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Hello extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//전달되는 한글이 깨지지 않게 처리
		response.setCharacterEncoding("utf-8");
		//전송되는 한글이 깨지지 않게 처리
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		//System.out.println("/hello url 접속");
		PrintWriter out = response.getWriter();
		
	
		out.print("<html>");
		out.print("<head><meta charset=\"UTF-8\"> </head>");
		out.print("<body>");
		out.print("<h1>hello url에 접속하셨습니다.</h1>");
		
		// /hello?insa=안녕&re=5  (insa = 안녕은 파라미터, 전달되는 정보)
		System.out.println();
		String p1 = request.getParameter("insa");
		int p2 = Integer.parseInt(request.getParameter("re"));
		System.out.println(p1);
		for(int i=0 ; i<p2 ; i++) {
			out.print(p1 + "<br>");
		} //문제점은 <br>가 단순한 문자로 표현되는 문제 발생 이를 해결하기 위해 html 기본문법에 해당코드를 입력
		
		out.print("</body>");
		out.print("<html>");
	}
}
