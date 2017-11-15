package com.loanstar.entity;

public class A_R {
    private int administrator_id;//管理员编号
    private int role_id;//角色编号

    public A_R() {
    }

    public A_R(int administrator_id, int role_id) {
        this.administrator_id = administrator_id;
        this.role_id = role_id;
    }

    public int getAdministrator_id() {
        return administrator_id;
    }

    public void setAdministrator_id(int administrator_id) {
        this.administrator_id = administrator_id;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }
}
