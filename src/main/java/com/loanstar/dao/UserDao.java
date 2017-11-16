package com.loanstar.dao;


import com.loanstar.entity.User;

public interface UserDao {


            public User userLogin(User user);

            public void userAdd(User user);
}
