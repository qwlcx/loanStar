<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2017/11/3
  Time: 8:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>贷款合作商管理</title>
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
</head>
<body onload="select()">
<div class="panel-body" style="padding-bottom:0px;">
    <div class="panel panel-default">
        <div class="panel-heading">查询条件</div>
        <div class="panel-body">
            <form id="formSearch" class="form-horizontal">
                <div class="form-group" style="margin-top:15px">
                    <label class="control-label col-sm-1" for="txt_search_departmentname">FA姓名</label>
                    <div class="col-sm-3">
                        <select class="form-control" name="facility_orgization_name" id="txt_search_departmentname">
                            <option></option>
                        </select>
                    </div>
                    <label class="control-label col-sm-1" for="txt_search_statu">所属机构</label>
                    <div class="col-sm-3">
                        <select class="form-control" name="facility_orgization_name" id="txt_search_statu">
                            <option></option>
                        </select>
                    </div>
                    <div class="col-sm-4" style="text-align:left;">
                        <button type="button" style="margin-left:50px" id="btn_query" class="btn btn-primary">查询</button>
                    </div>
                </div>
            </form>
        </div>
    </div>

    <div id="toolbar" class="btn-group">
        <button id="btn_add" type="button" class="btn btn-default"  onclick="getSelect()">
            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增FA
        </button>
    </div>
    <table id="tb_departments"></table>

    <!-- 添加 -->
    <div class="modal" id="mymodal1">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-body">
                    FA登录账号：<input class="input-text radius" type="text" name="partner_character" id="partner_character" placeholder="请输入FA登录账号"><br><br/>
                    FA负责人姓名：<input class="input-text radius" type="text" name="partner_name" id="partner_name" placeholder="请输入负责人姓名" value="${administrator_name}" disabled><br><br/>
                    FA办公地址：<input class="input-text radius" type="text" name="partner_address" id="partner_address" placeholder="请输入办公地址"><br><br/>
                    FA联系电话：<input class="input-text radius" type="tel" name="partner_telphone" id="partner_telphone" placeholder="请输入联系电话"><br><br/>
                    所属角色：<select class="form-control" name="role_name" id="roleName">
                                    <option></option>
                            </select><br/>
                    所属机构：<select class="form-control" name="facility_orgization_name" id="facility_orgizationName">
                                    <option></option>
                            </select><br/>
                    所属部门：<select class="form-control" name="department_industry_title" id="department_industryTitle">
                                    <option></option>
                            </select><br/>
                    <button type="button" class="btn btn-default add2" data-dismiss="modal" style="margin-left: 40%;">确认</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->


    <!-- 删除 -->
    <div class="modal" id="mymodal12">
        <div class="modal-body" id="bbody">
            <a class="close" data-dismiss="modal">×</a>
            <p class="pdelete">确认删除？</p>
        </div>
        <div class="modal-footer">
            <a id="sure" class="btn btn-primary">确定</a>
            <a  data-dismiss="modal" class="btn btn-primary">取消</a>
        </div>
    </div>


    <!-- 修改 -->
    <div class="modal" id="mymodal13">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-body">
                    FA登录账号：<input class="input-text radius" type="text" name="partner_character" id="partner_character2"  style="border-style: none;background: white" disabled><br><br/>
                    FA负责人姓名：<input class="input-text radius" type="text" name="partner_name" id="partner_name2" style="border-style: none"><br><br/>
                    FA办公地址：<input class="input-text radius" type="text" name="partner_address" id="partner_address2" style="border-style: none"><br><br/>
                    FA联系电话：<input class="input-text radius" type="tel" name="partner_telphone" id="partner_telphone2" style="border-style: none"><br><br/>
                    所属角色：<select class="form-control" name="role_name" id="roleName2">
                                    <option></option>
                             </select><br/>
                    所属机构：<select class="form-control" name="facility_orgization_name" id="facility_orgizationName2">
                                    <option></option>
                            </select><br/>
                    所属部门：<select class="form-control" name="department_industry_title" id="department_industryTitle2">
                                    <option></option>
                            </select><br/>
                    <button type="button" class="btn btn-default update" data-dismiss="modal" style="margin-left: 40%;">确认</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->


