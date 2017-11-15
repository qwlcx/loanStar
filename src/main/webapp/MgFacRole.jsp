<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="static/h-ui/css/H-ui.min.css" />
    <link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/H-ui.admin.css" />
    <link rel="stylesheet" type="text/css" href="lib/Hui-iconfont/1.0.8/iconfont.css" />
    <link rel="stylesheet" type="text/css" href="static/h-ui.admin/skin/green/skin.css" id="skin" />
    <link rel="stylesheet" type="text/css" href="static/h-ui.admin/css/style.css" />
    <script type="text/javascript" src="jquery/jquery-3.1.1.min.js"></script>
    <script type="text/javascript" src="bootstrap/js/bootstrap.js"></script>
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.11.1/bootstrap-table.min.css">
    <!-- Latest compiled and minified JavaScript -->
    <script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.11.1/bootstrap-table.min.js"></script>
    <!-- Latest compiled and minified Locales -->
    <script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.11.1/locale/bootstrap-table-zh-CN.min.js"></script>
    <meta charset="UTF-8" />
    <title>Title</title>
</head>
<body>
<!-- 删除 -->
<div class="modal" id="mymodal12">
    <div class="modal-body" id="bbody">
        <a class="close" data-dismiss="modal">×</a>
        <p class="pdelete">确认删除？</p>
    </div>
    <div class="modal-footer">
        <a id="facility_id" class="btn btn-primary">确定</a>
        <a  data-dismiss="modal" class="btn btn-primary">取消</a>
    </div>
</div>
<button class="btn btn-primary size-M radius add" style="float: right;margin-right: 50px;margin-bottom: 6px;">添加</button>
<div class="mt-20" style="width: 90%;margin-left: 5%;">
    <p  style="float: right;margin-right: 5px;margin-bottom: 6px;">
        <button type="button" class="btn btn-default btn-sm" onclick="refresh()">
            <span class="glyphicon glyphicon-refresh"></span> Refresh
        </button>
    </p>
    <table class="table table-hover table-striped table-bg" id="myt"></table>
