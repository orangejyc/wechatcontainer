package org.orange.wechatcontainer.service;

import org.springframework.stereotype.Service;
import org.orange.wechatcontainer.common.Page;
import org.orange.wechatcontainer.pojo.TentantInfo;

import org.orange.wechatcontainer.sdk.ext.RequestContext;
import org.orange.wechatcontainer.sdk.ext.SignatureInfo;

public interface TentantInfoService extends BaseService {
	
	public boolean validate(SignatureInfo signatureInfo,TentantInfo tentantInfo);
	
	public boolean validate(SignatureInfo signatureInfo,String tentantid);
		
	public String handle(RequestContext requestContext);
}