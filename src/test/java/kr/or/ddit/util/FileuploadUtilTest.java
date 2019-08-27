package kr.or.ddit.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class FileuploadUtilTest {

	/**
	* Method : getFilenameTest
	* 작성자 : PC-03
	* 변경이력 :
	* Method 설명 : Content-disposition 헤더 문자열로 파일 이름 추출 테스트
	 */
	@Test
	public void getFilenameTest() {
		/***Given***/
		String contentDisposition = "form-data; name=\"file\"; filename=\"brown.png\""; 
		String contentDisposition2 = "form-data; name=\"file\"; filename=\"moon.png\""; 

		/***When***/
		String filename = FileuploadUtil.getFilename(contentDisposition);
		String filename2 = FileuploadUtil.getFilename(contentDisposition2);

		/***Then***/
		assertEquals("brown.png", filename);
		assertEquals("moon.png", filename2);
	}

	
	/**
	 * Method : getFilenameTest
	 * 작성자 : PC-03
	 * 변경이력 :
	 * Method 설명 : Content-disposition 헤더 문자열로 파일 확장자추출 테스트
	 */
	@Test
	public void getFileExtenstionTest() {
		/***Given***/
		String contentDisposition = "form-data; name=\"file\"; filename=\"brown.png\""; 
		String contentDisposition2 = "form-data; name=\"file\"; filename=\"moon.png\""; 
		String contentDisposition3 = "form-data; name=\"file\"; filename=\"moon\""; 
		String contentDisposition4 = "form-data; name=\"file\"; filename=\"moon.png.jpg\""; 
		
		/***When***/
		String fileExtenstionName = FileuploadUtil.getFileExtenstion(contentDisposition);
		String fileExtenstionName2 = FileuploadUtil.getFileExtenstion(contentDisposition2);
		String fileExtenstionName3 = FileuploadUtil.getFileExtenstion(contentDisposition3);
		String fileExtenstionName4 = FileuploadUtil.getFileExtenstion(contentDisposition4);
		
		/***Then***/
		assertEquals(".png", fileExtenstionName);
		assertEquals(".png", fileExtenstionName2);
		assertEquals("", fileExtenstionName3);
		assertEquals(".jpg", fileExtenstionName4);
	}
	
	@Test
	public void getPathTest() {
		/***Given***/

		/***When***/
		String path = FileuploadUtil.getPath();
		
		/***Then***/
		assertEquals("e:\\upload\\2019\\08\\", path);
	}

}
