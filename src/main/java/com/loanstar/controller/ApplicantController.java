package com.loanstar.controller;

import com.loanstar.dao.*;
import com.loanstar.dto.ApplicantDto;
import com.loanstar.entity.Applicant;
import com.loanstar.entity.Applicants;
import com.loanstar.entity.HisApplicant;
import com.loanstar.entity.Survey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 申请人基本信息Controller
 */
@Controller
public class ApplicantController {

        @Autowired
        private ApplicantDao applicantDao;

        @Autowired
        private FacilityDao facilityDao;

        @Autowired
        private PartnerDao partnerDao;

        @Autowired
        private ApplicantsDao applicantsDao;

        @Autowired
        private HisApplicantDao hisApplicantDao;

        @Autowired
        private SurveyDao surveyDao;
        /**
         * 查询所有申请贷款用户的基本信息
         * @param pageNumber
         * @param pageSize
         * @return
         */
        @RequestMapping(value =  "getApplicantSelect")
        @ResponseBody
        public Map<String,Object> getAll(int pageNumber, int pageSize){
            //获取总页数
            int sum=(pageNumber-1)*pageSize;
            //查询所有申请人基本数据的数据
            List<Applicant> applicants=applicantDao.getApplicantController(sum,pageSize);
            List<ApplicantDto> applicantDtos = new ArrayList<ApplicantDto>();
            for (Applicant applicant : applicants) {
                ApplicantDto applicantDto = new ApplicantDto();
                applicantDto.setApplicant_id(applicant.getApplicant_id());
                applicantDto.setApplicant_serial_number(applicant.getApplicant_serial_number());
                applicantDto.setApplicant_name(applicant.getApplicant_name());
                applicantDto.setApplicant_telphone(applicant.getApplicant_telphone());
                applicantDto.setApplicant_id_type(applicant.getApplicant_id_type());
                applicantDto.setApplicant_id_number(applicant.getApplicant_id_number());
                applicantDto.setApplicant_land(applicant.getApplicant_land());
                applicantDto.setApplicant_work_age(applicant.getApplicant_work_age());
                applicantDto.setApplicant_address(applicant.getApplicant_address());
                applicantDto.setApplicant_use(applicant.getApplicant_use());
                applicantDto.setApplicant_aggregate_amount(applicant.getApplicant_aggregate_amount());
                applicantDto.setApplicant_email(applicant.getApplicant_email());
                applicantDto.setApplicant_card_number(applicant.getApplicant_card_number());
                applicantDto.setApplicant_state(applicant.getApplicant_state());
                applicantDto.setApplicant_time(applicant.getApplicant_time());
                applicantDto.setFacility_name(facilityDao.getFacilityName(applicant.getFacility_id()));
                applicantDto.setPartner_name(partnerDao.getPartnerName(applicant.getPartner_id()));
                applicantDtos.add(applicantDto);
            }
            int count=applicantDao.getSize();
            Map<String,Object> map=new HashMap<String,Object>();
            map.put("total",count);
            map.put("rows",applicantDtos);
            return map;
        }


