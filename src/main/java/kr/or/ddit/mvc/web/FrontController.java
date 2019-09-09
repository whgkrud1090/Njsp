package kr.or.ddit.mvc.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
	모든 요청을 가장 앞에서 박는 FrontController
	지금까지 서블릿을 생성할 때 doGet, doPost재정의
		-> service 메소드 재정의(모든 요청 메서드의 요청을 받기 위해서)
 */
public class FrontController extends HttpServlet{
	private HandlerMapper handlerMapper;
	
	@Override
	public void init() throws ServletException {
		handlerMapper = new HandlerMapper();
	}
	
	private static final Logger logger = LoggerFactory.getLogger(FrontController.class);
	
	//service 재정의
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.debug("request method : {}", req.getMethod());

		//HttpServelt아래 클래
		//userList.do --> UserListController
		//memberList.do --> MemberListController
		
		logger.debug("req.getRequestURL() : {}", req.getRequestURI());
		
		String uri = req.getRequestURI();
	
		IController controller = handlerMapper.getController(uri);
		controller.exeucte(req, resp);
		
		/*
		if(uri.equals("/mvc/userList.do")) {
			IController controller = new UserListController();
			controller.exeucte(req, resp);
		}
		else if(uri.equals("/mvc/user.do")) {
			IController controller = new MemberListController();
			controller.exeucte(req, resp);
		}
		*/
	}
}
