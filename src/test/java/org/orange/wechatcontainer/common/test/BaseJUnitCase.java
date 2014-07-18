package org.orange.wechatcontainer.common.test;



import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;






@RunWith(SpringJUnit4ClassRunner.class)  
@WebAppConfiguration(value = "src/main/webapp")  
@TransactionConfiguration(defaultRollback=true)
@Transactional
@ContextHierarchy({  
    @ContextConfiguration(name = "parent", locations = "classpath:applicationContext.xml"),  
    @ContextConfiguration(name = "child", locations = "classpath:springmvc-servlet.xml") 
   // @ContextConfiguration(name = "child", locations = "file:src/main/webapp/WEB-INF/spring-mvc.xml")  
}) 

public  class BaseJUnitCase {
		
	@Autowired  
    protected ApplicationContext ac;  
	
	@Before
	public void beforeTest(){
		
	}
	
	@Test
	public void baseTest(){
		
	}
}