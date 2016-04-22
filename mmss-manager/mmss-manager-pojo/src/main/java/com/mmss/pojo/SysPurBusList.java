package com.mmss.pojo;

import java.util.Date;

public class SysPurBusList {
    private Long id;

    private String name;

    private String userid;

    private String status;

    private String processinstanceid;

    private String wzname;

    private Date createtime;

    private Date endtime;

    private Integer wznum;

    private String content;

    private String area;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getProcessinstanceid() {
        return processinstanceid;
    }

    public void setProcessinstanceid(String processinstanceid) {
        this.processinstanceid = processinstanceid == null ? null : processinstanceid.trim();
    }

    public String getWzname() {
        return wzname;
    }

    public void setWzname(String wzname) {
        this.wzname = wzname == null ? null : wzname.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Integer getWznum() {
        return wznum;
    }

    public void setWznum(Integer wznum) {
        this.wznum = wznum;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }
}