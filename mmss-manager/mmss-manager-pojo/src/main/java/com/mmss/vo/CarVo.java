package com.mmss.vo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CarVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6826370361817165633L;

	private Long id;

    private String carnum;

    private String name;

    private String type;

    private String specification;

    private Float weight;

    private String unit;

    private String status;

    private String remark;

    private Date creattime;
    private Date createdateStart;
    private Date createdateEnd;

    private String state;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCarnum() {
		return carnum;
	}

	public void setCarnum(String carnum) {
		this.carnum = carnum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public Float getWeight() {
		return weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getCreattime() {
		return creattime;
	}
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	public void setCreattime(Date creattime) {
		this.creattime = creattime;
	}
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	public Date getCreatedateStart() {
		return createdateStart;
	}

	public void setCreatedateStart(Date createdateStart) {
		this.createdateStart = createdateStart;
	}
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	public Date getCreatedateEnd() {
		return createdateEnd;
	}

	public void setCreatedateEnd(Date createdateEnd) {
		this.createdateEnd = createdateEnd;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
    
    
    
}
