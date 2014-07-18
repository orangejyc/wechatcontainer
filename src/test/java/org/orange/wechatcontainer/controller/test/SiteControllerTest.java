package org.orange.wechatcontainer.controller.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;



import org.orange.wechatcontainer.common.test.BaseDaoJUnitCase;
import org.orange.wechatcontainer.common.test.BaseWebJUnitCase;
import org.orange.wechatcontainer.dao.TentantInfoDao;
import org.orange.wechatcontainer.pojo.TentantInfo;
import org.orange.wechatcontainer.service.TentantInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

//static import org.springframework.test.web.servlet.MvcResult;
//static import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//static import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//static import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


public class SiteControllerTest extends BaseWebJUnitCase{
	
	  
	 @Test  
	 public void testView() throws Exception {  
	    mockMvc.perform(MockMvcRequestBuilders.get("/site/index.jtml"))  ;
	             //.andExpect(MockMvcResultMatchers.view().name("site/index"))  
	             //.andExpect(MockMvcResultMatchers.model().attributeExists("user"))  
	            // .andDo(MockMvcResultHandlers.print()); 
	 }  
}
