package com.enigmacamp.simplejpa.repository;

public class SearchCriteria {

    private String key;
    private CriteriaOperation operation;
    private Object value;

    public SearchCriteria(String key, CriteriaOperation operation, Object value) {
        this.key = key;
        this.operation = operation;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public CriteriaOperation getOperation() {
        return operation;
    }

    public void setOperation(CriteriaOperation operation) {
        this.operation = operation;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
