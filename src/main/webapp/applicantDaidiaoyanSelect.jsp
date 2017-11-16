<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/11/4 0004
  Time: 18:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <!-- 引入BootStrap库 -->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!--http://issues.wenzhixin.net.cn/bootstrap-table/assets/bootstrap-table/src/bootstrap-table.css-->
    <link rel="stylesheet" href="bootstrap/css/bootstrap-table.css">
    <link rel="stylesheet" href="bootstrap/css/select2.css">
    <link rel="stylesheet" href="bootstrap/css/select.css">
    <!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
    <script src="bootstrap/jquery.min.js"></script>
    <!-- 包括所有已编译的插件 -->
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <style>
        .w70 {width: 70px !important;}
    </style>
    <script src="bootstrap/js/bootstrap-table.js"></script>
    <%--    <script src="js/bootstrap/js/bootstrap-table-editable.js"></script>--%>
    <script src="bootstrap/js/select2.js"></script>
    <script src="bootstrap/js/select.js"></script>
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.11.1/bootstrap-table.min.css">
    <!-- Latest compiled and minified JavaScript -->
    <script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.11.1/bootstrap-table.min.js"></script>
    <!-- Latest compiled and minified Locales -->
    <script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.11.1/locale/bootstrap-table-zh-CN.min.js"></script>

    <script>
<c:choose>
    <c:when test="${roleName1=='风控研调人员' or roleName2=='风控研调人员'}">
        $(function(){
            $("#cusTable").bootstrapTable({
                url: "/getApplicantSelectState1.action", //获取数据的Servlet地址
                striped: true,                      //是否显示行间隔色
                pagination: true, //启动分页
                pageSize: 10,  //每页显示的记录数
                pageNumber:1, //当前第几页
                pageList: [5, 10, 15, 20, 25],  //记录数可选列表
                queryParamsType : "undefined",
                //设置为undefined可以获取pageNumber，pageSize，searchText，sortName，sortOrder
                //设置为limit可以获取limit, offset, search, sort, order
                sidePagination: "server",
                cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
                strictSearch: true,
                clickToSelect: true,                //是否启用点击选中行
                columns: [{
                    checkbox: true
                }, {
                    field: 'applicant_serial_number',
                    title: '申请人流水号'
                }, {
                    field: 'applicant_name',
                    title: '申请人姓名'
                }, {
                    field: 'applicant_time',
                    title: '申请时间'
                }, {
                    field: 'applicant_telphone',
                    title: '申请人联系电话'
                }, {
                    field: 'applicant_id_type',
                    title: '证件类型'
                }, {
                    field: 'applicant_id_number',
                    title: '证件号'
                }, {
                    field: 'applicant_address',
                    title: '地址'
                }, {
                    field: 'applicant_aggregate_amount',
                    title: '申请总金额'
                }, {
                    field: 'facility_name',
                    title: '所属服务机构'
                }, {
                    field: 'partner_name',
                    title: '所属FA'
                }, {
                    field: 'applicant_state',
                    title: '当前状态'
                },
                    {
                        title: '操作',
                        align: 'center',
                        formatter: function (value, row, index) {
                            var e = '<button class="btn btn-primary btn" data-toggle="modal" data-target="#myModal">添加调研信息</button> ';
                            return e ;
                        }
                    }
                ]
            });
        });
    </c:when>
<c:otherwise>
$(function(){
    $("#cusTable").bootstrapTable({
        url: "/getApplicantSelectState1.action", //获取数据的Servlet地址
        striped: true,                      //是否显示行间隔色
        pagination: true, //启动分页
        pageSize: 10,  //每页显示的记录数
        pageNumber:1, //当前第几页
        pageList: [5, 10, 15, 20, 25],  //记录数可选列表
        queryParamsType : "undefined",
        //设置为undefined可以获取pageNumber，pageSize，searchText，sortName，sortOrder
        //设置为limit可以获取limit, offset, search, sort, order
        sidePagination: "server",
        cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        strictSearch: true,
        clickToSelect: true,                //是否启用点击选中行
        columns: [{
            checkbox: true
        }, {
            field: 'applicant_serial_number',
            title: '申请人流水号'
        }, {
            field: 'applicant_name',
            title: '申请人姓名'
        }, {
            field: 'applicant_time',
            title: '申请时间'
        }, {
            field: 'applicant_telphone',
            title: '申请人联系电话'
        }, {
            field: 'applicant_id_type',
            title: '证件类型'
        }, {
            field: 'applicant_id_number',
            title: '证件号'
        }, {
            field: 'applicant_address',
            title: '地址'
        }, {
            field: 'applicant_aggregate_amount',
            title: '申请总金额'
        }, {
            field: 'facility_name',
            title: '所属服务机构'
        }, {
            field: 'partner_name',
            title: '所属FA'
        }, {
            field: 'applicant_state',
            title: '当前状态'
        }]
    });
});
</c:otherwise>
</c:choose>


        $(function () {
            $('#myModal').on('shown.bs.modal', function () {
                //
                var b= $("#cusTable").bootstrapTable('getSelections');
                if(b.length>0){
                    //绑定数据
                    $('#applicantid').val(b[0].applicant_id);
                }
            });
        });

    </script>

