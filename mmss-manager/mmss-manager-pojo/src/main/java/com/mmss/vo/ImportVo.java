package com.mmss.vo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ImportVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -409125487265032397L;

	private Long id;

    private Long materialId;

    private Long repositoryId;

    private Float impoprice;

    private String priceunit;

    private Date impodate;

    private Integer imponum;

    private String numunit;

    private String impodesc;
    
    private Date createdateStart;
    
    private Date createdateEnd;
    
    private String repositoryName;
    
    private String materialName;

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

	public Float getImpoprice() {
		return impoprice;
	}

	public void setImpoprice(Float impoprice) {
		this.impoprice = impoprice;
	}

	public String getPriceunit() {
		return priceunit;
	}

	public void setPriceunit(String priceunit) {
		this.priceunit = priceunit;
	}
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	public Date getImpodate() {
		return impodate;
	}

	public void setImpodate(Date impodate) {
		this.impodate = impodate;
	}

	public Integer getImponum() {
		return imponum;
	}

	public void setImponum(Integer imponum) {
		this.imponum = imponum;
	}

	public String getNumunit() {
		return numunit;
	}

	public void setNumunit(String numunit) {
		this.numunit = numunit;
	}

	public String getImpodesc() {
		return impodesc;
	}

	public void setImpodesc(String impodesc) {
		this.impodesc = impodesc;
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
