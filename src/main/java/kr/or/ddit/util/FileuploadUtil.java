package kr.or.ddit.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileuploadUtil {

	/**
	* Method : getFilename
	* 작성자 : PC-03
	* 변경이력 :
	* @param contentDisposition
	* @return
	* Method 설명 :Content-disposition 헤더 문자열로 파일 이름 추출
	*/
	public static String getFilename(String contentDisposition) {
		
		//메소드 인자 : "form-data; name=\"file\"; filename=\"brown.png\""; 
		
		String[] attrs = contentDisposition.split("; ");
		
		String filename = "";
		for(String attr : attrs) {
			if(attr.startsWith("filename")) {
				String[] keyValue = attr.split("=");
				filename = keyValue[1].substring(keyValue[1].indexOf("\"")+1, 
							keyValue[1].lastIndexOf("\""));
				break;
			}
		}
		return filename;
	}

	/**
	* Method : getFilename
	* 작성자 : PC-03
	* 변경이력 :
	* @param contentDisposition
	* @return
	* Method 설명 :Content-disposition 헤더 문자열로 파일 확장자 추출
	*/
	public static String getFileExtenstion(String contentDisposition) {
		//메소드 인자 : "form-data; name=\"file\"; filename=\"brown.png\""; 

		String filename = getFilename(contentDisposition);
		
			if(filename.lastIndexOf(".") > 0) {
				return filename.substring(filename.lastIndexOf("."), filename.length());
			}else {
				return "";
			}
	}
	/**
	* Method : getFilename
	* 작성자 : PC-03
	* 변경이력 :
	* @param contentDisposition
	* @return
	* Method 설명 :파일을 업로드할 경로를 조회한다.
	*/
	public static String getPath() {
		String basicPath = "e:\\upload";
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		String yyyyMM = sdf.format(new Date());
		String yyyy = yyyyMM.substring(0, 4);
		String mm = yyyyMM.substring(4, 6);
		
		File directory = new File(basicPath + "\\" + yyyy + "\\" + mm);
		if(!directory.exists()) {
			directory.mkdirs();
		}
		return basicPath + "\\" + yyyy + "\\" + mm + "\\";
	}
	
	

}
