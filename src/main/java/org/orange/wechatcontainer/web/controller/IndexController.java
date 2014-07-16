package org.orange.wechatcontainer.web.controller;


import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.orange.wechatcontainer.sdk.bean.EventMessage;
import org.orange.wechatcontainer.sdk.bean.xmlmessage.XMLTextMessage;
import org.orange.wechatcontainer.sdk.ext.RequestContext;
import org.orange.wechatcontainer.sdk.ext.RequestContextImpl;
import org.orange.wechatcontainer.sdk.ext.SignatureInfo;
import org.orange.wechatcontainer.sdk.util.SignatureUtil;
import org.orange.wechatcontainer.sdk.util.XMLConverUtil;
import org.orange.wechatcontainer.service.TentantInfoService;


@Controller
@RequestMapping("/index")
public class IndexController extends BaseSpringController{
	
	
	public TentantInfoService getTentantInfoService() {
		return tentantInfoService;
	}

	public void setTentantInfoService(TentantInfoService tentantInfoService) {
		this.tentantInfoService = tentantInfoService;
	}

	@Autowired
	private TentantInfoService tentantInfoService;
	
	public IndexController() {
	}
	
	@RequestMapping(value="/{tentantId}",method=RequestMethod.GET)
	public @ResponseBody String validate(@PathVariable String tentantId,
			@RequestParam("signature") String signature,
			@RequestParam("timestamp") String timestamp,
			@RequestParam("nonce") String nonce,
			@RequestParam("echostr") String echostr
			) throws Exception {
		//第一次注册后用于微信的验证
		/*在开发者首次提交验证申请时，微信服务器将发送GET请求到填写的URL上，
		 * 并且带上四个参数（signature、timestamp、nonce、echostr），
		 * 开发者通过对签名（即signature）的效验，来判断此条消息的真实性。
		 */
		
		logger.debug("signature:"+signature);
		logger.debug("timestamp:"+timestamp);
		logger.debug("nonce:"+nonce);
		logger.debug("echostr:"+echostr);
		
		SignatureInfo signatureInfo=new SignatureInfo();
		signatureInfo.setSignature(signature);
		signatureInfo.setTimestamp(timestamp);
		signatureInfo.setNonce(nonce);
		if(tentantInfoService.validate(signatureInfo,tentantId)){
			return echostr;
		}else{
			return "";
		}
	}
	
	@RequestMapping(value="/{tentantId}",method=RequestMethod.POST)
	public @ResponseBody String index(@PathVariable String tentantId,
			@RequestParam("signature") String signature,
			@RequestParam("timestamp") String timestamp,
			@RequestParam("nonce") String nonce,
			@RequestBody  String xml) throws Exception {
		try{	
			logger.debug("signature:"+signature);
			logger.debug("timestamp:"+timestamp);
			logger.debug("nonce:"+nonce);
			logger.debug("xml:"+xml);
			
			
			
			xml=xml.substring(xml.lastIndexOf("&")+1);
			logger.debug("xml1:"+xml);
			
			xml="<xml>"+
 "<ToUserName><![CDATA[toUser]]></ToUserName>"+
 "<FromUserName><![CDATA[fromUser]]></FromUserName> "+
 "<CreateTime>1348831860</CreateTime>"+
 "<MsgType><![CDATA[text]]></MsgType>"+
 "<Content><![CDATA[this is a test]]></Content>"+
 "<MsgId>1234567890123456</MsgId>"+
"</xml>";
			//这里处理公众号相关的操作
			RequestContext requestContext=new RequestContextImpl();
			requestContext.setTentantId(tentantId);
			//构造验证对象
			
			 //每次开发者接收用户消息的时候，微信也都会带上前面三个参数（signature、timestamp、nonce）
			 //访问开发者设置的URL，开发者依然通过对签名的效验判断此条消息的真实性。效验方式与首次提交验证申请一致。
			 
			SignatureInfo signatureInfo=new SignatureInfo();
			signatureInfo.setSignature(signature);
			signatureInfo.setTimestamp(timestamp);
			signatureInfo.setNonce(nonce);
			requestContext.setSignatureInfo(signatureInfo);
			//构造接收消息对象
			EventMessage eventMessage = XMLConverUtil.convertToObject(EventMessage.class,xml);
			requestContext.setEventMessage(eventMessage);
			//容器service调用脚本处理返回结果 
			return tentantInfoService.handle(requestContext);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return "";
	}
	
	
	/*
	@RequestMapping(value="/{tentantId}",method=RequestMethod.POST)
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    ServletInputStream inputStream = request.getInputStream();
	    ServletOutputStream outputStream = response.getOutputStream();
	    String signature = request.getParameter("signature");
	    String timestamp = request.getParameter("timestamp");
	    String nonce = request.getParameter("nonce");
	    String echostr = request.getParameter("echostr");

	    //首次请求申请验证,返回echostr
	    
	    if(echostr!=null){
	        outputStreamWrite(outputStream,echostr);
	        return;
	    }

	    //验证请求签名
	    if(!signature.equals(SignatureUtil.generateEventMessageSignature(token,timestamp,nonce))){
	        System.out.println("The request signature is invalid");
	        return;
	    }

	    if(inputStream!=null){
	        String xml = StreamUtils.copyToString(inputStream,Charset.forName("utf-8"));
	        System.out.println("xml: "+xml);
	        //转换XML
	        EventMessage eventMessage = XMLConverUtil.convertToObject(EventMessage.class,xml);
	        //创建回复
	        XMLTextMessage xmlTextMessage = new XMLTextMessage(
	                eventMessage.getFromUserName(), 
	                eventMessage.getToUserName(),
	                "你好");
	        //回复
	        xmlTextMessage.outputStreamWrite(outputStream);
	        return;
	    }
	    outputStreamWrite(outputStream,"");
	}*/
	/**
	 * 数据流输出
	 * @param outputStream
	 * @param text
	 * @return
	 */
	/*private boolean outputStreamWrite(OutputStream outputStream,String text){
	    try {
	        outputStream.write(text.getBytes("utf-8"));
	    } catch (UnsupportedEncodingException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	        return false;
	    } catch (IOException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	        return false;
	    }
	    return true;
	}*/
	
	public static void main(String[] args){
		String xml="<xml>"+
				 "<ToUserName><![CDATA[toUser]]></ToUserName>"+
				 "<FromUserName><![CDATA[fromUser]]></FromUserName> "+
				 "<CreateTime>1348831860</CreateTime>"+
				 "<MsgType><![CDATA[text]]></MsgType>"+
				 "<Content><![CDATA[this is a test]]></Content>"+
				 "<MsgId>1234567890123456</MsgId>"+
				"</xml>";
		
		xml=xml.substring(xml.lastIndexOf("&")+1);
		xml=xml.substring(xml.lastIndexOf("&")+1);
	}
	
	
	
	
}