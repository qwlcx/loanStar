package com.loanstar.dto;

public class ApplicantDto {

    private int applicant_id;  //申请人信息ID
    private String applicant_serial_number;   //申请人流水号
    private String applicant_name;     //申请人姓名
    private String applicant_telphone;   //申请人联系电话
    private String applicant_id_type;    //证件类型
    private String applicant_id_number;   //证件号
    private String applicant_land;        //自有土地
    private String applicant_work_age;    //从业年限
    private String applicant_address;     //地址
    private String applicant_use;        //贷款用途
    private int applicant_aggregate_amount;  //申请总金额
    private String applicant_email;        //电子邮箱
    private String applicant_card_number;  //银行卡号
    private String applicant_state;        //状态
    private String applicant_time;         //申请时间
    private String facility_name;               //所属服务机构
    private String partner_name;                //所属FA

    public ApplicantDto() {
    }

    public ApplicantDto(int applicant_id, String applicant_serial_number, String applicant_name, String applicant_telphone, String applicant_id_type, String applicant_id_number, String applicant_land, String applicant_work_age, String applicant_address, String applicant_use, int applicant_aggregate_amount, String applicant_email, String applicant_card_number, String applicant_state, String applicant_time, String facility_name, String partner_name) {
        this.applicant_id = applicant_id;
        this.applicant_serial_number = applicant_serial_number;
        this.applicant_name = applicant_name;
        this.applicant_telphone = applicant_telphone;
        this.applicant_id_type = applicant_id_type;
        this.applicant_id_number = applicant_id_number;
        this.applicant_land = applicant_land;
        this.applicant_work_age = applicant_work_age;
        this.applicant_address = applicant_address;
        this.applicant_use = applicant_use;
        this.applicant_aggregate_amount = applicant_aggregate_amount;
        this.applicant_email = applicant_email;
        this.applicant_card_number = applicant_card_number;
        this.applicant_state = applicant_state;
        this.applicant_time = applicant_time;
        this.facility_name = facility_name;
        this.partner_name = partner_name;
    }

    public ApplicantDto(String applicant_serial_number, String applicant_name, String applicant_telphone, String applicant_id_type, String applicant_id_number, String applicant_land, String applicant_work_age, String applicant_address, String applicant_use, int applicant_aggregate_amount, String applicant_email, String applicant_card_number, String applicant_state, String applicant_time, String facility_name, String partner_name) {
        this.applicant_serial_number = applicant_serial_number;
        this.applicant_name = applicant_name;
        this.applicant_telphone = applicant_telphone;
        this.applicant_id_type = applicant_id_type;
        this.applicant_id_number = applicant_id_number;
        this.applicant_land = applicant_land;
        this.applicant_work_age = applicant_work_age;
        this.applicant_address = applicant_address;
        this.applicant_use = applicant_use;
        this.applicant_aggregate_amount = applicant_aggregate_amount;
        this.applicant_email = applicant_email;
        this.applicant_card_number = applicant_card_number;
        this.applicant_state = applicant_state;
        this.applicant_time = applicant_time;
        this.facility_name = facility_name;
        this.partner_name = partner_name;
    }

    public int getApplicant_id() {
        return applicant_id;
    }

    public void setApplicant_id(int applicant_id) {
        this.applicant_id = applicant_id;
    }

    public String getApplicant_serial_number() {
        return applicant_serial_number;
    }

    public void setApplicant_serial_number(String applicant_serial_number) {
        this.applicant_serial_number = applicant_serial_number;
    }

    public String getApplicant_name() {
        return applicant_name;
    }

    public void setApplicant_name(String applicant_name) {
        this.applicant_name = applicant_name;
    }

    public String getApplicant_telphone() {
        return applicant_telphone;
    }

    public void setApplicant_telphone(String applicant_telphone) {
        this.applicant_telphone = applicant_telphone;
    }

    public String getApplicant_id_type() {
        return applicant_id_type;
    }

    public void setApplicant_id_type(String applicant_id_type) {
        this.applicant_id_type = applicant_id_type;
    }

    public String getApplicant_id_number() {
        return applicant_id_number;
    }

    public void setApplicant_id_number(String applicant_id_number) {
        this.applicant_id_number = applicant_id_number;
    }

    public String getApplicant_land() {
        return applicant_land;
    }

    public void setApplicant_land(String applicant_land) {
        this.applicant_land = applicant_land;
    }

    public String getApplicant_work_age() {
        return applicant_work_age;
    }

    public void setApplicant_work_age(String applicant_work_age) {
        this.applicant_work_age = applicant_work_age;
    }

    public String getApplicant_address() {
        return applicant_address;
    }

    public void setApplicant_address(String applicant_address) {
        this.applicant_address = applicant_address;
    }

    public String getApplicant_use() {
        return applicant_use;
    }

    public void setApplicant_use(String applicant_use) {
        this.applicant_use = applicant_use;
    }

    public int getApplicant_aggregate_amount() {
        return applicant_aggregate_amount;
    }

    public void setApplicant_aggregate_amount(int applicant_aggregate_amount) {
        this.applicant_aggregate_amount = applicant_aggregate_amount;
    }

    public String getApplicant_email() {
        return applicant_email;
    }

    public void setApplicant_email(String applicant_email) {
        this.applicant_email = applicant_email;
    }

    public String getApplicant_card_number() {
        return applicant_card_number;
    }

    public void setApplicant_card_number(String applicant_card_number) {
        this.applicant_card_number = applicant_card_number;
    }

    public String getApplicant_state() {
        return applicant_state;
    }

    public void setApplicant_state(String applicant_state) {
        this.applicant_state = applicant_state;
    }

    public String getApplicant_time() {
        return applicant_time;
    }

    public void setApplicant_time(String applicant_time) {
        this.applicant_time = applicant_time;
    }

    public String getFacility_name() {
        return facility_name;
    }

    public void setFacility_name(String facility_name) {
        this.facility_name = facility_name;
    }

    public String getPartner_name() {
        return partner_name;
    }

    public void setPartner_name(String partner_name) {
        this.partner_name = partner_name;
    }
}
