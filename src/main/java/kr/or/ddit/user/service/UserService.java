package kr.or.ddit.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.user.model.User;
import kr.or.ddit.user.repository.IUserDao;
import kr.or.ddit.user.repository.UserDao;
import kr.or.ddit.util.MybatisUtil;

public class UserService implements IUserService{
	
	private IUserDao userDao;
	
	public UserService() {
		userDao = new UserDao();
	}

	@Override
	public List<User> getUserList() {
		SqlSession sqlSession = MybatisUtil.getSession();
		
		List<User> userList = userDao.getUserList(sqlSession);
		sqlSession.close();
		
		return userList;
	}

	@Override
	public User getUser(String userId) {
		SqlSession sqlSession = MybatisUtil.getSession();
		
		User user = userDao.getUser(sqlSession, userId);
		sqlSession.close();
		return user;
	}

	@Override
	public List<User> getUserListOnlyHalf() {
		SqlSession sqlSession = MybatisUtil.getSession();
		
		List<User> userList = userDao.getUserListOnlyHalf(sqlSession);
		sqlSession.close();
		
		return userList;
	}

	@Override
	public Map<String, Object> getUserPagingList(Page page) {
		
		//반환환해야 하는 값이 한개 이상이기 때문에 List를 사용할 수 없다.
		Map<String, Object> map = new HashMap<String, Object>();
		
		SqlSession sqlSession = MybatisUtil.getSession();
		
		List<User> userList = userDao.getUserPagingList(sqlSession, page);
		int totalCnt = userDao.getUsetTotalCnt(sqlSession);
		
		map.put("userList", userList);
		map.put("paginationSize", (int)Math.ceil((double)totalCnt/page.getPagesize()));
		
		sqlSession.close();
		
		return map;
	}

	@Override
	public int insertUser(User user) {
		SqlSession sqlSession = MybatisUtil.getSession();
		
		int insertCnt = userDao.insertUser(sqlSession, user);
		
		sqlSession.commit();
		sqlSession.close();
		
		return insertCnt;
	}

	@Override
	public int deleteUser(String userId) {
		SqlSession sqlSession = MybatisUtil.getSession();
		
		int deleteCnt = userDao.deleteUser(sqlSession, userId);
		
		sqlSession.commit();
		sqlSession.close();
		
		return deleteCnt;
	}

	@Override
	public int updateUser(User user) {
		SqlSession sqlSession = MybatisUtil.getSession();
		
		int updateCnt = userDao.updateUser(sqlSession, user);
		
		sqlSession.commit();
		sqlSession.close();
		
		return updateCnt;
	}

}
