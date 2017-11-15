package com.loanstar.entity;

import java.util.Set;

public class Department {
    private int department_id;//部门ID
    private String department_time;//部门添加时间
    private String department_industry_title;//部门名称
    private int department_number_quantity;//部门人员数量
    private String department_name;//添加人姓名
    private Set<Manager> managers2;

    public Department() {
    }
    public Department(String department_industry_title, int department_number_quantity) {
        this.department_industry_title = department_industry_title;
        this.department_number_quantity = department_number_quantity;
    }

    public Department(String department_time, String department_industry_title, String department_name) {
        this.department_time = department_time;
        this.department_industry_title = department_industry_title;
        this.department_name = department_name;
    }

    public Set<Manager> getManagers2() {
        return managers2;
    }

    public void setManagers2(Set<Manager> managers2) {
        this.managers2 = managers2;
    }

    public Department(String department_time, String department_industry_title, int department_number_quantity, String department_name) {
        this.department_time = department_time;
        this.department_industry_title = department_industry_title;
        this.department_number_quantity = department_number_quantity;
        this.department_name = department_name;
    }


    public Department(int department_id, String department_time, String department_industry_title, int department_number_quantity, String department_name) {
        this.department_id = department_id;
        this.department_time = department_time;
        this.department_industry_title = department_industry_title;
        this.department_number_quantity = department_number_quantity;
        this.department_name = department_name;
    }


    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public String getDepartment_time() {
        return department_time;
    }

    public void setDepartment_time(String department_time) {
        this.department_time = department_time;
    }

    public String getDepartment_industry_title() {
        return department_industry_title;
    }

    public void setDepartment_industry_title(String department_industry_title) {
        this.department_industry_title = department_industry_title;
    }

    public int getDepartment_number_quantity() {
        return department_number_quantity;
    }

    public void setDepartment_number_quantity(int department_number_quantity) {
        this.department_number_quantity = department_number_quantity;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

}