    /**
     * 申请信息
     * @param applicant
     */
    @RequestMapping(value = "addApplicant", method = RequestMethod.POST, produces = "text/html; charset=UTF-8")
            public String addApplicant(Applicant applicant,HttpServletRequest request){
                    String user_character = (String) request.getSession().getAttribute("uname");
                    String applicant_serial_number = genCodes(8); //申请人流水号(随机生成,需返回给用户)
                    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Date d=new Date();
                    String str =  sdf.format(d);                         //申请时间系统当前时间
                    String loclel = applicant.getApplicant_address().substring(0,9);   //查询服务机构地址
                    System.out.println(loclel);
                    int  facility_id = facilityDao.getFacilityLoclel(loclel);               //所属服务机构
                    int  partner_id = partnerDao.getPartnerFacility_id(facility_id);
                    Applicant applicant1 = new Applicant();
                    applicant1.setApplicant_serial_number(applicant_serial_number);//申请人流水号
                    applicant1.setApplicant_name(applicant.getApplicant_name());//申请人姓名
                    applicant1.setApplicant_telphone(applicant.getApplicant_telphone());//申请人联系电话
                    applicant1.setApplicant_id_type(applicant.getApplicant_id_type());  //证件类型
                    applicant1.setApplicant_id_number(applicant.getApplicant_id_number());//证件号
                    applicant1.setApplicant_land(applicant.getApplicant_land());            //自有土地
                    applicant1.setApplicant_work_age(applicant.getApplicant_work_age());  //从业年限
                    applicant1.setApplicant_address(applicant.getApplicant_address());    //地址
                    applicant1.setApplicant_use(applicant.getApplicant_use());           //贷款用途
                    applicant1.setApplicant_aggregate_amount(applicant.getApplicant_aggregate_amount()); //申请总金额
                    applicant1.setApplicant_email(applicant.getApplicant_email());  //电子邮箱
                    applicant1.setApplicant_card_number(applicant.getApplicant_card_number());  //银行卡号
                    applicant1.setApplicant_state("待审核");    //状态
                    applicant1.setApplicant_time(str);          //申请时间
                    applicant1.setFacility_id(facility_id);   //所属服务机构
                    applicant1.setPartner_id(partner_id);     //所属FA
                    applicant1.setUser_character(user_character);
                    applicantDao.addApplocant(applicant1);

                    Integer n = applicantsDao.selectApplicantsSize(applicant.getApplicant_name());
                    if(n==null){
                        applicantsDao.addApplicants(new Applicants(applicant.getApplicant_name(),1,500,0,0));
                    }else{

                        applicantsDao.updateNumber(applicant.getApplicant_name(),n+1);
                    }
                    return  "applicantSuccess";
            }

    /**
     * 查询所有申请贷款用户的申请
     * @param pageNumber
     * @param pageSize
     * @return
     */
    @RequestMapping(value =  "getAllName")
    @ResponseBody
    public Map<String,Object> getAllName(int pageNumber, int pageSize,HttpServletRequest request){
        String name = (String) request.getSession().getAttribute("uname");
        //获取总页数
        int sum=(pageNumber-1)*pageSize;
        //查询所有申请人基本数据的数据
        List<Applicant> applicants=applicantDao.getApplicantControllerName(sum,pageSize,name);
        List<ApplicantDto> applicantDtos = new ArrayList<ApplicantDto>();
        for (Applicant applicant : applicants) {
            ApplicantDto applicantDto = new ApplicantDto();
            applicantDto.setApplicant_id(applicant.getApplicant_id());
            applicantDto.setApplicant_serial_number(applicant.getApplicant_serial_number());
            applicantDto.setApplicant_name(applicant.getApplicant_name());
            applicantDto.setApplicant_telphone(applicant.getApplicant_telphone());
            applicantDto.setApplicant_id_type(applicant.getApplicant_id_type());
            applicantDto.setApplicant_id_number(applicant.getApplicant_id_number());
            applicantDto.setApplicant_land(applicant.getApplicant_land());
            applicantDto.setApplicant_work_age(applicant.getApplicant_work_age());
            applicantDto.setApplicant_address(applicant.getApplicant_address());
            applicantDto.setApplicant_use(applicant.getApplicant_use());
            applicantDto.setApplicant_aggregate_amount(applicant.getApplicant_aggregate_amount());
            applicantDto.setApplicant_email(applicant.getApplicant_email());
            applicantDto.setApplicant_card_number(applicant.getApplicant_card_number());
            applicantDto.setApplicant_state(applicant.getApplicant_state());
            applicantDto.setApplicant_time(applicant.getApplicant_time());
            applicantDto.setFacility_name(facilityDao.getFacilityName(applicant.getFacility_id()));
            applicantDto.setPartner_name(partnerDao.getPartnerName(applicant.getPartner_id()));
            applicantDtos.add(applicantDto);
        }
        int count=applicantDao.getSizeName(name);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("total",count);
        map.put("rows",applicantDtos);
        return map;
    }

