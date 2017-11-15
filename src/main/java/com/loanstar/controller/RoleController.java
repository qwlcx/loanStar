package com.loanstar.controller;

import com.loanstar.dao.PartnerDao;
import com.loanstar.dao.PermissionDao;
import com.loanstar.dao.RoleDao;
import com.loanstar.entity.Permission;
import com.loanstar.entity.Role;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
public class RoleController {
    @Autowired
    private RoleDao roleDao;
    private PartnerDao partnerDao;

    @RequestMapping("getRoleAll")
    public String getRoleAll(String txt_search_statu,String txt_search_departmentname,Integer offset,Integer limit,HttpServletRequest request, HttpServletResponse response){
        try {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("pageNo",offset);
        map.put("pageSize",limit);
        map.put("role_describe",txt_search_statu);
        map.put("role_name",txt_search_departmentname);
        List<Role> roles=roleDao.getRoleAll(map);
        JSONObject jsonObject=new JSONObject();
        int allPage=roleDao.getRolePage(map);
        jsonObject.put("total",allPage);
        jsonObject.put("rows",roles);
        try {
            PrintWriter pw=response.getWriter();
            pw.write(jsonObject.toString());
            pw.close();
            pw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "role";
    }


    @RequestMapping("getRoleDescribes")
    @ResponseBody
    public List<String> getRoleDescribes(){
        List<String> roleDescribes=roleDao.getRoleDescribes();
        return roleDescribes;
    }



    @RequestMapping("deleteR")
    public String deleteR(Integer rid,HttpServletRequest request,HttpServletResponse response){
        try {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Role role=roleDao.getRoleNumber(rid);
        if (role==null){
            roleDao.deleteRole(rid);
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
        return "role";
    }



    @RequestMapping("getPermissionNames")
    @ResponseBody
    public List<String> getPermissionNames(){
        List<String> perminssionNames=roleDao.getPermissionNames();
        for (String perminssionName : perminssionNames) {
            System.out.println(perminssionName);
        }
        for (int i = 0; i < perminssionNames.size(); i++) {
            System.out.printf(perminssionNames.get(i));
        }
        return perminssionNames;
    }




    @RequestMapping("getRolePermissionAll")
    public String getRolePermissionAll(){
        return "role";
    }


    @Autowired
    private PermissionDao permissionDao;

    @RequestMapping(value = "getPermissionRole" , method = RequestMethod.GET)
    public String getPermissionRole(Integer roleid, HttpServletRequest request, HttpServletResponse response){
        try {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        List<Permission> list=new ArrayList<Permission>();
        List<Integer> permission_ids = permissionDao.getPermission_id(roleid);
        for (Integer permission_id : permission_ids) {
            Permission permission = permissionDao.getPermissionRole(permission_id);
            list.add(permission);
            System.out.println(list);
        }
        JSONArray jsonArray=JSONArray.fromObject(list);
        try {
            PrintWriter pw=response.getWriter();
            pw.write(jsonArray.toString());
            pw.close();
            pw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "role";
    }

}
