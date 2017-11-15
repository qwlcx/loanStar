package com.loanstar.dto;

public class FacilityManager {
    private int manager_id;//管理员ID
    private String manager_register_time;//管理员注册时间
    private String manager_character;//管理员账号
    private String manager_name;//管理员姓名
    private String facility_type;//所属机构
    private String manager_state;//状态

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

    public String getFacility_type() {
        return facility_type;
    }

    public void setFacility_type(String facility_type) {
        this.facility_type = facility_type;
    }

    public String getManager_state() {
        return manager_state;
    }

    public void setManager_state(String manager_state) {
        this.manager_state = manager_state;
    }

    public FacilityManager() {

    }

    public FacilityManager(String manager_register_time, String manager_character, String manager_name, String facility_type, String manager_state) {
        this.manager_register_time = manager_register_time;
        this.manager_character = manager_character;
        this.manager_name = manager_name;
        this.facility_type = facility_type;
        this.manager_state = manager_state;
    }

    public FacilityManager(int manager_id, String manager_register_time, String manager_character, String manager_name, String facility_type, String manager_state) {
        this.manager_id = manager_id;
        this.manager_register_time = manager_register_time;
        this.manager_character = manager_character;
        this.manager_name = manager_name;
        this.facility_type = facility_type;
        this.manager_state = manager_state;
    }
}
