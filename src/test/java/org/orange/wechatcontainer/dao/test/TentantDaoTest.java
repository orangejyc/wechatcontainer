package org.orange.wechatcontainer.dao.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;



import org.orange.wechatcontainer.common.test.BaseDaoJUnitCase;
import org.orange.wechatcontainer.dao.TentantInfoDao;
import org.orange.wechatcontainer.pojo.TentantInfo;
import org.orange.wechatcontainer.service.TentantInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;


public class TentantDaoTest extends BaseDaoJUnitCase{
	 @Autowired  
	 private TentantInfoDao tentantInfoDao;  
	  
	  
	 @Test  
	 public void test() {  
		 TentantInfo tentantInfo = new TentantInfo();  
		 tentantInfo=tentantInfoDao.getById("123");
	    }  
}
