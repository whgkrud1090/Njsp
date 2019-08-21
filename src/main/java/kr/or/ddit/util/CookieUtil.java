package kr.or.ddit.util;

public class CookieUtil {

	/**
	* Method : getCookie
	* 작성자 : SEM-PC
	* 변경이력 :
	* @param cookieString
	* @param string
	* @return
	* Method 설명 : 쿠키 문자열로부터 특정 쿠키의 값을 반환한다
	*/
	public static String getCookie(String cookieString, String cookieId) {
		//cookieString : "userId=brown; rememberMe=Y; test=testValue"
		//cookieId : userId
		
		String[] cookies = cookieString.split("; ");
		// cookies[0] = "userId=brown";		//쿠키이름=쿠키값
		// cookies[1] = "rememberMe=Y";
		// cookies[2] = "test=testValue";
		
		for(String cookie : cookies) {
			String[] cookieNmVal = cookie.split("=");
			if(cookieId.equals(cookieNmVal[0]))
				return cookieNmVal[1];
		}
		
		return null;
		
		//for 1
		//cookieNmVal[0] = userId
		//cookieNmVal[1] = brown
		
		//for 2
		//cookieNmVal[0] = rememberMe
		//cookieNmVal[1] = Y
		
		//for 3
		//cookieNmVal[0] = test
		//cookieNmVal[1] = testValue
	}
}