</div>
<script type="text/javascript">

    var parId;

    //一进入界面就开始调方法，下拉查询
    function select() {
        //机构
        $.ajax({
            type: 'post',
            url: "getPartnerFacilityNames.action",
            dataType: 'json',
            success: function (datas) {//返回list数据并循环获取
                var select = $("#txt_search_statu");
                for (var i = 0; i < datas.length; i++) {
                    select.append("<option value='" + datas[i] + "'>" + datas[i] + "</option>");
                }
            }
        });

        $.ajax({
            type: 'post',
            url: "getPartnerNames.action",
            dataType: 'json',
            success: function (datas) {//返回list数据并循环获取
                var select = $("#txt_search_departmentname");
                for (var i = 0; i < datas.length; i++) {
                    select.append("<option value='" + datas[i] + "'>" + datas[i] + "</option>");
                }
            }
        });
    }

    $(function () {
        //1.初始化Table
        var oTable = new TableInit();
        oTable.Init();
        //2.初始化Button的点击事件
        var oButtonInit = new ButtonInit();
        oButtonInit.Init();

    //根据条件查询
        $("#btn_query").click(function () {
            $("#tb_departments").bootstrapTable('refresh', {url: '/getPartnerAll.action'});
        });

        //添加
        $("#btn_add").click(function(){
            $("#mymodal1").modal("toggle");
        });
        $(".add2").click(function(){
            var partner_character=$("#partner_character").val();
            var partner_name=$("#partner_name").val();
            var partner_address=$("#partner_address").val();
            var partner_telphone=$("#partner_telphone").val();
            var role_name=$("#roleName").val();
            var facility_orgization_name=$("#facility_orgizationName").val();
            var department_industry_title=$("#department_industryTitle").val();
            $.post("/addPart.action",{
                "partner_character":partner_character,
                "partner_name":partner_name,
                "partner_address":partner_address,
                "partner_telphone":partner_telphone,
                "role_name":role_name,
                "facility_orgization_name":facility_orgization_name,
                "department_industry_title":department_industry_title
            },function(data){
                if(data=="失败"){
                    alert("已有该账号，请重新填写");
                }else {
                    alert("添加成功");
                    $("#tb_departments").bootstrapTable('refresh', {url: '/getPartnerAll.action'});
                }
            });
        });
    });



    var TableInit = function () {
        var oTableInit = new Object();
        //初始化Table
        oTableInit.Init = function () {

            $('#tb_departments').bootstrapTable({
                url: '/getPartnerAll.action',         //请求后台的URL（*）
                method: 'get',                      //请求方式（*）
                toolbar: '#toolbar',                //工具按钮用哪个容器
                striped: true,                      //是否显示行间隔色
                cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
                pagination: true,                   //是否显示分页（*）
                sortable: true,                     //是否启用排序
                sortOrder: "asc",                   //排序方式
                queryParams: oTableInit.queryParams,//传递参数（*）
                sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
                pageNumber:1,                       //初始化加载第一页，默认第一页
                pageSize: 10,                       //每页的记录行数（*）
                pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
//                search: true,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
                strictSearch: true,
                showColumns: true,                  //是否显示所有的列
                showRefresh: true,                  //是否显示刷新按钮
                minimumCountColumns: 2,             //最少允许的列数
                clickToSelect: true,                //是否启用点击选中行
                height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
                uniqueId: "ID",                     //每一行的唯一标识，一般为主键列
                showToggle:true,                    //是否显示详细视图和列表视图的切换按钮
                cardView: false,                    //是否显示详细视图
                detailView: false,                   //是否显示父子表
                columns: [{
                    checkbox: true
                }, {
                    field: 'partner_id',
                    title: 'FA编号'
                }, {
                    field: 'partner_time',
                    title: '添加时间'
                }, {
                    field: 'partner_character',
                    title: 'FA登录账号'
                }, {
                    field: 'partner_name',
                    title: 'FA姓名'
                }, {
                    field: 'partner_address',
                    title: '办公地址'
                } , {
                    field: 'partner_telphone',
                    title: '联系电话'
                } , {
                    field: 'facility_orgization_name',
                    title: '所属机构'
                } , {
                    field: 'role_name',
                    title: '所属角色'
                } , {
                    field: 'department_industry_title',
                    title: '所属部门'
                } , {
                    field: 'partner_sate',
                    title: '状态'
                },{
                    title: '操作',
                    align: 'center',
                    formatter:function(value,row,index){
                        var d = '<button  class="btn btn-primary radius"  onclick="updatePartner()">修改</button> ';
                        var e = '<button  class="btn btn-primary radius"  onclick="deletePartner(\''+row.partner_id+'\',\''+row.department_industry_title+'\')">删除</button> ';
                        if(row.partner_sate=='激活'){
                           var f= '<button  class="btn btn-primary size-M radius delete"  onclick="djPartner(\''+row.partner_sate+'\',\''+row.partner_id+'\')">冻结</button> ';
                             return d+e+f;
                        }else{
                           var f = '<button  class="btn btn-primary size-M radius delete"  onclick="djPartner(\''+row.partner_sate+'\',\''+row.partner_id+'\')">激活</button> ';
                            return d+e+f;
                        }
                    }
                }],
                //单击一行得到当前行数据
                onClickCell:function(field, value, row) {
                    parId=row.partner_id;
                    $("#partner_character2").val(row.partner_character);
                    $("#partner_name2").val(row.partner_name);
                    $("#partner_address2").val(row.partner_address);
                    $("#partner_telphone2").val(row.partner_telphone);
                    jQuery("#roleName2  option:selected").text(row.role_name);
                    jQuery("#facility_orgizationName2  option:selected").text(row.facility_orgization_name);
                    jQuery("#department_industryTitle2  option:selected").text(row.department_industry_title);
                }
            });
        };
        //得到查询的参数

        oTableInit.queryParams = function (params) {
            var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
                limit: params.limit,   //页面大小
                offset: params.offset,  //页码
                txt_search_departmentname:$("#txt_search_departmentname").val(),
                txt_search_statu:$("#txt_search_statu").val()
            };
            return temp;
        };

        return oTableInit;
    };
    var ButtonInit = function () {
        var oInit = new Object();
        var postdata = {};
        oInit.Init = function () {
            //初始化页面上面的按钮事件
        };
        return oInit;
    };


    //角色下拉
    function getSelect() {
        //角色
        $.ajax({
            type: 'post',
            url: "getRoleNames.action",
            dataType: 'json',
            success: function (datas) {//返回list数据并循环获取
                var select = $("#roleName");
                for (var i = 0; i < datas.length; i++) {
                    select.append("<option value='" + datas[i] + "'>" + datas[i] + "</option>");
                }
            }
        });
        //部门
        $.ajax({
            type: 'post',
            url: "getDepartmentNames.action",
            dataType: 'json',
            success: function (datas) {//返回list数据并循环获取
                var select = $("#department_industryTitle");
                for (var i = 0; i < datas.length; i++) {
                    select.append("<option value='" + datas[i] + "'>" + datas[i] + "</option>");
                }
            }
        });
        //机构
        $.ajax({
            type: 'post',
            url: "getFacilityNames.action",
            dataType: 'json',
            success: function (datas) {//返回list数据并循环获取
                var select = $("#facility_orgizationName");
                for (var i = 0; i < datas.length; i++) {
                    select.append("<option value='" + datas[i] + "'>" + datas[i] + "</option>");
                }
            }
        });
    }


    //删除
    var parid;
    var ptitle;
    function deletePartner(pid,dtitle) {
        $("#mymodal12").modal("toggle");
        parid=pid;
        ptitle=dtitle;
    }
    $("#sure").click(function () {
        $.post("/deletep.action",{
            "pid":parid,
            "dtitle":ptitle
        },function(data){
            $('#mymodal12').modal('hide');//隐藏对话框
            if(data=="成功"){
                alert("删除成功")
            }
            $("#tb_departments").bootstrapTable('refresh', {url: '/getPartnerAll.action'});
        });
    });


    //修改
    function updatePartner() {
        //角色
        $.ajax({
            type: 'post',
            url: "getRoleNames.action",
            dataType: 'json',
            success: function (datas) {//返回list数据并循环获取
                var select = $("#roleName2");
                for (var i = 0; i < datas.length; i++) {
                    select.append("<option value='" + datas[i] + "'>" + datas[i] + "</option>");
                }
            }
        });
        //部门
        $.ajax({
            type: 'post',
            url: "getDepartmentNames.action",
            dataType: 'json',
            success: function (datas) {//返回list数据并循环获取
                var select = $("#department_industryTitle2");
                for (var i = 0; i < datas.length; i++) {
                    select.append("<option value='" + datas[i] + "'>" + datas[i] + "</option>");
                }
            }
        });
        //机构
        $.ajax({
            type: 'post',
            url: "getFacilityNames.action",
            dataType: 'json',
            success: function (datas) {//返回list数据并循环获取
                var select = $("#facility_orgizationName2");
                for (var i = 0; i < datas.length; i++) {
                    select.append("<option value='" + datas[i] + "'>" + datas[i] + "</option>");
                }
            }
        });
        $("#mymodal13").modal("toggle");
    }
    $(".update").click(function () {
        $.post("/upPartner.action", {
            "parId":parId,
            "partner_character":$("#partner_character2").val(),
            "partner_name":$("#partner_name2").val(),
            "partner_address":$("#partner_address2").val(),
            "partner_telphone":$("#partner_telphone2").val(),
            "role_name":$("#roleName2").val(),
            "facility_orgization_name":$("#facility_orgizationName2").val(),
            "department_industry_title":$("#department_industryTitle2").val()
        },function (data) {
            if(data=="成功"){
                alert("修改FA信息成功")
            }
            $("#tb_departments").bootstrapTable('refresh', {url: '/getPartnerAll.action'});
        });
    });



    //是否冻结
    function djPartner(pdj,pid) {
        $.post("/upPartDj.action", {
            "pdj":pdj,
            "pid":pid
        },function (data) {
            $("#tb_departments").bootstrapTable('refresh', {url: '/getPartnerAll.action'});
        });
    }

</script>

<style type="text/css">
    .form-control{
        background-color: #2aabd2;
    }
    .modal-dialog{
        width: 600px;
        height: 600px;
    }
    .form-control{
        width: 250px;
    }
    #mymodal12{
        margin-top: 200px;
        margin-left:500px;
        text-align: center;
        background: black;
        width: 300px;
        height: 170px
    }
    #bbody{
        height: 100px
    }
    .close{
        color: white
    }
    .pdelete{
        color: white;
        padding-top: 30px
    }
</style>
</body>
</html>
