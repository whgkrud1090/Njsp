package kr.or.ddit.user.service;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.user.model.User;

public class UserServiceTest {
   private IUserService userService;
   
   private String userId = "brownTest";
   
   @Before
   public void setup() {
      userService = new UserService();
      
      userService.deleteUser(userId);
   }

   /**
    * 
   * Method : getUserListTest
   * 작성자 : PC-07
   * 변경이력 :
   * Method 설명 : getUserList 테스트
    */
   @Test
   public void getUserList() {
      /***Given***/
      
      /***When***/
      List<User> userList = userService.getUserList();
      
      /***Then***/
      assertEquals(105, userList.size());
   }
   
   /**
    * 
   * Method : getUserTest
   * 작성자 : PC-07
   * 변경이력 :
   * Method 설명 : 사용자 정보 조회 테스트
    */
   @Test
   public void getUser() {
      /***Given***/
      String userId = "brown";
      
      /***When***/
      User userVo = userService.getUser(userId);
      
      /***Then***/
      assertEquals("브라운", userVo.getUserNm());
      assertEquals("brown1234", userVo.getPass());
   }
   
   @Test
   public void getUserListOnlyHalf() {
      /***Given***/
      
      /***When***/
      List<User> userList = userService.getUserListOnlyHalf();
      
      /***Then***/
      assertEquals(50, userList.size());
      System.out.println(userList);
   }
   
   /**
	 * 
	* Method : getUserPagingListTest
	* 작성자 : PC-04
	* 변경이력 :
	* Method 설명 : 사용자 페이징 리스트 조회
	 */
	@Test
	public void getUserPagingListTest(){
		/***Given***/
		Page page = new Page();
		page.setPage(3);
		page.setPagesize(10);
		
		/***When***/
		Map<String, Object> resultMap = userService.getUserPagingList(page);
		List<User> userList = (List<User>)resultMap.get("userList");
		int paginationSize = (Integer)resultMap.get("paginationSize");
		
		/***Then***/
		assertEquals(10, userList.size());
		assertEquals("xuserid22", userList.get(0).getUserId());
		assertEquals(11, paginationSize);
	}
	
	@Test
	public void ceilingTest() {
		/***Given***/
		int totalCnt = 105;
		int pagesize = 10;

		/***When***/
		double paginationSize = Math.ceil((double)totalCnt / pagesize);
		
		/***Then***/
		assertEquals(11, (int)paginationSize);
	}
	

	@Test
	public void insertUserTest() throws ParseException {
		/***Given***/
		User user = new User();
		
		user.setUserId(userId);
		user.setUserNm("브라운테스트");
		user.setPass("brown1234");
		user.setReg_dt(new SimpleDateFormat("yyyy-MM-dd").parse("2019-08-08"));
		user.setAlias("곰테스트");
		user.setAddr1("대전광역시 중구 중앙로 76");
		user.setAddr2("영민빌딩 2층 DDIT");
		user.setZipcode("34940");
		
		
		

		/***When***/
		int insertCnt = userService.insertUser(user);
		

		/***Then***/
		assertEquals(1, insertCnt);
	}	
	

}