package kr.or.ddit.user.web;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.user.model.User;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.util.FileuploadUtil;

@WebServlet("/userupdate")
@MultipartConfig(maxFileSize = 1024*1024*5, maxRequestSize = 1024*1024*5*5)
public class UserUpdateConroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IUserService userService;

	@Override
	public void init() throws ServletException {
		userService = new UserService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userId = request.getParameter("userId");

		User user = userService.getUser(userId);

		request.setAttribute("user", user);

		request.getRequestDispatcher("/user/userUpdateForm.jsp").forward(request, response);
	}

	/**
	 * Method : doPost 작성자 : PC-03 변경이력 :
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException      Method 설명 : 사용자 수정 요청
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String userId = request.getParameter("userId");
		String userNm = request.getParameter("userNm");
		String alias = request.getParameter("alias");
		String reg_dt = request.getParameter("reg_dt");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String pass = request.getParameter("pass");
		String zipcode = request.getParameter("zipcode");

		Date reg_dt_date = null;

		Part picture = request.getPart("picture");

		String filename = "";
		String path = "";
		// 사용자가 파일을 업로드한 경우
		if (picture.getSize() > 0) {
			filename = FileuploadUtil.getFilename(picture.getHeader("Content-Disposition")); // 사용자가 업로드한 파일의 이름

			String realfilename = UUID.randomUUID().toString();
			String ext = FileuploadUtil.getFileExtenstion(picture.getHeader("Content-Disposition"));

			path = FileuploadUtil.getPath() + realfilename + ext;

			picture.write(path);
			
		}else {
			User orgin = userService.getUser(userId);
			
			filename = orgin.getFilename();
			path = orgin.getRealFilename();
		}
		try {
			reg_dt_date = new SimpleDateFormat("yyyy-MM-dd").parse(reg_dt);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		
		User user = new User(userId, userNm, alias, reg_dt_date, addr1, addr2, pass, zipcode, filename, path);
		
		int updateCnt = 0;
		
		try {
			updateCnt = userService.updateUser(user);
			
			if(updateCnt == 1) {
				
				response.sendRedirect(request.getContextPath() + "/user?userId=" + userId);
			}
			
		} catch (Exception e) {
			doGet(request, response);
		}	
	}

}
