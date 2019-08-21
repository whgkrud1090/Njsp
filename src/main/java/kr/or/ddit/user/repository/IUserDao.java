package kr.or.ddit.user.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.user.model.User;

public interface IUserDao {
	
	List<User> getUserList(SqlSession sqlSession);

	User getUser(SqlSession sqlSession, String userId);

	/**
	* Method : getUserListOnlyHalf
	* 작성자 : SEM-PC
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 리스트중 50명임의 조회
	*/
	List<User> getUserListOnlyHalf(SqlSession sqlSession);
	
	/**
	* Method : getUserPagingList
	* 작성자 : PC-03
	* 변경이력 :
	* @param sqlSession
	* @param page
	* @return
	* Method 설명 :사용자 페이징리스트 조회
	 */
	List<User> getUserPagingList(SqlSession sqlSession, Page page);
	
	/**
	* Method : getUsetTotalCnt
	* 작성자 : PC-03
	* 변경이력 :
	* @param sqlSession
	* @return
	* Method 설명 : 전체 사용자 건수 조회
	 */
	int getUsetTotalCnt(SqlSession sqlSession);
}
