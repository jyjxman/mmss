package com.mmss.pojo;

public class SysStock {
    private Long id;

    private Long materialId;

    private Long repositoryId;

    private Integer stocknum;

    private Float impoprice;

    private Float expoprice;

    private String priceunit;

    private String stockdesc;

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
        this.priceunit = priceunit == null ? null : priceunit.trim();
    }

    public String getStockdesc() {
        return stockdesc;
    }

    public void setStockdesc(String stockdesc) {
        this.stockdesc = stockdesc == null ? null : stockdesc.trim();
    }
}