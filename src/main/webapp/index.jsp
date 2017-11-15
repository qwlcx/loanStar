<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/10/11
  Time: 11:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>云农场贷款管理后台</title>

<link rel="stylesheet" href="css/index.css" type="text/css" media="screen" />

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/tendina.min.js"></script>
<script type="text/javascript" src="js/common.js"></script>

</head>
<body>
       <!--顶部-->
       <div class="top">
           <div style="float: left"><span style="font-size: 26px;line-height: 45px;padding-left: 20px;color: #fff">云农场贷款管理</span></div>
           <div id="ad_setting" class="ad_setting">
               <a class="ad_setting_a" href="javascript:; ">${administrator_name}</a>
               <ul class="dropdown-menu-uu" style="display: none" id="ad_setting_ul">
                   <li class="ad_setting_ul_li"> <a href="javascript:;"><i class="icon-user glyph-icon"></i>个人中心</a> </li>
                   <li class="ad_setting_ul_li"> <a href="javascript:;"><i class="icon-cog glyph-icon"></i>设置</a> </li>
                   <li class="ad_setting_ul_li"> <a href="upPass.jsp"><i class="icon-signout glyph-icon"></i> <span class="font-bold">退出</span> </a> </li>
               </ul>
               <img class="use_xl" src="images/right_menu.png" />
           </div>
       </div>
       <!--顶部结束-->
       <!--菜单-->
       <div class="left-menu">
           <ul id="menu">
               <c:choose>
                 <c:when test="${roleName1=='系统管理员' or roleName2=='系统管理员' or roleName1=='系统维护管理员' or roleName2=='系统维护管理员'}">
               <li class="menu-list">
                   <a style="cursor:pointer" class="firsta"><i  class="glyph-icon xlcd"></i>系统管理<s class="sz"></s></a>
                   <ul>
                               <li><a href="department.jsp" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>部门管理</a></li>
                               <li><a href="facility.jsp" target="menuFrame"><i class="glyph-icon icon-chevron-right2"></i>服务机构</a></li>
                               <li><a href="partner.jsp" target="menuFrame"><i class="glyph-icon icon-chevron-right3"></i>FA(贷款合作商)管理</a></li>
                               <li><a href="partner.jsp" target="menuFrame"><i class="glyph-icon icon-chevron-right4"></i>人员管理</a></li>
                               <li><a href="role.jsp" target="menuFrame"><i class="glyph-icon icon-chevron-right5"></i>角色与权限</a></li>
                   </ul>
               </li>
                </c:when>
               </c:choose>
               <c:choose>
               <c:when test="${roleName1=='系统管理员' or roleName2=='系统管理员' or roleName1=='金融机构接口人' or roleName2=='金融机构接口人' or roleName1=='贷款财务人员' or roleName2=='贷款财务人员' or roleName1=='系统维护管理员' or roleName2=='系统维护管理员'}">
               <li class="menu-list">
                   <a style="cursor:pointer" class="firsta"><i  class="glyph-icon xlcd"></i>金融机构<s class="sz"></s></a>
                   <ul>
                                <li><a href="企业资料管理.html" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>金融机构列表</a></li>
                                <li><a href="产品管理.html" target="menuFrame"><i class="glyph-icon icon-chevron-right2"></i>金融产品列表</a></li>
                   </ul>
               </li>
               </c:when>
               </c:choose>
               <c:choose>
               <c:when test="${roleName1=='系统管理员' or roleName2=='系统管理员' or roleName1=='系统维护管理员' or roleName2=='系统维护管理员' or roleName1=='风控人员' or roleName2=='风控人员' or roleName1=='FA（贷款合作商）人员' or roleName2=='FA（贷款合作商）人员' or roleName1=='风控初审人员' or roleName2=='风控初审人员' or roleName1=='风控复审人员' or roleName2=='风控复审人员' or roleName1=='风控研调人员' or roleName2=='风控研调人员' or roleName1=='风控授信人员' or roleName2=='风控授信人员' or roleName1=='贷款催收人员' or roleName2=='贷款催收人员' or roleName1=='贷款风控人员' or roleName2=='贷款风控人员' or roleName1=='机构负责人' or roleName2=='机构负责人'}">
               <li class="menu-list">
                   <a style="cursor:pointer" class="firsta"><i  class="glyph-icon xlcd"></i>贷款<s class="sz"></s></a>
                   <ul>
                       <li><a href="partner.jsp" target="menuFrame"><i class="glyph-icon icon-chevron-right7"></i>待分配</a></li>
                       <li><a href="企业资料管理.html" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>初审</a></li>
                       <li><a href="企业资料管理.html" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>尽职调研</a></li>
                       <li><a href="企业资料管理.html" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>复审</a></li>
                       <li><a href="企业资料管理.html" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>授信</a></li>
                       <li><a href="企业资料管理.html" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>债权打包</a></li>
                       <li><a href="企业资料管理.html" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>电子合同管理</a></li>
                       <li><a href="partner.jsp" target="menuFrame"><i class="glyph-icon icon-chevron-right7"></i>贷款参数管理</a></li>
                       <li><a href="企业资料管理.html" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>实时风险预警</a></li>
                       <li><a href="企业资料管理.html" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>黑名单管理</a></li>
                       <li><a href="企业资料管理.html" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>全部贷款</a></li>
                   </ul>
               </li>
               </c:when>
               </c:choose>
               <c:choose>
               <c:when test="${roleName1=='系统管理员' or roleName2=='系统管理员' or roleName1=='风控人员' or roleName2=='风控人员' or roleName1=='贷款财务人员' or roleName2=='贷款财务人员' or roleName1=='贷款风控人员' or roleName2=='贷款风控人员' or roleName1=='系统维护管理员' or roleName2=='系统维护管理员'}">
               <li class="menu-list">
                   <a style="cursor:pointer" class="firsta"><i  class="glyph-icon xlcd"></i>客户管理<s class="sz"></s></a>
                   <ul>
                               <li><a href="企业资料管理.html" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>客户管理列表</a></li>
                               <li><a href="企业资料管理.html" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>客户管理列表</a></li>
                               <li><a href="产品管理.html" target="menuFrame"><i class="glyph-icon icon-chevron-right2"></i>贷款支付订单管理</a></li>
                               <li><a href="企业资料管理.html" target="menuFrame"><i class="glyph-icon icon-chevron-right1"></i>客户信用记录</a></li>
                   </ul>
               </li>
               </c:when>
               </c:choose>
               <c:choose>
                   <c:when test="${roleName1=='系统管理员' or roleName2=='系统管理员' or roleName1=='金融机构接口人' or roleName2=='金融机构接口人' or roleName1=='贷款财务人员' or roleName2=='贷款财务人员'  or roleName1=='系统维护管理员' or roleName2=='系统维护管理员' or roleName1=='风控人员' or roleName2=='风控人员' or roleName1=='FA（贷款合作商）人员' or roleName2=='FA（贷款合作商）人员' or roleName1=='风控初审人员' or roleName2=='风控初审人员' or roleName1=='风控复审人员' or roleName2=='风控复审人员' or roleName1=='风控研调人员' or roleName2=='风控研调人员' or roleName1=='风控授信人员' or roleName2=='风控授信人员' or roleName1=='贷款催收人员' or roleName2=='贷款催收人员' or roleName1=='贷款风控人员' or roleName2=='贷款风控人员' or roleName1=='机构负责人' or roleName2=='机构负责人'}">
                       <li class="menu-list">
                           <a style="cursor:pointer" class="firsta"><i  class="glyph-icon xlcd"></i>个人中心<s class="sz"></s></a>
                           <ul>
                               <li><a href="upPassWord.jsp" target="menuFrame"><i class="glyph-icon icon-chevron-right7"></i>修改密码</a></li>
                           </ul>
                       </li>
                   </c:when>
               </c:choose>
           </ul>
       </div>

       <!--菜单右边的iframe页面-->
       <div id="right-content" class="right-content">
           <div class="content">
               <div id="page_content">
                   <iframe id="menuFrame" name="menuFrame" src="top.jsp" style="overflow:visible;"
                           scrolling="yes" frameborder="no" width="100%" height="100%"></iframe>
               </div>
           </div>
       </div>


</body>
</html>