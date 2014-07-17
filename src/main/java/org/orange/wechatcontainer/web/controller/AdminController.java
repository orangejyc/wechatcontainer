/*
 * 用户微会员商家管理端分发
 */

package org.orange.wechatcontainer.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.orange.wechatcontainer.pojo.CardInfo;
import org.orange.wechatcontainer.service.CardInfoService;


/**
 * 
 * @author orange
 *
 */
@Controller
@RequestMapping("/admin")
public class AdminController extends BaseSpringController{

	private static final String CARD_INFO_PAGE="admin/index";
	
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
		ModelAndView mv=new ModelAndView(CARD_INFO_PAGE);
		mv.addObject("cardinfo", card);
		return mv;
	}
}