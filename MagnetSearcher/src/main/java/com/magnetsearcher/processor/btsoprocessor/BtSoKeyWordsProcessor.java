package com.magnetsearcher.processor.btsoprocessor;

import java.text.Collator;
import java.util.List;
import com.magnetsearcher.pipeline.BtSoPipeline;
import com.magnetsearcher.util.ProcessUtil;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

public class BtSoKeyWordsProcessor implements PageProcessor {

	private static boolean taskFinished = false;
	
	public static boolean isTaskFinished() {
		return taskFinished;
	}


	public static void setTaskFinished(boolean taskFinished) {
		BtSoKeyWordsProcessor.taskFinished = taskFinished;
	}


	private Site site = Site.me()
    		.setUserAgent("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:49.0) Gecko/20100101 Firefox/49.0")
    		.addHeader("Host"," btso.pw").addCookie("Cookie", "_ga=GA1.2.885174110.1475816482; __PPU_SESSION_1_470916_false=1481096488208|1|1481096488208|1|1; AD_enterTime=1481096461; AD_adst_b_M_300x50=0; AD_exoc_b_M_300x50=0; AD_jav_b_M_300x50=0; AD_javu_b_M_300x50=0; AD_wav_b_M_300x50=0; AD_wwwp_b_M_300x50=0; AD_clic_b_POPUNDER=2; AD_adst_b_SM_T_728x90=1; AD_popa_b_POPUNDER=1; _gat=1")
    		.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
    		.addHeader("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3")
    		.addHeader("Accept-Encoding", " gzip, deflate, br")
    		.addHeader("Upgrade-Insecure-Requests", "1")
    		.addHeader("Connection", "keep-alive")
    		.addHeader("If-Modified-Since", "Thu, 20 Oct 2016 03:12:06 GMT")
    		.setRetryTimes(10);
	
	@Override
	public void process(Page page) {
		List<String> targetUrls = page.getHtml().links().regex("https://btso.pw/magnet/detail/hash/\\S+").all();
		
		if(ProcessUtil.needProcess) {
			List<String> sizes = page.getHtml().regex("[0-9]+\\.[0-9]+GB").regex("[0-9]+\\.[0-9]+").all();
			if(sizes.isEmpty())
				sizes = page.getHtml().regex("[0-9]+\\.[0-9]+MB").regex("[0-9]+\\.[0-9]+").all();
			Collator callator = Collator.getInstance();
			sizes.sort(callator);
			int index = sizes.size() - 1;
			for (int i = 0; i < sizes.size() - 1; i++) {
				Spider.create(new BtSoTargetMagnetProcessor()).addUrl(targetUrls.get(index)).addPipeline(new BtSoPipeline()).run();
				if(taskFinished)
					break;
				index--;
			}
		}else {
			List<String> pageUrls = page.getHtml().links().regex("https://btso.pw/search/\\S+/page/[0-9]+").all();
			page.addTargetRequests(pageUrls);
			for (String targetUrl : targetUrls) {
				Spider.create(new BtSoTargetMagnetProcessor()).addUrl(targetUrl).addPipeline(new BtSoPipeline()).run();
			}
		}
	}
	

	@Override
	public Site getSite() {
		return site;
	}

	
}
