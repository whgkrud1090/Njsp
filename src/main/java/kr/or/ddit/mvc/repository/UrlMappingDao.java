package kr.or.ddit.mvc.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.mvc.model.UrlMapping;
import kr.or.ddit.util.MybatisUtil;

public class UrlMappingDao implements IUrlMappingDao{

	@Override
	public List<UrlMapping> getUrlMapping() {
		
		SqlSession sqlSession = MybatisUtil.getSession();
		List<UrlMapping> list = sqlSession.selectList("db.getUrlMapping");
		sqlSession.close();
		
		return list;
	}

}
