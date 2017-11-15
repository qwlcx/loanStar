package com.loanstar.entity;

/**
 * 客户表
 */
public class Client {
    private int client_id;//客户管理ID
    private int user_id;//用户ID(客户ID)
    private String client_name;//客户姓名
    private String client_telphone;//客户联系电话
    private String client_id_type;//客户证件类型
    private String client_id_number;//客户证件号(身份证号)
    private String client_foreign_nationlity;//是否取得外国国籍
    private String client_marry;//客户婚姻状况
    private String client_education;//客户学历
    private int facility_id;//服务机构ID
    private String client_card_number;//卡号
    private int pagenumber;
    private int limit;

    public Client(int client_id, String client_name, String client_telphone, String client_id_number, String client_card_number) {
        this.client_id = client_id;
        this.client_name = client_name;
        this.client_telphone = client_telphone;
        this.client_id_number = client_id_number;
        this.client_card_number = client_card_number;
    }

    public Client(int client_id, String client_name, String client_telphone, String client_id_number, int facility_id, String client_card_number, int pagenumber, int limit) {
        this.client_id = client_id;
        this.client_name = client_name;
        this.client_telphone = client_telphone;
        this.client_id_number = client_id_number;
        this.facility_id = facility_id;
        this.client_card_number = client_card_number;
        this.pagenumber = pagenumber;
        this.limit = limit;
    }

    public Client(int user_id, String client_name, String client_telphone, String client_id_type, String client_id_number, String client_foreign_nationlity, String client_marry, String client_education, int facility_id, String client_card_number, int pagenumber, int limit) {
        this.user_id = user_id;
        this.client_name = client_name;
        this.client_telphone = client_telphone;
        this.client_id_type = client_id_type;
        this.client_id_number = client_id_number;
        this.client_foreign_nationlity = client_foreign_nationlity;
        this.client_marry = client_marry;
        this.client_education = client_education;
        this.facility_id = facility_id;
        this.client_card_number = client_card_number;
        this.pagenumber = pagenumber;
        this.limit = limit;
    }

    public Client(int client_id, int user_id, String client_name, String client_telphone, String client_id_type, String client_id_number, String client_foreign_nationlity, String client_marry, String client_education, int facility_id, String client_card_number, int pagenumber, int limit) {
        this.client_id = client_id;
        this.user_id = user_id;
        this.client_name = client_name;
        this.client_telphone = client_telphone;
        this.client_id_type = client_id_type;
        this.client_id_number = client_id_number;
        this.client_foreign_nationlity = client_foreign_nationlity;
        this.client_marry = client_marry;
        this.client_education = client_education;
        this.facility_id = facility_id;
        this.client_card_number = client_card_number;
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

    public Client(int client_id, String client_name, String client_telphone, String client_id_number, int facility_id, String client_card_number) {
        this.client_id = client_id;
        this.client_name = client_name;
        this.client_telphone = client_telphone;
        this.client_id_number = client_id_number;
        this.facility_id = facility_id;
        this.client_card_number = client_card_number;
    }

    public Client(int user_id, String client_name, String client_telphone, String client_id_type, String client_id_number, String client_foreign_nationlity, String client_marry, String client_education, int facility_id, String client_card_number) {
        this.user_id = user_id;
        this.client_name = client_name;
        this.client_telphone = client_telphone;
        this.client_id_type = client_id_type;
        this.client_id_number = client_id_number;
        this.client_foreign_nationlity = client_foreign_nationlity;
        this.client_marry = client_marry;
        this.client_education = client_education;
        this.facility_id = facility_id;
        this.client_card_number = client_card_number;
    }

    public Client(int client_id, int user_id, String client_name, String client_telphone, String client_id_type, String client_id_number, String client_foreign_nationlity, String client_marry, String client_education, int facility_id, String client_card_number) {
        this.client_id = client_id;
        this.user_id = user_id;
        this.client_name = client_name;
        this.client_telphone = client_telphone;
        this.client_id_type = client_id_type;
        this.client_id_number = client_id_number;
        this.client_foreign_nationlity = client_foreign_nationlity;
        this.client_marry = client_marry;
        this.client_education = client_education;
        this.facility_id = facility_id;
        this.client_card_number = client_card_number;
    }

    public String getClient_education() {
        return client_education;
    }

    public void setClient_education(String client_education) {
        this.client_education = client_education;
    }

    public Client() {

    }

    public Client(int user_id, String client_name, String client_telphone, String client_id_type, String client_id_number, String client_foreign_nationlity, String client_marry, int facility_id, String client_card_number) {
        this.user_id = user_id;
        this.client_name = client_name;
        this.client_telphone = client_telphone;
        this.client_id_type = client_id_type;
        this.client_id_number = client_id_number;
        this.client_foreign_nationlity = client_foreign_nationlity;
        this.client_marry = client_marry;
        this.facility_id = facility_id;
        this.client_card_number = client_card_number;
    }

    public Client(int client_id, int user_id, String client_name, String client_telphone, String client_id_type, String client_id_number, String client_foreign_nationlity, String client_marry, int facility_id, String client_card_number) {
        this.client_id = client_id;
        this.user_id = user_id;
        this.client_name = client_name;
        this.client_telphone = client_telphone;
        this.client_id_type = client_id_type;
        this.client_id_number = client_id_number;
        this.client_foreign_nationlity = client_foreign_nationlity;
        this.client_marry = client_marry;
        this.facility_id = facility_id;
        this.client_card_number = client_card_number;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public String getClient_telphone() {
        return client_telphone;
    }

    public void setClient_telphone(String client_telphone) {
        this.client_telphone = client_telphone;
    }

    public String getClient_id_type() {
        return client_id_type;
    }

    public void setClient_id_type(String client_id_type) {
        this.client_id_type = client_id_type;
    }

    public String getClient_id_number() {
        return client_id_number;
    }

    public void setClient_id_number(String client_id_number) {
        this.client_id_number = client_id_number;
    }

    public String getClient_foreign_nationlity() {
        return client_foreign_nationlity;
    }

    public void setClient_foreign_nationlity(String client_foreign_nationlity) {
        this.client_foreign_nationlity = client_foreign_nationlity;
    }

    public String getClient_marry() {
        return client_marry;
    }

    public void setClient_marry(String client_marry) {
        this.client_marry = client_marry;
    }

    public int getFacility_id() {
        return facility_id;
    }

    public void setFacility_id(int facility_id) {
        this.facility_id = facility_id;
    }

    public String getClient_card_number() {
        return client_card_number;
    }

    public void setClient_card_number(String client_card_number) {
        this.client_card_number = client_card_number;
    }
}
