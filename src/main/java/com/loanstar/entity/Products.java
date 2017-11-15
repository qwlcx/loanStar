package com.loanstar.entity;

/**
 * 金融产品表
 */
public class Products {
    private int products_id;//金融产品id
    private String products_name;//产品名称
    private String products_time;//产品上线时间
    private int financial_id;
    private String products_online_payment;//云农场是否支持线上支付
    private String products_payment_method;//还款方式
    private String products_collection_service;//是否由我们提供催收服务
    private String products_scan_service;//是否由我们提供贷后审查服务
    private String products_shibor;//年代利率
    private String products_condition;//申请条件
    private String products_limit_range;//贷款额度范围
    private String products_time_range;//期限范围
    private String products_credit_cycle;//是否循环授信
    private int products_funding_cost;//资金成本
    private String products_earmark;//是否专款专用
    private String products_credit_field;//设置授信字段
    private String products_material;//所需资料
    private String products_state;//状态
    private int pagenumber;
    private int limit;

    public Products(int products_id, String products_name, String products_online_payment, String products_payment_method) {
        this.products_id = products_id;
        this.products_name = products_name;
        this.products_online_payment = products_online_payment;
        this.products_payment_method = products_payment_method;
    }

    public Products(String products_name, String products_time, int financial_id, String products_online_payment, String products_payment_method, String products_collection_service, String products_scan_service, String products_shibor, String products_condition, String products_limit_range, String products_time_range, String products_credit_cycle, int products_funding_cost, String products_earmark, String products_credit_field, String products_material, String products_state, int pagenumber, int limit) {
        this.products_name = products_name;
        this.products_time = products_time;
        this.financial_id = financial_id;
        this.products_online_payment = products_online_payment;
        this.products_payment_method = products_payment_method;
        this.products_collection_service = products_collection_service;
        this.products_scan_service = products_scan_service;
        this.products_shibor = products_shibor;
        this.products_condition = products_condition;
        this.products_limit_range = products_limit_range;
        this.products_time_range = products_time_range;
        this.products_credit_cycle = products_credit_cycle;
        this.products_funding_cost = products_funding_cost;
        this.products_earmark = products_earmark;
        this.products_credit_field = products_credit_field;
        this.products_material = products_material;
        this.products_state = products_state;
        this.pagenumber = pagenumber;
        this.limit = limit;
    }

    public Products(int products_id, String products_name, String products_time, int financial_id, String products_online_payment, String products_payment_method, String products_collection_service, String products_scan_service, String products_shibor, String products_condition, String products_limit_range, String products_time_range, String products_credit_cycle, int products_funding_cost, String products_earmark, String products_credit_field, String products_material, String products_state, int pagenumber, int limit) {
        this.products_id = products_id;
        this.products_name = products_name;
        this.products_time = products_time;
        this.financial_id = financial_id;
        this.products_online_payment = products_online_payment;
        this.products_payment_method = products_payment_method;
        this.products_collection_service = products_collection_service;
        this.products_scan_service = products_scan_service;
        this.products_shibor = products_shibor;
        this.products_condition = products_condition;
        this.products_limit_range = products_limit_range;
        this.products_time_range = products_time_range;
        this.products_credit_cycle = products_credit_cycle;
        this.products_funding_cost = products_funding_cost;
        this.products_earmark = products_earmark;
        this.products_credit_field = products_credit_field;
        this.products_material = products_material;
        this.products_state = products_state;
        this.pagenumber = pagenumber;
        this.limit = limit;
    }

    public int getFinancial_id() {
        return financial_id;
    }

    public void setFinancial_id(int financial_id) {
        this.financial_id = financial_id;
    }

    public Products() {
    }

    public Products(String products_name, String products_time, String products_online_payment, String products_payment_method, String products_collection_service, String products_scan_service, String products_shibor, String products_condition, String products_limit_range, String products_time_range, String products_credit_cycle, int products_funding_cost, String products_earmark, String products_credit_field, String products_material, String products_state, int pagenumber, int limit) {
        this.products_name = products_name;
        this.products_time = products_time;
        this.products_online_payment = products_online_payment;
        this.products_payment_method = products_payment_method;
        this.products_collection_service = products_collection_service;
        this.products_scan_service = products_scan_service;
        this.products_shibor = products_shibor;
        this.products_condition = products_condition;
        this.products_limit_range = products_limit_range;
        this.products_time_range = products_time_range;
        this.products_credit_cycle = products_credit_cycle;
        this.products_funding_cost = products_funding_cost;
        this.products_earmark = products_earmark;
        this.products_credit_field = products_credit_field;
        this.products_material = products_material;
        this.products_state = products_state;
        this.pagenumber = pagenumber;
        this.limit = limit;
    }

