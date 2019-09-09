package kr.or.ddit.mvc.repository;

import java.util.List;

import kr.or.ddit.mvc.model.UrlMapping;

public interface IUrlMappingDao {
	
	List<UrlMapping> getUrlMapping();
	
}
