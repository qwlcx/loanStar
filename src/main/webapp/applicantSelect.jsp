<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/10/26 0026
  Time: 18:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
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
    <c:when test="${roleName1=='风控初审人员' or roleName2=='风控初审人员'}">
        $(function(){
            $("#cusTable").bootstrapTable({
                url: "/getApplicantSelect.action", //获取数据的Servlet地址
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
                            var e = '<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">审核</button> ';
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
        url: "/getApplicantSelect.action", //获取数据的Servlet地址
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

       $(function(){
           $('#myModal').on('shown.bs.modal', function () {
               //
               var b= $("#cusTable").bootstrapTable('getSelections');
               if(b.length>0){
                    //绑定数据
                   $('#applicant_serial_number').val(b[0].applicant_serial_number);
                   $('#applicant_name').val(b[0].applicant_name);
                   $('#applicant_time').val(b[0].applicant_time);
                   $('#applicant_telphone').val(b[0].applicant_telphone);
                   $('#applicant_id_type').val(b[0].applicant_id_type);
                   $('#applicant_id_number').val(b[0].applicant_id_number);
                   $('#applicant_address').val(b[0].applicant_address);
                   $('#applicant_aggregate_amount').val(b[0].applicant_aggregate_amount);
                   $('#facility_name').val(b[0].facility_name);
                   $('#partner_name').val(b[0].partner_name);
                   $('#applicant_state').val(b[0].applicant_state);
               }
           });

           $("#update").click(function () {
               var b= $("#cusTable").bootstrapTable('getSelections');
               var trueorfalse = $('#trueorfalse').val();
               var number = $('#applicant_serial_number').val();
               var state = $('#applicant_state').val();
               $.post("/updateState.action",{
                       "trueorfalse":trueorfalse,
                       "number":number,
                       "state":state
                   },
                   function(data){
                       $("#myModal").modal('hide');
                       $("#cusTable").bootstrapTable("refresh");
                   });
           });

       });
       
    </script>
</head>
<body>
<table class="table table-hover" id="cusTable"></table>
<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">详细数据</h4>
            </div>
            <div class="input-group" style="width: 400px; align-content: center;">
                <span class="input-group-addon">申请人流水号:</span>
                <input type="text" class="form-control" id="applicant_serial_number" readonly >
            </div>
            <div class="input-group" style="width: 400px; align-content: center;">
                <span class="input-group-addon">申请人姓名:</span>
                <input type="text" class="form-control" id="applicant_name" readonly >
            </div>
            <div class="input-group" style="width: 400px; align-content: center;">
                <span class="input-group-addon">申请时间:</span>
                <input type="text" class="form-control" id="applicant_time" readonly >
            </div>
            <div class="input-group" style="width: 400px; align-content: center;">
                <span class="input-group-addon">申请人联系电话:</span>
                <input type="text" class="form-control" id="applicant_telphone" readonly >
            </div>
            <div class="input-group" style="width: 400px; align-content: center;">
                <span class="input-group-addon">证件类型:</span>
                <input type="text" class="form-control" id="applicant_id_type" readonly >
            </div>
            <div class="input-group" style="width: 400px; align-content: center;">
                <span class="input-group-addon">证件号:</span>
                <input type="text" class="form-control" id="applicant_id_number" readonly >
            </div>
            <div class="input-group" style="width: 400px; align-content: center;">
                <span class="input-group-addon">地址:</span>
                <input type="text" class="form-control" id="applicant_address" readonly >
            </div>
            <div class="input-group" style="width: 400px; align-content: center;">
                <span class="input-group-addon">申请总金额:</span>
                <input type="text" class="form-control" id="applicant_aggregate_amount" readonly >
            </div>
            <div class="input-group" style="width: 400px; align-content: center;">
                <span class="input-group-addon">所属服务机构:</span>
                <input type="text" class="form-control" id="facility_name" readonly >
            </div>
            <div class="input-group" style="width: 400px; align-content: center;">
                <span class="input-group-addon">所属FA:</span>
                <input type="text" class="form-control" id="partner_name" readonly >
            </div>
            <div class="input-group" style="width: 400px; align-content: center;">
                <span class="input-group-addon">当前状态:</span>
                <input type="text" class="form-control" id="applicant_state" readonly >
            </div>
            <div class="input-group" style="width: 400px; align-content: center;">
                <span class="input-group-addon">审核是否通过:</span>
                <select class="form-control" name="trueorfalse" id="trueorfalse">
                    <option>通过</option>
                    <option>未通过</option>
                </select>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" onclick="update()" id="update" name="update" >提交</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
</body>
</html>
