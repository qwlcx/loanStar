package com.loanstar.entity;


/**
 * 用户表实体类
 */
public class User {

            private int User_id;      //用户ID
            private String User_character; //账号
            private String User_password;   //密码
            private String User_register_time;  //用户注册时间

            public User() {
            }

            public User(int user_id, String user_character, String user_password, String user_register_time) {
                User_id = user_id;
                User_character = user_character;
                User_password = user_password;
                User_register_time = user_register_time;
            }

            public User(String user_character, String user_password, String user_register_time) {
                User_character = user_character;
                User_password = user_password;
                User_register_time = user_register_time;
            }

    public User(String user_character, String user_password) {
        User_character = user_character;
        User_password = user_password;
    }

    public int getUser_id() {
                return User_id;
            }

            public void setUser_id(int user_id) {
                User_id = user_id;
            }

            public String getUser_character() {
                return User_character;
            }

            public void setUser_character(String user_character) {
                User_character = user_character;
            }

            public String getUser_password() {
                return User_password;
            }

            public void setUser_password(String user_password) {
                User_password = user_password;
            }

            public String getUser_register_time() {
                return User_register_time;
            }

            public void setUser_register_time(String user_register_time) {
                User_register_time = user_register_time;
            }
}
