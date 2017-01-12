package com.magnetsearcher.util;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import us.codecraft.webmagic.Page;

public class ProcessUtil {

	public static boolean needProcess = false;
	
	public static boolean resultNeedProcess(String keywords) {
		Pattern pattern = Pattern.compile("[a-zA-Z]+-\\d+");
		Matcher matcher = pattern.matcher(keywords);
		if(matcher.matches());
			needProcess = true;
		return needProcess;
	}
	
	public static boolean notISO(Page page) {
	  List<String> magnets = page.getHtml().regex("\\.iso").all();
	  return magnets.isEmpty();
	}
}
