package com.loanstar.controller;

import com.loanstar.dao.A_RDao;
import com.loanstar.dao.AdministratorDao;
import com.loanstar.dao.PartnerDao;
import com.loanstar.dto.PartnerDto;
import com.loanstar.entity.A_R;
import com.loanstar.entity.Administrator;
import com.loanstar.entity.Partner;
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
public class PartnerController {

    @Autowired
    private PartnerDao partnerDao;
    @Autowired
    private A_RDao a_rDao;
    @Autowired
    private AdministratorDao administratorDao;


    @RequestMapping("addPart")
    public String addPart(HttpServletRequest request, HttpServletResponse response){
        try {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //账号
        String partner_character=request.getParameter("partner_character");
        //负责人
        String partner_name=request.getParameter("partner_name");
        //地址
        String partner_address=request.getParameter("partner_address");
        //联系电话
        String partner_telphone=request.getParameter("partner_telphone");
        //时间
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date=new Date();
        String partner_time=sdf.format(date);
        //角色Id
        String role_name=request.getParameter("role_name");//角色
        Integer role_id=partnerDao.getRole_id(role_name);
        //机构Id
        String facility_orgization_name=request.getParameter("facility_orgization_name");//机构名称
        Integer facility_id=partnerDao.getFacility_id(facility_orgization_name);
        //部门Id
        String department_industry_title=request.getParameter("department_industry_title");//部门名称
        Integer department_id=partnerDao.getDepartment_id(department_industry_title);


        //根据管理员账号得到该管理员
        Administrator ad=partnerDao.getAdministrator(partner_character);
        if(ad==null){
            //查询部门人员数量
            int department_number_quantity=partnerDao.getDepartment_number_quantity(department_industry_title);
            //修改部门人员数量
            Map<String,Object> map=new HashMap<String,Object>();
            map.put("department_number_quantity",department_number_quantity+1);
            map.put("department_industry_title",department_industry_title);
            partnerDao.updateDepartment_number_quantity(map);


            //添加管理员
            Administrator administrator=new Administrator(partner_character,partner_time,partner_name);
            partnerDao.addAdministrator(administrator);

            //添加FA
            Partner partner=new Partner(partner_time,partner_character,partner_name,partner_address,partner_telphone,facility_id,role_id,department_id);
            partnerDao.addPartner(partner);

            //管理员编号
            Integer administrator_id = administratorDao.getAdministrator_id(partner_character);
            A_R a_r=new A_R(administrator_id,role_id);
            a_rDao.addA_R(a_r);

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

        return "partner";
    }



    @RequestMapping("getRoleNames")
    @ResponseBody
    public List<String> getRoleNames(){
        List<String> roleNames=partnerDao.getRoleNames();
        return  roleNames;
    }

    @RequestMapping("getFacilityNames")
    @ResponseBody
    public List<String> getFacilityNames(){
        List<String> facilityNames=partnerDao.getFacilityNames();
        return  facilityNames;
    }

    @RequestMapping("getDepartmentNames")
    @ResponseBody
    public List<String> getDepartmentNames(){
        List<String> departmentNames=partnerDao.getDepartmentNames();
        return  departmentNames;
    }

    @RequestMapping("getPartnerFacilityNames")
    @ResponseBody
    public List<String> getPartnerFacilityNames(){
        List<String> partnerFacilityNames=partnerDao.getPartnerFacilityNames();
        return  partnerFacilityNames;
    }

    @RequestMapping("getPartnerNames")
    @ResponseBody
    public List<String> getPartnerNames(){
        List<String> partnerNames=partnerDao.getPartnerNames();
        return  partnerNames;
    }


    @RequestMapping("getPartnerAll")
    public String getPartnerAll(Integer offset,Integer limit,String txt_search_departmentname,String txt_search_statu,HttpServletRequest request, HttpServletResponse response){
        try {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("pageNo",offset);
        map.put("pageSize",limit);
        map.put("facility_orgization_name",txt_search_statu);
        map.put("partner_name",txt_search_departmentname);
        List<PartnerDto> partnerDtos=partnerDao.getPartAll(map);
        int total=partnerDao.getPartPage(map);
        JSONArray jsonArray=JSONArray.fromObject(partnerDtos);
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
        return "partner";
    }



    @RequestMapping("upPartDj")
    public String upPartDj(String pdj,Integer pid){
        String isDj="";
        if ("冻结".equals(pdj)){
            isDj="激活";
        }else {
            isDj="冻结";
        }
        //管理员登录账号
        String partner_character=partnerDao.getAdministrator_character(pid);
        Map<String,Object> map1=new HashMap<String, Object>();
        map1.put("administrator_character",partner_character);
        map1.put("administrator_state",isDj);

        Map<String,Object> map=new HashMap<String,Object>();
        map.put("partner_sate",isDj);
        map.put("partner_id",pid);

        //FA表中修改状态
        partnerDao.djChange(map);
        //管理员表中修改账号状态
        partnerDao.updateDj(map1);
        return "partner";
    }



    @RequestMapping("deletep")
    public String deletep(Integer pid,String dtitle,HttpServletRequest request, HttpServletResponse response){
        try {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //根据FA编号查询到管理员账号
        String partner_character=partnerDao.getAdministrator_character(pid);
        //根据管理员账号删除该管理员
        partnerDao.deleteAdministrator(partner_character);
        //根据FA编号删除该FA
        partnerDao.deletePartner(pid);

        int department_number_quantity=partnerDao.getDepartment_number_quantity(dtitle);
        //修改部门人员数量
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("department_number_quantity",department_number_quantity-1);
        map.put("department_industry_title",dtitle);
        partnerDao.updateDepartment_number_quantity(map);

        try {
            PrintWriter pw=response.getWriter();
            pw.write("成功");
            pw.close();
            pw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "partner";
    }


    @RequestMapping("upPartner")
    public String upPartner(HttpServletRequest request, HttpServletResponse response){
        try {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //FA编号
        Integer partner_id=Integer.parseInt(request.getParameter("parId"));
        //FA负责人
        String partner_name=request.getParameter("partner_name");
        //FA办公地址
        String partner_address=request.getParameter("partner_address");
        //FA电话
        String partner_telphone=request.getParameter("partner_telphone");
        //FA所属角色
        String role_name=request.getParameter("role_name");
        Integer role_id=partnerDao.getRole_id(role_name);
        //FA所属机构
        String facility_orgization_name=request.getParameter("facility_orgization_name");
        Integer facility_id=partnerDao.getFacility_id(facility_orgization_name);
        //FA所属部门
        String department_industry_title=request.getParameter("department_industry_title");
        Integer department_id=partnerDao.getDepartment_id(department_industry_title);
        //FA登录账号
        String partner_character=request.getParameter("partner_character");

        //根据界面传过来的FA编号查询原部门编号
        Integer depar_id=partnerDao.getDepartmentidByPartner_id(partner_id);

        //修改FA信息
        Partner partner=new Partner(partner_id,partner_name,partner_address,partner_telphone,role_id,facility_id,department_id);
        partnerDao.updatePartner(partner);

        //修改管理员姓名
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("administrator_name",partner_name);
        map.put("administrator_character",partner_character);
        partnerDao.updateAdministratorName(map);


        //根据原部门编号查询原部门名称
        String depar_name=partnerDao.getDepartmentNameByDepartmentid(depar_id);
        //根据原部门名称查询原部门人员数量
        int department_number_quantity=partnerDao.getDepartment_number_quantity(depar_name);
        //修改原部门人员数量（减一）
        Map<String,Object> map1=new HashMap<String, Object>();
        map1.put("department_number_quantity",department_number_quantity-1);
        map1.put("department_industry_title",depar_name);
        partnerDao.updateDepartment_number_quantity(map1);

        //根据现部门名称查询原部门人员数量
        int department_number_quantity2=partnerDao.getDepartment_number_quantity(department_industry_title);

        //修改现部门人员数量（加一）
        Map<String,Object> map2=new HashMap<String, Object>();
        map2.put("department_number_quantity",department_number_quantity2+1);
        map2.put("department_id",department_id);
        partnerDao.updateDepartment_number_quantity2(map2);

        try {
            PrintWriter pw=response.getWriter();
            pw.write("成功");
            pw.close();
            pw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "partner";
    }

}
