package com.mmss.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SysPurBusListAudit implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 8812684391586301438L;

	private String id;

    private String userid;

    private String listid;

    private String auditinfo;

    private String audittype;

    private Date createtime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getListid() {
        return listid;
    }

    public void setListid(String listid) {
        this.listid = listid == null ? null : listid.trim();
    }

    public String getAuditinfo() {
        return auditinfo;
    }

    public void setAuditinfo(String auditinfo) {
        this.auditinfo = auditinfo == null ? null : auditinfo.trim();
    }

    public String getAudittype() {
        return audittype;
    }

    public void setAudittype(String audittype) {
        this.audittype = audittype == null ? null : audittype.trim();
    }
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}