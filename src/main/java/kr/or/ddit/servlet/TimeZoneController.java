package kr.or.ddit.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.TimeZone;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/timeZone")
public class TimeZoneController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String[] timeZoneList = TimeZone.getAvailableIDs();
		request.setAttribute("timeZoneList", timeZoneList);
		request.setAttribute("dt", new Date());
		request.getRequestDispatcher("/jstl/timeZone.jsp").forward(request, response);
	}
}
