<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/10/11
  Time: 11:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>部门管理</title>
    <!-- 引入BootStrap库 -->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
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
    <script src="bootstrap/js/select2.js"></script>
    <script src="bootstrap/js/select.js"></script>
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.11.1/bootstrap-table.min.css">
    <!-- Latest compiled and minified JavaScript -->
    <script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.11.1/bootstrap-table.min.js"></script>
    <!-- Latest compiled and minified Locales -->
    <script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.11.1/locale/bootstrap-table-zh-CN.min.js"></script>
</head>
<body onload="showSe()">
<div class="panel-body" style="padding-bottom:0px;">
    <div class="panel panel-default">
        <div class="panel-heading">查询条件</div>
        <div class="panel-body">
            <form id="formSearch" class="form-horizontal">
                <div class="form-group" style="margin-top:15px">
                    <label class="control-label col-sm-1" for="d_txt_search_statu">部门编号</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" id="d_txt_search_statu">
                    </div>
                    <label class="control-label col-sm-1" for="d_txt_search_departmentname">部门名称</label>
                    <div class="col-sm-3">
                        <select class="form-control" name="facility_type" id="d_txt_search_departmentname">
                            <option></option>
                        </select>
                    </div>
                    <div class="col-sm-4" style="text-align:left;">
                        <button type="button" style="margin-left:50px" id="btn_query2" class="btn btn-primary">查询</button>
                    </div>
                </div>
            </form>
        </div>
    </div>

    <div id="toolbar" class="btn-group">
        <button id="btn_add2" type="button" class="btn btn-default">
            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增部门
        </button>
    </div>
    <table id="tb_departments"></table>

    <!-- 添加 -->
    <div class="modal" id="mymodal1">
        <div class="modal-dialog">
            <div class="modal-content">
                <br/>
                    部门名称：<input class="input-text radius" type="text" name="department_industry_title" id="department_industry_title" placeholder="请输入部门名称"><br><br/>
                    添加人：<input class="input-text radius" type="text" name="department_name" id="department_name" value="${administrator_name}" disabled><br><br/>
                    <button type="button" class="btn btn-default add2" data-dismiss="modal" style="margin-left: 40%;">确认</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->


<!-- 修改 -->
<div class="modal" id="mymodal13">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                <br/>
                部门名称：<input class="input-text radius" type="text" name="department_industry_title" id="department_industry_title2" style="border-style: none"><br><br/>
                部门人员数量：<input class="input-text radius" type="number" name="department_number_quantity" id="department_number_quantity2" style="border-style: none;background: white" disabled><br/><br/>
                添加人：<input class="input-text radius" type="text" name="department_name" id="department_name2" value="${administrator_name}" style="border-style: none;background: white" disabled><br><br/>
                注册时间：<input class="input-text radius" type="text" name="department_time" id="department_time2" style="border-style: none;background: white" disabled><br><br/>
                <button type="button" class="btn btn-default update" data-dismiss="modal" style="margin-left: 40%;">确认</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<!-- 删除 -->
    <div class="modal" id="mymodal12">
        <div class="modal-body" id="bbody">
            <a class="close" data-dismiss="modal">×</a>
            <p class="ddelete">确认删除？</p>
        </div>
    <div class="modal-footer">
        <a id="sure" class="btn btn-primary">确定</a>
        <a  data-dismiss="modal" class="btn btn-primary">取消</a>
    </div>
</div>

