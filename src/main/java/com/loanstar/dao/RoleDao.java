package com.loanstar.dao;

import com.loanstar.entity.Permission;
import com.loanstar.entity.Role;

import java.util.List;
import java.util.Map;

public interface RoleDao {
    /**
     * 查询所有的角色
     * @return 所有的角色
     */
    public List<Role> getRoleManager();

    /**
     * 两表查询总页数
     * @return 总页数
     */
    public int getRoleManagerCount();

    /**
     * 根据角色名称查询角色ID
     * @param role_name 角色名称
     * @return 角色ID
     */
    public int getRole_idByRole_name(String role_name);

    /**
     * 根据角色ID 查询角色名称
     * @param role_id 根据角色ID
     * @return 返回角色名称
     */
    public String getRole_nameByRole_id(int role_id);

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
