package com.jiefeng.ssm.bean;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@JsonIgnoreProperties(value = {"handler"})
public class Document implements Serializable {

  private Integer id;
  private String url;
  private User studentId;
  private Test testId;
  private Date createTime;


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public User getStudentId() {
    return studentId;
  }

  public void setStudentId(User studentId) {
    this.studentId = studentId;
  }

  public Test getTestId() {
    return testId;
  }

  public void setTestId(Test testId) {
    this.testId = testId;
  }

  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  @Override
  public String toString() {
    return "Document{" +
            "id=" + id +
            ", url='" + url + '\'' +
            ", studentId=" + studentId +
            ", testId=" + testId +
            ", createTime=" + createTime +
            '}';
  }
}
