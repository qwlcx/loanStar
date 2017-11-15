<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/11/9 0009
  Time: 19:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<table class="table table-hover table-striped table-bg" id="myt"></table>
<div class="modal" id="mymodal33">
    <div class="modal-body" id="bbody">
        <a class="close" data-dismiss="modal">×</a>
        <p class="pdelete">确认删除？</p>
    </div>
    <div class="modal-footer">
        <a id="facility_id" class="btn btn-primary">确定</a>
        <a  data-dismiss="modal" class="btn btn-primary">取消</a>
    </div>
</div>
<!-- 修改 -->
<div class="modal" id="mymodal36">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                客户姓名：<input class="input-text radius" type="text" name="client_name" id="client_name" style="border-style: none"><br/><br/>
                客户电话：<input class="input-text radius" type="text" name="client_telphone" id="client_telphone" style="border-style: none"><br/><br/>
                客户身份证：<input class="input-text radius" type="text" name="client_id_number" id="client_id_number" style="border-style: none;background: white"><br><br/>
                卡号：<input class="input-text radius" type="text" name="client_card_number" id="client_card_number" style="border-style: none;background: white"><br><br/>
                <button type="button" class="btn btn-default update" data-dismiss="modal" style="margin-left: 40%;" onclick="updateClient2()">确认</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<!-- 添加 -->
<%--<div class="modal" id="mymodal1">--%>
    <%--<div class="modal-dialog">--%>
        <%--<div class="modal-content">--%>
            <%--<div class="modal-body">--%>
                <%--<input class="input-text radius" type="text" name="client_name2" id="client_name2" placeholder="请输入客户姓名"><br/>--%>
                <%--<input class="input-text radius" type="text" name="client_telphone2" id="client_telphone2" placeholder="请输入客户联系电话"><br/>--%>
                <%--<input class="input-text radius" type="text" name="client_id_type2" id="client_id_type2" placeholder="请输入证件类型"><br/>--%>
                <%--<input class="input-text radius" type="text" name="client_id_number2" id="client_id_number2" placeholder="请输入证件号"><br/>--%>
                <%--<input class="input-text radius" type="text" name="financial_remark" id="financial_remark" placeholder="备注"><br/>--%>
                <%--<input class="input-text radius" type="text" name="financial_state" id="financial_state" placeholder="状态"><br/>--%>
                <%--<button type="button" class="btn btn-default add2" data-dismiss="modal" style="margin-left: 40%;">确认</button>--%>
                <%--<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>--%>
            <%--</div>--%>
        <%--</div><!-- /.modal-content -->--%>
    <%--</div><!-- /.modal-dialog -->--%>
<%--</div><!-- /.modal -->--%>
<script type="text/javascript">
    $(function () {

        var client_id;

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
                url: '/getClientAll.action',         //请求后台的URL（*）
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
                pageSize: 7,                       //每页的记录行数（*）
                pageList: [14, 21, 28, 35],        //可供选择的每页的行数（*）
                search: true,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
                strictSearch: true,
                showColumns: true,                  //是否显示所有的列
                showRefresh: true,                  //是否显示刷新按钮
                minimumCountColumns: 2,             //最少允许的列数
                clickToSelect: true,                //是否启用点击选中行
                height: 510,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
                uniqueId: "client_id",                     //每一行的唯一标识，一般为主键列
                showToggle:true,                    //是否显示详细视图和列表视图的切换按钮
                cardView: false,                    //是否显示详细视图
                detailView: false,                   //是否显示父子表
                columns:  [{
                    title: '客户管理ID',
                    field: 'client_id',
                    align: 'center',
                    valign: 'middle',
                    visible:false
                }, {
                    title: '客户姓名',
                    field: 'client_name',
                    align: 'center',
                    valign: 'middle',
                }, {
                    title: '联系电话',
                    field: 'client_telphone',
                    align: 'center',
                    valign: 'middle',
                }, {
                    title: '身份证号',
                    field: 'client_id_number',
                    align: 'center',
                    valign: 'middle',
                }, {
                    title: '服务机构',
                    field: 'facility_type',
                    align: 'center',
                    valign: 'middle',
                }, {
                    title: '卡号',
                    field: 'client_card_number',
                    align: 'center',
                    valign: 'middle',
                },{
                    title: '操作',
                    align: 'center',
                    formatter:function(value,row,index){
                        financial_id=row.financial_id;
                        var e = '<button class="btn btn-primary size-M radius delete" onclick="deleteClient()">删除</button> ';
                        var f = '<button class="btn btn-primary size-M radius delete" onclick="updateClient()">修改</button> ';
                        /*var g = '<button class="btn btn-primary size-M radius delete" onclick="addClient()">添加</button> ';*/
                        return e+f;
                    }
                }
                ],
                onClickCell:function(field, value, row) {
                    client_id=row.client_id;
                }
            });
        };

        //得到查询的参数
        oTableInit.queryParams = function (params) {
            var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
                limit: params.limit,   //页面大小
                offset: params.offset  //页码
//                departmentname: $("#financial_institution_number").val(),
//                statu: $("#financial_state").val()
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

    function deleteClient() {
        $("#mymodal33").modal("toggle");
        $.post("/deleteClient.action",{
            "fid":client_id
        },function(data){
            $("#myt").bootstrapTable('refresh', {url: '/getClientAll.action'});
        });
    }

    function updateClient() {
        $("#mymodal36").modal("toggle");
    }

    function updateClient2() {
        var client_name = $("#client_name").val();
        var client_telphone = $("#client_telphone").val();
        var client_id_number = $("#client_id_number").val();
        var client_card_number = $("#client_card_number").val();
        $.post("/updateClient.action",{
            "client_id":client_id,
            "client_name": client_name,
            "client_telphone": client_telphone,
            "client_id_number": client_id_number,
            "client_card_number": client_card_number
        },function(data){
            $("#myt").bootstrapTable('refresh', {url: '/getClientAll.action'});
        });
    }

   /* function addClient() {

    }*/
</script>
<style type="text/css">
    #mymodal33{
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
