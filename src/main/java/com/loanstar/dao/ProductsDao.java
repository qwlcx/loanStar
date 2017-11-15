package com.loanstar.dao;

import com.loanstar.entity.Products;

import java.util.List;
import java.util.Map;

public interface ProductsDao {
    /**
     * 添加一个金融产品
     * @param products
     */
    public void addProducts(Products products);

    /**
     * 查询所有金融产品
     * @return 所有金融产品
     */
    public List<Products> getProducts(Map<String, Object> map);

    /**
     * 删除一个金融产品
     * @param products_id 根据金融产品ID
     */
    public void deleteProducts(int products_id);

    /**
     * 修改一个金融产品
     * @param products 修改的信息(根据ID修改)
     */
    public void updateProducts(Products products);

    /**
     * 查询所有金融产品的条数
     * @return
     */
    public int getProductsCount();
}
