package com.loanstar.entity;


/**
 * 申请人信用信息简表
 */
public class Applicants {

            private String applicant_name;     //申请人信息ID
            private int applicant_number; //申请次数
            private int applicant_credit_limit;  //信用额度
            private int applicant_default_number; //违约次数
            private int applicant_heimingdan;     //是否黑名单

            public Applicants() {
            }

            public Applicants(String applicant_name, int applicant_number, int applicant_credit_limit, int applicant_default_number, int applicant_heimingdan) {
                this.applicant_name = applicant_name;
                this.applicant_number = applicant_number;
                this.applicant_credit_limit = applicant_credit_limit;
                this.applicant_default_number = applicant_default_number;
                this.applicant_heimingdan = applicant_heimingdan;
            }

    public String getApplicant_name() {
                return applicant_name;
            }

            public void setApplicant_name(String applicant_name) {
                this.applicant_name = applicant_name;
            }

            public int getApplicant_number() {
                        return applicant_number;
                    }

            public void setApplicant_number(int applicant_number) {
                this.applicant_number = applicant_number;
            }

            public int getApplicant_credit_limit() {
                return applicant_credit_limit;
            }

            public void setApplicant_credit_limit(int applicant_credit_limit) {
                this.applicant_credit_limit = applicant_credit_limit;
            }

            public int getApplicant_default_number() {
                return applicant_default_number;
            }

            public void setApplicant_default_number(int applicant_default_number) {
                this.applicant_default_number = applicant_default_number;
            }

            public int getApplicant_heimingdan() {
                return applicant_heimingdan;
            }

            public void setApplicant_heimingdan(int applicant_heimingdan) {
                this.applicant_heimingdan = applicant_heimingdan;
            }
}
