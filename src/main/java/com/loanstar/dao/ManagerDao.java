package com.loanstar.dao;

import com.loanstar.entity.Manager;

import java.util.List;
import java.util.Map;

public interface ManagerDao {

    /**
     * 查询所有Manager
     * @return
     */
    public List<Manager> getManagerAll(Map<String,Object> map);

    /**
     * 根据ID 删除
     * @param manager_id 根据 manager_id 进行删除
     */
    public void deleteManager(int manager_id);

    /**
     * 根据ID 修改
     * @param manager 传入对象
     */
    public void updateManager(Manager manager);

    /**
     * 添加一个服务机构
     * @param manager
     */
    public void addManager(Manager manager);

    /**
     * 根据manager_id查询administrator_id
     * @param manager_id
     * @return administrator_id
     */
    public int getAdmini_idByManager(int manager_id);

    /**
     * 查询管理表一共多少条数据
     * @return 多少条数据
     */
    public int getManagerCount();
}
