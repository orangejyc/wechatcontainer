package org.orange.wechatcontainer.common;

public abstract class BaseEntity implements java.io.Serializable {

	private static final long serialVersionUID = -7200095849148417467L;

	protected static final String DATE_FORMAT = "yyyy-MM-dd";

	protected static final String TIME_FORMAT = "HH:mm:ss";

	protected static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

	protected static final String TIMESTAMP_FORMAT = "yyyy-MM-dd HH:mm:ss.S";

	protected String createdate = "";

	protected String lastdate = "";

	protected String getCreatedate() {
		return createdate;
	}

	protected void setCreatedate(String createdate) {
		this.createdate = createdate;
	}

	protected String getLastdate() {
		return lastdate;
	}

	protected void setLastdate(String lastdate) {
		this.lastdate = lastdate;
	}
}
