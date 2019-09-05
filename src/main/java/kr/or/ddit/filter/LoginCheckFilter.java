package kr.or.ddit.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.user.model.User;

//@WebFilter("/*")
public class LoginCheckFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		//사용자가 로그인은 했는지?
		//yes -> chain.doFilter() 다은 filter 혹은 servlet 요청 전송
		//no -> request, response객체를 이용하여 login화면으로 이동
		
		//로그인 요청(login.jsp 로그인 하기 버튼 눌렀을때)
		
		//getSession() 가져오기 위해 형변환
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession();
		
		//선언한 session에서 'S_USERVO'에 넣은 값을 가져온다.
			// -> session에 넣은 값과 같은 타입변수생성해 넣어준다.
		User S_USERVO = (User) session.getAttribute("S_USERVO");
		
		String uri = httpRequest.getRequestURI();
		
		//로그인을 체크하지 말아야하는 url을 확인
		//style.CSS
		if(uri.startsWith("/login") || uri.endsWith(".css") || uri.endsWith(".js")) {
			chain.doFilter(request, response);
		}
		//로그인하지 않은 상황
		else if(S_USERVO == null) {
			//로그인 화면
			//리다이렉트
			HttpServletResponse httpResponse = (HttpServletResponse) response;
			httpResponse.sendRedirect("/login");
		}
		//로그인한 상황
		else {
			//기존 
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
