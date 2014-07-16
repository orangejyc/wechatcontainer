package org.orange.wechatcontainer.sdk.api;

import org.springframework.web.client.RestTemplate;

import org.orange.wechatcontainer.sdk.client.RestTemplateClient;

public abstract class BaseAPI {
	protected static final String BASE_URI = "https://api.weixin.qq.com";
	protected static final String MEDIA_URI = "http://file.api.weixin.qq.com";
	protected static final String QRCODE_DOWNLOAD_URI = "https://mp.weixin.qq.com";
	

	protected RestTemplate restTemplate = RestTemplateClient.restTemplate();
  	
}
