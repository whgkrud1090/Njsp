package kr.or.ddit.lprod.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.lprod.dao.ILprodDao;
import kr.or.ddit.lprod.dao.LprodDao;

/**
 * Servlet implementation class LprodListController
 */
@WebServlet("/lprodList")
public class LprodListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(LprodListController.class);
	
	private ILprodDao lprodDao;
	
	@Override
	public void init() throws ServletException {
		lprodDao = new LprodDao();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("lprodList", lprodDao.getLprodList());
		request.getRequestDispatcher("/lprod/lprodList.jsp").forward(request, response);
	}

}
