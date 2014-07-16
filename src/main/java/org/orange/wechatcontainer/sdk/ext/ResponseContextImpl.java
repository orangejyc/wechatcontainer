package org.orange.wechatcontainer.sdk.ext;


import org.orange.wechatcontainer.sdk.bean.xmlmessage.XMLMessage;


public class ResponseContextImpl extends ResponseContext {

	private String messgeType="text";
	
	private XMLMessage message=null;
	
	@Override
	public String buildResultString() {
		// TODO Auto-generated method stub
		/*
		switch(messgeType){
			case "text":{
				break;
			}
			default:{
				return "";

			}
		}*/
		if(null!=message)
			return message.toXML();
		else
			return "";
	}

	@Override
	public void setMessageType(String messgeType) {
		// TODO Auto-generated method stub
		this.messgeType=messgeType;
	}

	public XMLMessage getMessage() {
		return message;
	}

	public void setMessage(XMLMessage message) {
		this.message = message;
	}

}
