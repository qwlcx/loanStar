<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/11/1 0001
  Time: 19:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        $(function(){
            $("#cusTable").bootstrapTable({
                url: "/getAllName.action", //获取数据的Servlet地址
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
                }
                ]
            });
        });



    </script>
</head>
<body>
<table class="table table-hover" id="cusTable"></table>
</body>
</html>