</div>
<!-- 添加 -->
<div class="modal" id="mymodal1">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                管理员注册时间：<input class="input-text radius" type="text" name="manager_register_time" id="manager_register_time" placeholder="请输入管理员注册时间"><br/>
                管理员账号：<input class="input-text radius" type="text" name="manager_character" id="manager_character" placeholder="请输入管理员账号"><br/>
                管理员姓名：<input class="input-text radius" type="text" name="manager_name" id="manager_name" placeholder="请输入管理员账号" value="${administrator_name}" disabled><br/>
                联系人电话：<input class="input-text radius" type="text" name="financial_telphone" id="financial_telphone" placeholder="请输入联系人电话"><br/>
                状态：<input class="input-text radius" type="text" name="manager_state" id="manager_state" placeholder="备注"><br/>
                <select onclick="selectRole_name()" id="sel_staff7" name="sel_staff7">
                    <option>-- 请选择角色 --</option>
                </select><br/>
                <select id="sel_staff8" onclick="selectFacility_type()" name="sel_staff8">
                    <option>-- 请选择服务机构 --</option>
                </select><br/>
                <select id="sel_staff9" onclick="selectFacility_type()" name="sel_staff9">
                    <option>-- 请选择部门类型 --</option>
                </select><br/>
                <button type="button" class="btn btn-default add2" data-dismiss="modal" style="margin-left: 40%;">确认</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<script type="text/javascript">

    var department;

    $(".add").click(function(){
        $("#mymodal1").modal("toggle");
        $.ajax({
            type : 'post',
            url :"/selectRole_name.action",
            dataType : 'json',
            success : function(datas) {//返回list数据并循环获取
                var select = $("#sel_staff7");
                for (var i = 0; i < datas.length; i++) {
                    select.append("<option value='"+datas[i].role_name+"'>"
                        + datas[i].role_name + "</option>");
                }
            }
        });
        $.ajax({
            type : 'post',
            url :"/selectFacility_type.action",
            dataType : 'json',
            success : function(datas) {//返回list数据并循环获取
                var select = $("#sel_staff8");
                for (var i = 0; i < datas.length; i++) {
                    select.append("<option value='"+datas[i].facility_orgization_name+"'>"
                        + datas[i].facility_orgization_name + "</option>");
                }
            }
        });
        $.ajax({
            type : 'post',
            url :"/selectDepartment_industry_title.action",
            dataType : 'json',
            success : function(datas) {//返回list数据并循环获取
                var select = $("#sel_staff9");
                for (var i = 0; i < datas.length; i++) {
                    select.append("<option value='"+datas[i].department_industry_title+"'>"
                        + datas[i].department_industry_title + "</option>");
                }
            }
        });
    });

    $(".add2").click(function(){
        var manager_register_time=$("#manager_register_time").val();
        var manager_character=$("#manager_character").val();
        var manager_name=$("#manager_name").val();
        var financial_telphone=$("#financial_telphone").val();
        var sel_staff7=$("#sel_staff7").val();
        var sel_staff8=$("#sel_staff8").val();
        var sel_staff9=$("#sel_staff9").val();
        department=sel_staff9;
        $.post("/addRoleFacilityManager.action",{
            "manager_register_time":manager_register_time,
            "manager_character":manager_character,
            "manager_name":manager_name,
            "financial_telphone":financial_telphone,
            "sel_staff7":sel_staff7,
            "sel_staff8":sel_staff8,
            "sel_staff9":sel_staff9
        },function(data){
            $("#myt").bootstrapTable('refresh', {url: '/getRoleManagerFac.action'});
        });
    });

    var fid;

    $(function () {

        //1.初始化Table
        var oTable = new TableInit();
        oTable.Init();

        //2.初始化Button的点击事件
        var oButtonInit = new ButtonInit();
        oButtonInit.Init();

    });

    var TableInit = function () {
        var oTableInit = new Object();
        //初始化Table
        oTableInit.Init = function () {

            $('#myt').bootstrapTable({
                url: '/getRoleManagerFac.action',         //请求后台的URL（*）
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
                columns:  [{
                    title: '管理员ID',
                    field: 'manager_id',
                    align: 'center',
                    valign: 'middle',
                    visible:false
                }, {
                    title: '注册时间',
                    field: 'manager_register_time',
                    align: 'center',
                    valign: 'middle',
                }, {
                    title: '管理员账号',
                    field: 'manager_character',
                    align: 'center',
                    valign: 'middle',
                }, {
                    title: '管理员名字',
                    field: 'manager_name',
                    align: 'center',
                    valign: 'middle',
                }, {
                    title: '所属机构',
                    field: 'facility_type',
                    align: 'center',
                    valign: 'middle',
                }, {
                    title: '所属部门',
                    field: 'department_industry_title',
                    align: 'center',
                    valign: 'middle',
                }, {
                    title: '所属角色',
                    field: 'role_name',
                    align: 'center',
                    valign: 'middle',
                }, {
                    title: '状态',
                    field: 'manager_state',
                    align: 'center',
                    valign: 'middle',
                },{
                    title: '操作',
                    align: 'center',
                    formatter:function(value,row,index){
                        if(row.manager_state=='冻结'){
                            var e = '<button class="btn btn-primary size-M radius delete" onclick="updateFacilityManager(\''+row.manager_id+'\',\''+row.manager_state+'\')">激活</button>';
                            return e;
                        }else{
                            var e = '<button class="btn btn-primary size-M radius delete" onclick="updateFacilityManager(\''+row.manager_id+'\',\''+row.manager_state+'\')">冻结</button>';
                            return e;
                        }
                    }
                }
                ]
            });
        };

        //得到查询的参数
        oTableInit.queryParams = function (params) {
            var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
                limit: params.limit,   //页面大小
                offset: params.offset  //页码
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

    function updateFacilityManager(a,b) {
        alert(a);
        alert(b);
        $.post("/updateRoleFacilityManager.action",{
            "manager_id":a,
            "manager_state":b
        },function(data){
            $("#myt").bootstrapTable('refresh', {url: '/getRoleManagerFac.action'});
            window.location.reload();
        });
    }
</script>
<style type="text/css">
    #mymodal12{
        margin-top: 200px;
        margin-left:500px;
        text-align: center;
        background: black;
        width: 300px;
        height: 170px
    }
</style>
</body>
</html>