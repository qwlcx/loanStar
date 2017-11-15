package com.loanstar.dto;

public class ProductsFacility {
    private int products_id;//金融产品ID
    private String products_time;//金融产品新增时间
    private String products_name;//金融产品名称
    private String financial_institution_number;//金融机构名称
    private String products_online_payment;//云农场线上支付
    private String products_payment_method;//还款方式
    private String products_state;//状态

    public ProductsFacility(String products_time, String products_name, String financial_institution_number, String products_online_payment, String products_payment_method, String products_state) {
        this.products_time = products_time;
        this.products_name = products_name;
        this.financial_institution_number = financial_institution_number;
        this.products_online_payment = products_online_payment;
        this.products_payment_method = products_payment_method;
        this.products_state = products_state;
    }

    public ProductsFacility() {

    }

    public int getProducts_id() {
        return products_id;
    }

    public void setProducts_id(int products_id) {
        this.products_id = products_id;
    }

    public String getProducts_time() {
        return products_time;
    }

    public void setProducts_time(String products_time) {
        this.products_time = products_time;
    }

    public String getProducts_name() {
        return products_name;
    }

    public void setProducts_name(String products_name) {
        this.products_name = products_name;
    }

    public String getFinancial_institution_number() {
        return financial_institution_number;
    }

    public void setFinancial_institution_number(String financial_institution_number) {
        this.financial_institution_number = financial_institution_number;
    }

    public String getProducts_online_payment() {
        return products_online_payment;
    }

    public void setProducts_online_payment(String products_online_payment) {
        this.products_online_payment = products_online_payment;
    }

    public String getProducts_payment_method() {
        return products_payment_method;
    }

    public void setProducts_payment_method(String products_payment_method) {
        this.products_payment_method = products_payment_method;
    }

    public String getProducts_state() {
        return products_state;
    }

    public void setProducts_state(String products_state) {
        this.products_state = products_state;
    }

    public ProductsFacility(int products_id, String products_time, String products_name, String financial_institution_number, String products_online_payment, String products_payment_method, String products_state) {
        this.products_id = products_id;
        this.products_time = products_time;
        this.products_name = products_name;
        this.financial_institution_number = financial_institution_number;
        this.products_online_payment = products_online_payment;
        this.products_payment_method = products_payment_method;
        this.products_state = products_state;
    }
}
