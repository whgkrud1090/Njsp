package kr.or.ddit.lprod.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import kr.or.ddit.lprod.model.Lprod;

public class LprodDaoTest {

	/**
	* Method : getLpordListTest
	* 작성자 : SEM-PC
	* 변경이력 :
	* Method 설명 : 제품 그룹 리스트 조회 테스트
	*/
	@Test
	public void getLpordListTest() {
		/***Given***/
		ILprodDao lprodDao = new LprodDao();

		/***When***/
		List<Lprod> lprodList = lprodDao.getLprodList();

		/***Then***/
		assertEquals(10, lprodList.size());
	}

}
