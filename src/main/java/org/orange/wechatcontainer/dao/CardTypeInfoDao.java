package org.orange.wechatcontainer.dao;


import org.springframework.stereotype.Repository;
import org.orange.wechatcontainer.pojo.CardInfo;
import org.orange.wechatcontainer.pojo.CardTypeInfo;
import org.orange.wechatcontainer.pojo.TentantInfo;
import org.orange.wechatcontainer.pojo.TentantInfoQuery;
import org.orange.wechatcontainer.common.Page;
@Repository
public class CardTypeInfoDao extends BaseIbatis3Dao<CardTypeInfo,java.lang.String>{
	
	@Override
	public String getIbatisMapperNamesapce() {
		return "CardTypeInfo";
	}
}
