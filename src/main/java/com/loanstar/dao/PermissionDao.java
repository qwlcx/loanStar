package com.loanstar.dao;

import com.loanstar.entity.Permission;

import java.util.List;

public interface PermissionDao {

    /**
     * 根据角色编号查询到当下角色所有权限编号（集合）
     * @return
     * @Author 李小娟
     */
    public List<Integer> getPermission_id(int role_id);

    /**
     * 根据权限编号查询当下角色的所有权限
     * @param permission_id
     * @return
     * @Author 李小娟
     */
    public Permission getPermissionRole(int permission_id);
}
