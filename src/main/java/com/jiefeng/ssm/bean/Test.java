package com.jiefeng.ssm.bean;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@JsonIgnoreProperties(value = {"handler"})
public class Test implements Serializable {

  private Integer id;
  private String title;
  private String testDesc;
  private boolean status;
  private User teacherId;
  private Course course;
  private List<Integer> classList;
  private String videoUrl;


}
