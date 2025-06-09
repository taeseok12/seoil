package member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class memberController extends HttpServlet{
	
	memberservice service;
	
	public memberController() {
		service = new memberservice();
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
	//페이지 호출에 대한  jsp 파일을 uri 명령으로 변환정리
	//로그인폼열기 -login.jsp-xxxx (명령)
	//로그인처리-login_proc.jsp-xxxx(uri 명령)
	//로그아웃-logout.jsp-xxxx(uri 명령)
		
	
		
	}
}
