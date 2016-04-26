package com.mmss.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysStockExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysStockExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andMaterialIdIsNull() {
            addCriterion("material_id is null");
            return (Criteria) this;
        }

        public Criteria andMaterialIdIsNotNull() {
            addCriterion("material_id is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialIdEqualTo(Long value) {
            addCriterion("material_id =", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdNotEqualTo(Long value) {
            addCriterion("material_id <>", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdGreaterThan(Long value) {
            addCriterion("material_id >", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdGreaterThanOrEqualTo(Long value) {
            addCriterion("material_id >=", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdLessThan(Long value) {
            addCriterion("material_id <", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdLessThanOrEqualTo(Long value) {
            addCriterion("material_id <=", value, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdIn(List<Long> values) {
            addCriterion("material_id in", values, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdNotIn(List<Long> values) {
            addCriterion("material_id not in", values, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdBetween(Long value1, Long value2) {
            addCriterion("material_id between", value1, value2, "materialId");
            return (Criteria) this;
        }

        public Criteria andMaterialIdNotBetween(Long value1, Long value2) {
            addCriterion("material_id not between", value1, value2, "materialId");
            return (Criteria) this;
        }

        public Criteria andRepositoryIdIsNull() {
            addCriterion("repository_id is null");
            return (Criteria) this;
        }

        public Criteria andRepositoryIdIsNotNull() {
            addCriterion("repository_id is not null");
            return (Criteria) this;
        }

        public Criteria andRepositoryIdEqualTo(Long value) {
            addCriterion("repository_id =", value, "repositoryId");
            return (Criteria) this;
        }

        public Criteria andRepositoryIdNotEqualTo(Long value) {
            addCriterion("repository_id <>", value, "repositoryId");
            return (Criteria) this;
        }

        public Criteria andRepositoryIdGreaterThan(Long value) {
            addCriterion("repository_id >", value, "repositoryId");
            return (Criteria) this;
        }

        public Criteria andRepositoryIdGreaterThanOrEqualTo(Long value) {
            addCriterion("repository_id >=", value, "repositoryId");
            return (Criteria) this;
        }

        public Criteria andRepositoryIdLessThan(Long value) {
            addCriterion("repository_id <", value, "repositoryId");
            return (Criteria) this;
        }

        public Criteria andRepositoryIdLessThanOrEqualTo(Long value) {
            addCriterion("repository_id <=", value, "repositoryId");
            return (Criteria) this;
        }

        public Criteria andRepositoryIdIn(List<Long> values) {
            addCriterion("repository_id in", values, "repositoryId");
            return (Criteria) this;
        }

        public Criteria andRepositoryIdNotIn(List<Long> values) {
            addCriterion("repository_id not in", values, "repositoryId");
            return (Criteria) this;
        }

        public Criteria andRepositoryIdBetween(Long value1, Long value2) {
            addCriterion("repository_id between", value1, value2, "repositoryId");
            return (Criteria) this;
        }

        public Criteria andRepositoryIdNotBetween(Long value1, Long value2) {
            addCriterion("repository_id not between", value1, value2, "repositoryId");
            return (Criteria) this;
        }

        public Criteria andStocknumIsNull() {
            addCriterion("stockNum is null");
            return (Criteria) this;
        }

        public Criteria andStocknumIsNotNull() {
            addCriterion("stockNum is not null");
            return (Criteria) this;
        }

        public Criteria andStocknumEqualTo(Integer value) {
            addCriterion("stockNum =", value, "stocknum");
            return (Criteria) this;
        }

        public Criteria andStocknumNotEqualTo(Integer value) {
            addCriterion("stockNum <>", value, "stocknum");
            return (Criteria) this;
        }

        public Criteria andStocknumGreaterThan(Integer value) {
            addCriterion("stockNum >", value, "stocknum");
            return (Criteria) this;
        }

        public Criteria andStocknumGreaterThanOrEqualTo(Integer value) {
            addCriterion("stockNum >=", value, "stocknum");
            return (Criteria) this;
        }

        public Criteria andStocknumLessThan(Integer value) {
            addCriterion("stockNum <", value, "stocknum");
            return (Criteria) this;
        }

        public Criteria andStocknumLessThanOrEqualTo(Integer value) {
            addCriterion("stockNum <=", value, "stocknum");
            return (Criteria) this;
        }

        public Criteria andStocknumIn(List<Integer> values) {
            addCriterion("stockNum in", values, "stocknum");
            return (Criteria) this;
        }

        public Criteria andStocknumNotIn(List<Integer> values) {
            addCriterion("stockNum not in", values, "stocknum");
            return (Criteria) this;
        }

        public Criteria andStocknumBetween(Integer value1, Integer value2) {
            addCriterion("stockNum between", value1, value2, "stocknum");
            return (Criteria) this;
        }

        public Criteria andStocknumNotBetween(Integer value1, Integer value2) {
            addCriterion("stockNum not between", value1, value2, "stocknum");
            return (Criteria) this;
        }

        public Criteria andImpopriceIsNull() {
            addCriterion("impoPrice is null");
            return (Criteria) this;
        }

        public Criteria andImpopriceIsNotNull() {
            addCriterion("impoPrice is not null");
            return (Criteria) this;
        }

        public Criteria andImpopriceEqualTo(Float value) {
            addCriterion("impoPrice =", value, "impoprice");
            return (Criteria) this;
        }

        public Criteria andImpopriceNotEqualTo(Float value) {
            addCriterion("impoPrice <>", value, "impoprice");
            return (Criteria) this;
        }

        public Criteria andImpopriceGreaterThan(Float value) {
            addCriterion("impoPrice >", value, "impoprice");
            return (Criteria) this;
        }

        public Criteria andImpopriceGreaterThanOrEqualTo(Float value) {
            addCriterion("impoPrice >=", value, "impoprice");
            return (Criteria) this;
        }

        public Criteria andImpopriceLessThan(Float value) {
            addCriterion("impoPrice <", value, "impoprice");
            return (Criteria) this;
        }

        public Criteria andImpopriceLessThanOrEqualTo(Float value) {
            addCriterion("impoPrice <=", value, "impoprice");
            return (Criteria) this;
        }

        public Criteria andImpopriceIn(List<Float> values) {
            addCriterion("impoPrice in", values, "impoprice");
            return (Criteria) this;
        }

        public Criteria andImpopriceNotIn(List<Float> values) {
            addCriterion("impoPrice not in", values, "impoprice");
            return (Criteria) this;
        }

        public Criteria andImpopriceBetween(Float value1, Float value2) {
            addCriterion("impoPrice between", value1, value2, "impoprice");
            return (Criteria) this;
        }

        public Criteria andImpopriceNotBetween(Float value1, Float value2) {
            addCriterion("impoPrice not between", value1, value2, "impoprice");
            return (Criteria) this;
        }

        public Criteria andExpopriceIsNull() {
            addCriterion("expoPrice is null");
            return (Criteria) this;
        }

        public Criteria andExpopriceIsNotNull() {
            addCriterion("expoPrice is not null");
            return (Criteria) this;
        }

        public Criteria andExpopriceEqualTo(Float value) {
            addCriterion("expoPrice =", value, "expoprice");
            return (Criteria) this;
        }

        public Criteria andExpopriceNotEqualTo(Float value) {
            addCriterion("expoPrice <>", value, "expoprice");
            return (Criteria) this;
        }

        public Criteria andExpopriceGreaterThan(Float value) {
            addCriterion("expoPrice >", value, "expoprice");
            return (Criteria) this;
        }

        public Criteria andExpopriceGreaterThanOrEqualTo(Float value) {
            addCriterion("expoPrice >=", value, "expoprice");
            return (Criteria) this;
        }

        public Criteria andExpopriceLessThan(Float value) {
            addCriterion("expoPrice <", value, "expoprice");
            return (Criteria) this;
        }

        public Criteria andExpopriceLessThanOrEqualTo(Float value) {
            addCriterion("expoPrice <=", value, "expoprice");
            return (Criteria) this;
        }

        public Criteria andExpopriceIn(List<Float> values) {
            addCriterion("expoPrice in", values, "expoprice");
            return (Criteria) this;
        }

        public Criteria andExpopriceNotIn(List<Float> values) {
            addCriterion("expoPrice not in", values, "expoprice");
            return (Criteria) this;
        }

        public Criteria andExpopriceBetween(Float value1, Float value2) {
            addCriterion("expoPrice between", value1, value2, "expoprice");
            return (Criteria) this;
        }

        public Criteria andExpopriceNotBetween(Float value1, Float value2) {
            addCriterion("expoPrice not between", value1, value2, "expoprice");
            return (Criteria) this;
        }

        public Criteria andPriceunitIsNull() {
            addCriterion("priceUnit is null");
            return (Criteria) this;
        }

        public Criteria andPriceunitIsNotNull() {
            addCriterion("priceUnit is not null");
            return (Criteria) this;
        }

        public Criteria andPriceunitEqualTo(String value) {
            addCriterion("priceUnit =", value, "priceunit");
            return (Criteria) this;
        }

        public Criteria andPriceunitNotEqualTo(String value) {
            addCriterion("priceUnit <>", value, "priceunit");
            return (Criteria) this;
        }

        public Criteria andPriceunitGreaterThan(String value) {
            addCriterion("priceUnit >", value, "priceunit");
            return (Criteria) this;
        }

        public Criteria andPriceunitGreaterThanOrEqualTo(String value) {
            addCriterion("priceUnit >=", value, "priceunit");
            return (Criteria) this;
        }

        public Criteria andPriceunitLessThan(String value) {
            addCriterion("priceUnit <", value, "priceunit");
            return (Criteria) this;
        }

        public Criteria andPriceunitLessThanOrEqualTo(String value) {
            addCriterion("priceUnit <=", value, "priceunit");
            return (Criteria) this;
        }

        public Criteria andPriceunitLike(String value) {
            addCriterion("priceUnit like", value, "priceunit");
            return (Criteria) this;
        }

        public Criteria andPriceunitNotLike(String value) {
            addCriterion("priceUnit not like", value, "priceunit");
            return (Criteria) this;
        }

        public Criteria andPriceunitIn(List<String> values) {
            addCriterion("priceUnit in", values, "priceunit");
            return (Criteria) this;
        }

        public Criteria andPriceunitNotIn(List<String> values) {
            addCriterion("priceUnit not in", values, "priceunit");
            return (Criteria) this;
        }

        public Criteria andPriceunitBetween(String value1, String value2) {
            addCriterion("priceUnit between", value1, value2, "priceunit");
            return (Criteria) this;
        }

        public Criteria andPriceunitNotBetween(String value1, String value2) {
            addCriterion("priceUnit not between", value1, value2, "priceunit");
            return (Criteria) this;
        }

        public Criteria andStockdescIsNull() {
            addCriterion("stockDesc is null");
            return (Criteria) this;
        }

        public Criteria andStockdescIsNotNull() {
            addCriterion("stockDesc is not null");
            return (Criteria) this;
        }

        public Criteria andStockdescEqualTo(String value) {
            addCriterion("stockDesc =", value, "stockdesc");
            return (Criteria) this;
        }

        public Criteria andStockdescNotEqualTo(String value) {
            addCriterion("stockDesc <>", value, "stockdesc");
            return (Criteria) this;
        }

        public Criteria andStockdescGreaterThan(String value) {
            addCriterion("stockDesc >", value, "stockdesc");
            return (Criteria) this;
        }

        public Criteria andStockdescGreaterThanOrEqualTo(String value) {
            addCriterion("stockDesc >=", value, "stockdesc");
            return (Criteria) this;
        }

        public Criteria andStockdescLessThan(String value) {
            addCriterion("stockDesc <", value, "stockdesc");
            return (Criteria) this;
        }

        public Criteria andStockdescLessThanOrEqualTo(String value) {
            addCriterion("stockDesc <=", value, "stockdesc");
            return (Criteria) this;
        }

        public Criteria andStockdescLike(String value) {
            addCriterion("stockDesc like", value, "stockdesc");
            return (Criteria) this;
        }

        public Criteria andStockdescNotLike(String value) {
            addCriterion("stockDesc not like", value, "stockdesc");
            return (Criteria) this;
        }

        public Criteria andStockdescIn(List<String> values) {
            addCriterion("stockDesc in", values, "stockdesc");
            return (Criteria) this;
        }

        public Criteria andStockdescNotIn(List<String> values) {
            addCriterion("stockDesc not in", values, "stockdesc");
            return (Criteria) this;
        }

        public Criteria andStockdescBetween(String value1, String value2) {
            addCriterion("stockDesc between", value1, value2, "stockdesc");
            return (Criteria) this;
        }

        public Criteria andStockdescNotBetween(String value1, String value2) {
            addCriterion("stockDesc not between", value1, value2, "stockdesc");
            return (Criteria) this;
        }

        public Criteria andUpdatdateIsNull() {
            addCriterion("updatDate is null");
            return (Criteria) this;
        }

        public Criteria andUpdatdateIsNotNull() {
            addCriterion("updatDate is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatdateEqualTo(Date value) {
            addCriterion("updatDate =", value, "updatdate");
            return (Criteria) this;
        }

        public Criteria andUpdatdateNotEqualTo(Date value) {
            addCriterion("updatDate <>", value, "updatdate");
            return (Criteria) this;
        }

        public Criteria andUpdatdateGreaterThan(Date value) {
            addCriterion("updatDate >", value, "updatdate");
            return (Criteria) this;
        }

        public Criteria andUpdatdateGreaterThanOrEqualTo(Date value) {
            addCriterion("updatDate >=", value, "updatdate");
            return (Criteria) this;
        }

        public Criteria andUpdatdateLessThan(Date value) {
            addCriterion("updatDate <", value, "updatdate");
            return (Criteria) this;
        }

        public Criteria andUpdatdateLessThanOrEqualTo(Date value) {
            addCriterion("updatDate <=", value, "updatdate");
            return (Criteria) this;
        }

        public Criteria andUpdatdateIn(List<Date> values) {
            addCriterion("updatDate in", values, "updatdate");
            return (Criteria) this;
        }

        public Criteria andUpdatdateNotIn(List<Date> values) {
            addCriterion("updatDate not in", values, "updatdate");
            return (Criteria) this;
        }

        public Criteria andUpdatdateBetween(Date value1, Date value2) {
            addCriterion("updatDate between", value1, value2, "updatdate");
            return (Criteria) this;
        }

        public Criteria andUpdatdateNotBetween(Date value1, Date value2) {
            addCriterion("updatDate not between", value1, value2, "updatdate");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}