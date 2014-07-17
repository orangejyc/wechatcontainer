package org.orange.wechatcontainer.dao;


import org.springframework.stereotype.Repository;
import org.orange.wechatcontainer.pojo.CardInfo;
import org.orange.wechatcontainer.pojo.CardTypeInfo;
import org.orange.wechatcontainer.pojo.GuestInfo;
import org.orange.wechatcontainer.pojo.TentantInfo;
import org.orange.wechatcontainer.pojo.TentantInfoQuery;
import org.orange.wechatcontainer.common.Page;
@Repository
public class GuestInfoDao extends BaseIbatis3Dao<GuestInfo,java.lang.String>{
	
	@Override
	public String getIbatisMapperNamesapce() {
		return "GuestInfo";
	}
}
