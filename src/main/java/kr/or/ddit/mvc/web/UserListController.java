package kr.or.ddit.mvc.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserListController implements IController{

	private static final Logger logger = LoggerFactory.getLogger(UserListController.class);
	
	public void exeucte(HttpServletRequest req, HttpServletResponse resp) {
		logger.debug("userListController.execute");
		
	}

}
