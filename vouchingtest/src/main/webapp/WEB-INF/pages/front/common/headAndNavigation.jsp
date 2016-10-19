<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<input type="hidden" id="role" value="2"/>
<!--头部信息-->
<div id="head">
  <div class="left"> 
  	<a href="#" class="button profile"><img src="<%=bp%>/img/icons/top/huser.png" alt="" /></a> 
     你好, <a href="#">孟浩</a> | 
     角色, <a id="roleName" href="#">学生</a> |
     <a href="#">回到首页</a> |
     <a id="logout" href="javascript:;">注销</a> |
     <a href="#">修改密码</a> | 
     <a href="#" role="1">互动平台积分:1</a> <span role="1">|<span>
     <a href="#">未读站内信:<span id="unReadEmailCount"></span></a> 
  </div>
</div>

<!--导航栏开始-->
<div id="sidebar">
  <ul>
    <li class="current"><a href="#"><img src="<%=bp%>/img/icons/menu/layout.png" alt="" /> 资源平台</a>
      <ul>
        <li><a href="#">教学板块</a></li>
        <li><a href="#">词汇查询</a></li>
        <li><a href="#">语句查询</a></li>
        <li><a href="/vouchingtest/common/upload">上传/下载教学资源</a></li>
      </ul>
    </li>
    <li ><a href="#"><img src="<%=bp%>/img/icons/menu/layout.png" alt="" /> 案例平台</a>
      <ul>
        <li><a href="#">Flash案例</a></li>
      </ul>
    </li>
    <li role="1"><a href="#"><img src="<%=bp%>/img/icons/menu/layout.png" alt="" /> 练习平台</a>
      <ul>
        <li><a href="#">学生练习</a></li>
      </ul>
    </li>
    <li ><a href="#"><img src="<%=bp%>/img/icons/menu/layout.png" alt="" /> 考试平台</a>
      <ul>
      	<li><a href="#" role="2">手工组卷</a></li>
        <li><a href="#" role="2">自动组卷</a></li>
        <li><a href="#" role="2">批改试卷</a></li>
        <li><a href="#" role="2">考试设置</a></li>
        <li><a href="#" role="1">参加考试</a></li>
        <li><a href="#">查看成绩</a></li>
      </ul>
    </li>
    <li ><a href="#"><img src="<%=bp%>/img/icons/menu/layout.png" alt="" /> 互动平台</a>
      <ul>
        <li><a href="#" role="1">知识点竞技</a></li>
        <li><a href="#">查看成绩</a></li>
        <li><a href="#" role="2">批阅试卷</a></li>
      </ul>
    </li>
    <li><a href="#"><img src="<%=bp%>/img/icons/menu/layout.png" alt="" /> 站内短信</a>
      <ul>
        <li><a href="/vouchingtest/common/emailIndex">站内信</a></li>
      </ul>
    </li>
  </ul>
</div>