    /**
     * 查询所有申请贷款用户的历史申请信息
     * @param pageNumber
     * @param pageSize
     * @return
     */
    @RequestMapping(value =  "getHisApplicantName")
    @ResponseBody
    public Map<String,Object> getHisApplicantName(int pageNumber, int pageSize,HttpServletRequest request){
        String name = (String) request.getSession().getAttribute("uname");
        //获取总页数
        int sum=(pageNumber-1)*pageSize;
        //查询所有申请人基本数据的数据
        List<HisApplicant> hisApplicants=hisApplicantDao.getHisApplicantName(sum,pageSize,name);
        int count=hisApplicantDao.getSizeName(name);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("total",count);
        map.put("rows",hisApplicants);
        return map;
    }

    @RequestMapping(value = "updateState", method = RequestMethod.POST, produces = "text/html; charset=UTF-8")
    public String udateState(String trueorfalse,String number,String state){
        System.out.println("in");
        String state1 = "";
        if("通过".equals(trueorfalse)){
                if("待审核".equals(state)){
                    state1 = "待调研";
                }
        }else{
            Applicant applicant = applicantDao.selectByNumber(number);
            HisApplicant hisApplicant = new HisApplicant();
            hisApplicant.setApplicant_id(applicant.getApplicant_id());
            hisApplicant.setApplicant_serial_number(applicant.getApplicant_serial_number());
            hisApplicant.setApplicant_name(applicant.getApplicant_name());
            hisApplicant.setApplicant_telphone(applicant.getApplicant_telphone());
            hisApplicant.setApplicant_id_type(applicant.getApplicant_id_type());
            hisApplicant.setApplicant_id_number(applicant.getApplicant_id_number());
            hisApplicant.setApplicant_land(applicant.getApplicant_land());
            hisApplicant.setApplicant_work_age(applicant.getApplicant_work_age());
            hisApplicant.setApplicant_address(applicant.getApplicant_address());
            hisApplicant.setApplicant_use(applicant.getApplicant_use());
            hisApplicant.setApplicant_aggregate_amount(applicant.getApplicant_aggregate_amount());
            hisApplicant.setApplicant_email(applicant.getApplicant_email());
            hisApplicant.setApplicant_card_number(applicant.getApplicant_card_number());
            hisApplicant.setApplicant_state("贷款失败");
            hisApplicant.setApplicant_time(applicant.getApplicant_time());
            hisApplicant.setFacility_id(applicant.getFacility_id());
            hisApplicant.setPartner_id(applicant.getPartner_id());
            hisApplicant.setUser_character(applicant.getUser_character());
            hisApplicant.setApplicant_trueorfalse("失败");
            hisApplicant.setApplicant_yuanyin("审核不通过");
            hisApplicantDao.addHisApplicant(hisApplicant);
            state1="初审不通过";
        }
        applicantDao.updateState(state1,number);
        return  "applicantSelect";
    }




