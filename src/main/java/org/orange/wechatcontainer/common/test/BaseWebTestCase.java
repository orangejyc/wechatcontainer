package org.orange.wechatcontainer.common.test;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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
@WebAppConfiguration(value = "src/main/webapp")  
@TransactionConfiguration(defaultRollback = true) 
@Transactional
@ContextHierarchy({  
        @ContextConfiguration(name = "parent", locations = "classpath:applicationContext.xml"),  
        @ContextConfiguration(name = "child", locations = "classpath:springmvc-servlet.xml")  
})  
//public class  BaseTestCase extends AbstractTransactionalJUnit4SpringContextTests  {
public class  BaseWebTestCase  {
  
    @Autowired  
    protected WebApplicationContext wac;  
    protected MockMvc mockMvc;  
  
    @Before  
    public void setUp() {  
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();  
    }  
}  
