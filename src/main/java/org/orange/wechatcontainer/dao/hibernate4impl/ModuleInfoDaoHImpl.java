package org.orange.wechatcontainer.dao.hibernate4impl;


import java.util.List;

import org.springframework.stereotype.Repository;
import org.orange.wechatcontainer.pojo.CardInfo;
import org.orange.wechatcontainer.pojo.ModuleInfo;
import org.orange.wechatcontainer.pojo.TentantInfo;
import org.orange.wechatcontainer.pojo.TentantInfoQuery;
import org.orange.wechatcontainer.common.Page;
import org.orange.wechatcontainer.dao.mybatis3impl.BaseIbatis3Dao;
@Repository
public class ModuleInfoDaoHImpl extends BaseHibernate4Dao<ModuleInfo,java.lang.String>{
	
	public List<ModuleInfo> getModuleListByTentant(TentantInfo tentantInfo){
		String tentantId="";
		//return this.getSqlSessionTemplate().selectList("", tentantId);
		return null;
	}
}
