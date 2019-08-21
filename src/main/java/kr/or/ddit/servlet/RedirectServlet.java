package kr.or.ddit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * web.xml <servlet></servlet>, <servlet-mapping></servlet-mapping> 설정을
 * @WebServlet을 통해 대체
 */
@WebServlet("/redirectServlet")
public class RedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// localhost:8081/redirectServlet get => doGet 호출
	// 웹브라우저 주소줄에 url을 입력하고 엔터를입력하면 get 방식의 요청
	
	//rediretForm.jsp에게 응답 생성을 위임
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//print writer 객체를 이용하여 html 코드를 직접 적상하는 것이 아니라
		//화면을 생성하는 jsp에게 요청을 위임
		
		//dispatch 방식으로 위임
		//context path를 적어주지 않는다
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/redirectForm.jsp");
		rd.forward(request, response);
	}
	
	// localhost:8081/redirectServlet post => doPost 호출
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//login 화면으로 리다이렉트
		
		//메소드 인자로 웹브라우저 주소줄에 입력할 url을 작성
		//context path가 root가 아니면 context path도 같이 적어줘야 한다
		response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");
	}
}







