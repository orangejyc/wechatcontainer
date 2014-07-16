package org.orange.wechatcontainer.sdk.ext;

import java.util.ArrayList;
import java.util.List;

import org.orange.wechatcontainer.sdk.bean.xmlmessage.XMLImageMessage;
import org.orange.wechatcontainer.sdk.bean.xmlmessage.XMLMusicMessage;
import org.orange.wechatcontainer.sdk.bean.xmlmessage.XMLNewsMessage;
import org.orange.wechatcontainer.sdk.bean.xmlmessage.XMLTextMessage;
import org.orange.wechatcontainer.sdk.bean.xmlmessage.XMLVideoMessage;
import org.orange.wechatcontainer.sdk.bean.xmlmessage.XMLVoiceMessage;
import org.orange.wechatcontainer.sdk.bean.xmlmessage.XMLNewsMessage.Article;

public  class MessageBuilder {
	public XMLImageMessage createXMLImageMessage(String toUserName, String fromUserName, String mediaId){
		return new XMLImageMessage(toUserName, fromUserName, mediaId);
	}
	
	public XMLMusicMessage createXMLMusicMessage(String toUserName, String fromUserName,
			String title,String description,String musicUrl,String hQMusicUrl,String thumbMediaId){
		return new XMLMusicMessage(toUserName, fromUserName,
				title,description,musicUrl,hQMusicUrl,thumbMediaId);
	}
	public XMLNewsMessage createXMLNewsMessage(String toUserName, String fromUserName,List<Article> articles){
		return new XMLNewsMessage(toUserName, fromUserName, articles);
	}
	public XMLTextMessage createXMLTextMessage(String toUserName, String fromUserName, String mediaId){
		return new XMLTextMessage(toUserName, fromUserName, mediaId);
	}
	public XMLVideoMessage createXMLVideoMessage(String toUserName, String fromUserName,String mediaId,String title,String description){
		return new XMLVideoMessage(toUserName, fromUserName, mediaId,title,description);
	}
	
	public XMLVoiceMessage createXMLVoiceMessage(String toUserName, String fromUserName, String mediaId){
		return new XMLVoiceMessage(toUserName, fromUserName, mediaId);
	}
}
