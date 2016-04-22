package com.mmss.pojo;

import java.util.Date;

public class SysPurBusListAudit {
    private Long id;

    private String userid;

    private Long listid;

    private String auditinfo;

    private String audittype;

    private String status;

    private Date createtime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public Long getListid() {
        return listid;
    }

    public void setListid(Long listid) {
        this.listid = listid;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}