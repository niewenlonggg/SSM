package com.jiefeng.ssm.bean;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonIgnoreProperties(value = {"handler"})
public class Course implements Serializable {

  private Integer id;
  private String courseName;
  private User teacher;
}
