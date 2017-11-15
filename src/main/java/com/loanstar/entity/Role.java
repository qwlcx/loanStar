package com.loanstar.entity;

import java.util.Set;

public class Role {
    private int role_id;//角色ID
    private String role_name;//角色名称
    private String role_describe;//角色描述
    private Set<Manager> managers;//人员管理表



    public Role() {
    }

    public Role(String role_name, String role_describe) {
        this.role_name = role_name;
        this.role_describe = role_describe;
    }

    public Role(int role_id, String role_name, String role_describe) {
        this.role_id = role_id;
        this.role_name = role_name;
        this.role_describe = role_describe;
    }

    public Set<Manager> getManagers() {
        return managers;
    }

    public void setManagers(Set<Manager> managers) {
        this.managers = managers;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public String getRole_describe() {
        return role_describe;
    }

    public void setRole_describe(String role_describe) {
        this.role_describe = role_describe;
    }

    @Override
    public String toString() {
        return "Role{" +
                "role_id=" + role_id +
                ", role_name='" + role_name + '\'' +
                ", role_describe='" + role_describe + '\'' +
                '}';
    }
}
