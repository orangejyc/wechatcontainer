package org.orange.wechatcontainer.common;

import java.util.List;

import org.orange.wechatcontainer.util.JasonHelper;



public class ActionResult<T> {
	private String result;
	private String reason;
	private String reasonCode;
	
	private T payload;
	private List<T> payloadList;

	public void success() {
		result = "success";
		reason = "";
		reasonCode = "";
	}
	
	public void failure(String reason, String reasonCode) {
		result = "failure";
		this.reason = reason;
		this.reasonCode = reasonCode;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public String getReason() {
		return reason;
	}
	
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	public String getReasonCode() {
		return reasonCode;
	}
	
	public void setReasonCode(String reasonCode) {
		this.reasonCode = reasonCode;
	}

	public T getPayload() {
		return payload;
	}

	public void setPayload(T payload) {
		this.payload = payload;
	}

	public String getPayloadToJsonString() {
		return JasonHelper.getJsonString(payload);
	}

	public List<T> getPayloadList() {
		return payloadList;
	}

	public void setPayloadList(List<T> payloadList) {
		this.payloadList = payloadList;
	}
	
}
