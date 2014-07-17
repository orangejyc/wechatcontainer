package org.orange.wechatcontainer.sdk.ext.handler;

import org.orange.wechatcontainer.sdk.bean.EventMessage;

public class TextMessageHandler extends BaseMessageHandler {
	
	@Override
	public String headle(EventMessage message){
		throw new RuntimeException("no defined");
	}
}
