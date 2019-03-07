package com.jiefeng.ssm.bean;

public class RepairsTable {
    private Integer id;

    private String repairDesc;

    private Integer submitNumber;

    private Integer repairNumber;

    private Integer status;

    private Integer repairStatus;

    private Integer assessment;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRepairDesc() {
        return repairDesc;
    }

    public void setRepairDesc(String repairDesc) {
        this.repairDesc = repairDesc == null ? null : repairDesc.trim();
    }

    public Integer getSubmitNumber() {
        return submitNumber;
    }

    public void setSubmitNumber(Integer submitNumber) {
        this.submitNumber = submitNumber;
    }

    public Integer getRepairNumber() {
        return repairNumber;
    }

    public void setRepairNumber(Integer repairNumber) {
        this.repairNumber = repairNumber;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getRepairStatus() {
        return repairStatus;
    }

    public void setRepairStatus(Integer repairStatus) {
        this.repairStatus = repairStatus;
    }

    public Integer getAssessment() {
        return assessment;
    }

    public void setAssessment(Integer assessment) {
        this.assessment = assessment;
    }
}