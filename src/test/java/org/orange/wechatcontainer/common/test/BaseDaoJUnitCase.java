package org.orange.wechatcontainer.common.test;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;


/*import javax.annotation.Resource;  
import javax.sql.DataSource;    

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;  
import org.springframework.test.context.ContextConfiguration;  
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;  
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;  
*//** 
 * <b>Summary: </b> TODO Junit   
 * <b>Remarks: </b> TODO DAO 
 *//*
@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})  
public  class BaseDaoJUnitCase extends AbstractTransactionalJUnit4SpringContextTests {  
  
    *//** 
     * <b>Summary: </b> Override method setDataSource 
     *  
     * @param dataSource 
     * @see org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests#setDataSource(javax.sql.DataSource) 
     *//*  
    @Override  
    @Resource(name = "dataSource")  
    public void setDataSource(DataSource dataSource) {  
        // TODO Auto-generated method stub  
        super.setDataSource(dataSource);  
    }  
    
    
    @Before
    public void before(){
    	
    }
    
    @Test
    public void baseDaoTest(){
    	
    }
}  */


public  class BaseDaoJUnitCase extends BaseJUnitCase {
	
		@Autowired
		protected DataSource dataSource;
}
