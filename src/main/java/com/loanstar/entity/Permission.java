package com.loanstar.entity;

import java.util.Set;

public class Permission {
    private int permission_id;//权限ID
    private String permission_name;//权限名
    private String permission_state;//状态
    private String permission_url;//路径
    private String permission_ranke;//级别
    private String permission_type;//类型


    public Permission(int permission_id, String permission_name, String permission_state) {
        this.permission_id = permission_id;
        this.permission_name = permission_name;
        this.permission_state = permission_state;
    }

    public Permission() {
    }

    public Permission(String permission_name, String permission_state, String permission_url, String permission_ranke, String permission_type) {
        this.permission_name = permission_name;
        this.permission_state = permission_state;
        this.permission_url = permission_url;
        this.permission_ranke = permission_ranke;
        this.permission_type = permission_type;
    }

    public Permission(int permission_id, String permission_name, String permission_state, String permission_url, String permission_ranke, String permission_type) {
        this.permission_id = permission_id;
        this.permission_name = permission_name;
        this.permission_state = permission_state;
        this.permission_url = permission_url;
        this.permission_ranke = permission_ranke;
        this.permission_type = permission_type;
    }

    public int getPermission_id() {
        return permission_id;
    }

    public void setPermission_id(int permission_id) {
        this.permission_id = permission_id;
    }

    public String getPermission_name() {
        return permission_name;
    }

    public void setPermission_name(String permission_name) {
        this.permission_name = permission_name;
    }

    public String getPermission_state() {
        return permission_state;
    }

    public void setPermission_state(String permission_state) {
        this.permission_state = permission_state;
    }

    public String getPermission_url() {
        return permission_url;
    }

    public void setPermission_url(String permission_url) {
        this.permission_url = permission_url;
    }

    public String getPermission_ranke() {
        return permission_ranke;
    }

    public void setPermission_ranke(String permission_ranke) {
        this.permission_ranke = permission_ranke;
    }

    public String getPermission_type() {
        return permission_type;
    }

    public void setPermission_type(String permission_type) {
        this.permission_type = permission_type;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "permission_id=" + permission_id +
                ", permission_name='" + permission_name + '\'' +
                ", permission_state='" + permission_state + '\'' +
                ", permission_url='" + permission_url + '\'' +
                ", permission_ranke='" + permission_ranke + '\'' +
                ", permission_type='" + permission_type + '\'' +
                '}';
    }
}
