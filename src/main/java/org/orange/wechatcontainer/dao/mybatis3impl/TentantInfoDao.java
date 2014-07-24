package org.orange.wechatcontainer.dao.mybatis3impl;


import org.springframework.stereotype.Repository;
import org.orange.wechatcontainer.pojo.TentantInfo;
import org.orange.wechatcontainer.pojo.TentantInfoQuery;
import org.orange.wechatcontainer.common.Page;
import org.orange.wechatcontainer.dao.mybatis3impl.BaseIbatis3Dao;
@Repository
public class TentantInfoDao extends BaseIbatis3Dao<TentantInfo,java.lang.String>{
	
	@Override
	public String getIbatisMapperNamesapce() {
		return "TentantInfo";
	}
}
