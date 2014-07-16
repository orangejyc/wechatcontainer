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

public class GuestInfo extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "container_guest_info";
	
	
	//date formats
	public static final String FORMAT_BIRTH_DATE = DATE_FORMAT;
	
	
	private String guestid="";
	
	private String guestname="";

	public String getGuestid() {
		return guestid;
	}

	public void setGuestid(String guestid) {
		this.guestid = guestid;
	}

	public String getGuestname() {
		return guestname;
	}

	public void setGuestname(String guestname) {
		this.guestname = guestname;
	}
	
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getGuestid())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof GuestInfo == false) return false;
		if(this == obj) return true;
		GuestInfo other = (GuestInfo)obj;
		return new EqualsBuilder()
			.append(getGuestid(),other.getGuestid())
			.isEquals();
	}
}