</head>
<body>
<table class="table table-hover" id="cusTable"></table>

<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">调研信息</h4>
            </div>
            <form class="bs-example bs-example-form" role="form" action="/addSurvey.action" method="post">
                <div class="input-group" style="width: 400px; align-content: center;">
                    <span class="input-group-addon">申请人信息ID:</span>
                    <input type="text" class="form-control" id="applicantid" name="applicant_id" readonly>
                </div>
                <br>
                <div class="input-group" style="width: 400px; align-content: center;">
                    <span class="input-group-addon">申请人性别:</span>
                    <input type="text" class="form-control" id="urvey_sex" name="urvey_sex">
                </div>
                <br>
                <div class="input-group" style="width: 400px; align-content: center;">
                <span class="input-group-addon">申请人是否取得外国国籍:</span>
                    <select class="form-control" name="survey_foreign_nationlity" id="survey_foreign_nationlity">
                        <option>是</option>
                        <option>否</option>
                    </select>
                </div>
                <br>
                <div class="input-group" style="width: 400px; align-content: center;">
                    <span class="input-group-addon">申请人学历:</span>
                    <input type="text" class="form-control" id="survey_education" name="survey_education" >
                </div>
                <br>
                <div class="input-group" style="width: 400px; align-content: center;">
                    <span class="input-group-addon">申请人婚姻信息:</span>
                    <select class="form-control" name="survey_marry"
                            id="survey_marry">
                        <option>已结婚</option>
                        <option>未结婚</option>
                    </select>
                </div>
                <br>
                <div class="input-group" style="width: 400px; align-content: center;">
                    <span class="input-group-addon">申请人出生日期:</span>
                    <input type="text" class="form-control" id="survey_birth" name="survey_birth">
                </div>
                <br>
                <div class="input-group" style="width: 400px; align-content: center;">
                    <span class="input-group-addon">申请人工作单位:</span>
                    <input type="text" class="form-control" id="survey_work_unitis"  name="survey_work_unitis">
                </div>
                <br>
                <div class="input-group" style="width: 400px; align-content: center;">
                    <span class="input-group-addon">申请人职务:</span>
                    <input type="text" class="form-control" id="survey_position"  name="survey_position">
                </div>
                <br>
                <div class="input-group" style="width: 400px; align-content: center;">
                    <span class="input-group-addon">申请人籍贯:</span>
                    <input type="text" class="form-control" id="survey_native_place"  name="survey_native_place">
                </div>
                <br>
                <div class="input-group" style="width: 400px; align-content: center;">
                    <span class="input-group-addon">申请人现居居住地:</span>
                    <input type="text" class="form-control" id="survey_address_now"  name="survey_address_now">
                </div>
                <br>
                <div class="input-group" style="width: 400px; align-content: center;">
                    <span class="input-group-addon">申请人商品房:</span>
                    <input type="text" class="form-control" id="survey_shop_house"  name="survey_shop_house">
                </div>
                <br>
                <div class="input-group" style="width: 400px; align-content: center;">
                    <span class="input-group-addon">申请人宅基地:</span>
                    <input type="text" class="form-control" id="survey_homestead"  name="survey_homestead">
                </div>
                <br>
                <div class="input-group" style="width: 400px; align-content: center;">
                    <span class="input-group-addon">申请人农用机械:</span>
                    <input type="text" class="form-control" id="survey_agricultural_machinery"  name="survey_agricultural_machinery">
                </div>
                <br>
                <div class="input-group" style="width: 400px; align-content: center;">
                    <span class="input-group-addon">申请人私家车:</span>
                    <input type="text" class="form-control" id="survey_sedan" name="survey_sedan">
                </div>
                <br>
                <div class="input-group" style="width: 400px; align-content: center;">
                    <span class="input-group-addon">申请人承包土地:</span>
                    <input type="text" class="form-control" id="survey_contract_land" name="survey_contract_land" >
                </div>
                <br>
                <div class="input-group" style="width: 400px; align-content: center;">
                    <span class="input-group-addon">申请人自有土地:</span>
                    <input type="text" class="form-control" id="survey_land" name="survey_land">
                </div>
                <br>
                <div class="input-group" style="width: 400px; align-content: center;">
                    <span class="input-group-addon">申请人负债情况:</span>
                    <input type="text" class="form-control" id="survey_liabilities"  name="survey_liabilities">
                </div>
                <br>
                <div class="input-group" style="width: 400px; align-content: center;">
                    <span class="input-group-addon">生产成本:</span>
                    <input type="text" class="form-control" id="survey_produation_cost"  name="survey_produation_cost">
                </div>
                <br>
                <div class="input-group" style="width: 400px; align-content: center;">
                    <span class="input-group-addon">申请人销售收入:</span>
                    <input type="text" class="form-control" id="survey_sale_procceds"  name="survey_sale_procceds">
                </div>
                <br>
                <div class="input-group" style="width: 400px; align-content: center;">
                    <span class="input-group-addon">申请人不良记录:</span>
                    <input type="text" class="form-control" id="survey_bad_record"  name="survey_bad_record">
                </div>
                <br>
                <div class="input-group" style="width: 400px; align-content: center;">
                <span class="input-group-addon">申请人是否存在民间融资或放贷情况:</span>
                    <input type="text" class="form-control" id="survey_financing_or_landing"  name="survey_financing_or_landing">
                </div>
                <br>
                <div class="input-group" style="width: 400px; align-content: center;">
                    <span class="input-group-addon">申请人主要授信银行:</span>
                    <input type="text" class="form-control" id="survey_banck" name="survey_banck" >
                </div>
                <br>
                <div class="input-group" style="width: 400px; align-content: center;">
                    <span class="input-group-addon">申请人信贷业务品种:</span>
                    <input type="text" class="form-control" id="survey_variety"name="survey_variety" >
                </div>
                <br>
                <div class="input-group" style="width: 400px; align-content: center;">
                    <span class="input-group-addon">申请人信贷业务余额:</span>
                    <input type="text" class="form-control" id="survey_balance"
                           name="survey_balance" >
                </div>
                <br>
                <div class="input-group" style="width: 400px; align-content: center;">
                    <span class="input-group-addon">利率:</span>
                    <input type="text" class="form-control" id="survey_interest_or_margin"  name="survey_interest_or_margin">
                </div>
                <br>
                <div class="input-group" style="width: 400px; align-content: center;">
                    <span class="input-group-addon">到期日:</span>
                    <input type="text" class="form-control" id="survey_due_date" name="survey_due_date" >
                </div>
                <br>
                <div class="input-group" style="width: 400px; align-content: center;">
                    <span class="input-group-addon">担保方式:</span>
                    <input type="text" class="form-control" id="survey_guaranty_style"  name="survey_guaranty_style">
                </div>
                <br>
                <div class="input-group" style="width: 400px; align-content: center;">
                    <span class="input-group-addon">担保人名称:</span>
                    <input type="text" class="form-control" id="survey_guarantor"  name="survey_guarantor">
                </div>
                <br>
                <div class="input-group" style="width: 400px; align-content: center;">
                    <span class="input-group-addon">其他说明事项:</span>
                    <input type="text" class="form-control" id="survey_other" name="survey_other" >
                </div>
                <br>
                <div class="input-group" style="width: 400px; align-content: center;">
                    <span class="input-group-addon">是否进入复审:</span>
                    <select class="form-control" name="fushen" id="fushen">
                        <option>是</option>
                        <option>否</option>
                    </select>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="submit" class="btn btn-primary">提交申请</button>
                </div>
            </form>

        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

</body>
</html>
