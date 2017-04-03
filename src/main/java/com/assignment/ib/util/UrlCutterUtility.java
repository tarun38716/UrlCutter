package com.assignment.ib.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.apache.tomcat.util.codec.binary.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.assignment.ib.exception.UrlCutterException;

/**
 * @author Tarun
 *
 */
public class UrlCutterUtility {

	private static final Character[] ELEMENTS = {
			'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o',
			'p','q','r','s','t','u','v','w','x','y','z','1','2','3','4',
			'5','6','7','8','9','0','A','B','C','D','E','F','G','H','I',
			'J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X',
			'Y','Z'
	};

	private static final long BASE = 62;

	public static String generateRandomPassword(){
		return RandomStringUtils.randomAlphanumeric(8);
	}

	public static ResponseEntity<String> exceptionResponseBuilder(UrlCutterException e){
		return new ResponseEntity<String>(e.getErrorMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}

	public static String encodeBase62(long number){
		long quotient = number / BASE;
		int remainder = (int)(number % BASE);
		if (quotient == 0){
			return ELEMENTS[remainder].toString();
		}
		else{
			return encodeBase62(quotient) + ELEMENTS[remainder];
		}            
	}

	public static long decodeBase10(String input){
		char [] inputArr = input.toCharArray();
		long output = 0l;
		int j = 0;
		for(int i = inputArr.length-1; i>=0; i--){
			int index = ArrayUtils.indexOf(ELEMENTS, inputArr[i]);
			output = (long) (output + index*Math.pow(BASE, j));
			j++;
		}
		return output;
	}

	public static String getAccountIdfromHeader(HttpServletRequest request){
		String hash = request.getHeader("Authorization").substring(6);
		String decodedHash = StringUtils.newStringUtf8(Base64.decodeBase64(hash));
		return decodedHash.split(":")[0];
	}
}
