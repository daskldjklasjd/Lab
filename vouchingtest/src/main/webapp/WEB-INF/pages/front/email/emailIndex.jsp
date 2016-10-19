<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>
<script type="text/javascript" src="<%=bp%>/js/email.js"></script>
<script type="text/javascript" src="<%=bp%>/js/zeroModal.js"></script>

<link rel="stylesheet" href="<%=bp%>/css/zeroModal.css" />
<%@ include file="../common/headAndNavigation.jsp" %>

<!--站内信开始-->
<div id="content" class="white">
  <h1><img src="<%=bp%>/img/icons/posts.png" alt="" /> 站内信</h1>
  <div class="bloc">
  	<div class="title">函电管理
    	<div class="tabs" id="tabs1">           
            <a href="#tab11" id="receiveBox">收信箱</a>
            <a href="#tab12" id="senterBox">发信箱</a>
            <a href="#tab13">写短信</a>
        </div>
    </div>
    <div class="content">
    <div id="tab11">
      <table>
        <thead>
          <tr>
          	<th><a class="button black" href="#"><img src="<%=bp%>/img/icons/actions/delete.png"/> 删除</a></th>
            <th>&nbsp;</th>
            <th>&nbsp;</th>
            <th>&nbsp;</th>
            <th>&nbsp;</th>
            <th>&nbsp;</th>
          </tr>
          <tr>
            <th><input type="checkbox" class="checkall"/></th>
            <th>发件人</th>
            <th>发件人邮箱</th>
            <th>邮件主题</th>
            <th>收件时间</th>
            <th>操作</th>
          </tr>
        </thead>
        <tbody id="receiveEmails"></tbody>
      </table>
      <%@include file="../common/pagination.jsp" %>
    </div>
    
    <div id="tab12">
      <table>
        <thead>
          <tr>
          	<th><a class="button black" href="#"><img src="<%=bp%>/img/icons/actions/delete.png"/> 删除</a></th>
            <th>&nbsp;</th>
            <th>&nbsp;</th>
            <th>&nbsp;</th>
            <th>&nbsp;</th>
            <th>&nbsp;</th>
          </tr>
           <tr>
            <th><input type="checkbox" class="checkall"/></th>
            <th>收件人</th>
            <th>收件人邮箱</th>
            <th>邮件主题</th>
            <th>收件时间</th>
            <th>操作</th>
          </tr>
        </thead>
        <tbody id="senterEmails"></tbody>
      </table>
       <%@include file="../common/pagination.jsp" %>
    </div>
    
    <div id="tab13">
    	<div class="input"> 
        	 <div class="input medium">
                <label for="input1">标题</label>
                <input type="text" id="subject" />
        	 </div>
             <div class="input medium">
                <label for="receiveEmail">收件人&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                	<button id="receiver" class="button">
                		<img src="<%=bp%>/img/icons/menu/users.png" alt="" />添加收件人
                	</button>
                </label>
                <input type="text" id="receiveEmail" />
        	 </div>
             <div class="input textarea">
            	<label for="textarea2">内容</label>
           		<textarea name="text" id="contents" rows="5" class="wysiwyg" cols="1"></textarea>
        	 </div>
             <div class="submit">
             	<button id="sentEmail" class="button">发  送</button>
        	 </div>
        </div>
    </div>
   </div>
  </div>
</div>
</body>
</html>