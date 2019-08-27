package kr.or.ddit.encypt.kias.aria;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.encrypt.kisa.aria.ARIAUtil;

public class AriaUtilTest {

	private static final Logger logger = LoggerFactory.getLogger(AriaUtilTest.class);
	/**
	* Method : encryptDecryptTest
	* 작성자 : PC-03
	* 변경이력 :
	* Method 설명 :aria 블록 암호화/복호화 테스트
	 * @throws UnsupportedEncodingException 
	 * @throws InvalidKeyException 
	 */
	@Test
	public void encryptDecryptTest() throws InvalidKeyException, UnsupportedEncodingException {
		
		/***Given***/
		String userId = "browm";

		/***When***/
		String encryptedText = ARIAUtil.ariaEncrypt(userId);
		String decryptedText = ARIAUtil.ariaDecrypt(encryptedText);

		logger.debug("encryptedText : {} ",encryptedText);
		logger.debug("decryptedText : {} ",decryptedText);
		
//		8BD6D0715B662698EF2642364FF9425C 
//		brown 
		
//		85F0C43065A727B5F5B38154277756F6 
//		browm 
		
		/***Then***/
		assertEquals(userId, decryptedText);
		
	}

}
