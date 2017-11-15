package com.loanstar.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Facility {
    private int facility_id;//机构ID
    private String facility_time;//机构添加时间
    private String facility_type;//机构类型
    private String facility_orgization_name;//机构名称
    private String facility_loclel;//负责地区
    private String facility_name;//机构添加人姓名
    private Set<Manager> managers;


    public Set<Manager> getManagers() {
        return managers;
    }

    public void setManagers(Set<Manager> managers) {
        this.managers = managers;
    }

    public Facility() {
    }

    public Facility(String facility_time, String facility_type, String facility_orgization_name, String facility_loclel, String facility_name) {
        this.facility_time = facility_time;
        this.facility_type = facility_type;
        this.facility_orgization_name = facility_orgization_name;
        this.facility_loclel = facility_loclel;
        this.facility_name = facility_name;
    }

    public Facility(int facility_id, String facility_time, String facility_type, String facility_orgization_name, String facility_loclel, String facility_name) {
        this.facility_id = facility_id;
        this.facility_time = facility_time;
        this.facility_type = facility_type;
        this.facility_orgization_name = facility_orgization_name;
        this.facility_loclel = facility_loclel;
        this.facility_name = facility_name;
    }


    public int getFacility_id() {
        return facility_id;
    }

    public void setFacility_id(int facility_id) {
        this.facility_id = facility_id;
    }

    public String getFacility_time() {
        return facility_time;
    }

    public void setFacility_time(String facility_time) {
        this.facility_time = facility_time;
    }

    public String getFacility_type() {
        return facility_type;
    }

    public void setFacility_type(String facility_type) {
        this.facility_type = facility_type;
    }

    public String getFacility_orgization_name() {
        return facility_orgization_name;
    }

    public void setFacility_orgization_name(String facility_orgization_name) {
        this.facility_orgization_name = facility_orgization_name;
    }

    public String getFacility_loclel() {
        return facility_loclel;
    }

    public void setFacility_loclel(String facility_loclel) {
        this.facility_loclel = facility_loclel;
    }

    public String getFacility_name() {
        return facility_name;
    }

    public void setFacility_name(String facility_name) {
        this.facility_name = facility_name;
    }

}
