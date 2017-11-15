package com.loanstar.controller;

import com.loanstar.dao.FacilityDao;
import com.loanstar.dao.ManagerDao;
import com.loanstar.entity.Facility;
import com.loanstar.entity.Manager;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class FacilityController {

    @Autowired
    public FacilityDao facilityDao;

    @RequestMapping("deletef")
    public String deleteFacility(Integer fid,HttpServletRequest request,HttpServletResponse response){
        try {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
       Facility facility=facilityDao.getManagerByFacility_id(fid);
        if(facility==null){
            facilityDao.deleteFacility(fid);
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
        return "facility";
    }

    @RequestMapping("getFacilityAll")
    public String getFacilityAll(String txt_search_statu,String txt_search_departmentname,Integer offset,Integer limit,HttpServletRequest request,HttpServletResponse response){
        try {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("pageNo",offset);
        map.put("pageSize",limit);
        map.put("facility_type",txt_search_statu);
        map.put("facility_orgization_name",txt_search_departmentname);
        List<Facility> facilities=facilityDao.getFacilityAll(map);
        JSONArray jsonArray=JSONArray.fromObject(facilities);
        JSONObject jsonObject=new JSONObject();
        int allPage=facilityDao.getPageAll(map);
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
        return "facility";
    }


    @RequestMapping("addFacility")
    public String addFacility(Facility facility,HttpServletRequest request,HttpServletResponse response){
        try {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date=new Date();
        String str=sdf.format(date);
        facility.setFacility_time(str);
        Facility facility1=facilityDao.getFacility(facility.getFacility_orgization_name());
        if(facility1==null){
            facilityDao.addFacility(facility);
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
        return "facility";
    }


    @RequestMapping("upFacility")
    public String upFacility(HttpServletRequest request,HttpServletResponse response){
        String ftime=request.getParameter("ftime");
        String ftype=request.getParameter("ftype");
        String foname=request.getParameter("foname");
        String fname=request.getParameter("fname");
        String floc=request.getParameter("floc");
        Integer fid=Integer.parseInt(request.getParameter("fid"));
        Facility facility=new Facility(fid,ftime,ftype,foname,floc,fname);
        System.out.println(facility.toString());
        facilityDao.updateFacility(facility);
        return "facility";
    }




}
