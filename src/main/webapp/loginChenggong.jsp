<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/10/31 0031
  Time: 14:03
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

       function tan() {
         /*  var name = document.getElementById("name").value;*/
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
       }


       function tan2() {
           /*  var name = document.getElementById("name").value;*/
           $("#cusTable_02").bootstrapTable({
               url: "/getHisApplicantName.action", //获取数据的Servlet地址
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
               }, {
                   field: 'applicant_yuanyin',
                   title: '失败原因'
               }
               ]
           });
       }

    </script>

</head>
<body>
<h1>欢迎${sessionScope.uname}登录</h1>
<%--<a class="btn btn-default" href="applicantAdd.jsp" role="button">申请贷款</a>--%>
<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">申请贷款</button>
<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModa2" onclick="tan()">查看当前申请款项</button>
<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModa3" onclick="tan2()">查看历史申请款项</button>

<!--申请贷款模态框-->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">申请贷款</h4>
            </div>
            <form class="bs-example bs-example-form" role="form" action="/addApplicant.action" method="post">
                <div class="input-group" style="width: 400px;">
                    <span class="input-group-addon">申请人:</span>
                    <input type="text" class="form-control" placeholder="申请人姓名" name="applicant_name" size="300px">
                </div>
                <br>
                <div class="input-group" style="width: 400px;">
                    <span class="input-group-addon">申请人联系电话：</span>
                    <input type="text" class="form-control" placeholder="申请人联系电话" name="applicant_telphone" >
                </div>
                <br>
                <div class="input-group" style="width: 400px;">
                    <span class="input-group-addon">证件类型：</span>
                    <select class="form-control" name="applicant_id_type">
                        <option>身份证</option>
                    </select>
                </div>
                <br>
                <div class="input-group" style="width: 400px;">
                    <span class="input-group-addon">证件号:</span>
                    <input type="text" class="form-control" placeholder="证件号" name="applicant_id_number">
                </div>
                <br>
                <div class="input-group" style="width: 400px;">
                    <span class="input-group-addon"> 自有土地:</span>
                    <input type="text" class="form-control" placeholder="自有土地" name="applicant_land">
                </div>
                <br>
                <div class="input-group" style="width: 400px;">
                    <span class="input-group-addon"> 从业年限:</span>
                    <input type="text" class="form-control" placeholder="从业年限" name="applicant_work_age">
                </div>
                <br>
                <div class="input-group" style="width: 400px;">
                    <span class="input-group-addon">地址：</span>
                    <input type="text" class="form-control" placeholder="地址" name="applicant_address">
                </div>
                <br>
                <div class="input-group" style="width: 400px;">
                    <span class="input-group-addon"> 贷款用途:</span>
                    <input type="text" class="form-control" placeholder="贷款用途" name="applicant_use">
                </div>
                <br>
                <div class="input-group" style="width: 400px;">
                    <span class="input-group-addon">申请金额:</span>
                    <input type="text" class="form-control" placeholder="申请金额" name="applicant_aggregate_amount">
                </div>
                <br>
                <div class="input-group" style="width: 400px;">
                    <span class="input-group-addon">电子邮箱：</span>
                    <input type="text" class="form-control" placeholder="电子邮箱" name="applicant_email">
                </div>
                <br>
                <div class="input-group" style="width: 400px;">
                    <span class="input-group-addon"> 银行卡号:</span>
                    <input type="text" class="form-control" placeholder="银行卡号" name="applicant_card_number">
                </div>
                <br>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="submit" class="btn btn-primary">提交申请</button>
                </div>
            </form>

        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>





<!-- 查看当前申请款项模态框 -->
<div class="modal fade" id="myModa2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabe2">当前申请款项</h4>
            </div>
            <%--<div class="input-group" style="width: 400px; align-content: center;">
                <span class="input-group-addon">请输入你的名字:</span>
                <input type="text" class="form-control" name="name" id="name">
            </div>--%>
            <table class="table table-hover" id="cusTable"></table>
            <div class="modal-footer">
              <%--  <button class="btn btn-primary"  onclick="tiao()">确定</button>--%>
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>



<!-- 查看当前申请款项模态框 -->
<div class="modal fade" id="myModa3" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabe3">当前申请款项</h4>
            </div>
            <table class="table table-hover" id="cusTable_02"></table>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

</body>
</html>
