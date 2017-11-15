package com.loanstar.dao;

import com.loanstar.entity.Administrator;

import java.util.Map;

public interface AdministratorDao {

    /**
     * 添加一个管理员
     * @param administrator 传进去一个对象
     */
    public void addAdministrator(Administrator administrator);

    /**
     * 根据管理员账号查询管理员ID
     * @param administrator_character 管理员账号
     * @return 管理员ID
     */
    public int getAdministratorByAdministrator_character(String administrator_character);

    /**
     * 删除一个管理员
     * @param administrator_id 管理员ID
     *
     */
    public void deleteAdministrator(int administrator_id);

    /**
     * 修改管理员密码
     * @param map
     */
    public void upPass(Map<String,Object> map);

    /**
     * 后台管理员登录
     * @param administrator
     * @return  Administrator对象
     * @Author 李小娟
     */
    public Administrator administratorLogin(Administrator administrator);


    /**
     * 根据管理员账号得到管理员姓名
     * @param administrator_character
     * @return 管理员姓名
     * @Author 李小娟
     */
    public String getAdministrator_name(String administrator_character);


    /**
     * 根据管理员账号得到管理员编号
     * @param administrator_character
     * @return
     * @Author 李小娟
     */
    public int getAdministrator_id(String administrator_character);

    /**
     * 根据账号查询角色（FA贷款合作商）
     * @param administrator_character
     * @return
     * @Author 李小娟
     */
    public Integer getRoleByCharacter1(String administrator_character);




    /**
     * 根据账号查询角色（人员管理）
     * @param administrator_character
     * @return
     * @Author 李小娟
     */
    public Integer getRoleByCharacter2(String administrator_character);

    /**
     * 根据角色编号找到角色名称
     * @param role_id
     * @return
     * @Author 李小娟
     */
    public String getRoleName(Integer role_id);

    /**
     * 根据角色编号找到角色名称
     * @param role_id
     * @return
     * @Author 李小娟
     */
    public String getRoleName2(Integer role_id);
}
