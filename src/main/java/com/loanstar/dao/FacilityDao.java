package com.loanstar.dao;

import com.loanstar.entity.Facility;
import com.loanstar.entity.Manager;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface FacilityDao {
    /**
     * 查询所有的服务机构
     * @return 所有的服务机构
     */
    public List<Facility> getFacilityManager();

    /**
     * 根据服务机构的名称查询到ID
     * @param facility_orgization_name 服务机构名称
     * @return 服务机构ID
     */
    public int getFacility_idByFacility_orgization_name(String facility_orgization_name);

    /**
     * 根据服务ID查询服务类型
     * @param facility_id
     * @return 服务类型
     */
    public String getFacility_typeByFacility_id(int facility_id);

    /**
     * 根据服务ID查询服务名称
     * @param facility_id 根据服务ID
     * @return 返回服务名称
     */
    public String getFinancial_institution_numberByFacility_id(int facility_id);

    /**
     * 服务机构的添加
     * @param facility
     * @Author 李小娟
     */
    public void addFacility(Facility facility);

    /**
     * 查询所有服务机构
     * @return List<Facility>
     * @Author 李小娟
     */
    public List<Facility> getFacilityAll(Map<String, Object> map);

    /**
     * 查询服务机构总页数
     * @return 总页数
     * @Author 李小娟
     */
    public int getPageAll(Map<String,Object> map);


    /**
     * 根据服务机构ID删除服务机构
     * @param facility_id
     * @Author 李小娟
     */
    public void deleteFacility(int facility_id);


    /**
     * 根据服务机构编号修改机构
     * @param facility
     * @Author 李小娟
     */
    public void updateFacility(Facility facility);


    /**
     * 根据服务机构编号查询该服务机构下的所有人员
     * @param facility_id
     * @return 部门集合
     * @Author 李小娟
     */
    public Facility getManagerByFacility_id(int facility_id);

    /**
     * 根据机构名称查询机构对象
     * @param facility_orgization_name
     * @return
     * @Author 李小娟
     */
    public Facility getFacility(String facility_orgization_name);


}
