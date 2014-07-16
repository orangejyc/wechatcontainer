package org.orange.wechatcontainer.pojo;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.orange.wechatcontainer.common.BaseQuery;
import org.orange.wechatcontainer.util.DateConvertUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class TentantInfoQuery extends BaseQuery implements Serializable {
    private static final long serialVersionUID = 3148176768559230877L;
    

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

	private String tentantid="";
	
	private String tenantname="";

	private String wechatcode="";
	
	private String adminname="";
	
	private String adminpwd="";
	
	private String baseurl="";
	
	private String token="";
	
	private String tentantaddress="";
	
	private String tentanttel="";
	
	private String tentantlinkman="";
	
	private float tentantamount=0.00f;
	
	private int registertype=0;
	
	private String parentid="";
	

	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
	}
	
}
