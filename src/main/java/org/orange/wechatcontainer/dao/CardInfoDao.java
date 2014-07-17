package org.orange.wechatcontainer.dao;


import org.springframework.stereotype.Repository;
import org.orange.wechatcontainer.pojo.CardInfo;
import org.orange.wechatcontainer.pojo.TentantInfo;
import org.orange.wechatcontainer.pojo.TentantInfoQuery;
import org.orange.wechatcontainer.common.Page;
@Repository
public class CardInfoDao extends BaseIbatis3Dao<CardInfo,java.lang.String>{
	
	@Override
	public String getIbatisMapperNamesapce() {
		return "CardInfo";
	}
	
	public void saveOrUpdate(CardInfo entity) {
		if(entity.getTentantid() == null) 
			save(entity);
		else 
			update(entity);
	}
}
