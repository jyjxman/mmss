package com.mmss.pojo;

public class SysMaterial {
    private Long id;

    private String materialName;

    private String specifications;

    private String materialType;

    private String measureUnit;

    private Float unitPrice;

    private Float minStorage;

    private Float maxStorage;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName == null ? null : materialName.trim();
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications == null ? null : specifications.trim();
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType == null ? null : materialType.trim();
    }

    public String getMeasureUnit() {
        return measureUnit;
    }

    public void setMeasureUnit(String measureUnit) {
        this.measureUnit = measureUnit == null ? null : measureUnit.trim();
    }

    public Float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Float getMinStorage() {
        return minStorage;
    }

    public void setMinStorage(Float minStorage) {
        this.minStorage = minStorage;
    }

    public Float getMaxStorage() {
        return maxStorage;
    }

    public void setMaxStorage(Float maxStorage) {
        this.maxStorage = maxStorage;
    }
}