</div>
<script type="text/javascript">
    var did;//部门编号
    var dtime;
    var dtitle;
    var dnumber;
    var dname;
    $(function () {
        //1.初始化Table
        var oTable = new TableInit();
        oTable.Init();
        //2.初始化Button的点击事件
        var oButtonInit = new ButtonInit();
        oButtonInit.Init();

        //根据条件查询
        $("#btn_query2").click(function () {
            var TableInit = function () {
                var oTableInit = new Object();
                //初始化Table
                oTableInit.Init = function () {

                    $('#tb_departments').bootstrapTable({
                        url: '/getDepartmentAll.action',         //请求后台的URL（*）
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
                            field: 'department_id',
                            title: '编号'
                        }, {
                            field: 'department_industry_title',
                            title: '部门名称'
                        }, {
                            field: 'department_number_quantity',
                            title: '部门人员数量'
                        }, {
                            field: 'department_name',
                            title: '添加人'
                        }, {
                            field: 'department_time',
                            title: '添加时间'
                        },{
                            title: '操作',
                            align: 'center',
                            formatter:function(value,row,index){
                                var d = '<button  class="btn btn-primary radius"  onclick="updateDepartment()">修改</button> ';
                                var e = '<button  class="btn btn-primary radius"  onclick="deleteDepartment()">删除</button> ';
                                return e+d;
                            }
                        }],
                        //单击一行得到当前行数据
                        onClickCell:function(field, value, row) {
                            did=row.department_id;
                            $("#department_time2").val(row.department_time);
                            $("#department_industry_title2").val(row.department_industry_title);
                            $("#department_number_quantity2").val(row.department_number_quantity);
                            $("#department_name2").val(row.department_name);
                        }
                    });
                };
                //得到查询的参数
                oTableInit.queryParams = function (params) {
                    var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
                        limit: params.limit,   //页面大小
                        offset: params.offset,  //页码
                        d_txt_search_departmentname: $("#d_txt_search_departmentname").val(),
                        d_txt_search_statu: $("#d_txt_search_statu").val()
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
                $("#tb_departments").bootstrapTable('refresh');
        });


        //添加
        $("#btn_add2").click(function(){
            $("#mymodal1").modal("toggle");
        });
        $(".add2").click(function(){
            var department_industry_title=$("#department_industry_title").val();
            var department_name=$("#department_name").val();
            $.post("/addDepartment.action",{
                "department_industry_title":department_industry_title,
                "department_name":department_name
            },function(data){
                if(data=="成功"){
                    alert("添加成功");
                    $("#tb_departments").bootstrapTable("refresh");
                }else {
                    alert("该部门已存在，请重新填写");
                }
            });
        });

        });



    var TableInit = function () {
        var oTableInit = new Object();
        //初始化Table
        oTableInit.Init = function () {

            $('#tb_departments').bootstrapTable({
                url: '/getDepartmentAll.action',         //请求后台的URL（*）
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
                    field: 'department_id',
                    title: '编号'
                }, {
                    field: 'department_industry_title',
                    title: '部门名称'
                }, {
                    field: 'department_number_quantity',
                    title: '部门数量'
                }, {
                    field: 'department_name',
                    title: '添加人'
                }, {
                    field: 'department_time',
                    title: '添加时间'
                },{
                    title: '操作',
                    align: 'center',
                    formatter:function(value,row,index){
                        var d = '<button  class="btn btn-primary radius"  onclick="updateDepartment()">修改</button> ';
                        var e = '<button  class="btn btn-primary radius"  onclick="deleteDepartment()">删除</button> ';
                        return e+d;
                    }
                } ],
                //单击一行得到当前行数据
                onClickCell:function(field, value, row) {
                    did=row.department_id;
                    $("#department_time2").val(row.department_time);
                    $("#department_industry_title2").val(row.department_industry_title);
                    $("#department_number_quantity2").val(row.department_number_quantity);
                    $("#department_name2").val(row.department_name);
                }
            });
        };

        //得到查询的参数
        oTableInit.queryParams = function (params) {
            var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
                limit: params.limit,   //页面大小
                offset: params.offset,  //页码
                d_txt_search_departmentname: $("#d_txt_search_departmentname").val(),
                d_txt_search_statu: $("#d_txt_search_statu").val()
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

    //下拉查询
    function showSe() {
        //部门
        $.ajax({
            type: 'post',
            url: "getDepartmentNames.action",
            dataType: 'json',
            success: function (datas) {//返回list数据并循环获取
                var select = $("#d_txt_search_departmentname");
                for (var i = 0; i < datas.length; i++) {
                    select.append("<option value='" + datas[i] + "'>" + datas[i] + "</option>");
                }
            }
        });
    }


    //删除
    function deleteDepartment() {
        $("#mymodal12").modal("toggle");
    }
    $("#sure").click(function () {
        $.post("/deleteDep.action",{
            "did":did
        },function(data){
            $('#mymodal12').modal('hide');//隐藏对话框
            if(data=="失败"){
                alert("该部门下面还有人员，无法删除");
            }else {
                alert("删除成功");
            }
            $("#tb_departments").bootstrapTable('refresh', {url: '/getDepartmentAll.action'});
        });
    });


    //修改
    function updateDepartment() {
        $("#mymodal13").modal("toggle");
    }
    $(".update").click(function () {
        $.post("/upDep.action", {
            "dtime":$("#department_time2").val(),
            "dtitle":$("#department_industry_title2").val(),
            "dnumber":$("#department_number_quantity2").val(),
            "dname":$("#department_name2").val(),
            "did":did
        },function (data) {
            if(data=="成功"){
                alert("部门信息修改成功")
            }
            $("#tb_departments").bootstrapTable('refresh', {url: '/getDepartmentAll.action'});
        });
    });


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
    .ddelete{
        color: white;
        padding-top: 30px
    }
</style>
</body>
</html>
