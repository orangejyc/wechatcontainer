package org.orange.wechatcontainer.service;

import org.orange.wechatcontainer.dao.CardInfoDao;
import org.orange.wechatcontainer.dao.CardTypeInfoDao;
import org.orange.wechatcontainer.dao.EntityDao;
import org.orange.wechatcontainer.pojo.CardInfo;
import org.orange.wechatcontainer.pojo.CardTypeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardTypeInfoServiceImpl extends BaseServiceImpl<CardTypeInfo, java.lang.String> implements CardTypeInfoService {
	
	@Autowired
	private CardTypeInfoDao cardTypeInfoDao=null;
	
	@Override
	public EntityDao<CardTypeInfo,String>  getEntityDao() {
		return this.cardTypeInfoDao;
	}
	
	
}
