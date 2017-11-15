package com.loanstar.dao;

import com.loanstar.entity.Facility;
import com.loanstar.entity.Manager;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface FacilityDao {
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
    /*public List<Facility> getFacilityAll(Facility facility);*/
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
