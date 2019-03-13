package com.jiefeng.ssm.bean;

public class Student extends BaseRole {
    private Integer id;

    private Login login;

    private String number;

    private String name;

    private String department;

    private String studentClass;

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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass == null ? null : studentClass.trim();
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", login=" + login +
                ", number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", studentClass='" + studentClass + '\'' +
                '}';
    }
}