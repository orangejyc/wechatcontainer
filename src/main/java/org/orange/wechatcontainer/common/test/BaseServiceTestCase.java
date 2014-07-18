package org.orange.wechatcontainer.common.test;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;



@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
@TransactionConfiguration(defaultRollback = true) 
@Transactional

public class  BaseServiceTestCase  {
  
	@Autowired
    protected ApplicationContext applicationContext;  
   
    
    public <T> T getBean(Class<T> type) {
    	return applicationContext.getBean(type);
    	}
    	 
    	public Object getBean(String beanName) {
    	return applicationContext.getBean(beanName);
    	}
    	 
    	protected ApplicationContext getContext() {
    	return applicationContext;
    	}
  
    @Before  
    public void setUp() {  
    	
    }  
}  
