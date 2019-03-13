package com.jiefeng.ssm.bean;

public class Manager extends BaseRole{

    private Integer id;

    private Login login;

    private String name;

    private String number;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", login=" + login +
                ", name='" + name + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}