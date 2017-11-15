package com.loanstar.dto;

public class RoleManager {
    private int manager_id;//管理员ID
    private String manager_register_time;//管理员注册时间
    private String manager_character;//管理员账号
    private String manager_name;//管理员姓名
    private String role_name;//所属角色
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

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public String getManager_state() {
        return manager_state;
    }

    public void setManager_state(String manager_state) {
        this.manager_state = manager_state;
    }

    public RoleManager() {

    }

    public RoleManager(String manager_register_time, String manager_character, String manager_name, String role_name, String manager_state) {
        this.manager_register_time = manager_register_time;
        this.manager_character = manager_character;
        this.manager_name = manager_name;
        this.role_name = role_name;
        this.manager_state = manager_state;
    }

    public RoleManager(int manager_id, String manager_register_time, String manager_character, String manager_name, String role_name, String manager_state) {
        this.manager_id = manager_id;
        this.manager_register_time = manager_register_time;
        this.manager_character = manager_character;
        this.manager_name = manager_name;
        this.role_name = role_name;
        this.manager_state = manager_state;
    }
}
