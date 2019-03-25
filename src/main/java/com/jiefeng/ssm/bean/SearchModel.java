package com.jiefeng.ssm.bean;

import lombok.Data;

@Data
public class SearchModel {
    private Integer id;
    private String name;
    private SearchModel children;

}
