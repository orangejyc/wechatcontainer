package org.orange.wechatcontainer.service;

import org.orange.wechatcontainer.dao.CardInfoDao;
import org.orange.wechatcontainer.dao.CardTypeInfoDao;
import org.orange.wechatcontainer.dao.EntityDao;
import org.orange.wechatcontainer.dao.GuestInfoDao;
import org.orange.wechatcontainer.dao.TentantInfoDao;
import org.orange.wechatcontainer.pojo.CardInfo;
import org.orange.wechatcontainer.pojo.CardTypeInfo;
import org.orange.wechatcontainer.pojo.GuestInfo;
import org.orange.wechatcontainer.pojo.TentantInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardInfoServiceImpl extends BaseServiceImpl<CardInfo, java.lang.String> implements CardInfoService {
	
	@Autowired
	private CardInfoDao cardInfoDao=null;
	@Autowired
	private CardTypeInfoDao cardTypeInfoDao=null;
	@Autowired
	private GuestInfoDao guestInfoDao=null;
	@Autowired
	private TentantInfoDao tentantInfoDao=null;
	
	public EntityDao<CardInfo, java.lang.String> getEntityDao() {
		return this.cardInfoDao;
	}
	
	@Override 
	public CardInfo getFullCardInfoById(String cardid){
		CardInfo cardInfo=this.getById(cardid);
		if(null!=cardInfo){
			CardTypeInfo cardType=cardTypeInfoDao.getById(cardInfo.getCardid());
			cardInfo.setCardtypeinfo(cardType);
			GuestInfo guest=guestInfoDao.getById(cardInfo.getGuestid());
			cardInfo.setGuestinfo(guest);
			TentantInfo tentant=tentantInfoDao.getById(cardInfo.getTentantid());
			if(null!=tentant){
				//构造modulelist
			}
			
			cardInfo.setTentantinfo(tentant);
		}
		return cardInfo;
	}
}
