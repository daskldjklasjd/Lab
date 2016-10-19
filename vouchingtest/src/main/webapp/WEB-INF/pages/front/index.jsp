<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="common/common.jsp" %>
<%@ include file="common/headAndNavigation.jsp" %>

<!--通知内容-->
<div id="content" class="white">
  <h1><img src="<%=bp%>/img/icons/dashboard.png" alt="" /> 欢迎使用XXX </h1>
  
  <!--尚未参加的考试-->
  <div class="bloc left">
    <div class="title"> 尚未参加的考试 ${pagecontext.request.contextpath}</div>
    <div class="content">
      <div>
        <table class="noalt">
          <thead>
            <tr>
              <th ><em>Content</em></th>
			  <th ><em>Content</em></th>
			  <th ><em>Content</em></th>
			  <th ><em>Content</em></th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td><h4>460</h4></td>
              <td><h4>460</h4></td>
			  <td><h4>460</h4></td>
			  <td><h4>460</h4></td>
            </tr>
            <tr>
              <td><h4>460</h4></td>
              <td><h4>460</h4></td>
			  <td><h4>460</h4></td>
			  <td><h4>460</h4></td>
            </tr>
            <tr>
              <td><h4>460</h4></td>
              <td><h4>460</h4></td>
			  <td><h4>460</h4></td>
			  <td><h4>460</h4></td>
            </tr>
            <tr>
              <td><h4>460</h4></td>
              <td><h4>460</h4></td>
			  <td><h4>460</h4></td>
			  <td><h4>460</h4></td>
            </tr>
			<tr>
              <td><h4>460</h4></td>
              <td><h4>460</h4></td>
			  <td><h4>460</h4></td>
			  <td><h4>460</h4></td>
            </tr>
          </tbody>
        </table>
      </div>
      <div class="cb"></div>
    </div>
  </div>
  
  <!--成绩排行榜-->
  <div class="bloc right">
    <div class="title"> 成绩排行榜 </div>
    <div class="content">
      <div>
        <table class="noalt">
          <thead>
            <tr>
              <th ><em>Content</em></th>
			  <th ><em>Content</em></th>
			  <th ><em>Content</em></th>
			  <th ><em>Content</em></th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td><h4>460</h4></td>
              <td>Posts</td>
			  <td>Posts</td>
			  <td>Posts</td>
            </tr>
            <tr>
              <td><h4>12</h4></td>
              <td>Pages</td>
			  <td>Posts</td>
			  <td>Posts</td>
            </tr>
            <tr>
              <td><h4>5</h4></td>
              <td>Categories</td>
			  <td>Posts</td>
			  <td>Posts</td>
            </tr>
            <tr>
              <td><h4>20 000</h4></td>
              <td>Contacts</td>
			  <td>Posts</td>
			  <td>Posts</td>
            </tr>
			<tr>
              <td><h4>20 000</h4></td>
              <td>Contacts</td>
			  <td>Posts</td>
			  <td>Posts</td>
            </tr>
          </tbody>
        </table>
      </div>    
      <div class="cb"></div>
    </div>
  </div>
  <div class="cb"></div>
  
  <!--未读邮件-->
  <div class="bloc left">
    <div class="title"> 未读邮件 </div>
    <div class="content">
      <div>
        <table class="noalt">
          <thead>
            <tr>
              <th ><em>发件人</em></th>
			  <th ><em>邮件主题</em></th>
			  <th ><em>收件时间</em></th>
            </tr>
          </thead>
          <tbody id="unreadEmails"></tbody>
        </table>
      </div>
      <div class="cb"></div>
    </div>
  </div>

</div>
</body>
</html>