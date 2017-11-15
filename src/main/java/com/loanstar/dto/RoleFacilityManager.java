package com.loanstar.dto;

public class RoleFacilityManager {
    private int role_id;//角色ID
    private int manager_id;//管理员ID
    private String manager_register_time;//管理员注册时间
    private String manager_character;//管理员账号
    private String manager_name;//管理员姓名
    private String manager_state;//状态
    private String facility_orgization_name;//所属机构
    private String role_name;//所属角色
    private String department_industry_title;//部门名称

    public RoleFacilityManager(int role_id, int manager_id, String manager_register_time, String manager_character, String manager_name, String manager_state, String facility_orgization_name, String role_name, String department_industry_title) {
        this.role_id = role_id;
        this.manager_id = manager_id;
        this.manager_register_time = manager_register_time;
        this.manager_character = manager_character;
        this.manager_name = manager_name;
        this.manager_state = manager_state;
        this.facility_orgization_name = facility_orgization_name;
        this.role_name = role_name;
        this.department_industry_title = department_industry_title;
    }

    public String getDepartment_industry_title() {
        return department_industry_title;
    }

    public void setDepartment_industry_title(String department_industry_title) {
        this.department_industry_title = department_industry_title;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getFacility_orgization_name() {
        return facility_orgization_name;
    }

    public void setFacility_orgization_name(String facility_orgization_name) {
        this.facility_orgization_name = facility_orgization_name;
    }

    @Override
    public String toString() {
        return "RoleFacilityManager{" +
                "manager_id=" + manager_id +
                ", manager_register_time='" + manager_register_time + '\'' +
                ", manager_character='" + manager_character + '\'' +
                ", manager_name='" + manager_name + '\'' +
                ", manager_state='" + manager_state + '\'' +
                ", facility_type='" + facility_orgization_name + '\'' +
                ", role_name='" + role_name + '\'' +
                '}';
    }

    public int getManager_id() {
        return manager_id;
    }

    public void setManager_id(int manager_id) {
        this.manager_id = manager_id;
    }

    public String getManager_register_time() {
        return manager_register_time;
    }

    public void setManager_register_time(String manager_register_time) {
        this.manager_register_time = manager_register_time;
    }

    public String getManager_character() {
        return manager_character;
    }

    public void setManager_character(String manager_character) {
        this.manager_character = manager_character;
    }

    public String getManager_name() {
        return manager_name;
    }

    public void setManager_name(String manager_name) {
        this.manager_name = manager_name;
    }

    public String getManager_state() {
        return manager_state;
    }

    public void setManager_state(String manager_state) {
        this.manager_state = manager_state;
    }

    public String getFacility_type() {
        return facility_orgization_name;
    }

    public void setFacility_type(String facility_type) {
        this.facility_orgization_name = facility_type;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public RoleFacilityManager() {

    }

    public RoleFacilityManager(int role_id,int manager_id, String manager_register_time, String manager_character, String manager_name, String manager_state, String facility_type, String role_name) {
        this.role_id = role_id;
        this.manager_id = manager_id;
        this.manager_register_time = manager_register_time;
        this.manager_character = manager_character;
        this.manager_name = manager_name;
        this.manager_state = manager_state;
        this.facility_orgization_name = facility_type;
        this.role_name = role_name;
    }
}
