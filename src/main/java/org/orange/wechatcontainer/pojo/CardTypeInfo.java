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

public class CardTypeInfo extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "member_cardtype_info";
	
	
	private String cardtypeid=null;
	
	
	public String getCardtypeid() {
		return cardtypeid;
	}

	public void setCardtypeid(String cardtypeid) {
		this.cardtypeid = cardtypeid;
	}

	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getCardtypeid())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof CardTypeInfo == false) return false;
		if(this == obj) return true;
		CardTypeInfo other = (CardTypeInfo)obj;
		return new EqualsBuilder()
			.append(getCardtypeid(),other.getCardtypeid())
			.isEquals();
	}

	}
