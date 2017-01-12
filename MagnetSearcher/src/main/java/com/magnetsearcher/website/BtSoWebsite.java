package com.magnetsearcher.website;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import com.magnetsearcher.pipeline.BtSoPipeline;
import com.magnetsearcher.processor.btsoprocessor.BtSoKeyWordsProcessor;

import us.codecraft.webmagic.Spider;

public class BtSoWebsite implements Website{

	private String website = "https://btso.pw/search/";
	private String url;
	
	public BtSoWebsite(String keyWords) {
		StringBuilder sb = new StringBuilder(website);
		try {
			keyWords = URLEncoder.encode(keyWords, "UTF-8");
			System.out.println(keyWords);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		sb.append(keyWords);
		url = sb.toString();
	}
	
	@Override
	public void search() {
		Spider.create(new BtSoKeyWordsProcessor()).addPipeline(new BtSoPipeline()).addUrl(url).run();
	}


}