    /**
     * 查询待调研状态申请贷款的信息
     * @param pageNumber
     * @param pageSize
     * @return
     */
    @RequestMapping(value =  "getApplicantSelectState1")
    @ResponseBody
    public Map<String,Object> getApplicantSelectState1(int pageNumber, int pageSize,HttpServletRequest request){
        //获取总页数
        int sum=(pageNumber-1)*pageSize;
        //查询所有申请人基本数据的数据
        List<Applicant> applicants=applicantDao.getApplicantControllerState1(sum,pageSize);
        List<ApplicantDto> applicantDtos = new ArrayList<ApplicantDto>();
        for (Applicant applicant : applicants) {
            ApplicantDto applicantDto = new ApplicantDto();
            applicantDto.setApplicant_id(applicant.getApplicant_id());
            applicantDto.setApplicant_serial_number(applicant.getApplicant_serial_number());
            applicantDto.setApplicant_name(applicant.getApplicant_name());
            applicantDto.setApplicant_telphone(applicant.getApplicant_telphone());
            applicantDto.setApplicant_id_type(applicant.getApplicant_id_type());
            applicantDto.setApplicant_id_number(applicant.getApplicant_id_number());
            applicantDto.setApplicant_land(applicant.getApplicant_land());
            applicantDto.setApplicant_work_age(applicant.getApplicant_work_age());
            applicantDto.setApplicant_address(applicant.getApplicant_address());
            applicantDto.setApplicant_use(applicant.getApplicant_use());
            applicantDto.setApplicant_aggregate_amount(applicant.getApplicant_aggregate_amount());
            applicantDto.setApplicant_email(applicant.getApplicant_email());
            applicantDto.setApplicant_card_number(applicant.getApplicant_card_number());
            applicantDto.setApplicant_state(applicant.getApplicant_state());
            applicantDto.setApplicant_time(applicant.getApplicant_time());
            applicantDto.setFacility_name(facilityDao.getFacilityName(applicant.getFacility_id()));
            applicantDto.setPartner_name(partnerDao.getPartnerName(applicant.getPartner_id()));
            applicantDtos.add(applicantDto);
        }
        int count=applicantDao.getSizeState1();
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("total",count);
        map.put("rows",applicantDtos);
        return map;
    }



