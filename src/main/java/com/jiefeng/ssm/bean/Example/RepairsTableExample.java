package com.jiefeng.ssm.bean.Example;

import java.util.ArrayList;
import java.util.List;

public class RepairsTableExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RepairsTableExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andRepairDescIsNull() {
            addCriterion("repair_desc is null");
            return (Criteria) this;
        }

        public Criteria andRepairDescIsNotNull() {
            addCriterion("repair_desc is not null");
            return (Criteria) this;
        }

        public Criteria andRepairDescEqualTo(String value) {
            addCriterion("repair_desc =", value, "repairDesc");
            return (Criteria) this;
        }

        public Criteria andRepairDescNotEqualTo(String value) {
            addCriterion("repair_desc <>", value, "repairDesc");
            return (Criteria) this;
        }

        public Criteria andRepairDescGreaterThan(String value) {
            addCriterion("repair_desc >", value, "repairDesc");
            return (Criteria) this;
        }

        public Criteria andRepairDescGreaterThanOrEqualTo(String value) {
            addCriterion("repair_desc >=", value, "repairDesc");
            return (Criteria) this;
        }

        public Criteria andRepairDescLessThan(String value) {
            addCriterion("repair_desc <", value, "repairDesc");
            return (Criteria) this;
        }

        public Criteria andRepairDescLessThanOrEqualTo(String value) {
            addCriterion("repair_desc <=", value, "repairDesc");
            return (Criteria) this;
        }

        public Criteria andRepairDescLike(String value) {
            addCriterion("repair_desc like", value, "repairDesc");
            return (Criteria) this;
        }

        public Criteria andRepairDescNotLike(String value) {
            addCriterion("repair_desc not like", value, "repairDesc");
            return (Criteria) this;
        }

        public Criteria andRepairDescIn(List<String> values) {
            addCriterion("repair_desc in", values, "repairDesc");
            return (Criteria) this;
        }

        public Criteria andRepairDescNotIn(List<String> values) {
            addCriterion("repair_desc not in", values, "repairDesc");
            return (Criteria) this;
        }

        public Criteria andRepairDescBetween(String value1, String value2) {
            addCriterion("repair_desc between", value1, value2, "repairDesc");
            return (Criteria) this;
        }

        public Criteria andRepairDescNotBetween(String value1, String value2) {
            addCriterion("repair_desc not between", value1, value2, "repairDesc");
            return (Criteria) this;
        }

        public Criteria andSubmitNumberIsNull() {
            addCriterion("submit_number is null");
            return (Criteria) this;
        }

        public Criteria andSubmitNumberIsNotNull() {
            addCriterion("submit_number is not null");
            return (Criteria) this;
        }

        public Criteria andSubmitNumberEqualTo(Integer value) {
            addCriterion("submit_number =", value, "submitNumber");
            return (Criteria) this;
        }

        public Criteria andSubmitNumberNotEqualTo(Integer value) {
            addCriterion("submit_number <>", value, "submitNumber");
            return (Criteria) this;
        }

        public Criteria andSubmitNumberGreaterThan(Integer value) {
            addCriterion("submit_number >", value, "submitNumber");
            return (Criteria) this;
        }

        public Criteria andSubmitNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("submit_number >=", value, "submitNumber");
            return (Criteria) this;
        }

        public Criteria andSubmitNumberLessThan(Integer value) {
            addCriterion("submit_number <", value, "submitNumber");
            return (Criteria) this;
        }

        public Criteria andSubmitNumberLessThanOrEqualTo(Integer value) {
            addCriterion("submit_number <=", value, "submitNumber");
            return (Criteria) this;
        }

        public Criteria andSubmitNumberIn(List<Integer> values) {
            addCriterion("submit_number in", values, "submitNumber");
            return (Criteria) this;
        }

        public Criteria andSubmitNumberNotIn(List<Integer> values) {
            addCriterion("submit_number not in", values, "submitNumber");
            return (Criteria) this;
        }

        public Criteria andSubmitNumberBetween(Integer value1, Integer value2) {
            addCriterion("submit_number between", value1, value2, "submitNumber");
            return (Criteria) this;
        }

        public Criteria andSubmitNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("submit_number not between", value1, value2, "submitNumber");
            return (Criteria) this;
        }

        public Criteria andRepairNumberIsNull() {
            addCriterion("repair_number is null");
            return (Criteria) this;
        }

        public Criteria andRepairNumberIsNotNull() {
            addCriterion("repair_number is not null");
            return (Criteria) this;
        }

        public Criteria andRepairNumberEqualTo(Integer value) {
            addCriterion("repair_number =", value, "repairNumber");
            return (Criteria) this;
        }

        public Criteria andRepairNumberNotEqualTo(Integer value) {
            addCriterion("repair_number <>", value, "repairNumber");
            return (Criteria) this;
        }

        public Criteria andRepairNumberGreaterThan(Integer value) {
            addCriterion("repair_number >", value, "repairNumber");
            return (Criteria) this;
        }

        public Criteria andRepairNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("repair_number >=", value, "repairNumber");
            return (Criteria) this;
        }

        public Criteria andRepairNumberLessThan(Integer value) {
            addCriterion("repair_number <", value, "repairNumber");
            return (Criteria) this;
        }

        public Criteria andRepairNumberLessThanOrEqualTo(Integer value) {
            addCriterion("repair_number <=", value, "repairNumber");
            return (Criteria) this;
        }

        public Criteria andRepairNumberIn(List<Integer> values) {
            addCriterion("repair_number in", values, "repairNumber");
            return (Criteria) this;
        }

        public Criteria andRepairNumberNotIn(List<Integer> values) {
            addCriterion("repair_number not in", values, "repairNumber");
            return (Criteria) this;
        }

        public Criteria andRepairNumberBetween(Integer value1, Integer value2) {
            addCriterion("repair_number between", value1, value2, "repairNumber");
            return (Criteria) this;
        }

        public Criteria andRepairNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("repair_number not between", value1, value2, "repairNumber");
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

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andRepairStatusIsNull() {
            addCriterion("repair_status is null");
            return (Criteria) this;
        }

        public Criteria andRepairStatusIsNotNull() {
            addCriterion("repair_status is not null");
            return (Criteria) this;
        }

        public Criteria andRepairStatusEqualTo(Integer value) {
            addCriterion("repair_status =", value, "repairStatus");
            return (Criteria) this;
        }

        public Criteria andRepairStatusNotEqualTo(Integer value) {
            addCriterion("repair_status <>", value, "repairStatus");
            return (Criteria) this;
        }

        public Criteria andRepairStatusGreaterThan(Integer value) {
            addCriterion("repair_status >", value, "repairStatus");
            return (Criteria) this;
        }

        public Criteria andRepairStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("repair_status >=", value, "repairStatus");
            return (Criteria) this;
        }

        public Criteria andRepairStatusLessThan(Integer value) {
            addCriterion("repair_status <", value, "repairStatus");
            return (Criteria) this;
        }

        public Criteria andRepairStatusLessThanOrEqualTo(Integer value) {
            addCriterion("repair_status <=", value, "repairStatus");
            return (Criteria) this;
        }

        public Criteria andRepairStatusIn(List<Integer> values) {
            addCriterion("repair_status in", values, "repairStatus");
            return (Criteria) this;
        }

        public Criteria andRepairStatusNotIn(List<Integer> values) {
            addCriterion("repair_status not in", values, "repairStatus");
            return (Criteria) this;
        }

        public Criteria andRepairStatusBetween(Integer value1, Integer value2) {
            addCriterion("repair_status between", value1, value2, "repairStatus");
            return (Criteria) this;
        }

        public Criteria andRepairStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("repair_status not between", value1, value2, "repairStatus");
            return (Criteria) this;
        }

        public Criteria andAssessmentIsNull() {
            addCriterion("assessment is null");
            return (Criteria) this;
        }

        public Criteria andAssessmentIsNotNull() {
            addCriterion("assessment is not null");
            return (Criteria) this;
        }

        public Criteria andAssessmentEqualTo(Integer value) {
            addCriterion("assessment =", value, "assessment");
            return (Criteria) this;
        }

        public Criteria andAssessmentNotEqualTo(Integer value) {
            addCriterion("assessment <>", value, "assessment");
            return (Criteria) this;
        }

        public Criteria andAssessmentGreaterThan(Integer value) {
            addCriterion("assessment >", value, "assessment");
            return (Criteria) this;
        }

        public Criteria andAssessmentGreaterThanOrEqualTo(Integer value) {
            addCriterion("assessment >=", value, "assessment");
            return (Criteria) this;
        }

        public Criteria andAssessmentLessThan(Integer value) {
            addCriterion("assessment <", value, "assessment");
            return (Criteria) this;
        }

        public Criteria andAssessmentLessThanOrEqualTo(Integer value) {
            addCriterion("assessment <=", value, "assessment");
            return (Criteria) this;
        }

        public Criteria andAssessmentIn(List<Integer> values) {
            addCriterion("assessment in", values, "assessment");
            return (Criteria) this;
        }

        public Criteria andAssessmentNotIn(List<Integer> values) {
            addCriterion("assessment not in", values, "assessment");
            return (Criteria) this;
        }

        public Criteria andAssessmentBetween(Integer value1, Integer value2) {
            addCriterion("assessment between", value1, value2, "assessment");
            return (Criteria) this;
        }

        public Criteria andAssessmentNotBetween(Integer value1, Integer value2) {
            addCriterion("assessment not between", value1, value2, "assessment");
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