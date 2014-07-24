package org.orange.wechatcontainer.service.impl;

import org.orange.wechatcontainer.dao.EntityDao;
import org.orange.wechatcontainer.dao.hibernate4impl.CardTypeInfoDaoHImpl;
import org.orange.wechatcontainer.pojo.CardInfo;
import org.orange.wechatcontainer.pojo.CardTypeInfo;
import org.orange.wechatcontainer.service.BaseServiceImpl;
import org.orange.wechatcontainer.service.CardTypeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardTypeInfoServiceImpl extends BaseServiceImpl<CardTypeInfo, java.lang.String> implements CardTypeInfoService {
	
	@Autowired
	private CardTypeInfoDaoHImpl cardTypeInfoDao=null;
	
	@Override
	public EntityDao<CardTypeInfo,String>  getEntityDao() {
		return this.cardTypeInfoDao;
	}
	
	
}
