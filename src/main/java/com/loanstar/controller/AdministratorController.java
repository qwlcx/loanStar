package com.loanstar.controller;

import com.loanstar.dao.AdministratorDao;
import com.loanstar.entity.Administrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class AdministratorController {

    @Autowired
    public AdministratorDao administratorDao;

    @RequestMapping("login")
    public String login(HttpServletRequest request, HttpServletResponse response){
        String administrator_character=request.getParameter("administrator_character");
        String administrator_password=request.getParameter("administrator_password");
        Administrator administrator=new Administrator(administrator_character,administrator_password);
        Administrator administrator1=administratorDao.administratorLogin(administrator);
        if(administrator1==null){
            return "redirect:login.html";
        }
        String administrator_name=administratorDao.getAdministrator_name(administrator_character);
        HttpSession session=request.getSession();
        session.setAttribute("administrator_name",administrator_name);
        session.setAttribute("administrator_character",administrator_character);
        //贷款合作商
        Integer roleId1=administratorDao.getRoleByCharacter1(administrator_character);
        String roleName1=administratorDao.getRoleName(roleId1);
        //人员管理
        Integer roleId2=administratorDao.getRoleByCharacter2(administrator_character);
        String roleName2=administratorDao.getRoleName2(roleId2);
            session.setAttribute("roleName1",roleName1);
            session.setAttribute("roleName2",roleName2);
        return "redirect:index.jsp";
    }


        @RequestMapping("upPass")
    public String upPass(HttpServletRequest request,HttpServletResponse response){
            try {
                request.setCharacterEncoding("UTF-8");
                response.setCharacterEncoding("UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            String pwd1=request.getParameter("administrator_password1");
            String pwd2=request.getParameter("administrator_password2");
            System.out.println(pwd1);
            System.out.println(pwd2);
            HttpSession session=request.getSession();
            String name= (String) session.getAttribute("administrator_character");
            if(pwd1.equals(pwd2)){
                Map<String,Object> map=new HashMap<String, Object>();
                map.put("administrator_password",pwd1);
                map.put("administrator_character",name);
                administratorDao.upPass(map);
                request.setAttribute("dis","dis");
            }else {

            }

        return "upPassWord";
        }

}
