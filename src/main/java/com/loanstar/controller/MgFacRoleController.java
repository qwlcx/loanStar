package com.loanstar.controller;

import com.loanstar.dao.*;
import com.loanstar.dto.RoleFacilityManager;
import com.loanstar.entity.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.*;

@Controller
public class MgFacRoleController {

    @Autowired
    private RoleDao roleManagerDao;

    @Autowired
    private FacilityDao facilityManagerDao;

    @Autowired
    private ManagerDao managerDao;

    @Autowired
    private AdministratorDao administratorDao;

    @Autowired
    private DepartmentDao departmentDao;

    @Autowired
    private A_RDao a_rDao;

    @RequestMapping(value = "getRoleManagerFac")
    public String getRoleManagerFac(Integer offset, Integer limit, HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("pageNo", offset);
        map.put("pageSize", limit);

        //DTO (人员 服务机构 角色的dto)
        List<RoleFacilityManager> roleFacilityManagers = new ArrayList<RoleFacilityManager>();

        //获取Manager表里的所有数据
        List<Manager> managerList = managerDao.getManagerAll(map);
        for (Manager manager : managerList) {
            int manager_id = manager.getManager_id();
            String manager_register_time = manager.getManager_register_time();
            String manager_character = manager.getManager_character();
            String manager_name = manager.getManager_name();
            int facility_id = manager.getFacility_id();
            int administrator_id = manager.getAdministrator_id();
            int role_id = manager.getRole_id();
            int department_id = manager.getDepartment_id();
            String facility_type = facilityManagerDao.getFacility_typeByFacility_id(facility_id);
            String department_industry_title = departmentDao.getDepartment__industry_titleByDepartment_id(department_id);
            String role_name = roleManagerDao.getRole_nameByRole_id(role_id);
            String manager_state = manager.getManager_state();
            RoleFacilityManager roleFacilityManager = new RoleFacilityManager(role_id, manager_id, manager_register_time, manager_character, manager_name, manager_state, facility_type, role_name, department_industry_title);
            //将对象一个个循环放入集合中
            roleFacilityManagers.add(roleFacilityManager);
        }

        int total = managerDao.getManagerCount();

        JSONArray jsonArray = JSONArray.fromObject(roleFacilityManagers);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("rows", jsonArray);
        jsonObject.put("total", total);
        try {
            PrintWriter pw = response.getWriter();
            pw.write(jsonObject.toString());
            pw.close();
            pw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "MgFacRole";
    }

    @RequestMapping(value = "deleteRoleFacilityManager")
    public String deleteRoleFacilityManager(HttpServletRequest request, HttpServletResponse response){
        try {
            //将编码方式修改为UTF-8
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String manager_id=request.getParameter("fid");
        int administrator_id=managerDao.getAdmini_idByManager(Integer.parseInt(manager_id));
        administratorDao.deleteAdministrator(administrator_id);
        managerDao.deleteManager(Integer.parseInt(manager_id));
        return "MgFacRole";
    }

    @RequestMapping(value = "updateRoleFacilityManager")
    public String updateRoleFacilityManager(HttpServletRequest request, HttpServletResponse response){
        try {
            //将编码方式修改为UTF-8
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String manager_id=request.getParameter("manager_id");
        System.out.println(manager_id);
        String manager_state=request.getParameter("manager_state");
        System.out.println(manager_state);
        if(manager_state.equals("激活")){
            manager_state="冻结";
        }else{
            manager_state="激活";
        }

        Manager manager=new Manager(Integer.parseInt(manager_id),manager_state);

        managerDao.updateManager(manager);
        return "MgFacRole";
    }


    @RequestMapping(value = "selectRole_name")
    @ResponseBody
    public List<Role> selectRole_name(HttpServletRequest request, HttpServletResponse response){
        try {
            //将编码方式修改为UTF-8
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        List<Role> roleList=roleManagerDao.getRoleManager();
        return roleList;
    }

    @RequestMapping(value = "selectFacility_type")
    @ResponseBody
    public List<Facility> selectFacility_type(HttpServletRequest request, HttpServletResponse response){
        try {
            //将编码方式修改为UTF-8
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        List<Facility> facilityList=facilityManagerDao.getFacilityManager();
        return facilityList;
    }

    @RequestMapping(value = "selectDepartment_industry_title")
    @ResponseBody
    public List<Department> selectDepartment_industry_title(HttpServletRequest request, HttpServletResponse response){
        try {
            //将编码方式修改为UTF-8
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        List<Department> departments=departmentDao.getDepartment_industry_title();
        return departments;
    }

    @RequestMapping(value = "addRoleFacilityManager")
    public String addRoleFacilityManager(HttpServletRequest request, HttpServletResponse response){
        try {
            //将编码方式修改为UTF-8
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        String manager_register_time=request.getParameter("manager_register_time");
        String manager_character=request.getParameter("manager_character");
        String manager_name=request.getParameter("manager_name");
        String financial_telphone=request.getParameter("financial_telphone");
        String sel_staff7=request.getParameter("sel_staff7");
        String sel_staff8=request.getParameter("sel_staff8");
        String sel_staff9=request.getParameter("sel_staff9");


        int d=departmentDao.getDdepartment_number_quantityByDepartment_industry_title(sel_staff9);
        int department_number_quantity=d+1;

        Department department=new Department(sel_staff9,department_number_quantity);
        departmentDao.updateDepartment_number_quantity(department);
        int department_id=departmentDao.getDepartment_industry_titleByDepartment_id(sel_staff9);

        int role_id=roleManagerDao.getRole_idByRole_name(sel_staff7);

        int facility_id=facilityManagerDao.getFacility_idByFacility_orgization_name(sel_staff8);

        Administrator administrator=new Administrator(manager_character,manager_register_time,manager_name);
        administratorDao.addAdministrator(administrator);

        int administrator_id=administratorDao.getAdministratorByAdministrator_character(manager_character);

        Manager manager=new Manager(administrator_id,manager_register_time,manager_character,manager_name,facility_id,role_id,department_id);

        managerDao.addManager(manager);

        //管理员编号
        Integer administrator_id2 = administratorDao.getAdministrator_id(manager_character);
        A_R a_r=new A_R(administrator_id2,role_id);
        a_rDao.addA_R(a_r);



        return "MgFacRole";
    }

}
