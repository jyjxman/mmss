package com.mmss.vo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CarAccidentVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4371629614336893407L;

	private Long id;

    private Long carid;

    private Date time;

    private String address;

    private Float price;

    private String unit;

    private String reason;
    
    private Date createdateStart;
    private Date createdateEnd;
    
    private String name;
    
    private String carnum;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCarid() {
		return carid;
	}

	public void setCarid(Long carid) {
		this.carid = carid;
	}
	 @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	 @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCarnum() {
		return carnum;
	}

	public void setCarnum(String carnum) {
		this.carnum = carnum;
	}
    
    
    
}
