package com.mmss.pojo;

import java.util.Date;

public class SysImport {
    private Long id;

    private Long materialId;

    private Long repositoryId;

    private Float impoprice;

    private String priceunit;

    private Date impodate;

    private Integer imponum;

    private String numunit;

    private String impodesc;

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
        this.priceunit = priceunit == null ? null : priceunit.trim();
    }

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
        this.numunit = numunit == null ? null : numunit.trim();
    }

    public String getImpodesc() {
        return impodesc;
    }

    public void setImpodesc(String impodesc) {
        this.impodesc = impodesc == null ? null : impodesc.trim();
    }
}