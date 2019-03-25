package com.jiefeng.ssm.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonIgnoreProperties(value = {"handler"})
public class User implements Serializable {

  private Integer id;
  private String username;
  private String password;
  private String number;
  private String name;
  private Integer age;
  private Integer gender;
  private Integer type;
  private TbClass classId;

}
