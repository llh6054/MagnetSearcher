package com.magnet.processor.btsoprocessor;

import java.util.List;
import java.util.Objects;


import com.magnet.website.siteconst.SiteConst;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

public class BtSoKeyWordsProcessor implements PageProcessor {

    private static final String TARGET = SiteConst.BTSO_WEBSITE + SiteConst.SLASH + "magnet/detail/hash/";

    private Site site = Site.me()
            .setUserAgent("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:49.0) Gecko/20100101 Firefox/49.0")
            .addCookie("Cookie", "_ga=GA1.2.1046523038.1609516447; AD_adst_b_M_300x50=0; _gid=GA1.2.1254224185.1611405697; __test; __PPU___PPU_SESSION_URL=%2F; __PPU_SESSION_1_470916=1611405701159|1|1611405701159|1|1; AD_clic_b_POPUNDER=2; AD_adst_b_POPUNDER=2; AD_popa_b_POPUNDER=1; AD_popc_b_POPUNDER=1; popcashpu=1; AD_adma_b_POPUNDER=2; AD_enterTime=1611411857; AD_jav_b_SM_T_728x90=0; AD_javu_b_SM_T_728x90=0; AD_jav_b_SM_B_728x90=7; AD_juic_b_SM_T_728x90=2; AD_javu_b_SM_B_728x90=6")
            .addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
            .addHeader("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3")
            .addHeader("Accept-Encoding", " gzip, deflate, br")
            .addHeader("Upgrade-Insecure-Requests", "1")
            .addHeader(":method", "GET")
            .addHeader(":path", "/search/SWAG")
            .addHeader("If-Modified-Since", "Sat, 23 Jan 2021 12:50:04 GMT")
            .addHeader(":authority", "btsow.cam")
            .addHeader(":scheme", "https")
            .setRetryTimes(10);

    @Override
    public void process(Page page) {
        List<String> targetUrls = page.getHtml().links().regex(TARGET + "\\S+").all();
        List<String> pageUrls = page.getHtml().links().regex(SiteConst.BTSO_WEBSITE_SEARCH + "\\S+/page/[0-9]+").all();
        page.addTargetRequests(pageUrls);
        page.addTargetRequests(targetUrls);

        String magnet = page.getHtml().$("#magnetLink").regex("magnet:\\?[^<]+").toString();
        if (Objects.nonNull(magnet)) {
            page.putField(SiteConst.TARGET_LINK_KEY, magnet);
        }
    }

    @Override
    public Site getSite() {
        return site;
    }


}
