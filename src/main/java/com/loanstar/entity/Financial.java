package com.loanstar.entity;

import java.util.Set;

/**
 * 金融机构表
 */
public class Financial {
    private int financial_id;//金融机构id
    private String financial_register_time;//金融机构注册时间
    private String financial_institution_number;//金融机构名称
    private String financial_name;//金融机构业务联系人
    private String financial_telphone;//业务联系人电话
    private String financial_remark;//备注
    private String financial_state;//状态
    private int pagenumber;
    private int limit;

    public Financial(int financial_id, String financial_register_time, String financial_institution_number, String financial_name, String financial_telphone, String financial_remark, String financial_state, int pagenumber, int limit, Set<Products> productses) {
        this.financial_id = financial_id;
        this.financial_register_time = financial_register_time;
        this.financial_institution_number = financial_institution_number;
        this.financial_name = financial_name;
        this.financial_telphone = financial_telphone;
        this.financial_remark = financial_remark;
        this.financial_state = financial_state;
        this.pagenumber = pagenumber;
        this.limit = limit;
        this.productses = productses;
    }

    public Financial(int financial_id, String financial_institution_number, String financial_name, String financial_telphone, String financial_remark) {
        this.financial_id = financial_id;
        this.financial_institution_number = financial_institution_number;
        this.financial_name = financial_name;
        this.financial_telphone = financial_telphone;
        this.financial_remark = financial_remark;
    }

    public Financial(String financial_institution_number, String financial_name, String financial_telphone, String financial_remark) {
        this.financial_institution_number = financial_institution_number;
        this.financial_name = financial_name;
        this.financial_telphone = financial_telphone;
        this.financial_remark = financial_remark;
    }

    private Set<Products> productses;

    public Set<Products> getProductses() {
        return productses;
    }

    public void setProductses(Set<Products> productses) {
        this.productses = productses;
    }

    public Financial(int pagenumber, int limit) {
        this.pagenumber = pagenumber;
        this.limit = limit;
    }

    public Financial(String financial_register_time, String financial_institution_number, String financial_name, String financial_telphone, String financial_remark, String financial_state, int pagenumber, int limit) {
        this.financial_register_time = financial_register_time;
        this.financial_institution_number = financial_institution_number;
        this.financial_name = financial_name;
        this.financial_telphone = financial_telphone;
        this.financial_remark = financial_remark;
        this.financial_state = financial_state;
        this.pagenumber = pagenumber;
        this.limit = limit;
    }

    public Financial(int financial_id, String financial_register_time, String financial_institution_number, String financial_name, String financial_telphone, String financial_remark, String financial_state, int pagenumber, int limit) {
        this.financial_id = financial_id;
        this.financial_register_time = financial_register_time;
        this.financial_institution_number = financial_institution_number;
        this.financial_name = financial_name;
        this.financial_telphone = financial_telphone;
        this.financial_remark = financial_remark;
        this.financial_state = financial_state;
        this.pagenumber = pagenumber;
        this.limit = limit;
    }

    public int getPagenumber() {
        return pagenumber;
    }

    public void setPagenumber(int pagenumber) {
        this.pagenumber = pagenumber;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public Financial() {
    }

    public int getFinancial_id() {
        return financial_id;
    }

    public void setFinancial_id(int financial_id) {
        this.financial_id = financial_id;
    }

    public String getFinancial_register_time() {
        return financial_register_time;
    }

    public void setFinancial_register_time(String financial_register_time) {
        this.financial_register_time = financial_register_time;
    }

    public String getFinancial_institution_number() {
        return financial_institution_number;
    }

    public void setFinancial_institution_number(String financial_institution_number) {
        this.financial_institution_number = financial_institution_number;
    }

    public String getFinancial_name() {
        return financial_name;
    }

    public void setFinancial_name(String financial_name) {
        this.financial_name = financial_name;
    }

    public String getFinancial_telphone() {
        return financial_telphone;
    }

    public void setFinancial_telphone(String financial_telphone) {
        this.financial_telphone = financial_telphone;
    }

    public String getFinancial_remark() {
        return financial_remark;
    }

    public void setFinancial_remark(String financial_remark) {
        this.financial_remark = financial_remark;
    }

    public String getFinancial_state() {
        return financial_state;
    }

    public void setFinancial_state(String financial_state) {
        this.financial_state = financial_state;
    }

    public Financial(String financial_register_time, String financial_institution_number, String financial_name, String financial_telphone, String financial_remark, String financial_state) {
        this.financial_register_time = financial_register_time;
        this.financial_institution_number = financial_institution_number;
        this.financial_name = financial_name;
        this.financial_telphone = financial_telphone;
        this.financial_remark = financial_remark;
        this.financial_state = financial_state;
    }

    public Financial(int financial_id, String financial_register_time, String financial_institution_number, String financial_name, String financial_telphone, String financial_remark, String financial_state) {
        this.financial_id = financial_id;
        this.financial_register_time = financial_register_time;
        this.financial_institution_number = financial_institution_number;
        this.financial_name = financial_name;
        this.financial_telphone = financial_telphone;
        this.financial_remark = financial_remark;
        this.financial_state = financial_state;
    }
}
