package com.loanstar.entity;


/**
 * 申请人信息调研表
 */
public class Survey {

             private int survey_id;     //用户调研ID
         private int applicant_id;  //申请人信息ID
         private String urvey_sex;      //申请人性别
         private String survey_foreign_nationlity;   //申请人是否取得外国国籍
         private String survey_education;            //申请人学历
         private String survey_marry;                //申请人婚姻信息
         private String survey_birth;               //申请人出生日期
         private String survey_work_unitis;         //申请人工作单位
         private String survey_position;            //申请人职务
         private String survey_native_place;        //申请人籍贯
         private String survey_address_now;         //申请人现居居住地
         private String survey_shop_house;          //申请人商品房
         private String survey_homestead;           //申请人宅基地
         private String survey_agricultural_machinery; //申请人农用机械
         private String survey_sedan;                   //申请人私家车
         private String survey_contract_land;          //申请人承包土地
         private String survey_land;                  //申请人自有土地
         private String survey_liabilities;           //申请人负债情况
         private String survey_produation_cost;       //生产成本
         private String survey_sale_procceds;         //申请人销售收入
         private String survey_bad_record;             //申请人不良记录
         private String survey_financing_or_landing;   //申请人是否存在民间融资或放贷情况
         private String survey_banck;                  //申请人主要授信银行
         private String survey_variety;                //申请人信贷业务品种
         private int survey_balance;                //申请人信贷业务余额
         private String survey_interest_or_margin;     //利率/保证金
         private String survey_due_date;               //到期日
         private String survey_guaranty_style;         //担保方式
         private String survey_guarantor;              //担保人名称
         private String survey_other;                  //其他说明事项

    public Survey() {
    }

    public Survey(int applicant_id, String urvey_sex, String survey_foreign_nationlity, String survey_education, String survey_marry, String survey_birth, String survey_work_unitis, String survey_position, String survey_native_place, String survey_address_now, String survey_shop_house, String survey_homestead, String survey_agricultural_machinery, String survey_sedan, String survey_contract_land, String survey_land, String survey_liabilities, String survey_produation_cost, String survey_sale_procceds, String survey_bad_record, String survey_financing_or_landing, String survey_banck, String survey_variety, int survey_balance, String survey_interest_or_margin, String survey_due_date, String survey_guaranty_style, String survey_guarantor, String survey_other) {
        this.applicant_id = applicant_id;
        this.urvey_sex = urvey_sex;
        this.survey_foreign_nationlity = survey_foreign_nationlity;
        this.survey_education = survey_education;
        this.survey_marry = survey_marry;
        this.survey_birth = survey_birth;
        this.survey_work_unitis = survey_work_unitis;
        this.survey_position = survey_position;
        this.survey_native_place = survey_native_place;
        this.survey_address_now = survey_address_now;
        this.survey_shop_house = survey_shop_house;
        this.survey_homestead = survey_homestead;
        this.survey_agricultural_machinery = survey_agricultural_machinery;
        this.survey_sedan = survey_sedan;
        this.survey_contract_land = survey_contract_land;
        this.survey_land = survey_land;
        this.survey_liabilities = survey_liabilities;
        this.survey_produation_cost = survey_produation_cost;
        this.survey_sale_procceds = survey_sale_procceds;
        this.survey_bad_record = survey_bad_record;
        this.survey_financing_or_landing = survey_financing_or_landing;
        this.survey_banck = survey_banck;
        this.survey_variety = survey_variety;
        this.survey_balance = survey_balance;
        this.survey_interest_or_margin = survey_interest_or_margin;
        this.survey_due_date = survey_due_date;
        this.survey_guaranty_style = survey_guaranty_style;
        this.survey_guarantor = survey_guarantor;
        this.survey_other = survey_other;
    }


