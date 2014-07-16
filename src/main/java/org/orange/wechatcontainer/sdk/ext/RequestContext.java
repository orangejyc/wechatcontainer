package org.orange.wechatcontainer.sdk.ext;

import org.orange.wechatcontainer.sdk.bean.EventMessage;


public abstract class RequestContext {
	
	private SignatureInfo signatureInfo=null;
	
	private EventMessage eventMessage=null;
	
	private String tentantId="";
	
	public SignatureInfo getSignatureInfo() {
		return signatureInfo;
	}

	public void setSignatureInfo(SignatureInfo signatureInfo) {
		this.signatureInfo = signatureInfo;
	}

	public EventMessage getEventMessage() {
		return eventMessage;
	}

	public void setEventMessage(EventMessage eventMessage) {
		this.eventMessage = eventMessage;
	}

	public void setTentantId(String tentantId){
		
	}
	
	public String getTentantId(){
		return tentantId;
	}
	
	
}
