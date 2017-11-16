package com.loanstar.dao;


import com.loanstar.entity.Applicants;
import org.apache.ibatis.annotations.Param;

/**
 * 申请人信用信息简表DAO
 */
public interface ApplicantsDao {
    /**
     * 添加数据
     * @param applicants
     */
    public void addApplicants(Applicants applicants);

    /**
     * 根据名字查询申请次数
     * @param name
     * @return
     */
    public Integer selectApplicantsSize(@Param(value = "name") String name);

    /**
     * 修改次数
     * @param number
     */
    public void updateNumber(@Param(value = "name") String name, @Param(value = "number") int number);
}
