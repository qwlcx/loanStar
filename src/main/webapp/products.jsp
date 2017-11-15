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
    <title>Title</title>
</head>
<body>
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
                金融机构名：<input class="input-text radius" type="text" name="financial_institution_number" id="financial_institution_number" placeholder="请输入金融机构名称"><br/>
                注册时间：<input class="input-text radius" type="text" name="financial_register_time" id="financial_register_time" placeholder="请输入注册时间"><br/>
                联系人名字：<input class="input-text radius" type="text" name="financial_name" id="financial_name" placeholder="请输入业务联系人"><br/>
                联系人电话：<input class="input-text radius" type="text" name="financial_telphone" id="financial_telphone" placeholder="请输入联系人电话"><br/>
                备注：<input class="input-text radius" type="text" name="financial_remark" id="financial_remark" placeholder="备注"><br/>
                状态：<input class="input-text radius" type="text" name="financial_state" id="financial_state" placeholder="状态"><br/>
                <button type="button" class="btn btn-default add2" data-dismiss="modal" style="margin-left: 40%;">确认</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<!-- 修改 -->
<div class="modal" id="mymodal99">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                金融产品名称：<input class="input-text radius" type="text" name="products_name2" id="products_name2" style="border-style: none"><br/><br/>
                还款方式：<input class="input-text radius" type="text" name="products_payment_method2" id="products_payment_method2" style="border-style: none"><br/><br/>
                云农场线上支付：<input class="input-text radius" type="text" name="products_online_payment2" id="products_online_payment2" style="border-style: none;background: white"><br><br/>
                <button type="button" class="btn btn-default update" data-dismiss="modal" style="margin-left: 40%;" onclick="updateProducts2()">确认</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<!-- 删除 -->
<div class="modal" id="mymodal22">
    <div class="modal-body" id="bbody">
        <a class="close" data-dismiss="modal">×</a>
        <p class="pdelete">确认删除？</p>
    </div>
    <div class="modal-footer">
        <a class="btn btn-primary" onclick="dTo()">确定</a>
        <a data-dismiss="modal" class="btn btn-primary">取消</a>
    </div>
</div>
<script type="text/javascript">

    var products_id;

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
                url: '/getProducts.action',         //请求后台的URL（*）
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
                uniqueId: "products_id",                     //每一行的唯一标识，一般为主键列
                showToggle:true,                    //是否显示详细视图和列表视图的切换按钮
                cardView: false,                    //是否显示详细视图
                detailView: false,                   //是否显示父子表
                columns:  [{
                    title: '金融产品ID',
                    field: 'products_id',
                    align: 'center',
                    valign: 'middle',
                    visible:false
                }, {
                    title: '新增时间',
                    field: 'products_time',
                    align: 'center',
                    valign: 'middle',
                }, {
                    title: '金融产品名称',
                    field: 'products_name',
                    align: 'center',
                    valign: 'middle',
                }, {
                    title: '服务机构名称',
                    field: 'financial_institution_number',
                    align: 'center',
                    valign: 'middle',
                }, {
                    title: '云农场线上支付',
                    field: 'products_online_payment',
                    align: 'center',
                    valign: 'middle',
                }, {
                    title: '还款方式',
                    field: 'products_payment_method',
                    align: 'center',
                    valign: 'middle',
                }, {
                    title: '状态',
                    field: 'products_state',
                    align: 'center',
                    valign: 'middle',
                },{
                    title: '操作',
                    align: 'center',
                    formatter:function(value,row,index){
                        financial_id=row.financial_id;
                        var e = '<button class="btn btn-primary size-M radius delete" onclick="deleteFinancial()">删除</button> ';
                        var f = '<button class="btn btn-primary size-M radius delete" onclick="updateFinancial()">修改</button> ';
                        return e+f;
                    }
                }
                ],
                onClickCell:function(field, value, row) {
                    products_id=row.products_id;
                }
            });
        };

        //得到查询的参数
        oTableInit.queryParams = function (params) {
            var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
                limit: params.limit,   //页面大小
                offset: params.offset  //页码
                /*departmentname: $("#financial_institution_number").val(),
                statu: $("#financial_state").val()*/
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

    function deleteFinancial() {
        $("#mymodal22").modal("toggle");
    }
    function dTo() {
        alert("a");
        /*$.post("/deleteProducts.action",{
            "fid":products_id
        },function(data){
            $("#myt").bootstrapTable('refresh', {url: '/getProducts.action'});
        });*/
    }

    function updateProducts2() {
        var products_name = $("#products_name2").val();
        var products_payment_method = $("#products_payment_method2").val();
        var products_online_payment = $("#products_online_payment2").val();
        $.post("/updateProducts.action",{
            "fid":products_id,
            "products_name": products_name,
            "products_payment_method": products_payment_method,
            "products_online_payment": products_online_payment
        },function(data){
            $("#myt").bootstrapTable('refresh', {url: '/getProducts.action'});
        });
    }

    function updateFinancial() {
        $("#mymodal99").modal("toggle");
    }

</script>
<style type="text/css">
    #mymodal22{
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
