package com.mmss.pojo;

import java.util.ArrayList;
import java.util.List;

public class SysRepositoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysRepositoryExample() {
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

        public Criteria andRepositoryNameIsNull() {
            addCriterion("repository_name is null");
            return (Criteria) this;
        }

        public Criteria andRepositoryNameIsNotNull() {
            addCriterion("repository_name is not null");
            return (Criteria) this;
        }

        public Criteria andRepositoryNameEqualTo(String value) {
            addCriterion("repository_name =", value, "repositoryName");
            return (Criteria) this;
        }

        public Criteria andRepositoryNameNotEqualTo(String value) {
            addCriterion("repository_name <>", value, "repositoryName");
            return (Criteria) this;
        }

        public Criteria andRepositoryNameGreaterThan(String value) {
            addCriterion("repository_name >", value, "repositoryName");
            return (Criteria) this;
        }

        public Criteria andRepositoryNameGreaterThanOrEqualTo(String value) {
            addCriterion("repository_name >=", value, "repositoryName");
            return (Criteria) this;
        }

        public Criteria andRepositoryNameLessThan(String value) {
            addCriterion("repository_name <", value, "repositoryName");
            return (Criteria) this;
        }

        public Criteria andRepositoryNameLessThanOrEqualTo(String value) {
            addCriterion("repository_name <=", value, "repositoryName");
            return (Criteria) this;
        }

        public Criteria andRepositoryNameLike(String value) {
            addCriterion("repository_name like", value, "repositoryName");
            return (Criteria) this;
        }

        public Criteria andRepositoryNameNotLike(String value) {
            addCriterion("repository_name not like", value, "repositoryName");
            return (Criteria) this;
        }

        public Criteria andRepositoryNameIn(List<String> values) {
            addCriterion("repository_name in", values, "repositoryName");
            return (Criteria) this;
        }

        public Criteria andRepositoryNameNotIn(List<String> values) {
            addCriterion("repository_name not in", values, "repositoryName");
            return (Criteria) this;
        }

        public Criteria andRepositoryNameBetween(String value1, String value2) {
            addCriterion("repository_name between", value1, value2, "repositoryName");
            return (Criteria) this;
        }

        public Criteria andRepositoryNameNotBetween(String value1, String value2) {
            addCriterion("repository_name not between", value1, value2, "repositoryName");
            return (Criteria) this;
        }

        public Criteria andRepositoryAddressIsNull() {
            addCriterion("repository_address is null");
            return (Criteria) this;
        }

        public Criteria andRepositoryAddressIsNotNull() {
            addCriterion("repository_address is not null");
            return (Criteria) this;
        }

        public Criteria andRepositoryAddressEqualTo(String value) {
            addCriterion("repository_address =", value, "repositoryAddress");
            return (Criteria) this;
        }

        public Criteria andRepositoryAddressNotEqualTo(String value) {
            addCriterion("repository_address <>", value, "repositoryAddress");
            return (Criteria) this;
        }

        public Criteria andRepositoryAddressGreaterThan(String value) {
            addCriterion("repository_address >", value, "repositoryAddress");
            return (Criteria) this;
        }

        public Criteria andRepositoryAddressGreaterThanOrEqualTo(String value) {
            addCriterion("repository_address >=", value, "repositoryAddress");
            return (Criteria) this;
        }

        public Criteria andRepositoryAddressLessThan(String value) {
            addCriterion("repository_address <", value, "repositoryAddress");
            return (Criteria) this;
        }

        public Criteria andRepositoryAddressLessThanOrEqualTo(String value) {
            addCriterion("repository_address <=", value, "repositoryAddress");
            return (Criteria) this;
        }

        public Criteria andRepositoryAddressLike(String value) {
            addCriterion("repository_address like", value, "repositoryAddress");
            return (Criteria) this;
        }

        public Criteria andRepositoryAddressNotLike(String value) {
            addCriterion("repository_address not like", value, "repositoryAddress");
            return (Criteria) this;
        }

        public Criteria andRepositoryAddressIn(List<String> values) {
            addCriterion("repository_address in", values, "repositoryAddress");
            return (Criteria) this;
        }

        public Criteria andRepositoryAddressNotIn(List<String> values) {
            addCriterion("repository_address not in", values, "repositoryAddress");
            return (Criteria) this;
        }

        public Criteria andRepositoryAddressBetween(String value1, String value2) {
            addCriterion("repository_address between", value1, value2, "repositoryAddress");
            return (Criteria) this;
        }

