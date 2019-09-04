package kr.or.ddit.dbConnection;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DbcpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(DbcpServlet.class);

	@Override
	public void init(ServletConfig config) throws ServletException {
		logger.debug("DbcpServlet init()");
		
		ServletContext application = config.getServletContext();
		
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		ds.setUsername("chk");
		ds.setPassword("java");
		ds.setInitialSize(10);
		
		application.setAttribute("ds", ds);
	}
       
	
}








