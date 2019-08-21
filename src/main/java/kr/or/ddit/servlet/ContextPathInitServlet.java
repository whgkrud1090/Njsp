package kr.or.ddit.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@WebServlet( urlPatterns = "/contextPathInit", loadOnStartup = 1)
public class ContextPathInitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(ContextPathInitServlet.class);
       
    @Override
    public void init(ServletConfig config) throws ServletException {
    	
    	ServletContext application = config.getServletContext();
    	application.setAttribute("cp", application.getContextPath());
    	logger.debug("contextPathInitServlet init() : {}", application.getContextPath());
    }
}





