package com.loanstar.controller;

import com.loanstar.dao.PermissionDao;
import com.loanstar.entity.Permission;
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
import java.util.List;

@Controller
public class PermissionController {
//    @Autowired
//    private PermissionDao permissionDao;
//
//    @RequestMapping(value = "getPermissionRole" , method = RequestMethod.GET)
//    public String getPermissionRole(Integer roleid, HttpServletRequest request, HttpServletResponse response){
//        try {
//            request.setCharacterEncoding("UTF-8");
//            response.setCharacterEncoding("UTF-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        List<Permission> list=new ArrayList<Permission>();
//        List<Integer> permission_ids = permissionDao.getPermission_id(roleid);
//        for (Integer permission_id : permission_ids) {
//            Permission permission = permissionDao.getPermissionRole(permission_id);
//            list.add(permission);
//            System.out.println(list);
//        }
//        JSONArray jsonArray=JSONArray.fromObject(list);
//        try {
//            PrintWriter pw=response.getWriter();
//            pw.write(jsonArray.toString());
//            pw.close();
//            pw.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return "role";
//    }
}
