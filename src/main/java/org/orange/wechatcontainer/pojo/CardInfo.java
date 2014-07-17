package org.orange.wechatcontainer.pojo;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Past;

import org.orange.wechatcontainer.common.BaseEntity;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;


import org.orange.wechatcontainer.util.DateConvertUtils;

public class CardInfo extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "member_card_info";
	
	
	private String cardid=null;
	private String cardcode=null;
	private float rechargeamount=0.00f;
	private float outlayamount=0.00f;
	private float balance=0.00f;
	private int outlayscore=0;
	private int loginscore=0;
	private int enabled=0;
	private String createdate=null;
	private String lastdate=null;
	private String enddate=null;
	private String cardtypeid=null;
	private String tentantid=null;
	private String guestid=null;
	private CardTypeInfo cardtypeinfo=null;
	private TentantInfo tentantinfo=null;
	private GuestInfo guestinfo=null;
	
	public String getCardid() {
		return cardid;
	}

	public void setCardid(String cardid) {
		this.cardid = cardid;
	}

	public String getCardcode() {
		return cardcode;
	}

	public void setCardcode(String cardcode) {
		this.cardcode = cardcode;
	}

	public float getRechargeamount() {
		return rechargeamount;
	}

	public void setRechargeamount(float rechargeamount) {
		this.rechargeamount = rechargeamount;
	}

	public float getOutlayamount() {
		return outlayamount;
	}

	public void setOutlayamount(float outlayamount) {
		this.outlayamount = outlayamount;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public int getOutlayscore() {
		return outlayscore;
	}

	public void setOutlayscore(int outlayscore) {
		this.outlayscore = outlayscore;
	}

	public int getLoginscore() {
		return loginscore;
	}

	public void setLoginscore(int loginscore) {
		this.loginscore = loginscore;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public String getCreatedate() {
		return createdate;
	}

	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}

	public String getLastdate() {
		return lastdate;
	}

	public void setLastdate(String lastdate) {
		this.lastdate = lastdate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public String getCardtypeid() {
		return cardtypeid;
	}

	public void setCardtypeid(String cardtypeid) {
		this.cardtypeid = cardtypeid;
	}

	public String getTentantid() {
		return tentantid;
	}

	public void setTentantid(String tentantid) {
		this.tentantid = tentantid;
	}

	public String getGuestid() {
		return guestid;
	}

	public void setGuestid(String guestid) {
		this.guestid = guestid;
	}

	public CardTypeInfo getCardtypeinfo() {
		return cardtypeinfo;
	}

	public void setCardtypeinfo(CardTypeInfo cardtypeinfo) {
		this.cardtypeinfo = cardtypeinfo;
	}

	public TentantInfo getTentantinfo() {
		return tentantinfo;
	}

	public void setTentantinfo(TentantInfo tentantinfo) {
		this.tentantinfo = tentantinfo;
	}

	public GuestInfo getGuestinfo() {
		return guestinfo;
	}

	public void setGuestinfo(GuestInfo guestinfo) {
		this.guestinfo = guestinfo;
	}


	
	
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getCardid())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof CardInfo == false) return false;
		if(this == obj) return true;
		CardInfo other = (CardInfo)obj;
		return new EqualsBuilder()
			.append(getCardid(),other.getCardid())
			.isEquals();
	}
}
