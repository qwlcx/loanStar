package com.loanstar.dao;


import com.loanstar.entity.HisApplicant;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 申请人历史信息表Dao层
 */
public interface HisApplicantDao {
    /**
     * 根据名字查询历史
     * @param pageNum
     * @param pageSize
     * @param name  名字
     * @return
     */
    public List<HisApplicant> getHisApplicantName(@Param(value = "pageNum") int pageNum, @Param(value = "pageSize") int pageSize, @Param(value = "name") String name);

    /**
     * 根据名字查询该用户有多少条数据
     * @return
     */
    public int getSizeName(@Param(value = "name") String name);


    /**
     * 添加历史
     * @param hisApplicant
     */
    public void addHisApplicant(HisApplicant hisApplicant);


}
