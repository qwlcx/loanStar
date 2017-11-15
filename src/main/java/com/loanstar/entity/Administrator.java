package com.loanstar.entity;

import java.util.Date;

public class Administrator {
    private int administrator_id;//管理员ID
    private String administrator_character;//管理员账号
    private String administrator_password;//管理员密码
    private String administrator_register_time;//管理员注册时间
    private String administrator_name;//管理员姓名
    private String administrator_state;//管理员账号状态

    public Administrator(String administrator_character, String administrator_register_time, String administrator_name) {
        this.administrator_character = administrator_character;
        this.administrator_register_time = administrator_register_time;
        this.administrator_name = administrator_name;
    }

    public Administrator() {
    }

    public Administrator(String administrator_character, String administrator_password) {
        this.administrator_character = administrator_character;
        this.administrator_password = administrator_password;
    }

    public Administrator(int administrator_id, String administrator_character, String administrator_password, String administrator_register_time, String administrator_name, String administrator_state) {
        this.administrator_id = administrator_id;
        this.administrator_character = administrator_character;
        this.administrator_password = administrator_password;
        this.administrator_register_time = administrator_register_time;
        this.administrator_name = administrator_name;
        this.administrator_state = administrator_state;
    }

    public int getAdministrator_id() {
        return administrator_id;
    }

    public void setAdministrator_id(int administrator_id) {
        this.administrator_id = administrator_id;
    }

    public String getAdministrator_character() {
        return administrator_character;
    }

    public void setAdministrator_character(String administrator_character) {
        this.administrator_character = administrator_character;
    }

    public String getAdministrator_password() {
        return administrator_password;
    }

    public void setAdministrator_password(String administrator_password) {
        this.administrator_password = administrator_password;
    }

    public String getAdministrator_register_time() {
        return administrator_register_time;
    }

    public void setAdministrator_register_time(String administrator_register_time) {
        this.administrator_register_time = administrator_register_time;
    }

    public String getAdministrator_name() {
        return administrator_name;
    }

    public void setAdministrator_name(String administrator_name) {
        this.administrator_name = administrator_name;
    }

    public String getAdministrator_state() {
        return administrator_state;
    }

    public void setAdministrator_state(String administrator_state) {
        this.administrator_state = administrator_state;
    }

}
