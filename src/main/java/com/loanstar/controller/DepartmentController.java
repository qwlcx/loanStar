package com.loanstar.controller;

import com.loanstar.dao.DepartmentDao;
import com.loanstar.entity.Department;
import com.loanstar.entity.Facility;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DepartmentController {
    @Autowired
    private DepartmentDao departmentDao;

    @RequestMapping("getDepartmentAll")
    public String getDepartmentAll(String d_txt_search_departmentname,String d_txt_search_statu,Integer offset, Integer limit, HttpServletRequest request, HttpServletResponse response){
        try {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("pageNo",offset);
        map.put("pageSize",limit);
        map.put("department_id",d_txt_search_statu);
        map.put("department_industry_title",d_txt_search_departmentname);
        List<Department> departments=departmentDao.getDepartmentAll(map);
        int allPage=departmentDao.getDepartmentPage(map);
        JSONArray jsonArray=JSONArray.fromObject(departments);
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("total",allPage);
        jsonObject.put("rows",jsonArray);
        try {
            PrintWriter pw=response.getWriter();
            pw.write(jsonObject.toString());
            pw.close();
            pw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "department";
    }


    @RequestMapping("deleteDep")
    public String deleteDep(Integer did,HttpServletRequest request,HttpServletResponse response){
        try {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Department department=departmentDao.getManagerByDepartment_id(did);
        if(department==null){
            departmentDao.deleteDep(did);
        }else {
            try {
                PrintWriter pw=response.getWriter();
                pw.write("失败");
                pw.close();
                pw.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "department";
    }


    @RequestMapping("upDep")
    public String upDep(HttpServletRequest request,HttpServletResponse response){
        String dtime=request.getParameter("dtime");
        String dtitle=request.getParameter("dtitle");
        Integer dnumber=Integer.parseInt(request.getParameter("dnumber"));
        String dname=request.getParameter("dname");
        Integer did=Integer.parseInt(request.getParameter("did"));
        Department department=new Department(did,dtime,dtitle,dnumber,dname);
        departmentDao.upDepartment(department);
        try {
            PrintWriter pw=response.getWriter();
            pw.write("成功");
            pw.close();
            pw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "department";
    }



    @RequestMapping("addDepartment")
    public String addDepartment(Department department,HttpServletRequest request,HttpServletResponse response){
        try {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date=new Date();
        String str=sdf.format(date);
        department.setDepartment_time(str);
        Department department1=departmentDao.getDepartment(department.getDepartment_industry_title());
        if(department1==null){
            departmentDao.addDepartment(department);
            try {
                PrintWriter pw=response.getWriter();
                pw.write("成功");
                pw.close();
                pw.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            try {
                PrintWriter pw=response.getWriter();
                pw.write("失败");
                pw.close();
                pw.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "department";
    }


}
