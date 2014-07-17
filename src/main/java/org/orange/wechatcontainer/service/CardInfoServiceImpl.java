package org.orange.wechatcontainer.service;

import org.orange.wechatcontainer.dao.CardInfoDao;
import org.orange.wechatcontainer.dao.EntityDao;
import org.orange.wechatcontainer.pojo.CardInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardInfoServiceImpl extends BaseServiceImpl<CardInfo, java.lang.String> implements CardInfoService {
	
	@Autowired
	private CardInfoDao cardInfoDao=null;
	
	public EntityDao<CardInfo, java.lang.String> getEntityDao() {
		return this.cardInfoDao;
	}
	
	@Override 
	public CardInfo getFullCardInfoById(String cardid){
		CardInfo cardInfo=this.getById(cardid);
		if(null!=cardInfo){
			
		}
		return cardInfo;
	}
}
