package org.orange.wechatcontainer.test.controller;

import org.junit.Assert;
import org.junit.Test;
import org.orange.wechatcontainer.test.common.BaseWebTestCase;
import org.springframework.test.web.servlet.MvcResult;
import  org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import  org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

public class SiteControllerTests extends BaseWebTestCase {
	
	@Test
	public void test() throws Exception{
		//MvcResult result = (MvcResult) mockMvc.perform(MockMvcRequestBuilders.get("/site/1.jtml"))  
	            //.andExpect(MockMvcResultMatchers.view().name("user/view"))  
	            //.andExpect(MockMvcResultMatchers.model().attributeExists("user"))  
				///.andExpect(MockMvcResultMatchers.status().isOk())//验证状态码  
		        //.andDo(MockMvcResultHandlers.print()); //输出MvcResult到控制台  
		
		// mockMvc.perform(MockMvcRequestBuilders.get("/site/index"))  
	            //.andExpect(MockMvcResultMatchers.view().name("user/view"))  
	            //.andExpect(MockMvcResultMatchers.model().attributeExists("user"))  
				//.andExpect(MockMvcResultMatchers.status().isOk())//验证状态码  
		       // .andDo(MockMvcResultHandlers.print()); //输出MvcResult到控制台  
	      
	    //Assert.assertNotNull(result.);  
		
		
		/*mockMvc.perform(MockMvcRequestBuilders.get("/site/index.jtml"))  
		.andExpect(MockMvcResultMatchers.view().name("site/index")) //验证viewName  
        .andExpect(MockMvcResultMatchers.forwardedUrl("/WEB-INF/jsp/site/index.jsp"))//验证视图渲染时forward到的jsp  
        .andExpect(MockMvcResultMatchers.status().isOk())//验证状态码  
        .andDo(MockMvcResultHandlers.print()); //输出MvcResult到控制台  
*/	}

}
