package com.magnet.action;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Scanner;

import com.magnet.pipeline.BtSoPipeline;
import com.magnet.processor.btsoprocessor.BtSoKeyWordsProcessor;

import us.codecraft.webmagic.Spider;

public class MagnetSearcherEntry {

	public static void main(String[] args) {
		System.out.println("what you want to search: ");
		Scanner scanner = new Scanner(System.in);
		String keyWords = scanner.nextLine();
		String site = "https://btso.pw/search/";
		StringBuilder sb = new StringBuilder(site);
		try {
			keyWords = URLEncoder.encode(keyWords, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		sb.append(keyWords);
		String url = sb.toString();
		System.out.println(url);
		
		Spider.create(new BtSoKeyWordsProcessor()).addPipeline(new BtSoPipeline()).addUrl(url).run();
		
	}
	
}
