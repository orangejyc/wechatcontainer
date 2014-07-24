package org.orange.wechatcontainer.service.impl;


import javax.script.ScriptException;

import org.orange.wechatcontainer.dao.EntityDao;
import org.orange.wechatcontainer.dao.hibernate4impl.TentantInfoDaoHImpl;
import org.orange.wechatcontainer.func.ScriptEngineer;
import org.orange.wechatcontainer.pojo.TentantInfo;
import org.orange.wechatcontainer.sdk.ext.MessageBuilder;
import org.orange.wechatcontainer.sdk.ext.RequestContext;
import org.orange.wechatcontainer.sdk.ext.ResponseContext;
import org.orange.wechatcontainer.sdk.ext.ResponseContextImpl;
import org.orange.wechatcontainer.sdk.ext.SignatureInfo;
import org.orange.wechatcontainer.sdk.util.SignatureUtil;
import org.orange.wechatcontainer.service.BaseServiceImpl;
import org.orange.wechatcontainer.service.TentantInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;

@Service
public class TentantInfoServiceImpl extends BaseServiceImpl<TentantInfo,String> implements TentantInfoService {

	@Autowired
	private TentantInfoDaoHImpl tentantInfoDao;

	/* (non-Javadoc)
	 * @see org.orange.wechatcontainer.service.TentantInfoService#getEntityDao()
	 */
	
	public EntityDao<TentantInfo,String> getEntityDao() {
		return this.tentantInfoDao;
	}
	
	@Override
	public boolean validate(SignatureInfo signatureInfo,String tentantid) {
		if(StringUtils.isEmpty(tentantid))
			return false;
		TentantInfo tentantInfo=tentantInfoDao.getById(tentantid);
		if(null!=tentantInfo){
			return validate(signatureInfo,tentantInfo);
		}
		return false;
	}
	
	@Override
	public boolean validate(SignatureInfo signatureInfo,TentantInfo tentantInfo) {
		// TODO Auto-generated method stub
		if(null!=signatureInfo&&null!=tentantInfo){
			//String token="123";
			if(!signatureInfo.getSignature().equals(SignatureUtil.generateEventMessageSignature(tentantInfo.getToken(),signatureInfo.getTimestamp(),signatureInfo.getNonce()))){
				//System.out.println("The request signature is invalid");
				return true;
			}
		}
		return false;
	}
	
	
	

	@Override
	public String handle(RequestContext requestContext) {
		
		TentantInfo tentantInfo=tentantInfoDao.getById(requestContext.getTentantId());
		if(null==tentantInfo)
			return "";
		
		if(!validate(requestContext.getSignatureInfo(),tentantInfo)){
			return "";
		}
		
		//验证是不是到期
	
		
		//如果是公用事件，该独立处理
		
		
		ResponseContext responseContext=new ResponseContextImpl();
		ScriptEngineer scriptEngineer=new ScriptEngineer();
		scriptEngineer.AddObject("RequestContext", requestContext);
		scriptEngineer.AddObject("ResponseContext", responseContext);
		scriptEngineer.AddObject("Log", this.log);
		scriptEngineer.AddObject("MessageBuilder", new MessageBuilder());
		scriptEngineer.AddObject("Out", System.out);
		try {
			requestContext.getEventMessage().getFromUserName();
			//StringBuilder sb=new StringBuilder();
			//sb.append("var me=RequestContext.getEventMessage();Out.println(RequestContext.getEventMessage().getFromUserName());");
			
			//sb.append("Out.println(me.getFromUserName());");
			//Object obj=scriptEngineer.Run(sb.toString());
			Object obj=scriptEngineer.Run(tentantInfo.getLogicscript());
			if(null!=obj){
				return obj.toString();
			}
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	
}
