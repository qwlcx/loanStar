package com.loanstar.entity;

public class Manager {
    private int manager_id;//人员管理ID
    private String manager_register_time;//管理员添加时间
    private String manager_character;//管理员账号
    private String manager_name;//管理员姓名
    private String manager_state;//人员状态
    private int facility_id;//所属机构ID
    private int role_id;//所属角色ID
    private int administrator_id;//管理员ID
    private int department_id;//部门ID

    public Manager() {
    }

    public Manager(String manager_register_time, String manager_character, String manager_name, int administrator_id, int role_id, int facility_id) {
        this.manager_register_time = manager_register_time;
        this.manager_character = manager_character;
        this.manager_name = manager_name;
        this.administrator_id = administrator_id;
        this.role_id = role_id;
        this.facility_id = facility_id;
    }

    public Manager(int administrator_id, String manager_register_time, String manager_character, String manager_name, int facility_id, int role_id, int department_id) {
        this.administrator_id = administrator_id;
        this.manager_register_time = manager_register_time;
        this.manager_character = manager_character;
        this.manager_name = manager_name;
        this.facility_id = facility_id;
        this.role_id = role_id;
        this.department_id = department_id;
    }

    public Manager(int manager_id, String manager_state) {
        this.manager_id = manager_id;
        this.manager_state = manager_state;
    }

    public Manager(String manager_register_time, String manager_character, String manager_name, String manager_state, int facility_id, int role_id, int administrator_id) {
        this.manager_register_time = manager_register_time;
        this.manager_character = manager_character;
        this.manager_name = manager_name;
        this.manager_state = manager_state;
        this.facility_id = facility_id;
        this.role_id = role_id;
        this.administrator_id = administrator_id;
    }

    public Manager(int manager_id, String manager_register_time, String manager_character, String manager_name, String manager_state, int facility_id, int role_id, int administrator_id) {
        this.manager_id = manager_id;
        this.manager_register_time = manager_register_time;
        this.manager_character = manager_character;
        this.manager_name = manager_name;
        this.manager_state = manager_state;
        this.facility_id = facility_id;
        this.role_id = role_id;
        this.administrator_id = administrator_id;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
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

    public int getFacility_id() {
        return facility_id;
    }

    public void setFacility_id(int facility_id) {
        this.facility_id = facility_id;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public int getAdministrator_id() {
        return administrator_id;
    }

    public void setAdministrator_id(int administrator_id) {
        this.administrator_id = administrator_id;
    }

}
