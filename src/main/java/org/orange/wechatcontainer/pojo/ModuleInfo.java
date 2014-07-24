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
	
	
	/**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column container_module_info.moduletid
     *
     * @mbggenerated
     */
    private String moduletid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column container_module_info.modulename
     *
     * @mbggenerated
     */
    private String modulename;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column container_module_info.baseurl
     *
     * @mbggenerated
     */
    private String baseurl;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column container_module_info.createdate
     *
     * @mbggenerated
     */
    private String createdate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column container_module_info.lastdate
     *
     * @mbggenerated
     */
    private String lastdate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column container_module_info.default
     *
     * @mbggenerated
     */
    private int defaults;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column container_module_info.parentid
     *
     * @mbggenerated
     */
    private String parentid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column container_module_info.moduletid
     *
     * @return the value of container_module_info.moduletid
     *
     * @mbggenerated
     */
    public String getModuletid() {
        return moduletid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column container_module_info.moduletid
     *
     * @param moduletid the value for container_module_info.moduletid
     *
     * @mbggenerated
     */
    public void setModuletid(String moduletid) {
        this.moduletid = moduletid == null ? null : moduletid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column container_module_info.modulename
     *
     * @return the value of container_module_info.modulename
     *
     * @mbggenerated
     */
    public String getModulename() {
        return modulename;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column container_module_info.modulename
     *
     * @param modulename the value for container_module_info.modulename
     *
     * @mbggenerated
     */
    public void setModulename(String modulename) {
        this.modulename = modulename == null ? null : modulename.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column container_module_info.baseurl
     *
     * @return the value of container_module_info.baseurl
     *
     * @mbggenerated
     */
    public String getBaseurl() {
        return baseurl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column container_module_info.baseurl
     *
     * @param baseurl the value for container_module_info.baseurl
     *
     * @mbggenerated
     */
    public void setBaseurl(String baseurl) {
        this.baseurl = baseurl == null ? null : baseurl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column container_module_info.createdate
     *
     * @return the value of container_module_info.createdate
     *
     * @mbggenerated
     */
    public String getCreatedate() {
        return createdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column container_module_info.createdate
     *
     * @param createdate the value for container_module_info.createdate
     *
     * @mbggenerated
     */
    public void setCreatedate(String createdate) {
        this.createdate = createdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column container_module_info.lastdate
     *
     * @return the value of container_module_info.lastdate
     *
     * @mbggenerated
     */
    public String getLastdate() {
        return lastdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column container_module_info.lastdate
     *
     * @param lastdate the value for container_module_info.lastdate
     *
     * @mbggenerated
     */
    public void setLastdate(String lastdate) {
        this.lastdate = lastdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column container_module_info.default
     *
     * @return the value of container_module_info.default
     *
     * @mbggenerated
     */
    public int getDefault() {
        return defaults;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column container_module_info.default
     *
     * @param default the value for container_module_info.default
     *
     * @mbggenerated
     */
    public void setDefault(int defaults) {
        this.defaults = defaults;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column container_module_info.parentid
     *
     * @return the value of container_module_info.parentid
     *
     * @mbggenerated
     */
    public String getParentid() {
        return parentid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column container_module_info.parentid
     *
     * @param parentid the value for container_module_info.parentid
     *
     * @mbggenerated
     */
    public void setParentid(String parentid) {
        this.parentid = parentid == null ? null : parentid.trim();
    }
	
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(this.getModuletid())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof TentantInfo == false) return false;
		if(this == obj) return true;
		ModuleInfo other = (ModuleInfo)obj;
		return new EqualsBuilder()
			.append(this.getModuletid(),other.getModuletid())
			.isEquals();
	}
	
}
