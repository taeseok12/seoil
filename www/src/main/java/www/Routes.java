package www;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class Routes extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("route 통과");
		String command = req.getRequestURI();
		
		System.out.println("command:" + command);
		command = command.substring(1);
		
		System.out.println("command2" + command);
		if(command.equals("favicon.ico")) return;
		int a = Integer.parseInt(req.getRequestURI());
		int b = Integer.parseInt(req.getRequestURI());
		switch (command) {
		case "add":
			System.out.println("더하기 실행: " + (a + b));
			break;
		case "sub":
			System.out.println("빼기 실행: " + (a - b));
			break;
		case "power":
			System.out.println("곱하기 실행: " + (a * b));
			break;
		case "div":
			System.out.println("나누기 실행: " + (a / b));
			break;
		default:
			break;
		}
	}
}
