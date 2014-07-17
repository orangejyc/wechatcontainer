package org.orange.wechatcontainer.dao;


import org.springframework.stereotype.Repository;
import org.orange.wechatcontainer.pojo.TentantInfo;
import org.orange.wechatcontainer.pojo.TentantInfoQuery;
import org.orange.wechatcontainer.common.Page;
@Repository
public class TentantInfoDao extends BaseIbatis3Dao<TentantInfo,java.lang.String>{
	
	@Override
	public String getIbatisMapperNamesapce() {
		return "TentantInfo";
	}
}
