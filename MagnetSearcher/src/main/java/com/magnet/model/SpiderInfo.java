package com.magnet.model;

/**
 * 
 * @author chubby
 * @version 2018/07/11
 */
public class SpiderInfo {

	private String userAgent = "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:49.0) Gecko/20100101 Firefox/49.0";

	/**
	 * Retry times if failure occurs
	 */
	private Integer retryTimes = 2;

	/**
	 * Max connect time out
	 */
	private Integer timeOut = 5000;

	/**
	 * Thread number to crawl
	 */
	private Integer threadNum = 1;

	/**
	 * Sleep time after one page has been processed
	 */
	private Integer sleepTime = 0;

	/**
	 * Max gather page, 0 means no limited
	 */
	private Integer maxGatherPage = 0;

	/**
	 * Name of the site to crawl
	 */
	private String siteName;

	/**
	 * Domain of the site to crawl
	 */
	private String domain;

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public Integer getRetryTimes() {
		return retryTimes;
	}

	public void setRetryTimes(Integer retryTimes) {
		this.retryTimes = retryTimes;
	}

	public Integer getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(Integer timeOut) {
		this.timeOut = timeOut;
	}

	public Integer getThreadNum() {
		return threadNum;
	}

	public void setThreadNum(Integer threadNum) {
		this.threadNum = threadNum;
	}

	public Integer getSleepTime() {
		return sleepTime;
	}

	public void setSleepTime(Integer sleepTime) {
		this.sleepTime = sleepTime;
	}

	public Integer getMaxGatherPage() {
		return maxGatherPage;
	}

	public void setMaxGatherPage(Integer maxGatherPage) {
		this.maxGatherPage = maxGatherPage;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	
}
