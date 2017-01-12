package com.magnetsearcher.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProcessUtil {

	public static boolean needProcess = false;
	
	public static boolean resultNeedProcess(String keywords) {
		Pattern pattern = Pattern.compile("[a-zA-Z]+-\\d+");
		Matcher matcher = pattern.matcher(keywords);
		if(matcher.matches());
			needProcess = true;
		return needProcess;
	}
}
