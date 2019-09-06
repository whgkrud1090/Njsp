package kr.or.ddit.listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.user.model.User;

public class SessionListener implements HttpSessionAttributeListener{

	private static final Logger logger = LoggerFactory.getLogger(SessionListener.class);
	// 추가
	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		
		//사용자가 정상적으로 로그인 했을때 Session에 추가되는 S_USERVO값을 기준으로 
		//S_USERVO 속성이 세션에 추가될때 application객체에 사용자를 추가해서
		//현재 접속한 사용자 리스트를 보여주는 화면 개발

		String attrName = event.getName();	//세션에 추가된 속성 이름

		if(attrName.equals("S_USERVO")) {
			ServletContext sc = event.getSession().getServletContext();
			List<User> s_uservo_list = (List<User>) sc.getAttribute("S_USERVO_LIST");
			s_uservo_list.add((User)event.getValue());
		}
	}

	// 삭제
	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		logger.debug("attributeRemoved");
		/*String attrName = event.getName();	//세션에 추가된 속성 이름

		if(attrName.equals("S_USERVO")) {
			ServletContext sc = event.getSession().getServletContext();
			List<User> s_uservo_list = (List<User>) sc.getAttribute("S_USERVO_LIST");
			s_uservo_list.remove((User)event.getValue());
		}*/
		
	}

	// 변경
	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		logger.debug("attributeReplaced");
//		attributeAdded(event);
		
		String attrName = event.getName();	//세션에 추가된 속성 이름
		
		if(attrName.equals("S_USERVO")) {
		
		//새롭게 변경된 사용자 세션 정보
		HttpSession session = (HttpSession) event.getSource();
		User user = (User) session.getAttribute("S_USERVO");
		
		//기존 사용자 세션 정보
		User oldUser = (User) event.getValue();
		
		ServletContext sc = event.getSession().getServletContext();
		List<User> s_uservo_list = (List<User>) sc.getAttribute("S_USERVO_LIST");
		
		//기존 사용자의 정보는 지우고 새로운 사용자의 정보를 리스트에 추가한다.
		s_uservo_list.remove(oldUser);
		s_uservo_list.add(user);
		}
	}
}
