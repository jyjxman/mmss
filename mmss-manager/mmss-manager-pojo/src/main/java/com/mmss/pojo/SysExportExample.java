package com.mmss.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysExportExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysExportExample() {
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

        public Criteria andExpodateIsNull() {
            addCriterion("expoDate is null");
            return (Criteria) this;
        }

        public Criteria andExpodateIsNotNull() {
            addCriterion("expoDate is not null");
            return (Criteria) this;
        }

        public Criteria andExpodateEqualTo(Date value) {
            addCriterion("expoDate =", value, "expodate");
            return (Criteria) this;
        }

        public Criteria andExpodateNotEqualTo(Date value) {
            addCriterion("expoDate <>", value, "expodate");
            return (Criteria) this;
        }

        public Criteria andExpodateGreaterThan(Date value) {
            addCriterion("expoDate >", value, "expodate");
            return (Criteria) this;
        }

        public Criteria andExpodateGreaterThanOrEqualTo(Date value) {
            addCriterion("expoDate >=", value, "expodate");
            return (Criteria) this;
        }

        public Criteria andExpodateLessThan(Date value) {
            addCriterion("expoDate <", value, "expodate");
            return (Criteria) this;
        }

        public Criteria andExpodateLessThanOrEqualTo(Date value) {
            addCriterion("expoDate <=", value, "expodate");
            return (Criteria) this;
        }

        public Criteria andExpodateIn(List<Date> values) {
            addCriterion("expoDate in", values, "expodate");
            return (Criteria) this;
        }

        public Criteria andExpodateNotIn(List<Date> values) {
            addCriterion("expoDate not in", values, "expodate");
            return (Criteria) this;
        }

        public Criteria andExpodateBetween(Date value1, Date value2) {
            addCriterion("expoDate between", value1, value2, "expodate");
            return (Criteria) this;
        }

        public Criteria andExpodateNotBetween(Date value1, Date value2) {
            addCriterion("expoDate not between", value1, value2, "expodate");
            return (Criteria) this;
        }

        public Criteria andExponumIsNull() {
            addCriterion("expoNum is null");
            return (Criteria) this;
        }

        public Criteria andExponumIsNotNull() {
            addCriterion("expoNum is not null");
            return (Criteria) this;
        }

        public Criteria andExponumEqualTo(Integer value) {
            addCriterion("expoNum =", value, "exponum");
            return (Criteria) this;
        }

        public Criteria andExponumNotEqualTo(Integer value) {
            addCriterion("expoNum <>", value, "exponum");
            return (Criteria) this;
        }

        public Criteria andExponumGreaterThan(Integer value) {
            addCriterion("expoNum >", value, "exponum");
            return (Criteria) this;
        }

        public Criteria andExponumGreaterThanOrEqualTo(Integer value) {
            addCriterion("expoNum >=", value, "exponum");
            return (Criteria) this;
        }

        public Criteria andExponumLessThan(Integer value) {
            addCriterion("expoNum <", value, "exponum");
            return (Criteria) this;
        }

        public Criteria andExponumLessThanOrEqualTo(Integer value) {
            addCriterion("expoNum <=", value, "exponum");
            return (Criteria) this;
        }

        public Criteria andExponumIn(List<Integer> values) {
            addCriterion("expoNum in", values, "exponum");
            return (Criteria) this;
        }

        public Criteria andExponumNotIn(List<Integer> values) {
            addCriterion("expoNum not in", values, "exponum");
            return (Criteria) this;
        }

        public Criteria andExponumBetween(Integer value1, Integer value2) {
            addCriterion("expoNum between", value1, value2, "exponum");
            return (Criteria) this;
        }

        public Criteria andExponumNotBetween(Integer value1, Integer value2) {
            addCriterion("expoNum not between", value1, value2, "exponum");
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

        public Criteria andExpodescIsNull() {
            addCriterion("expoDesc is null");
            return (Criteria) this;
        }

        public Criteria andExpodescIsNotNull() {
            addCriterion("expoDesc is not null");
            return (Criteria) this;
        }

        public Criteria andExpodescEqualTo(String value) {
            addCriterion("expoDesc =", value, "expodesc");
            return (Criteria) this;
        }

        public Criteria andExpodescNotEqualTo(String value) {
            addCriterion("expoDesc <>", value, "expodesc");
            return (Criteria) this;
        }

        public Criteria andExpodescGreaterThan(String value) {
            addCriterion("expoDesc >", value, "expodesc");
            return (Criteria) this;
        }

        public Criteria andExpodescGreaterThanOrEqualTo(String value) {
            addCriterion("expoDesc >=", value, "expodesc");
            return (Criteria) this;
        }

        public Criteria andExpodescLessThan(String value) {
            addCriterion("expoDesc <", value, "expodesc");
            return (Criteria) this;
        }

        public Criteria andExpodescLessThanOrEqualTo(String value) {
            addCriterion("expoDesc <=", value, "expodesc");
            return (Criteria) this;
        }

        public Criteria andExpodescLike(String value) {
            addCriterion("expoDesc like", value, "expodesc");
            return (Criteria) this;
        }

        public Criteria andExpodescNotLike(String value) {
            addCriterion("expoDesc not like", value, "expodesc");
            return (Criteria) this;
        }

        public Criteria andExpodescIn(List<String> values) {
            addCriterion("expoDesc in", values, "expodesc");
            return (Criteria) this;
        }

        public Criteria andExpodescNotIn(List<String> values) {
            addCriterion("expoDesc not in", values, "expodesc");
            return (Criteria) this;
        }

        public Criteria andExpodescBetween(String value1, String value2) {
            addCriterion("expoDesc between", value1, value2, "expodesc");
            return (Criteria) this;
        }

        public Criteria andExpodescNotBetween(String value1, String value2) {
            addCriterion("expoDesc not between", value1, value2, "expodesc");
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