    public Survey(int survey_id, int applicant_id, String urvey_sex, String survey_foreign_nationlity, String survey_education, String survey_marry, String survey_birth, String survey_work_unitis, String survey_position, String survey_native_place, String survey_address_now, String survey_shop_house, String survey_homestead, String survey_agricultural_machinery, String survey_sedan, String survey_contract_land, String survey_land, String survey_liabilities, String survey_produation_cost, String survey_sale_procceds, String survey_bad_record, String survey_financing_or_landing, String survey_banck, String survey_variety, int survey_balance, String survey_interest_or_margin, String survey_due_date, String survey_guaranty_style, String survey_guarantor, String survey_other) {
        this.survey_id = survey_id;
        this.applicant_id = applicant_id;
        this.urvey_sex = urvey_sex;
        this.survey_foreign_nationlity = survey_foreign_nationlity;
        this.survey_education = survey_education;
        this.survey_marry = survey_marry;
        this.survey_birth = survey_birth;
        this.survey_work_unitis = survey_work_unitis;
        this.survey_position = survey_position;
        this.survey_native_place = survey_native_place;
        this.survey_address_now = survey_address_now;
        this.survey_shop_house = survey_shop_house;
        this.survey_homestead = survey_homestead;
        this.survey_agricultural_machinery = survey_agricultural_machinery;
        this.survey_sedan = survey_sedan;
        this.survey_contract_land = survey_contract_land;
        this.survey_land = survey_land;
        this.survey_liabilities = survey_liabilities;
        this.survey_produation_cost = survey_produation_cost;
        this.survey_sale_procceds = survey_sale_procceds;
        this.survey_bad_record = survey_bad_record;
        this.survey_financing_or_landing = survey_financing_or_landing;
        this.survey_banck = survey_banck;
        this.survey_variety = survey_variety;
        this.survey_balance = survey_balance;
        this.survey_interest_or_margin = survey_interest_or_margin;
        this.survey_due_date = survey_due_date;
        this.survey_guaranty_style = survey_guaranty_style;
        this.survey_guarantor = survey_guarantor;
        this.survey_other = survey_other;
    }

    public int getSurvey_id() {
        return survey_id;
    }

    public void setSurvey_id(int survey_id) {
        this.survey_id = survey_id;
    }

    public int getApplicant_id() {
        return applicant_id;
    }

    public void setApplicant_id(int applicant_id) {
        this.applicant_id = applicant_id;
    }


    public String getUrvey_sex() {
        return urvey_sex;
    }

    public void setUrvey_sex(String urvey_sex) {
        this.urvey_sex = urvey_sex;
    }

    public String getSurvey_foreign_nationlity() {
        return survey_foreign_nationlity;
    }

    public void setSurvey_foreign_nationlity(String survey_foreign_nationlity) {
        this.survey_foreign_nationlity = survey_foreign_nationlity;
    }

    public String getSurvey_education() {
        return survey_education;
    }

    public void setSurvey_education(String survey_education) {
        this.survey_education = survey_education;
    }

    public String getSurvey_marry() {
        return survey_marry;
    }

    public void setSurvey_marry(String survey_marry) {
        this.survey_marry = survey_marry;
    }


    public String getSurvey_birth() {
        return survey_birth;
    }

    public void setSurvey_birth(String survey_birth) {
        this.survey_birth = survey_birth;
    }

    public String getSurvey_work_unitis() {
        return survey_work_unitis;
    }

    public void setSurvey_work_unitis(String survey_work_unitis) {
        this.survey_work_unitis = survey_work_unitis;
    }

    public String getSurvey_position() {
        return survey_position;
    }

    public void setSurvey_position(String survey_position) {
        this.survey_position = survey_position;
    }

    public String getSurvey_native_place() {
        return survey_native_place;
    }

    public void setSurvey_native_place(String survey_native_place) {
        this.survey_native_place = survey_native_place;
    }

    public String getSurvey_address_now() {
        return survey_address_now;
    }

    public void setSurvey_address_now(String survey_address_now) {
        this.survey_address_now = survey_address_now;
    }

    public String getSurvey_shop_house() {
        return survey_shop_house;
    }

    public void setSurvey_shop_house(String survey_shop_house) {
        this.survey_shop_house = survey_shop_house;
    }

    public String getSurvey_homestead() {
        return survey_homestead;
    }

    public void setSurvey_homestead(String survey_homestead) {
        this.survey_homestead = survey_homestead;
    }

    public String getSurvey_agricultural_machinery() {
        return survey_agricultural_machinery;
    }

    public void setSurvey_agricultural_machinery(String survey_agricultural_machinery) {
        this.survey_agricultural_machinery = survey_agricultural_machinery;
    }

    public String getSurvey_sedan() {
        return survey_sedan;
    }

    public void setSurvey_sedan(String survey_sedan) {
        this.survey_sedan = survey_sedan;
    }

    public String getSurvey_contract_land() {
        return survey_contract_land;
    }

    public void setSurvey_contract_land(String survey_contract_land) {
        this.survey_contract_land = survey_contract_land;
    }

    public String getSurvey_land() {
        return survey_land;
    }

    public void setSurvey_land(String survey_land) {
        this.survey_land = survey_land;
    }

    public String getSurvey_liabilities() {
        return survey_liabilities;
    }

