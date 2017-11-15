package com.loanstar.dao;

import com.loanstar.entity.Permission;
import com.loanstar.entity.Role;

import java.util.List;
import java.util.Map;

public interface RoleDao {
    /**
     * 查询所有角色（模糊查询）
     * @param map
     * @return
     * @Author 李小娟
     */
    public List<Role> getRoleAll(Map<String,Object> map);

    /**
     * 查询所有角色描述
     * @return
     * @Author 李小娟
     */
    public List<String> getRoleDescribes();

    /**
     * 查询角色表总页数
     * @return
     * @Author 李小娟
     */
    public int getRolePage(Map<String,Object> map);


    /**
     * 根据角色编号删除编号
     * @param role_id
     * @Author 李小娟
     */
    public void deleteRole(int role_id);


    /**
     * 查询角色下面的所有人员
     * @return
     * @Author 李小娟
     */
    public Role getRoleNumber(int role_id);


    /**
     * 查询权限表中所有权限名
     * @return
     * @Author 李小娟
     */
    public List<String> getPermissionNames();

}
