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
    <title>角色管理</title>
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
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.10.0/css/bootstrap-select.min.css">
    <!-- Latest compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.10.0/js/bootstrap-select.min.js"></script>
    <!-- (Optional) Latest compiled and minified JavaScript translation files -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.10.0/js/i18n/defaults-*.min.js"></script>
</head>
<body onload="showSele()">
<div class="panel-body" style="padding-bottom:0px;">
    <div class="panel panel-default">
        <div class="panel-heading">查询条件</div>
        <div class="panel-body">
            <form id="formSearch" class="form-horizontal">
                <div class="form-group" style="margin-top:15px">
                    <label class="control-label col-sm-1" for="txt_search_departmentname">角色名称</label>
                    <div class="col-sm-3">
                        <select class="form-control" name="facility_type" id="txt_search_departmentname">
                            <option></option>
                        </select>
                    </div>
                    <label class="control-label col-sm-1" for="txt_search_statu">角色描述</label>
                    <div class="col-sm-3">
                        <select class="form-control" name="facility_type" id="txt_search_statu">
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
        <button id="btn_add" type="button" class="btn btn-default" onclick="getRole()">
            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增角色
        </button>
    </div>
    <table id="tb_departments"></table>

    <!-- 添加 -->
    <div class="modal" id="mymodal1">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-body">
                    角色名：<input class="input-text radius" type="text" name="role_name" id="role_name" placeholder="请输入机构名称"><br><br/>
                    角色描述：<input class="input-text radius" type="text" name="role_describe" id="role_describe" placeholder="请输入负责地区"><br/><br/>
                    权限： <select  class="form-control" data-style="btn-success" name="permission_name" id="permission_name">
                </select><br/><br/>
                    <button type="button" class="btn btn-default add2" data-dismiss="modal" style="margin-left: 40%;">确认</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button><br/>
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
                    机构类型：<input class="input-text radius" type="text" name="facility_type" id="facility_type2" style="border-style: none"><br/><br/>
                    <input class="input-text radius" type="hidden" name="facility_type" id="facility_id2">
                    机构名称：<input class="input-text radius" type="text" name="facility_orgization_name" id="facility_orgization_name2" style="border-style: none"><br><br/>
                    负责地区：<input class="input-text radius" type="text" name="facility_loclel" id="facility_loclel2" style="border-style: none"><br/><br/>
                    添加人：<input class="input-text radius" type="text" name="facility_name" id="facility_name2" disabled style="border-style: none;background: white"><br><br/>
                    注册时间：<input class="input-text radius" type="text" name="facility_time" id="facility_time2" disabled style="border-style: none;background: white"><br><br/>
                    <button type="button" class="btn btn-default update" data-dismiss="modal" style="margin-left: 40%;">确认</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->


