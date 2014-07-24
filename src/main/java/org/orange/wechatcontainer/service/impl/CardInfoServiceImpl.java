package org.orange.wechatcontainer.service.impl;

import java.util.List;

import org.orange.wechatcontainer.dao.EntityDao;
import org.orange.wechatcontainer.dao.hibernate4impl.CardInfoDaoHImpl;
import org.orange.wechatcontainer.dao.hibernate4impl.CardTypeInfoDaoHImpl;
import org.orange.wechatcontainer.dao.hibernate4impl.GuestInfoDaoHImpl;
import org.orange.wechatcontainer.dao.hibernate4impl.ModuleInfoDaoHImpl;
import org.orange.wechatcontainer.dao.hibernate4impl.TentantInfoDaoHImpl;
import org.orange.wechatcontainer.pojo.CardInfo;
import org.orange.wechatcontainer.pojo.CardTypeInfo;
import org.orange.wechatcontainer.pojo.GuestInfo;
import org.orange.wechatcontainer.pojo.ModuleInfo;
import org.orange.wechatcontainer.pojo.TentantInfo;
import org.orange.wechatcontainer.service.BaseServiceImpl;
import org.orange.wechatcontainer.service.CardInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardInfoServiceImpl extends BaseServiceImpl<CardInfo, java.lang.String> implements CardInfoService {
	
	@Autowired
	private CardInfoDaoHImpl cardInfoDao=null;
	@Autowired
	private CardTypeInfoDaoHImpl cardTypeInfoDao=null;
	@Autowired
	private GuestInfoDaoHImpl guestInfoDao=null;
	@Autowired
	private TentantInfoDaoHImpl tentantInfoDao=null;
	@Autowired
	private ModuleInfoDaoHImpl moduleInfoDao=null;
	
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
				cardInfo.setTentantinfo(tentant);
				//构造modulelist
				List<ModuleInfo> modules=moduleInfoDao.getModuleListByTentant(tentant);
				cardInfo.setModules(modules);
			}
		}
		return cardInfo;
	}
}
