package org.orange.wechatcontainer.pojo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
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

import static javax.persistence.GenerationType.IDENTITY;


@Entity
@Table(name = "container_tenant_info")
public class TentantInfo extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "container_tenant_info";
	
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tenantid", unique = true, nullable = false,length=38)
	private String tentantid=null;
	
	private String tenantname;

	private String wechatcode;
	
	private String adminname;
	
	private String adminpwd;
	
	private String baseurl;
	
	private String token;
	
	private String tentantaddress;
	
	private String tentanttel;
	
	private String tentantlinkman;
	
	private float tentantamount=0.00f;
	
	private int registertype=0;
	
	private String parentid;
	
	private String logicscript;
	

	
	
	
	public String getTentantid() {
		return tentantid;
	}

	public void setTentantid(String tentantid) {
		this.tentantid = tentantid;
	}

	public String getTenantname() {
		return tenantname;
	}

	public void setTenantname(String tenantname) {
		this.tenantname = tenantname;
	}

	public String getWechatcode() {
		return wechatcode;
	}

	public void setWechatcode(String wechatcode) {
		this.wechatcode = wechatcode;
	}

	public String getAdminname() {
		return adminname;
	}

	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}

	public String getAdminpwd() {
		return adminpwd;
	}

	public void setAdminpwd(String adminpwd) {
		this.adminpwd = adminpwd;
	}

	public String getBaseurl() {
		return baseurl;
	}

	public void setBaseurl(String baseurl) {
		this.baseurl = baseurl;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getTentantaddress() {
		return tentantaddress;
	}

	public void setTentantaddress(String tentantaddress) {
		this.tentantaddress = tentantaddress;
	}

	public String getTentanttel() {
		return tentanttel;
	}

	public void setTentanttel(String tentanttel) {
		this.tentanttel = tentanttel;
	}

	public String getTentantlinkman() {
		return tentantlinkman;
	}

	public void setTentantlinkman(String tentantlinkman) {
		this.tentantlinkman = tentantlinkman;
	}

	public float getTentantamount() {
		return tentantamount;
	}

	public void setTentantamount(float tentantamount) {
		this.tentantamount = tentantamount;
	}

	public int getRegistertype() {
		return registertype;
	}

	public void setRegistertype(int registertype) {
		this.registertype = registertype;
	}

	public String getParentid() {
		return parentid;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
	}
	
	public String getLogicscript() {
		return logicscript;
	}

	public void setLogicscript(String logicscript) {
		this.logicscript = logicscript;
	}
	
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getTentantid())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof TentantInfo == false) return false;
		if(this == obj) return true;
		TentantInfo other = (TentantInfo)obj;
		return new EqualsBuilder()
			.append(getTentantid(),other.getTentantid())
			.isEquals();
	}

	

	
}