        public Criteria andRepositoryAddressNotBetween(String value1, String value2) {
            addCriterion("repository_address not between", value1, value2, "repositoryAddress");
            return (Criteria) this;
        }

        public Criteria andRepositoryAreaIsNull() {
            addCriterion("repository_area is null");
            return (Criteria) this;
        }

        public Criteria andRepositoryAreaIsNotNull() {
            addCriterion("repository_area is not null");
            return (Criteria) this;
        }

        public Criteria andRepositoryAreaEqualTo(Float value) {
            addCriterion("repository_area =", value, "repositoryArea");
            return (Criteria) this;
        }

        public Criteria andRepositoryAreaNotEqualTo(Float value) {
            addCriterion("repository_area <>", value, "repositoryArea");
            return (Criteria) this;
        }

        public Criteria andRepositoryAreaGreaterThan(Float value) {
            addCriterion("repository_area >", value, "repositoryArea");
            return (Criteria) this;
        }

        public Criteria andRepositoryAreaGreaterThanOrEqualTo(Float value) {
            addCriterion("repository_area >=", value, "repositoryArea");
            return (Criteria) this;
        }

        public Criteria andRepositoryAreaLessThan(Float value) {
            addCriterion("repository_area <", value, "repositoryArea");
            return (Criteria) this;
        }

        public Criteria andRepositoryAreaLessThanOrEqualTo(Float value) {
            addCriterion("repository_area <=", value, "repositoryArea");
            return (Criteria) this;
        }

        public Criteria andRepositoryAreaIn(List<Float> values) {
            addCriterion("repository_area in", values, "repositoryArea");
            return (Criteria) this;
        }

        public Criteria andRepositoryAreaNotIn(List<Float> values) {
            addCriterion("repository_area not in", values, "repositoryArea");
            return (Criteria) this;
        }

        public Criteria andRepositoryAreaBetween(Float value1, Float value2) {
            addCriterion("repository_area between", value1, value2, "repositoryArea");
            return (Criteria) this;
        }

        public Criteria andRepositoryAreaNotBetween(Float value1, Float value2) {
            addCriterion("repository_area not between", value1, value2, "repositoryArea");
            return (Criteria) this;
        }

        public Criteria andRepositoryDescIsNull() {
            addCriterion("repository_desc is null");
            return (Criteria) this;
        }

        public Criteria andRepositoryDescIsNotNull() {
            addCriterion("repository_desc is not null");
            return (Criteria) this;
        }

        public Criteria andRepositoryDescEqualTo(String value) {
            addCriterion("repository_desc =", value, "repositoryDesc");
            return (Criteria) this;
        }

        public Criteria andRepositoryDescNotEqualTo(String value) {
            addCriterion("repository_desc <>", value, "repositoryDesc");
            return (Criteria) this;
        }

        public Criteria andRepositoryDescGreaterThan(String value) {
            addCriterion("repository_desc >", value, "repositoryDesc");
            return (Criteria) this;
        }

        public Criteria andRepositoryDescGreaterThanOrEqualTo(String value) {
            addCriterion("repository_desc >=", value, "repositoryDesc");
            return (Criteria) this;
        }

        public Criteria andRepositoryDescLessThan(String value) {
            addCriterion("repository_desc <", value, "repositoryDesc");
            return (Criteria) this;
        }

        public Criteria andRepositoryDescLessThanOrEqualTo(String value) {
            addCriterion("repository_desc <=", value, "repositoryDesc");
            return (Criteria) this;
        }

        public Criteria andRepositoryDescLike(String value) {
            addCriterion("repository_desc like", value, "repositoryDesc");
            return (Criteria) this;
        }

        public Criteria andRepositoryDescNotLike(String value) {
            addCriterion("repository_desc not like", value, "repositoryDesc");
            return (Criteria) this;
        }

        public Criteria andRepositoryDescIn(List<String> values) {
            addCriterion("repository_desc in", values, "repositoryDesc");
            return (Criteria) this;
        }

        public Criteria andRepositoryDescNotIn(List<String> values) {
            addCriterion("repository_desc not in", values, "repositoryDesc");
            return (Criteria) this;
        }

        public Criteria andRepositoryDescBetween(String value1, String value2) {
            addCriterion("repository_desc between", value1, value2, "repositoryDesc");
            return (Criteria) this;
        }

        public Criteria andRepositoryDescNotBetween(String value1, String value2) {
            addCriterion("repository_desc not between", value1, value2, "repositoryDesc");
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