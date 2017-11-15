package com.loanstar.dao;


import com.loanstar.entity.Financial;

import java.util.List;
import java.util.Map;

public interface FinancialDao {
    /**
     * 添加一个金融机构
     * @param financial
     */
    public void addFinancial(Financial financial);

    /**
     * 查询所有金融机构(分页)
     * @return 所有金融机构
     */
    public List<Financial> getFinancial(Map<String, Object> map);

    /**
     * 查询所有金融机构(不分页)
     * @return 所有金融机构
     */
    public List<Financial> getFinancialAll();

    /**
     * 根据服务ID删除服务机构
     * @param financial_id 根据服务ID
     */
    public void deleteFinancial(int financial_id);

    /**
     * 根据ID修改服务机构的各种信息
     * @param financial 服务机构的参数
     */
    public void updateFinancial(Financial financial);

    public String getFinancial_institution_numberByFinanical_id(int financial_id);

    /**
     * 查询服务机构的总条数
     * @return 总条数
     */
    public int getFinancialCount();
}
