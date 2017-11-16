package com.loanstar.controller;


import com.loanstar.dao.UserDao;
import com.loanstar.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 前台登录
 */
@Controller
public class UserController {
            @Autowired
            private UserDao userDao;



    /**
     * 登录
     * @param user
     * @param request
     * @return
     */
    @RequestMapping(value = "userLogin", method = RequestMethod.POST, produces = "text/html; charset=UTF-8")
    public String userLogin(User user, HttpServletRequest request){
        request.getSession().setAttribute("uname", user.getUser_character());
        User user1 = userDao.userLogin(user);

        if(user1!=null){
            return "loginChenggong";
        }else{
            return "UserLogin";
        }
    }



    @RequestMapping(value = "userAdd", method = RequestMethod.POST, produces = "text/html; charset=UTF-8")
            public String userAdd(User user){
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date d=new Date();
                String str =  sdf.format(d);
                user.setUser_register_time(str);
                userDao.userAdd(user);
                return "UserLogin";
            }
}
