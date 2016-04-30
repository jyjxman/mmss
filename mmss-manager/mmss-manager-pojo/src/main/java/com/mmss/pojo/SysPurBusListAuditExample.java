package com.mmss.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysPurBusListAuditExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysPurBusListAuditExample() {
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

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userId is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userId is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(String value) {
            addCriterion("userId =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(String value) {
            addCriterion("userId <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(String value) {
            addCriterion("userId >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(String value) {
            addCriterion("userId >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(String value) {
            addCriterion("userId <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(String value) {
            addCriterion("userId <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLike(String value) {
            addCriterion("userId like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotLike(String value) {
            addCriterion("userId not like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<String> values) {
            addCriterion("userId in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<String> values) {
            addCriterion("userId not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(String value1, String value2) {
            addCriterion("userId between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(String value1, String value2) {
            addCriterion("userId not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andListidIsNull() {
            addCriterion("listId is null");
            return (Criteria) this;
        }

        public Criteria andListidIsNotNull() {
            addCriterion("listId is not null");
            return (Criteria) this;
        }

        public Criteria andListidEqualTo(String value) {
            addCriterion("listId =", value, "listid");
            return (Criteria) this;
        }

        public Criteria andListidNotEqualTo(String value) {
            addCriterion("listId <>", value, "listid");
            return (Criteria) this;
        }

        public Criteria andListidGreaterThan(String value) {
            addCriterion("listId >", value, "listid");
            return (Criteria) this;
        }

        public Criteria andListidGreaterThanOrEqualTo(String value) {
            addCriterion("listId >=", value, "listid");
            return (Criteria) this;
        }

        public Criteria andListidLessThan(String value) {
            addCriterion("listId <", value, "listid");
            return (Criteria) this;
        }

        public Criteria andListidLessThanOrEqualTo(String value) {
            addCriterion("listId <=", value, "listid");
            return (Criteria) this;
        }

        public Criteria andListidLike(String value) {
            addCriterion("listId like", value, "listid");
            return (Criteria) this;
        }

        public Criteria andListidNotLike(String value) {
            addCriterion("listId not like", value, "listid");
            return (Criteria) this;
        }

        public Criteria andListidIn(List<String> values) {
            addCriterion("listId in", values, "listid");
            return (Criteria) this;
        }

        public Criteria andListidNotIn(List<String> values) {
            addCriterion("listId not in", values, "listid");
            return (Criteria) this;
        }

        public Criteria andListidBetween(String value1, String value2) {
            addCriterion("listId between", value1, value2, "listid");
            return (Criteria) this;
        }

        public Criteria andListidNotBetween(String value1, String value2) {
            addCriterion("listId not between", value1, value2, "listid");
            return (Criteria) this;
        }

        public Criteria andAuditinfoIsNull() {
            addCriterion("auditInfo is null");
            return (Criteria) this;
        }

        public Criteria andAuditinfoIsNotNull() {
            addCriterion("auditInfo is not null");
            return (Criteria) this;
        }

        public Criteria andAuditinfoEqualTo(String value) {
            addCriterion("auditInfo =", value, "auditinfo");
            return (Criteria) this;
        }

        public Criteria andAuditinfoNotEqualTo(String value) {
            addCriterion("auditInfo <>", value, "auditinfo");
            return (Criteria) this;
        }

        public Criteria andAuditinfoGreaterThan(String value) {
            addCriterion("auditInfo >", value, "auditinfo");
            return (Criteria) this;
        }

        public Criteria andAuditinfoGreaterThanOrEqualTo(String value) {
            addCriterion("auditInfo >=", value, "auditinfo");
            return (Criteria) this;
        }

        public Criteria andAuditinfoLessThan(String value) {
            addCriterion("auditInfo <", value, "auditinfo");
            return (Criteria) this;
        }

        public Criteria andAuditinfoLessThanOrEqualTo(String value) {
            addCriterion("auditInfo <=", value, "auditinfo");
            return (Criteria) this;
        }

        public Criteria andAuditinfoLike(String value) {
            addCriterion("auditInfo like", value, "auditinfo");
            return (Criteria) this;
        }

        public Criteria andAuditinfoNotLike(String value) {
            addCriterion("auditInfo not like", value, "auditinfo");
            return (Criteria) this;
        }

        public Criteria andAuditinfoIn(List<String> values) {
            addCriterion("auditInfo in", values, "auditinfo");
            return (Criteria) this;
        }

        public Criteria andAuditinfoNotIn(List<String> values) {
            addCriterion("auditInfo not in", values, "auditinfo");
            return (Criteria) this;
        }

        public Criteria andAuditinfoBetween(String value1, String value2) {
            addCriterion("auditInfo between", value1, value2, "auditinfo");
            return (Criteria) this;
        }

        public Criteria andAuditinfoNotBetween(String value1, String value2) {
            addCriterion("auditInfo not between", value1, value2, "auditinfo");
            return (Criteria) this;
        }

        public Criteria andAudittypeIsNull() {
            addCriterion("auditType is null");
            return (Criteria) this;
        }

        public Criteria andAudittypeIsNotNull() {
            addCriterion("auditType is not null");
            return (Criteria) this;
        }

        public Criteria andAudittypeEqualTo(String value) {
            addCriterion("auditType =", value, "audittype");
            return (Criteria) this;
        }

        public Criteria andAudittypeNotEqualTo(String value) {
            addCriterion("auditType <>", value, "audittype");
            return (Criteria) this;
        }

        public Criteria andAudittypeGreaterThan(String value) {
            addCriterion("auditType >", value, "audittype");
            return (Criteria) this;
        }

        public Criteria andAudittypeGreaterThanOrEqualTo(String value) {
            addCriterion("auditType >=", value, "audittype");
            return (Criteria) this;
        }

        public Criteria andAudittypeLessThan(String value) {
            addCriterion("auditType <", value, "audittype");
            return (Criteria) this;
        }

        public Criteria andAudittypeLessThanOrEqualTo(String value) {
            addCriterion("auditType <=", value, "audittype");
            return (Criteria) this;
        }

        public Criteria andAudittypeLike(String value) {
            addCriterion("auditType like", value, "audittype");
            return (Criteria) this;
        }

        public Criteria andAudittypeNotLike(String value) {
            addCriterion("auditType not like", value, "audittype");
            return (Criteria) this;
        }

        public Criteria andAudittypeIn(List<String> values) {
            addCriterion("auditType in", values, "audittype");
            return (Criteria) this;
        }

        public Criteria andAudittypeNotIn(List<String> values) {
            addCriterion("auditType not in", values, "audittype");
            return (Criteria) this;
        }

        public Criteria andAudittypeBetween(String value1, String value2) {
            addCriterion("auditType between", value1, value2, "audittype");
            return (Criteria) this;
        }

        public Criteria andAudittypeNotBetween(String value1, String value2) {
            addCriterion("auditType not between", value1, value2, "audittype");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createtime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createtime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createtime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createtime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createtime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createtime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createtime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createtime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createtime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createtime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createtime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createtime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
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