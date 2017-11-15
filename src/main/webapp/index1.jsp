<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>云农场贷款首页</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.10.0/css/bootstrap-select.min.css">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.10.0/js/bootstrap-select.min.js"></script>

    <!-- (Optional) Latest compiled and minified JavaScript translation files -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.10.0/js/i18n/defaults-*.min.js"></script>
    <title>star</title>
</head>
<body>
<script type="text/javascript">
//    $(window).on('load', function () {
//        $('#usertype').selectpicker({
//            'selectedText': 'cat'
//            //角色
//
//        });
//        var str='3,4,5,6';
//        var arr=str.split(',');
//        $('#usertype').selectpicker('val', arr);
//
//
//    });
$(window).on('load', function () {
        $.ajax({
            type: 'post',
            url: "getPermissionNames.action",
            dataType: 'json',
            success: function (datas) {//返回list数据并循环获取
                for (var i = 0; i < datas.length; i++) {
//                    $("ul[role='menu']").append("<option value='" + datas[i] + "'>" + datas[i] + "</option>");
                    $("ul[role='menu']").append("<li data-original-index='"+i+"'>"+
                        "<a tabindex='0' class style data-tokens='null'>"+
                        "<span class='text'>"+datas[i]+"</span><span class='glyphicon glyphicon-ok check-mark'></span>"
                        +"</a>"
                        +"</li>");
//                    $(".selector"+i).find("li:selected").text();
//                    $('.selectpicker').selectpicker('val', i);
                }
            }
        });
    });
</script>

　　 <div class="form-group">
    <label class="col-sm-3 control-label">客资类型：</label>
    <div class="col-sm-4">
        <select id="uuu" name="usertype" class="selectpicker show-tick form-control" multiple data-live-search="false">
          <%-- <option value="0">苹果</option>
            <option value="1">菠萝</option>
            <option value="2">香蕉</option>
            <opt-ion value="3">火龙果</opt-ion>
            <option value="4">梨子</option>
            <option value="5">草莓</option>
            <option value="6">哈密瓜</option>
            <option value="7">椰子</option>
            <option value="8">猕猴桃</option>
            <option value="9">桃子</option>--%>
        </select>
    </div>
</div>
</body>
</html>