    public Products(int products_id, String products_name, String products_time, String products_online_payment, String products_payment_method, String products_collection_service, String products_scan_service, String products_shibor, String products_condition, String products_limit_range, String products_time_range, String products_credit_cycle, int products_funding_cost, String products_earmark, String products_credit_field, String products_material, String products_state, int pagenumber, int limit) {
        this.products_id = products_id;
        this.products_name = products_name;
        this.products_time = products_time;
        this.products_online_payment = products_online_payment;
        this.products_payment_method = products_payment_method;
        this.products_collection_service = products_collection_service;
        this.products_scan_service = products_scan_service;
        this.products_shibor = products_shibor;
        this.products_condition = products_condition;
        this.products_limit_range = products_limit_range;
        this.products_time_range = products_time_range;
        this.products_credit_cycle = products_credit_cycle;
        this.products_funding_cost = products_funding_cost;
        this.products_earmark = products_earmark;
        this.products_credit_field = products_credit_field;
        this.products_material = products_material;
        this.products_state = products_state;
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

    public Products(String products_name, String products_time, String products_online_payment, String products_payment_method, String products_collection_service, String products_scan_service, String products_shibor, String products_condition, String products_limit_range, String products_time_range, String products_credit_cycle, int products_funding_cost, String products_earmark, String products_credit_field, String products_material, String products_state) {
        this.products_name = products_name;
        this.products_time = products_time;
        this.products_online_payment = products_online_payment;
        this.products_payment_method = products_payment_method;
        this.products_collection_service = products_collection_service;
        this.products_scan_service = products_scan_service;
        this.products_shibor = products_shibor;
        this.products_condition = products_condition;
        this.products_limit_range = products_limit_range;
        this.products_time_range = products_time_range;
        this.products_credit_cycle = products_credit_cycle;
        this.products_funding_cost = products_funding_cost;
        this.products_earmark = products_earmark;
        this.products_credit_field = products_credit_field;
        this.products_material = products_material;
        this.products_state = products_state;
    }

    public Products(int products_id, String products_name, String products_time, String products_online_payment, String products_payment_method, String products_collection_service, String products_scan_service, String products_shibor, String products_condition, String products_limit_range, String products_time_range, String products_credit_cycle, int products_funding_cost, String products_earmark, String products_credit_field, String products_material, String products_state) {
        this.products_id = products_id;
        this.products_name = products_name;
        this.products_time = products_time;
        this.products_online_payment = products_online_payment;
        this.products_payment_method = products_payment_method;
        this.products_collection_service = products_collection_service;
        this.products_scan_service = products_scan_service;
        this.products_shibor = products_shibor;
        this.products_condition = products_condition;
        this.products_limit_range = products_limit_range;
        this.products_time_range = products_time_range;
        this.products_credit_cycle = products_credit_cycle;
        this.products_funding_cost = products_funding_cost;
        this.products_earmark = products_earmark;
        this.products_credit_field = products_credit_field;
        this.products_material = products_material;
        this.products_state = products_state;
    }

    public int getProducts_id() {
        return products_id;
    }

    public void setProducts_id(int products_id) {
        this.products_id = products_id;
    }

    public String getProducts_name() {
        return products_name;
    }

    public void setProducts_name(String products_name) {
        this.products_name = products_name;
    }

    public String getProducts_time() {
        return products_time;
    }

    public void setProducts_time(String products_time) {
        this.products_time = products_time;
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

    public String getProducts_collection_service() {
        return products_collection_service;
    }

    public void setProducts_collection_service(String products_collection_service) {
        this.products_collection_service = products_collection_service;
    }

    public String getProducts_scan_service() {
        return products_scan_service;
    }

    public void setProducts_scan_service(String products_scan_service) {
        this.products_scan_service = products_scan_service;
    }

    public String getProducts_shibor() {
        return products_shibor;
    }

    public void setProducts_shibor(String products_shibor) {
        this.products_shibor = products_shibor;
    }

    public String getProducts_condition() {
        return products_condition;
    }

    public void setProducts_condition(String products_condition) {
        this.products_condition = products_condition;
    }

    public String getProducts_limit_range() {
        return products_limit_range;
    }

    public void setProducts_limit_range(String products_limit_range) {
        this.products_limit_range = products_limit_range;
    }

    public String getProducts_time_range() {
        return products_time_range;
    }

    public void setProducts_time_range(String products_time_range) {
        this.products_time_range = products_time_range;
    }

    public String getProducts_credit_cycle() {
        return products_credit_cycle;
    }

    public void setProducts_credit_cycle(String products_credit_cycle) {
        this.products_credit_cycle = products_credit_cycle;
    }

    public int getProducts_funding_cost() {
        return products_funding_cost;
    }

    public void setProducts_funding_cost(int products_funding_cost) {
        this.products_funding_cost = products_funding_cost;
    }

    public String getProducts_earmark() {
        return products_earmark;
    }

    public void setProducts_earmark(String products_earmark) {
        this.products_earmark = products_earmark;
    }

    public String getProducts_credit_field() {
        return products_credit_field;
    }

    public void setProducts_credit_field(String products_credit_field) {
        this.products_credit_field = products_credit_field;
    }

    public String getProducts_material() {
        return products_material;
    }

    public void setProducts_material(String products_material) {
        this.products_material = products_material;
    }

    public String getProducts_state() {
        return products_state;
    }

    public void setProducts_state(String products_state) {
        this.products_state = products_state;
    }
}
