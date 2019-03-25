package com.jiefeng.ssm.bean;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@JsonIgnoreProperties(value = {"handler"})
public class Comment  implements Serializable {

  private Integer id;
  private User acceptId;
  private String content;
  private Date createTime;
  private Test testId;
}
