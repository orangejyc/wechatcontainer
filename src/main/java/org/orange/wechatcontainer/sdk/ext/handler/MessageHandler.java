package org.orange.wechatcontainer.sdk.ext.handler;

import org.orange.wechatcontainer.sdk.bean.EventMessage;

public interface MessageHandler {
	String headle(EventMessage message);
}