        @RequestMapping(value = "addSurvey", method = RequestMethod.POST, produces = "text/html; charset=UTF-8")
        public String addSurvey(Survey survey, String fushen, HttpServletRequest request, HttpServletResponse response){
            try {
                request.setCharacterEncoding("UTF-8");
                response.setCharacterEncoding("UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            Applicant applicant = applicantDao.selectById(survey.getApplicant_id());
            if("是".equals(fushen)){
                    surveyDao.addSurvey(survey);
                    applicantDao.updateState("待复审",applicant.getApplicant_serial_number());
                }else{
                HisApplicant hisApplicant = new HisApplicant();
                hisApplicant.setApplicant_id(applicant.getApplicant_id());
                hisApplicant.setApplicant_serial_number(applicant.getApplicant_serial_number());
                hisApplicant.setApplicant_name(applicant.getApplicant_name());
                hisApplicant.setApplicant_telphone(applicant.getApplicant_telphone());
                hisApplicant.setApplicant_id_type(applicant.getApplicant_id_type());
                hisApplicant.setApplicant_id_number(applicant.getApplicant_id_number());
                hisApplicant.setApplicant_land(applicant.getApplicant_land());
                hisApplicant.setApplicant_work_age(applicant.getApplicant_work_age());
                hisApplicant.setApplicant_address(applicant.getApplicant_address());
                hisApplicant.setApplicant_use(applicant.getApplicant_use());
                hisApplicant.setApplicant_aggregate_amount(applicant.getApplicant_aggregate_amount());
                hisApplicant.setApplicant_email(applicant.getApplicant_email());
                hisApplicant.setApplicant_card_number(applicant.getApplicant_card_number());
                hisApplicant.setApplicant_state("贷款失败");
                hisApplicant.setApplicant_time(applicant.getApplicant_time());
                hisApplicant.setFacility_id(applicant.getFacility_id());
                hisApplicant.setPartner_id(applicant.getPartner_id());
                hisApplicant.setUser_character(applicant.getUser_character());
                hisApplicant.setApplicant_trueorfalse("失败");
                hisApplicant.setApplicant_yuanyin("调研信息不过关");
                hisApplicantDao.addHisApplicant(hisApplicant);
                applicantDao.updateState("调研不通过",applicant.getApplicant_serial_number());
                }
                return "applicantDaidiaoyanSelect";
        }

    /**
     * 查询待复审状态申请贷款的信息
     * @param pageNumber
     * @param pageSize
     * @return
     */
    @RequestMapping(value =  "getApplicantSelectState2")
    @ResponseBody
    public Map<String,Object> getApplicantSelectState2(int pageNumber, int pageSize,HttpServletRequest request){
        //获取总页数
        int sum=(pageNumber-1)*pageSize;
        //查询所有申请人基本数据的数据
        List<Applicant> applicants=applicantDao.getApplicantControllerState2(sum,pageSize);
        List<ApplicantDto> applicantDtos = new ArrayList<ApplicantDto>();
        for (Applicant applicant : applicants) {
            ApplicantDto applicantDto = new ApplicantDto();
            applicantDto.setApplicant_id(applicant.getApplicant_id());
            applicantDto.setApplicant_serial_number(applicant.getApplicant_serial_number());
            applicantDto.setApplicant_name(applicant.getApplicant_name());
            applicantDto.setApplicant_telphone(applicant.getApplicant_telphone());
            applicantDto.setApplicant_id_type(applicant.getApplicant_id_type());
            applicantDto.setApplicant_id_number(applicant.getApplicant_id_number());
            applicantDto.setApplicant_land(applicant.getApplicant_land());
            applicantDto.setApplicant_work_age(applicant.getApplicant_work_age());
            applicantDto.setApplicant_address(applicant.getApplicant_address());
            applicantDto.setApplicant_use(applicant.getApplicant_use());
            applicantDto.setApplicant_aggregate_amount(applicant.getApplicant_aggregate_amount());
            applicantDto.setApplicant_email(applicant.getApplicant_email());
            applicantDto.setApplicant_card_number(applicant.getApplicant_card_number());
            applicantDto.setApplicant_state(applicant.getApplicant_state());
            applicantDto.setApplicant_time(applicant.getApplicant_time());
            applicantDto.setFacility_name(facilityDao.getFacilityName(applicant.getFacility_id()));
            applicantDto.setPartner_name(partnerDao.getPartnerName(applicant.getPartner_id()));
            applicantDtos.add(applicantDto);
        }
        int count=applicantDao.getSizeState2();
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("total",count);
        map.put("rows",applicantDtos);
        return map;
    }

    @RequestMapping(value = "updateState2")
    public String updateState2(String trueorfalse,String number,String state){
        String state1 = "";
        if("复审通过".equals(trueorfalse)){
            if("待复审".equals(state)){
                state1 = "待授信";
            }
        }else{
            Applicant applicant = applicantDao.selectByNumber(number);
            HisApplicant hisApplicant = new HisApplicant();
            hisApplicant.setApplicant_id(applicant.getApplicant_id());
            hisApplicant.setApplicant_serial_number(applicant.getApplicant_serial_number());
            hisApplicant.setApplicant_name(applicant.getApplicant_name());
            hisApplicant.setApplicant_telphone(applicant.getApplicant_telphone());
            hisApplicant.setApplicant_id_type(applicant.getApplicant_id_type());
            hisApplicant.setApplicant_id_number(applicant.getApplicant_id_number());
            hisApplicant.setApplicant_land(applicant.getApplicant_land());
            hisApplicant.setApplicant_work_age(applicant.getApplicant_work_age());
            hisApplicant.setApplicant_address(applicant.getApplicant_address());
            hisApplicant.setApplicant_use(applicant.getApplicant_use());
            hisApplicant.setApplicant_aggregate_amount(applicant.getApplicant_aggregate_amount());
            hisApplicant.setApplicant_email(applicant.getApplicant_email());
            hisApplicant.setApplicant_card_number(applicant.getApplicant_card_number());
            hisApplicant.setApplicant_state("贷款失败");
            hisApplicant.setApplicant_time(applicant.getApplicant_time());
            hisApplicant.setFacility_id(applicant.getFacility_id());
            hisApplicant.setPartner_id(applicant.getPartner_id());
            hisApplicant.setUser_character(applicant.getUser_character());
            hisApplicant.setApplicant_trueorfalse("失败");
            hisApplicant.setApplicant_yuanyin("复审不通过");
            hisApplicantDao.addHisApplicant(hisApplicant);
            state1="复审不通过";
        }
        applicantDao.updateState(state1,number);
        return  "applicantDaiFushenSelect";
    }

    @ResponseBody
    @RequestMapping(value = "selectSurvey", method = RequestMethod.POST, produces = "text/html; charset=UTF-8")
    public Map<String,Object> selectSurvey(int pageNumber, int pageSize,int strParentID){
        int sum=(pageNumber-1)*pageSize;
        List<Survey> surveys = surveyDao.getSurveyById(sum,pageSize,strParentID);
        int count=surveyDao.getSize(strParentID);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("total",count);
        map.put("rows",surveys);
        return map;
    }



    /**
     * 查询待授信状态申请贷款的信息
     * @param pageNumber
     * @param pageSize
     * @return
     */
    @RequestMapping(value =  "getApplicantSelectState3")
    @ResponseBody
    public Map<String,Object> getApplicantSelectState3(int pageNumber, int pageSize,HttpServletRequest request){
        //获取总页数
        int sum=(pageNumber-1)*pageSize;
        //查询所有申请人基本数据的数据
        List<Applicant> applicants=applicantDao.getApplicantControllerState3(sum,pageSize);
        System.out.println( "psdlp,   "+applicants);
        List<ApplicantDto> applicantDtos = new ArrayList<ApplicantDto>();
        for (Applicant applicant : applicants) {
            ApplicantDto applicantDto = new ApplicantDto();
            applicantDto.setApplicant_id(applicant.getApplicant_id());
            applicantDto.setApplicant_serial_number(applicant.getApplicant_serial_number());
            applicantDto.setApplicant_name(applicant.getApplicant_name());
            applicantDto.setApplicant_telphone(applicant.getApplicant_telphone());
            applicantDto.setApplicant_id_type(applicant.getApplicant_id_type());
            applicantDto.setApplicant_id_number(applicant.getApplicant_id_number());
            applicantDto.setApplicant_land(applicant.getApplicant_land());
            applicantDto.setApplicant_work_age(applicant.getApplicant_work_age());
            applicantDto.setApplicant_address(applicant.getApplicant_address());
            applicantDto.setApplicant_use(applicant.getApplicant_use());
            applicantDto.setApplicant_aggregate_amount(applicant.getApplicant_aggregate_amount());
            applicantDto.setApplicant_email(applicant.getApplicant_email());
            applicantDto.setApplicant_card_number(applicant.getApplicant_card_number());
            applicantDto.setApplicant_state(applicant.getApplicant_state());
            applicantDto.setApplicant_time(applicant.getApplicant_time());
            applicantDto.setFacility_name(facilityDao.getFacilityName(applicant.getFacility_id()));
            applicantDto.setPartner_name(partnerDao.getPartnerName(applicant.getPartner_id()));
            applicantDtos.add(applicantDto);
        }
        int count=applicantDao.getSizeState3();
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("total",count);
        map.put("rows",applicantDtos);
        System.out.println(applicantDtos);
        return map;
    }




    /**
     * 随机生成流水号
     * @param length  流水号长度
     * @return  字符串
     */
    public String  genCodes(int length){
        String val = "";
        Random random = new Random();
        for (int i = 0;i<length;i++){
            String charOrNum = random.nextInt(2)%2==0?"char":"num";
            if("char".equalsIgnoreCase(charOrNum)){
                int temp = random.nextInt(2)%2==0?65:97;
                val += (char)(random.nextInt(26)+temp);
            }else if("num".equalsIgnoreCase(charOrNum)){
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val;
    }

}
