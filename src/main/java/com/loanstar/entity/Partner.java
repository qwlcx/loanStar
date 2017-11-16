package com.loanstar.entity;

public class Partner {
    private int partner_id;//合作商ID
    private String partner_time;//合作商添加时间
    private String partner_character;//合作商登录账号
    private String partner_password;//密码
    private String partner_name;//负责人姓名
    private String partner_address;//合作商办公地址
    private String partner_telphone;//合作商联系电话
    private int facility_id;//所属机构ID
    private int role_id;//所属角色ID
    private int department_id;//所属部门ID
    private String partner_sate;//账号状态，是否冻结


    public Partner() {
    }


    public Partner(int partner_id, String partner_name, String partner_address, String partner_telphone, int facility_id, int role_id, int department_id) {
        this.partner_id = partner_id;
        this.partner_name = partner_name;
        this.partner_address = partner_address;
        this.partner_telphone = partner_telphone;
        this.facility_id = facility_id;
        this.role_id = role_id;
        this.department_id = department_id;
    }

    public Partner(String partner_time, String partner_character, String partner_name, String partner_address, String partner_telphone, int facility_id, int role_id, int department_id) {
        this.partner_time = partner_time;
        this.partner_character = partner_character;
        this.partner_name = partner_name;
        this.partner_address = partner_address;
        this.partner_telphone = partner_telphone;
        this.facility_id = facility_id;
        this.role_id = role_id;
        this.department_id = department_id;
    }

    public Partner(String partner_time, String partner_character, String partner_password, String partner_name, String partner_address, String partner_telphone, int facility_id, int role_id, int department_id, String partner_sate) {
        this.partner_time = partner_time;
        this.partner_character = partner_character;
        this.partner_password = partner_password;
        this.partner_name = partner_name;
        this.partner_address = partner_address;
        this.partner_telphone = partner_telphone;
        this.facility_id = facility_id;
        this.role_id = role_id;
        this.department_id = department_id;
        this.partner_sate = partner_sate;
    }

    public Partner(int partner_id, String partner_time, String partner_character, String partner_password, String partner_name, String partner_address, String partner_telphone, int facility_id, int role_id, int department_id, String partner_sate) {
        this.partner_id = partner_id;
        this.partner_time = partner_time;
        this.partner_character = partner_character;
        this.partner_password = partner_password;
        this.partner_name = partner_name;
        this.partner_address = partner_address;
        this.partner_telphone = partner_telphone;
        this.facility_id = facility_id;
        this.role_id = role_id;
        this.department_id = department_id;
        this.partner_sate = partner_sate;
    }

    public int getPartner_id() {
        return partner_id;
    }

    public void setPartner_id(int partner_id) {
        this.partner_id = partner_id;
    }

    public String getPartner_time() {
        return partner_time;
    }

    public void setPartner_time(String partner_time) {
        this.partner_time = partner_time;
    }

    public String getPartner_character() {
        return partner_character;
    }

    public void setPartner_character(String partner_character) {
        this.partner_character = partner_character;
    }

    public String getPartner_password() {
        return partner_password;
    }

    public void setPartner_password(String partner_password) {
        this.partner_password = partner_password;
    }

    public String getPartner_name() {
        return partner_name;
    }

    public void setPartner_name(String partner_name) {
        this.partner_name = partner_name;
    }

    public String getPartner_address() {
        return partner_address;
    }

    public void setPartner_address(String partner_address) {
        this.partner_address = partner_address;
    }

    public String getPartner_telphone() {
        return partner_telphone;
    }

    public void setPartner_telphone(String partner_telphone) {
        this.partner_telphone = partner_telphone;
    }

    public int getFacility_id() {
        return facility_id;
    }

    public void setFacility_id(int facility_id) {
        this.facility_id = facility_id;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public String getPartner_sate() {
        return partner_sate;
    }

    public void setPartner_sate(String partner_sate) {
        this.partner_sate = partner_sate;
    }

}
