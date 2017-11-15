package com.loanstar.dto;

public class PartnerDto {
    private int partner_id;//FA编号
    private String partner_time;//添加时间
    private String partner_character;//FA登录账号
    private String partner_name;//FA姓名
    private String partner_address;//办公地址
    private String partner_telphone;//联系电话
    private String facility_orgization_name;//所属机构
    private String role_name;//所属角色
    private String department_industry_title;//所属部门
    private String partner_sate;//是否冻结

    public PartnerDto() {
    }

    public PartnerDto(int partner_id, String partner_time, String partner_character, String partner_name, String partner_address, String partner_telphone, String facility_orgization_name, String role_name, String department_industry_title, String partner_sate) {
        this.partner_id = partner_id;
        this.partner_time = partner_time;
        this.partner_character = partner_character;
        this.partner_name = partner_name;
        this.partner_address = partner_address;
        this.partner_telphone = partner_telphone;
        this.facility_orgization_name = facility_orgization_name;
        this.role_name = role_name;
        this.department_industry_title = department_industry_title;
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

    public String getFacility_orgization_name() {
        return facility_orgization_name;
    }

    public void setFacility_orgization_name(String facility_orgization_name) {
        this.facility_orgization_name = facility_orgization_name;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public String getDepartment_industry_title() {
        return department_industry_title;
    }

    public void setDepartment_industry_title(String department_industry_title) {
        this.department_industry_title = department_industry_title;
    }

    public String getPartner_sate() {
        return partner_sate;
    }

    public void setPartner_sate(String partner_sate) {
        this.partner_sate = partner_sate;
    }

    @Override
    public String toString() {
        return "PartnerDto{" +
                "partner_id=" + partner_id +
                ", partner_time='" + partner_time + '\'' +
                ", partner_character='" + partner_character + '\'' +
                ", partner_name='" + partner_name + '\'' +
                ", partner_address='" + partner_address + '\'' +
                ", partner_telphone='" + partner_telphone + '\'' +
                ", facility_orgization_name='" + facility_orgization_name + '\'' +
                ", role_name='" + role_name + '\'' +
                ", department_industry_title='" + department_industry_title + '\'' +
                ", partner_sate='" + partner_sate + '\'' +
                '}';
    }
}
