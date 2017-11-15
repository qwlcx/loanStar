package com.loanstar.dao;

import com.loanstar.entity.Client;

import java.util.List;
import java.util.Map;

public interface ClientDao {
    /**
     * 分页查询所有客户信息
     * @param map
     * @return
     */
    public List<Client> getClientAll(Map<String, Object> map);

    /**
     * 查询客户的总条数
     * @return 查询到的总条数
     */
    public int getClientCount();

    /**
     * 根据ID删除
     * @param client_id 根据ID
     */
    public void deleteClient(int client_id);

    /**
     * 根据ID修改客户信息
     * @param client 根据客户信息
     * @return 客户信息
     */
    public void updateClient(Client client);
}
