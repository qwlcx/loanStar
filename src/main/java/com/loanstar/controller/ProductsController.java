package com.loanstar.controller;

import com.loanstar.dao.FinancialDao;
import com.loanstar.dao.ProductsDao;
import com.loanstar.dto.ProductsFacility;
import com.loanstar.entity.Products;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ProductsController {
    @Autowired
    private ProductsDao productsDao;

    @Autowired
    private FinancialDao financialDao;

    @RequestMapping(value = "getProducts")
    public String getProducts(Integer offset, Integer limit, HttpServletRequest request, HttpServletResponse response){
        try {
            //将编码方式修改为UTF-8
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        Map<String,Object> map=new HashMap<String,Object>();
        map.put("pageNo",offset);
        map.put("pageSize",limit);

        List<Products> productsList=productsDao.getProducts(map);
        List<ProductsFacility> productsFacilities=new ArrayList<ProductsFacility>();
        for (Products p : productsList) {
            int products_id=p.getProducts_id();
            String products_time=p.getProducts_time();
            String products_name=p.getProducts_name();
            int facility_id=p.getFinancial_id();
            String financial_institution_number=financialDao.getFinancial_institution_numberByFinanical_id(facility_id);
            String products_online_payment=p.getProducts_online_payment();
            String products_payment_method=p.getProducts_payment_method();
            String products_state=p.getProducts_state();
            ProductsFacility productsFacility=new ProductsFacility(products_id,products_time,products_name,financial_institution_number,products_online_payment,products_payment_method,products_state);
            productsFacilities.add(productsFacility);
        }

        int total=productsDao.getProductsCount();

        JSONArray jsonArray=JSONArray.fromObject(productsFacilities);
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("rows",jsonArray);
        jsonObject.put("total",total);
        try {
            PrintWriter pw=response.getWriter();
            pw.write(jsonObject.toString());
            pw.close();
            pw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "products";
    }

    @RequestMapping(value = "deleteProducts")
    public String deleteProducts(HttpServletRequest request, HttpServletResponse response){

        System.out.println("jinlaile");

        return "products";
    }

    @RequestMapping(value = "updateProducts")
    public String updateProducts(HttpServletRequest request, HttpServletResponse response){
        String products_id=request.getParameter("fid");
        String products_name=request.getParameter("products_name");
        String products_payment_method=request.getParameter("products_payment_method");
        String products_online_payment=request.getParameter("products_online_payment");

        Products products=new Products(Integer.parseInt(products_id),products_name,products_online_payment,products_payment_method);
        productsDao.updateProducts(products);

        return "products";
    }
}
