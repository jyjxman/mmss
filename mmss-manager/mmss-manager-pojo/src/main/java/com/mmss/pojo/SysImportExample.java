package com.mmss.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysImportExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysImportExample() {
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

        public Criteria andImpodateIsNull() {
            addCriterion("impoDate is null");
            return (Criteria) this;
        }

        public Criteria andImpodateIsNotNull() {
            addCriterion("impoDate is not null");
            return (Criteria) this;
        }

        public Criteria andImpodateEqualTo(Date value) {
            addCriterion("impoDate =", value, "impodate");
            return (Criteria) this;
        }

        public Criteria andImpodateNotEqualTo(Date value) {
            addCriterion("impoDate <>", value, "impodate");
            return (Criteria) this;
        }

        public Criteria andImpodateGreaterThan(Date value) {
            addCriterion("impoDate >", value, "impodate");
            return (Criteria) this;
        }

        public Criteria andImpodateGreaterThanOrEqualTo(Date value) {
            addCriterion("impoDate >=", value, "impodate");
            return (Criteria) this;
        }

        public Criteria andImpodateLessThan(Date value) {
            addCriterion("impoDate <", value, "impodate");
            return (Criteria) this;
        }

        public Criteria andImpodateLessThanOrEqualTo(Date value) {
            addCriterion("impoDate <=", value, "impodate");
            return (Criteria) this;
        }

        public Criteria andImpodateIn(List<Date> values) {
            addCriterion("impoDate in", values, "impodate");
            return (Criteria) this;
        }

        public Criteria andImpodateNotIn(List<Date> values) {
            addCriterion("impoDate not in", values, "impodate");
            return (Criteria) this;
        }

        public Criteria andImpodateBetween(Date value1, Date value2) {
            addCriterion("impoDate between", value1, value2, "impodate");
            return (Criteria) this;
        }

        public Criteria andImpodateNotBetween(Date value1, Date value2) {
            addCriterion("impoDate not between", value1, value2, "impodate");
            return (Criteria) this;
        }

        public Criteria andImponumIsNull() {
            addCriterion("impoNum is null");
            return (Criteria) this;
        }

        public Criteria andImponumIsNotNull() {
            addCriterion("impoNum is not null");
            return (Criteria) this;
        }

        public Criteria andImponumEqualTo(Integer value) {
            addCriterion("impoNum =", value, "imponum");
            return (Criteria) this;
        }

        public Criteria andImponumNotEqualTo(Integer value) {
            addCriterion("impoNum <>", value, "imponum");
            return (Criteria) this;
        }

        public Criteria andImponumGreaterThan(Integer value) {
            addCriterion("impoNum >", value, "imponum");
            return (Criteria) this;
        }

        public Criteria andImponumGreaterThanOrEqualTo(Integer value) {
            addCriterion("impoNum >=", value, "imponum");
            return (Criteria) this;
        }

        public Criteria andImponumLessThan(Integer value) {
            addCriterion("impoNum <", value, "imponum");
            return (Criteria) this;
        }

        public Criteria andImponumLessThanOrEqualTo(Integer value) {
            addCriterion("impoNum <=", value, "imponum");
            return (Criteria) this;
        }

        public Criteria andImponumIn(List<Integer> values) {
            addCriterion("impoNum in", values, "imponum");
            return (Criteria) this;
        }

        public Criteria andImponumNotIn(List<Integer> values) {
            addCriterion("impoNum not in", values, "imponum");
            return (Criteria) this;
        }

        public Criteria andImponumBetween(Integer value1, Integer value2) {
            addCriterion("impoNum between", value1, value2, "imponum");
            return (Criteria) this;
        }

        public Criteria andImponumNotBetween(Integer value1, Integer value2) {
            addCriterion("impoNum not between", value1, value2, "imponum");
            return (Criteria) this;
        }

        public Criteria andNumunitIsNull() {
            addCriterion("numUnit is null");
            return (Criteria) this;
        }

        public Criteria andNumunitIsNotNull() {
            addCriterion("numUnit is not null");
            return (Criteria) this;
        }

        public Criteria andNumunitEqualTo(String value) {
            addCriterion("numUnit =", value, "numunit");
            return (Criteria) this;
        }

        public Criteria andNumunitNotEqualTo(String value) {
            addCriterion("numUnit <>", value, "numunit");
            return (Criteria) this;
        }

        public Criteria andNumunitGreaterThan(String value) {
            addCriterion("numUnit >", value, "numunit");
            return (Criteria) this;
        }

        public Criteria andNumunitGreaterThanOrEqualTo(String value) {
            addCriterion("numUnit >=", value, "numunit");
            return (Criteria) this;
        }

        public Criteria andNumunitLessThan(String value) {
            addCriterion("numUnit <", value, "numunit");
            return (Criteria) this;
        }

        public Criteria andNumunitLessThanOrEqualTo(String value) {
            addCriterion("numUnit <=", value, "numunit");
            return (Criteria) this;
        }

        public Criteria andNumunitLike(String value) {
            addCriterion("numUnit like", value, "numunit");
            return (Criteria) this;
        }

        public Criteria andNumunitNotLike(String value) {
            addCriterion("numUnit not like", value, "numunit");
            return (Criteria) this;
        }

        public Criteria andNumunitIn(List<String> values) {
            addCriterion("numUnit in", values, "numunit");
            return (Criteria) this;
        }

        public Criteria andNumunitNotIn(List<String> values) {
            addCriterion("numUnit not in", values, "numunit");
            return (Criteria) this;
        }

        public Criteria andNumunitBetween(String value1, String value2) {
            addCriterion("numUnit between", value1, value2, "numunit");
            return (Criteria) this;
        }

        public Criteria andNumunitNotBetween(String value1, String value2) {
            addCriterion("numUnit not between", value1, value2, "numunit");
            return (Criteria) this;
        }

        public Criteria andImpodescIsNull() {
            addCriterion("impoDesc is null");
            return (Criteria) this;
        }

        public Criteria andImpodescIsNotNull() {
            addCriterion("impoDesc is not null");
            return (Criteria) this;
        }

        public Criteria andImpodescEqualTo(String value) {
            addCriterion("impoDesc =", value, "impodesc");
            return (Criteria) this;
        }

        public Criteria andImpodescNotEqualTo(String value) {
            addCriterion("impoDesc <>", value, "impodesc");
            return (Criteria) this;
        }

        public Criteria andImpodescGreaterThan(String value) {
            addCriterion("impoDesc >", value, "impodesc");
            return (Criteria) this;
        }

        public Criteria andImpodescGreaterThanOrEqualTo(String value) {
            addCriterion("impoDesc >=", value, "impodesc");
            return (Criteria) this;
        }

        public Criteria andImpodescLessThan(String value) {
            addCriterion("impoDesc <", value, "impodesc");
            return (Criteria) this;
        }

        public Criteria andImpodescLessThanOrEqualTo(String value) {
            addCriterion("impoDesc <=", value, "impodesc");
            return (Criteria) this;
        }

        public Criteria andImpodescLike(String value) {
            addCriterion("impoDesc like", value, "impodesc");
            return (Criteria) this;
        }

        public Criteria andImpodescNotLike(String value) {
            addCriterion("impoDesc not like", value, "impodesc");
            return (Criteria) this;
        }

        public Criteria andImpodescIn(List<String> values) {
            addCriterion("impoDesc in", values, "impodesc");
            return (Criteria) this;
        }

        public Criteria andImpodescNotIn(List<String> values) {
            addCriterion("impoDesc not in", values, "impodesc");
            return (Criteria) this;
        }

        public Criteria andImpodescBetween(String value1, String value2) {
            addCriterion("impoDesc between", value1, value2, "impodesc");
            return (Criteria) this;
        }

        public Criteria andImpodescNotBetween(String value1, String value2) {
            addCriterion("impoDesc not between", value1, value2, "impodesc");
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