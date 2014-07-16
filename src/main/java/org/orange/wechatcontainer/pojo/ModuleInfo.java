package org.orange.wechatcontainer.pojo;

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

public class ModuleInfo extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	
	//date formats
	public static final String FORMAT_BIRTH_DATE = DATE_FORMAT;
	
	
	
}
