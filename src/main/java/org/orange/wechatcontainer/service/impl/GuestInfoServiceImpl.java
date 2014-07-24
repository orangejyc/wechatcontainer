package org.orange.wechatcontainer.service.impl;

import org.orange.wechatcontainer.dao.EntityDao;
import org.orange.wechatcontainer.dao.hibernate4impl.GuestInfoDaoHImpl;
import org.orange.wechatcontainer.pojo.CardInfo;
import org.orange.wechatcontainer.pojo.CardTypeInfo;
import org.orange.wechatcontainer.pojo.GuestInfo;
import org.orange.wechatcontainer.service.BaseServiceImpl;
import org.orange.wechatcontainer.service.GuestInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuestInfoServiceImpl extends BaseServiceImpl<GuestInfo, java.lang.String> implements GuestInfoService {
	
	@Autowired
	private GuestInfoDaoHImpl guestInfoDao=null;
	
	@Override
	public EntityDao<GuestInfo,String>  getEntityDao() {
		return this.guestInfoDao;
	}
	
	
}
