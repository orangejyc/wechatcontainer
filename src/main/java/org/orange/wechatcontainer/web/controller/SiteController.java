/*
 * 用于前端展示站分发
 */
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
import org.springframework.web.servlet.ModelAndView;
import org.orange.wechatcontainer.pojo.CardInfo;
import org.orange.wechatcontainer.sdk.bean.EventMessage;
import org.orange.wechatcontainer.sdk.bean.xmlmessage.XMLTextMessage;
import org.orange.wechatcontainer.sdk.ext.RequestContext;
import org.orange.wechatcontainer.sdk.ext.RequestContextImpl;
import org.orange.wechatcontainer.sdk.ext.SignatureInfo;
import org.orange.wechatcontainer.sdk.util.SignatureUtil;
import org.orange.wechatcontainer.sdk.util.XMLConverUtil;
import org.orange.wechatcontainer.service.CardInfoService;
import org.orange.wechatcontainer.service.TentantInfoService;


@Controller
@RequestMapping("/site")
public class SiteController extends BaseSpringController{

	private static final String INDEX_PAGE="site/index";
	
	@Autowired
	private CardInfoService cardInfoService=null;
	
	
	public CardInfoService getCardInfoService() {
		return cardInfoService;
	}


	public void setCardInfoService(CardInfoService cardInfoService) {
		this.cardInfoService = cardInfoService;
	}


	@RequestMapping(value="/{cardId}"+SUFFIX_STRING,method=RequestMethod.GET)
	public ModelAndView showCard(@PathVariable String cardId){
		CardInfo card=(CardInfo)cardInfoService.getFullCardInfoById(cardId);
		ModelAndView mv=new ModelAndView(INDEX_PAGE);
		mv.addObject("cardinfo", card);
		return mv;
	}
	
	@RequestMapping(value="/index"+SUFFIX_STRING,method=RequestMethod.GET)
	public ModelAndView index(){
		ModelAndView mv=new ModelAndView(INDEX_PAGE);
		return mv;
	}
}