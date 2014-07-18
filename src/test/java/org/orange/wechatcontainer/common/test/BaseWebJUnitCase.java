package org.orange.wechatcontainer.common.test;

import javax.activation.DataSource;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;


public  class BaseWebJUnitCase extends BaseJUnitCase{
	
	protected MockMvc mockMvc;  
	
	@Override
	@Before
	public void beforeTest(){
		WebApplicationContext wac=(WebApplicationContext)ac;
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();  
	}
	
}