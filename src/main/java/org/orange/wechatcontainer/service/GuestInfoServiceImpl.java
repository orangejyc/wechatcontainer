package org.orange.wechatcontainer.service;

import org.orange.wechatcontainer.dao.CardInfoDao;
import org.orange.wechatcontainer.dao.CardTypeInfoDao;
import org.orange.wechatcontainer.dao.EntityDao;
import org.orange.wechatcontainer.dao.GuestInfoDao;
import org.orange.wechatcontainer.pojo.CardInfo;
import org.orange.wechatcontainer.pojo.CardTypeInfo;
import org.orange.wechatcontainer.pojo.GuestInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuestInfoServiceImpl extends BaseServiceImpl<GuestInfo, java.lang.String> implements GuestInfoService {
	
	@Autowired
	private GuestInfoDao guestInfoDao=null;
	
	@Override
	public EntityDao<GuestInfo,String>  getEntityDao() {
		return this.guestInfoDao;
	}
	
	
}
