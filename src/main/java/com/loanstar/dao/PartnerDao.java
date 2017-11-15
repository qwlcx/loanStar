package com.loanstar.dao;
;
import com.loanstar.dto.PartnerDto;
import com.loanstar.entity.Administrator;
import com.loanstar.entity.Partner;

import java.util.List;
import java.util.Map;

public interface PartnerDao {

    /**
     * 联表（FA表，角色表，机构表，部门表）查询
     * @return PartnerDto
     * @Author 李小娟
     */
    public List<PartnerDto> getPartAll(Map<String,Object> map);


    /**
     * 联表（FA表，角色表，机构表，部门表）查询总页数
     * @return 总页数
     * @Author 李小娟
     */
    public int getPartPage(Map<String,Object> map);


    /**
     * FA若是被冻结，则激活，相反，则被冻结
     * @param map
     * @Author 李小娟
     */
    public void djChange(Map<String,Object> map);


    /**
     * 当点击冻结（激活）时，改变管理员表中的账号状态
     * @param map
     * @Author 李小娟
     */
    public void updateDj(Map<String,Object> map);


    /**
     * 根据FA编号查询管理员账号
     * @param partner_id
     * @return
     * @Author 李小娟
     */
    public String getAdministrator_character(int partner_id);

    /**
     * 根据FA（贷款合作商）ID删除相对应的贷款合作商
     * @param partner_id
     * @Author 李小娟
     */
    public void deletePartner(int partner_id);


    /**
     * 添加贷款合作商
     * @param partner
     * @Author 李小娟
     */
    public void addPartner(Partner partner);

    /**
     * 根据角色名找到角色编号
     * @param role_name
     * @return Int
     * @Author 李小娟
     */
    public int getRole_id(String role_name);


    /**
     * 根据机构名查询机构编号
     * @param facility_orgization_name
     * @return
     * @Author 李小娟
     */
    public int getFacility_id(String facility_orgization_name);


    /**
     * 根据部门名字找到该部门编号
     * @param department_industry_title
     * @return
     * @Author 李小娟
     */
    public int getDepartment_id(String department_industry_title);


    /**
     * 查询所有角色名
     * @return
     * @Author 李小娟
     */
    public List<String> getRoleNames();


    /**
     * 查询机构表中所有机构名
     * @return
     * @Author 李小娟
     */
    public List<String> getFacilityNames();


    /**
     * 查询FA中所有FA的名字
     * @return
     * @Author 李小娟
     */
    public List<String> getPartnerNames();


    /**
     * 查询机构名当FA机构编号等于机构表机构编号
     * @return
     * @Author 李小娟
     */
    public List<String> getPartnerFacilityNames();

    /**
     * 查询所有部门名
     * @return
     * @Author 李小娟
     */
    public List<String> getDepartmentNames();


    /**
     * 添加管理员
     * @param administrator
     * @Author 李小娟
     */
    public void addAdministrator(Administrator administrator);


    /**
     * 查询所有登录账号
     * @return
     * @Author 李小娟
     */
    public Administrator getAdministrator(String administrator_character);


    /**
     * 根据部门名称查询部门数量
     * @param department_industry_title
     * @return
     * @Author 李小娟
     */
    public int getDepartment_number_quantity(String department_industry_title);


    /**
     * 根据部门名称修改部门人员数量
     * @param map
     * @Author 李小娟
     */
    public void updateDepartment_number_quantity(Map<String,Object> map);

    /**
     * 根据管理员账号删除该管理员
     * @param administrator_character
     * @Author 李小娟
     */
    public void deleteAdministrator(String administrator_character);


    /**
     * 根据FA编号修改FA信息
     * @param partner
     * @Author 李小娟
     */
    public void updatePartner(Partner partner);


    /**
     * 根据管理员账号修改管理员姓名
     * @param map
     * @Author 李小娟
     */
    public void updateAdministratorName(Map<String,Object> map);


    /**
     * 根据FA编号查询到部门编号
     * @param partner_id
     * @return
     * @Author 李小娟
     */
    public int getDepartmentidByPartner_id(int partner_id);


    /**
     * 根据部门编号查询部门名称
     * @param departmentId
     * @return
     */
    public String getDepartmentNameByDepartmentid(int departmentId);


    /**
     * 根据部门编号修改部门人员数量
     * @param map
     */
    public void updateDepartment_number_quantity2(Map<String,Object> map);


}


