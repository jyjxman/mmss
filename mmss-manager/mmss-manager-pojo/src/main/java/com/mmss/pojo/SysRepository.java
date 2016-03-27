package com.mmss.pojo;

public class SysRepository {
    private Long id;

    private String repositoryName;

    private String repositoryAddress;

    private Float repositoryArea;

    private String materialType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRepositoryName() {
        return repositoryName;
    }

    public void setRepositoryName(String repositoryName) {
        this.repositoryName = repositoryName == null ? null : repositoryName.trim();
    }

    public String getRepositoryAddress() {
        return repositoryAddress;
    }

    public void setRepositoryAddress(String repositoryAddress) {
        this.repositoryAddress = repositoryAddress == null ? null : repositoryAddress.trim();
    }

    public Float getRepositoryArea() {
        return repositoryArea;
    }

    public void setRepositoryArea(Float repositoryArea) {
        this.repositoryArea = repositoryArea;
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType == null ? null : materialType.trim();
    }
}