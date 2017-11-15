package com.loanstar.controller;

import com.loanstar.dao.FinancialDao;
import com.loanstar.entity.Financial;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class FinancialController {
    @Autowired
    private FinancialDao financialDao;

    @RequestMapping(value = "addFinancial")
    public String addFinancial(Financial financial){
        //添加一个金融机构
        financialDao.addFinancial(financial);
        return "index";
    }

    @RequestMapping(value = "getFianacial")
    public String getFianacial(Integer offset, Integer limit, HttpServletRequest request, HttpServletResponse response){
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


        System.out.println("pageNo:" + offset + ",pageSize:" + limit);

        List<Financial> financialList=financialDao.getFinancial(map);

        int total=financialDao.getFinancialCount();
        JSONArray jsonArray=JSONArray.fromObject(financialList);
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

        return "index";
    }

    @RequestMapping(value = "deleteFinancial")
    public String deleteFinancial(HttpServletRequest request, HttpServletResponse response){

        String financial_id=request.getParameter("fid");
        financialDao.deleteFinancial(Integer.parseInt(financial_id));
        return "index";
    }

    @RequestMapping(value = "updateFinancial")
    public String updateFinancial(HttpServletRequest request, HttpServletResponse response){
        String financial_id=request.getParameter("fid");
        String financial_institution_number=request.getParameter("financial_institution_number");
        String financial_name=request.getParameter("financial_name");
        String financial_telphone=request.getParameter("financial_telphone");
        String financial_remark=request.getParameter("financial_remark");

        Financial financial=new Financial(Integer.parseInt(financial_id),financial_institution_number,financial_name,financial_telphone,financial_remark);
        financialDao.updateFinancial(financial);
        return "index";
    }
}
