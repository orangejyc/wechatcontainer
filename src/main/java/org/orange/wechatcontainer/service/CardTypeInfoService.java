package org.orange.wechatcontainer.service;

import java.io.Serializable;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.orange.wechatcontainer.common.Page;
import org.orange.wechatcontainer.pojo.CardInfo;
import org.orange.wechatcontainer.pojo.CardTypeInfo;
import org.orange.wechatcontainer.pojo.TentantInfo;
import org.orange.wechatcontainer.sdk.ext.RequestContext;
import org.orange.wechatcontainer.sdk.ext.SignatureInfo;

public interface CardTypeInfoService extends BaseService<CardTypeInfo,java.lang.String> {
	
}