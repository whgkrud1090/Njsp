package kr.or.ddit.lprod.dao;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.lprod.model.Lprod;
import kr.or.ddit.lprod.service.ILprodService;
import kr.or.ddit.lprod.service.LprodService;
import kr.or.ddit.util.MybatisUtil;

public class LprodDaoTest {
	
	SqlSession sqlSession;
	
	@Before
	public void setup() {
		sqlSession = MybatisUtil.getSession();
	}

	/**
	* Method : getLpordListTest
	* 작성자 : SEM-PC
	* 변경이력 :
	* Method 설명 : 제품 그룹 리스트 조회 테스트
	*/
	@Test
	public void getLpordListTest() {
		/***Given***/
		ILprodService lprodService = new LprodService();

		/***When***/
		List<Lprod> lprodList = lprodService.getLprodList();

		/***Then***/
		assertEquals(10, lprodList.size());
	}
	
	public void getLprodPagingListTest() {
		/***Given***/
		ILprodService lprodService = new LprodService();
		Page page = new Page();
		page.setPage(1);
		page.setPagesize(5);

		/***When***/
		Map<String, Object> lprodList = lprodService.getLprodPagingList(page);
		
		/***Then***/
		
		assertEquals(5, lprodList.size());
	}
	
	public void getLprodTotalCnt() {
		/***Given***/
		ILprodDao lprodDao = new LprodDao();

		/***When***/
		int totalCnt = lprodDao.getLprodTotalCnt(sqlSession);

		/***Then***/
		assertEquals(10, totalCnt);
	}
}