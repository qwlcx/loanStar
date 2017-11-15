package com.loanstar.controller;

import com.loanstar.dao.ManagerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ManagerController {
    @Autowired
    private ManagerDao managerDao;

}
