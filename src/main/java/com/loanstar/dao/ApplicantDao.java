package com.loanstar.dao;

import com.loanstar.entity.Applicant;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ApplicantDao {

    /**
     * 分页查询所有申请贷款用户基本信息
     * @param pageNum
     * @param pageSize
     * @return
     */
    public List<Applicant> getApplicantController(@Param(value = "pageNum") int pageNum, @Param(value = "pageSize") int pageSize);

    /**
     * 查询有多少条申请贷款用户信息
     * @return
     */
    public int getSize();

    /**
     * 申请贷款用户基本信息增加
     * @param applicant
     */
    public void addApplocant(Applicant applicant);

    /**
     * 根据名字查询所有信息
     * @param pageNum
     * @param pageSize
     * @param name  名字
     * @return
     */
    public List<Applicant> getApplicantControllerName(@Param(value = "pageNum") int pageNum, @Param(value = "pageSize") int pageSize, @Param(value = "name") String name);

    /**
     * 根据名字查询该用户有多少条数据
     * @return
     */
    public int getSizeName(@Param(value = "name") String name);


    /**
     * 根据流水号修改状态
     * @param state
     * @param applicant_serial_number
     */
    public void updateState(@Param(value = "state") String state, @Param(value = "applicant_serial_number") String applicant_serial_number);


    /**
     * 查询待调研所有信息
     * @param pageNum
     * @param pageSize
     *
     * @return
     */
    public List<Applicant> getApplicantControllerState1(@Param(value = "pageNum") int pageNum, @Param(value = "pageSize") int pageSize);

    /**
     * 根据状态查询该用户有多少条数据
     * @return
     */
    public int getSizeState1();


    /**
     * 根据申请人信息ID查询申请人
     * @param id
     * @return
     */
    public Applicant selectById(@Param(value = "id") int id);


    /**
     * 根据申请人流水号查询申请人
     * @param number  流水号
     * @return
     */
    public Applicant selectByNumber(@Param(value = "number") String number);



    /**
     * 查询待复审所有信息
     * @param pageNum
     * @param pageSize
     *
     * @return
     */
    public List<Applicant> getApplicantControllerState2(@Param(value = "pageNum") int pageNum, @Param(value = "pageSize") int pageSize);

    /**
     * 根据状态查询该用户有多少条数据
     * @return
     */
    public int getSizeState2();


    /**
     * 查询待授信所有信息
     * @param pageNum
     * @param pageSize
     *
     * @return
     */
    public List<Applicant> getApplicantControllerState3(@Param(value = "pageNum") int pageNum, @Param(value = "pageSize") int pageSize);

    /**
     * 根据状态查询该用户有多少条数据
     * @return
     */
    public int getSizeState3();


}
