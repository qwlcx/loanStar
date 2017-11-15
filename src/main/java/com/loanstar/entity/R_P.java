package com.loanstar.entity;

public class R_P {
    private int permission_id;//权限编号
    private int role_id;//角色编号

    public R_P() {
    }

    public R_P(int permission_id, int role_id) {
        this.permission_id = permission_id;
        this.role_id = role_id;
    }

    public int getPermission_id() {
        return permission_id;
    }

    public void setPermission_id(int permission_id) {
        this.permission_id = permission_id;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }
}
