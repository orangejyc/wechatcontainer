package org.orange.wechatcontainer.sdk.ext.handler;

import org.orange.wechatcontainer.sdk.bean.EventMessage;

public abstract class BaseMessageHandler implements MessageHandler {
	
	public String headle(EventMessage message){
		throw new RuntimeException("no defined");
	}
}