    public void setSurvey_liabilities(String survey_liabilities) {
        this.survey_liabilities = survey_liabilities;
    }

    public String getSurvey_produation_cost() {
        return survey_produation_cost;
    }

    public void setSurvey_produation_cost(String survey_produation_cost) {
        this.survey_produation_cost = survey_produation_cost;
    }

    public String getSurvey_sale_procceds() {
        return survey_sale_procceds;
    }

    public void setSurvey_sale_procceds(String survey_sale_procceds) {
        this.survey_sale_procceds = survey_sale_procceds;
    }

    public String getSurvey_bad_record() {
        return survey_bad_record;
    }

    public void setSurvey_bad_record(String survey_bad_record) {
        this.survey_bad_record = survey_bad_record;
    }

    public String getSurvey_financing_or_landing() {
        return survey_financing_or_landing;
    }

    public void setSurvey_financing_or_landing(String survey_financing_or_landing) {
        this.survey_financing_or_landing = survey_financing_or_landing;
    }

    public String getSurvey_banck() {
        return survey_banck;
    }

    public void setSurvey_banck(String survey_banck) {
        this.survey_banck = survey_banck;
    }

    public String getSurvey_variety() {
        return survey_variety;
    }

    public void setSurvey_variety(String survey_variety) {
        this.survey_variety = survey_variety;
    }

    public int getSurvey_balance() {
        return survey_balance;
    }

    public void setSurvey_balance(int survey_balance) {
        this.survey_balance = survey_balance;
    }

    public String getSurvey_interest_or_margin() {
        return survey_interest_or_margin;
    }

    public void setSurvey_interest_or_margin(String survey_interest_or_margin) {
        this.survey_interest_or_margin = survey_interest_or_margin;
    }

    public String getSurvey_due_date() {
        return survey_due_date;
    }

    public void setSurvey_due_date(String survey_due_date) {
        this.survey_due_date = survey_due_date;
    }

    public String getSurvey_guaranty_style() {
        return survey_guaranty_style;
    }

    public void setSurvey_guaranty_style(String survey_guaranty_style) {
        this.survey_guaranty_style = survey_guaranty_style;
    }

    public String getSurvey_guarantor() {
        return survey_guarantor;
    }

    public void setSurvey_guarantor(String survey_guarantor) {
        this.survey_guarantor = survey_guarantor;
    }


    public String getSurvey_other() {
        return survey_other;
    }

    public void setSurvey_other(String survey_other) {
        this.survey_other = survey_other;
    }

    @Override
    public String toString() {
        return "Survey{" +
                "survey_id=" + survey_id +
                ", applicant_id=" + applicant_id +
                ", urvey_sex='" + urvey_sex + '\'' +
                ", survey_foreign_nationlity='" + survey_foreign_nationlity + '\'' +
                ", survey_education='" + survey_education + '\'' +
                ", survey_marry='" + survey_marry + '\'' +
                ", survey_birth='" + survey_birth + '\'' +
                ", survey_work_unitis='" + survey_work_unitis + '\'' +
                ", survey_position='" + survey_position + '\'' +
                ", survey_native_place='" + survey_native_place + '\'' +
                ", survey_address_now='" + survey_address_now + '\'' +
                ", survey_shop_house='" + survey_shop_house + '\'' +
                ", survey_homestead='" + survey_homestead + '\'' +
                ", survey_agricultural_machinery='" + survey_agricultural_machinery + '\'' +
                ", survey_sedan='" + survey_sedan + '\'' +
                ", survey_contract_land='" + survey_contract_land + '\'' +
                ", survey_land='" + survey_land + '\'' +
                ", survey_liabilities='" + survey_liabilities + '\'' +
                ", survey_produation_cost='" + survey_produation_cost + '\'' +
                ", survey_sale_procceds='" + survey_sale_procceds + '\'' +
                ", survey_bad_record='" + survey_bad_record + '\'' +
                ", survey_financing_or_landing='" + survey_financing_or_landing + '\'' +
                ", survey_banck='" + survey_banck + '\'' +
                ", survey_variety='" + survey_variety + '\'' +
                ", survey_balance=" + survey_balance +
                ", survey_interest_or_margin='" + survey_interest_or_margin + '\'' +
                ", survey_due_date='" + survey_due_date + '\'' +
                ", survey_guaranty_style='" + survey_guaranty_style + '\'' +
                ", survey_guarantor='" + survey_guarantor + '\'' +
                ", survey_other='" + survey_other + '\'' +
                '}';
    }
}
