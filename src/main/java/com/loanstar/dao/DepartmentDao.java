package com.loanstar.dao;

import com.loanstar.entity.Department;

import java.security.PublicKey;
import java.util.List;
import java.util.Map;

public interface DepartmentDao {

    /**
     * 查询所有部门
     * @param map
     * @return 部门集合
     * @Author 李小娟
     */
    public List<Department> getDepartmentAll(Map<String,Object> map);

    /**
     * 查询部门总页数
     * @return 部门总页数
     * @Authorl 李小娟
     */
    public int getDepartmentPage(Map<String,Object> map);


    /**
     * 添加部门
     * @param department
     * @Author 李小娟
     */
    public void addDepartment(Department department);


    /**
     * 根据部门ID删除改部门
     * @param department_id
     * @Author 李小娟
     */
    public void deleteDep(int department_id);


    /**
     * 根据部门编号查询改部门下的所有人员
     * @param department_id
     * @return 部门对象
     * @Author 李小娟
     */
    public Department getManagerByDepartment_id(int department_id);


    /**
     * 根据部门编号修改部门信息
     * @param department
     * @Author 李小娟
     */
    public void upDepartment(Department department);


    /**
     * 查询某部门下成员数量
     * @return
     * @Author 李小娟
     */
    public int getDepartmentNumber(int department_id);

    /**
     *  根据部门名称查询部门表中相对应的部门
     * @param department_industry_title
     * @return
     * @Author 李小娟
     */
    public Department getDepartment(String department_industry_title);


}
