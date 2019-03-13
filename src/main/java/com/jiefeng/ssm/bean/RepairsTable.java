package com.jiefeng.ssm.bean;

import java.util.Date;

public class RepairsTable {
    private Integer id;

    private String repairDesc;

    private String submitNumber;

    private String repairNumber;

    private Integer status;

    private Integer repairStatus;

    private Integer assessment;

    private Date createTime;

    private String repairAddress;

    private String imageUrl;

    private Date  endTime;


    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

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

    public String getSubmitNumber() {
        return submitNumber;
    }

    public void setSubmitNumber(String submitNumber) {
        this.submitNumber = submitNumber == null ? null : submitNumber.trim();
    }

    public String getRepairNumber() {
        return repairNumber;
    }

    public void setRepairNumber(String repairNumber) {
        this.repairNumber = repairNumber == null ? null : repairNumber.trim();
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRepairAddress() {
        return repairAddress;
    }

    public void setRepairAddress(String repairAddress) {
        this.repairAddress = repairAddress == null ? null : repairAddress.trim();
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl == null ? null : imageUrl.trim();
    }

    @Override
    public String toString() {
        return "RepairsTable{" +
                "id=" + id +
                ", repairDesc='" + repairDesc + '\'' +
                ", submitNumber='" + submitNumber + '\'' +
                ", repairNumber='" + repairNumber + '\'' +
                ", status=" + status +
                ", repairStatus=" + repairStatus +
                ", assessment=" + assessment +
                ", createTime=" + createTime +
                ", repairAddress='" + repairAddress + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}