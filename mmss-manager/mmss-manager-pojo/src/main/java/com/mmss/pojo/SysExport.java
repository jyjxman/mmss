package com.mmss.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SysExport {
    private Long id;

    private Long materialId;

    private Long repositoryId;

    private Float expoprice;

    private String priceunit;

    private Date expodate;

    private Integer exponum;

    private String numunit;

    private String expodesc;

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
        this.priceunit = priceunit == null ? null : priceunit.trim();
    }
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    public Date getExpodate() {
        return expodate;
    }

    public void setExpodate(Date expodate) {
        this.expodate = expodate;
    }

    public Integer getExponum() {
        return exponum;
    }

    public void setExponum(Integer exponum) {
        this.exponum = exponum;
    }

    public String getNumunit() {
        return numunit;
    }

    public void setNumunit(String numunit) {
        this.numunit = numunit == null ? null : numunit.trim();
    }

    public String getExpodesc() {
        return expodesc;
    }

    public void setExpodesc(String expodesc) {
        this.expodesc = expodesc == null ? null : expodesc.trim();
    }
}