package com.loanstar.dto;

/**
 * 客户管理 + 服务机构的 DTO
 */
public class ClientFacility {
    private int client_id;//客户管理ID
    private String client_name;//客户姓名
    private String client_telphone;//客户联系电话
    private String client_id_number;//客户证件号(身份证号)
    private String facility_type;//机构类型
    private String client_card_number;//卡号

    public ClientFacility() {

    }

    public ClientFacility(String client_name, String client_telphone, String client_id_number, String facility_type, String client_card_number) {
        this.client_name = client_name;
        this.client_telphone = client_telphone;
        this.client_id_number = client_id_number;
        this.facility_type = facility_type;
        this.client_card_number = client_card_number;
    }

    public ClientFacility(int client_id, String client_name, String client_telphone, String client_id_number, String facility_type, String client_card_number) {
        this.client_id = client_id;
        this.client_name = client_name;
        this.client_telphone = client_telphone;
        this.client_id_number = client_id_number;
        this.facility_type = facility_type;
        this.client_card_number = client_card_number;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
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

    public String getClient_id_number() {
        return client_id_number;
    }

    public void setClient_id_number(String client_id_number) {
        this.client_id_number = client_id_number;
    }

    public String getFacility_type() {
        return facility_type;
    }

    public void setFacility_type(String facility_type) {
        this.facility_type = facility_type;
    }

    public String getClient_card_number() {
        return client_card_number;
    }

    public void setClient_card_number(String client_card_number) {
        this.client_card_number = client_card_number;
    }
}
