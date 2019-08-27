package kr.or.ddit.servlet;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.util.FileuploadUtil;

/*
 * maxRequestSize : 요청최대크기
 * maxFileSize : 파일당최대크기
 * 
 * 파일 최대사이드 5메가, 요청당 최대 5개 파일(25메가)
 */
@WebServlet("/fileupload")
@MultipartConfig(maxFileSize = 1024*1024*5, maxRequestSize = 1024*1024*5*5)
public class FileuploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(FileuploadServlet.class);
	
	//jsp로 연결하는 요청처리
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//view요청처리
		request.getRequestDispatcher("/jsp/fileupload.jsp").forward(request, response);
	}

	//form submit처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String file = request.getParameter("file");
		
		Part part = request.getPart("file");
		part.getName();	//업로트 파라미터 명(input의 name속성)
		part.getContentType();	//
		part.getSize();	//업로드 파일사이즈
		part.getHeader("Content-Disposition");		
		
		logger.debug("userId : {}", userId);
		logger.debug("file : {}", file);
		
		logger.debug("part.getName() : {}", part.getName());
		logger.debug("part.getContentType() : {}", part.getContentType());
		logger.debug("part.getSize() : {}", part.getSize());
		logger.debug("header content-dispostion : {}", part.getHeader("Content-Disposition"));
		
		String path = FileuploadUtil.getPath();
		//어떤 파일을 업로드해도 파일명이 brownupload.png로 고정됨
		// --> 실제 업로드한 파일명으로 수정
		
		//e:\\upload\\ 폴더하나에 모든 파일을 저장하고 있던 것을 파일 업로드 날짜의 년월폴더를 체크하여 월단위로 파일을 관리
		//path ex : e:\\upload\\2019\\08
		part.write(path + UUID.randomUUID().toString() + FileuploadUtil.getFilename(part.getHeader("Content-Disposition")));
//		part.write("e:\\upload\\" + FileuploadUtil.getFilename(part.getHeader("Content-Disposition")));
		
		
		//최초 view로 이동
		doGet(request, response);
	}

}