</div>
<script type="text/javascript">
    var rid;//机构编号
    $(function () {
        //1.初始化Table
        var oTable = new TableInit();
        oTable.Init();
        //2.初始化Button的点击事件
        var oButtonInit = new ButtonInit();
        oButtonInit.Init();

        //根据条件查询
        $("#btn_query").click(function () {
            $("#tb_departments").bootstrapTable('refresh',{url:'/getRoleAll.action'});
        });

        //添加
        $("#btn_add").click(function(){
            $("#mymodal1").modal("toggle");
        });
        $(".add2").click(function(){
            var role_name=$("#role_name").val();
            var role_describe=$("#role_describe").val();
            var permission_name=$("#permission_name").val();
            $.post("/addRole.action",{
                "role_name":role_name,
                "role_describe":role_describe,
                "permission_name":permission_name
            },function(data){
                if(data=="成功"){
                    alert("添加成功");
                    $("#tb_departments").bootstrapTable('refresh', {url: '/getRoleAll.action'});
                }else {
                    alert("该角色已存在，请重新填写");
                }
            });
        });
    });



    var TableInit = function () {
        var oTableInit = new Object();
        //初始化Table
        oTableInit.Init = function () {
            $('#tb_departments').bootstrapTable({
                url: '/getRoleAll.action',         //请求后台的URL（*）
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
                detailView: true,                   //是否显示父子表
                columns: [{
                    field: 'role_id',
                    title: '编号'
                }, {
                    field: 'role_name',
                    title: '角色名称'
                }, {
                    field: 'role_describe',
                    title: '角色描述'
                },{
                    title: '操作',
                    align: 'center',
                    formatter:function(value,row,index){
                        var d = '<button  class="btn btn-primary radius"  onclick="updateFacility()">修改</button> ';
                        var e = '<button  class="btn btn-primary radius"  onclick="deleteRole()">删除</button> ';
                        return e+d;
                    }
                }],
                //注册加载子表的事件。注意下这里的三个参数！
                onExpandRow: function (index, row, $detail) {
                    oTableInit.InitSubTable(index, row, $detail);
                },
                //单击一行得到当前行数据
                onClickCell:function(field, value, row) {
                    rid=row.role_id;
                    //给模态框的输入框赋值
                    $("#facility_type2").val(row.facility_type);
                    $("#facility_orgization_name2").val(row.facility_orgization_name);
                    $("#facility_loclel2").val(row.facility_loclel);
                    $("#facility_name2").val(row.facility_name);
                    $("#facility_time2").val(row.facility_time);
                    $("#facility_id2").val(row.facility_id);
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


        //初始化子表格(无线循环)
        oTableInit.InitSubTable = function (index, row, $detail) {
            var roleid=row.role_id;
            var cur_table = $detail.html('<table></table>').find('table');
            $(cur_table).bootstrapTable({
                url: 'getPermissionRole.action',
                method: 'get',
                queryParams: { roleid: roleid },
                clickToSelect: true,
                pagination:true,
                detailView:false,//父子表
                dataType:'json',
                pageSize: 10,
                pageList: [10, 25],
                columns: [
                    {field: 'permission_id',title: '权限编号',align:'center'},
                    {field: 'permission_name',title: '权限名',align:'center'},
                    {field: 'permission_state',title: '权限状态',align:'center'},
                    {title: '操作',field: 'id',align: 'center',
                        formatter:function(value,row,index){
                            var ee = '<button href="#" class="btn btn-default" mce_href="#" onclick="accept(\''+collect_organization+'\',\''+collect_admin+'\',\''+summarized_voucher+'\',\''+row.collect_sum+'\',\''+row.begin_serial_num+'\',\''+row.end_serial_num+'\',\''+row.document_type+'\',\''+row.dispose_sign+'\')">受理<button> ';
                            return ee;
                        }
                    }
                ]
            });
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

    function getRole() {
        //角色
        $.ajax({
            type: 'post',
            url: "getPermissionNames.action",
            dataType: 'json',
            success: function (datas) {//返回list数据并循环获取
                var select = $("#permission_name");
                for (var i = 0; i < datas.length; i++) {
                    select.append("<option value='" + datas[i] + "'>" + datas[i] + "</option>");
                }
            }
        });
    }

    //下拉查询
    function showSele() {
        //角色名称
        $.ajax({
            type: 'post',
            url: "getRoleNames.action",
            dataType: 'json',
            success: function (datas) {//返回list数据并循环获取
                var select = $("#txt_search_departmentname");
                for (var i = 0; i < datas.length; i++) {
                    select.append("<option value='" + datas[i] + "'>" + datas[i] + "</option>");
                }
            }
        });
        //角色描述
        $.ajax({
            type: 'post',
            url: "getRoleDescribes.action",
            dataType: 'json',
            success: function (datas) {//返回list数据并循环获取
                var select = $("#txt_search_statu");
                for (var i = 0; i < datas.length; i++) {
                    select.append("<option value='" + datas[i] + "'>" + datas[i] + "</option>");
                }
            }
        });
    }


    //删除
    function deleteRole() {
        $("#mymodal12").modal("toggle");
    }
    $("#sure").click(function () {
        $.post("/deleteR.action",{
            "rid":rid
        },function(data){
            $('#mymodal12').modal('hide');//隐藏对话框
            if(data=="失败"){
                alert("该角色下面还有人员，无法删除");
            }else {
                alert("删除成功");
            }
            $("#tb_departments").bootstrapTable('refresh', {url: '/getRoleAll.action'});
        });
    });


    //修改
    function updateFacility() {
        $("#mymodal13").modal("toggle");
    }
    $(".update").click(function () {
        $.post("/upFacility.action", {
            "ftime":$("#facility_time2").val(),
            "ftype":$("#facility_type2").val(),
            "foname":$("#facility_orgization_name2").val(),
            "fname":$("#facility_name2").val(),
            "floc":$("#facility_loclel2").val(),
            "fid":$("#facility_id2").val()
        },function (data) {
            $("#tb_departments").bootstrapTable('refresh', {url: '/getRoleAll.action'});
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
    .pdelete{
        color: white;
        padding-top: 30px
    }
</style>
</body>
</html>
