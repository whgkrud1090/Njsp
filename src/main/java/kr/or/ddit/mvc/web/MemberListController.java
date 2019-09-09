package kr.or.ddit.mvc.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MemberListController implements IController{
	public static void main(String[] args) {
	}

	private static final Logger logger = LoggerFactory.getLogger(MemberListController.class);
	public void exeucte(HttpServletRequest req, HttpServletResponse resp) {
		logger.debug("memberListController.execute");
	}
}

