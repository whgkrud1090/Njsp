package kr.or.ddit.lprod.dao;

import java.util.List;

import kr.or.ddit.lprod.model.Lprod;

public interface ILprodDao {

	/**
	* Method : getLprodList
	* 작성자 : SEM-PC
	* 변경이력 :
	* @return
	* Method 설명 : 제품 그룹 리스트 조회
	*/
	List<Lprod> getLprodList();

}
