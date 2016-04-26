package com.mmss.vo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class StockVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 907474180924842850L;

	private Long id;

	private Long materialId;

	private Long repositoryId;

	private Integer stocknum;

	private Float impoprice;

	private Float expoprice;

	private String priceunit;

	private String stockdesc;

	private Date updatdate;
	
	private Date createdateStart;

	private Date createdateEnd;
	private String repositoryName;

	private String materialName;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	public Date getUpdatdate() {
		return updatdate;
	}

	public void setUpdatdate(Date updatdate) {
		this.updatdate = updatdate;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMaterialId() {
		return materialId;
	}

	public void setMaterialId(Long materialId) {
		this.materialId = materialId;
	}

	public Long getRepositoryId() {
		return repositoryId;
	}

	public void setRepositoryId(Long repositoryId) {
		this.repositoryId = repositoryId;
	}

	public Integer getStocknum() {
		return stocknum;
	}

	public void setStocknum(Integer stocknum) {
		this.stocknum = stocknum;
	}

	public Float getImpoprice() {
		return impoprice;
	}

	public void setImpoprice(Float impoprice) {
		this.impoprice = impoprice;
	}

	public Float getExpoprice() {
		return expoprice;
	}

	public void setExpoprice(Float expoprice) {
		this.expoprice = expoprice;
	}

	public String getPriceunit() {
		return priceunit;
	}

	public void setPriceunit(String priceunit) {
		this.priceunit = priceunit;
	}

	public String getStockdesc() {
		return stockdesc;
	}

	public void setStockdesc(String stockdesc) {
		this.stockdesc = stockdesc;
	}

	public String getRepositoryName() {
		return repositoryName;
	}

	public void setRepositoryName(String repositoryName) {
		this.repositoryName = repositoryName;
	}

	public String getMaterialName() {
		return materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

}
