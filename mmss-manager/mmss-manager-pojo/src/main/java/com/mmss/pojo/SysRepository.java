package com.mmss.pojo;

import java.io.Serializable;

public class SysRepository implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -6095195944071876039L;

	private Long id;

    private String repositoryName;

    private String repositoryAddress;

    private Float repositoryArea;

    private String repositoryDesc;

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

    public String getRepositoryDesc() {
        return repositoryDesc;
    }

    public void setRepositoryDesc(String repositoryDesc) {
        this.repositoryDesc = repositoryDesc == null ? null : repositoryDesc.trim();
    }
}