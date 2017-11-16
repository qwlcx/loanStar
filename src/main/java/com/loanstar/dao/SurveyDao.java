package com.loanstar.dao;

import com.loanstar.entity.Survey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 信息调研表DAO层
 */
public interface SurveyDao {

    /**
     * 添加信息
     * @param survey
     */
    public void addSurvey(Survey survey);


    /**
     * 查询所有的
     * @param pageNum
     * @param pageSize
     * @return
     */
    public List<Survey> getSurveySelect(@Param(value = "pageNum") int pageNum, @Param(value = "pageSize") int pageSize);

    /**
     *
     * @return
     */
    public int getSize(@Param(value = "id") int id);


    /**
     * 根据id查询调研信息
     * @param pageNum
     * @param pageSize
     * @param id
     * @return
     */
    public List<Survey> getSurveyById(@Param(value = "pageNum") int pageNum, @Param(value = "pageSize") int pageSize, @Param(value = "id") int id);
}
