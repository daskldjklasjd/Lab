<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>
<%@ include file="../common/headAndNavigation.jsp" %>
<div id="content" class="white">

	<h1>
		<img src="<%=bp%>/img/icons/font.png" alt="" /> 教学资源
	</h1>

	<div class="bloc">
		<div class="title">
			教学资源
			<div class="tabs" id="tabs1">
				<a href="#tab11">下载教学资源</a> 
				<a href="#tab12">上传教学资源</a>
			</div>
		</div>
		<div class="content">
			<div id="tab11">
				<p>
					Lorem ipsum dolor sit amet, <strong>consectetur</strong> adipiscing
					elit. In vulputate fermentum sollicitudin. Donec purus dolor,
					sagittis at rutrum id, volutpat eu nisl. Suspendisse quis velit et
					sapien malesuada vulputate. Pellentesque ante diam, congue ut
					volutpat nec, varius non erat.
				</p>
			</div>
			<div id="tab12">
				<div class="notif tip">
					<strong>注意 :</strong>
					<ul>
						<ol>选择的文件类型应为:PPT,DOC,TXT,否则会造成上传失败!</ol>
						<ol>选择的文件大小应为:小于5MB,否则会造成上传失败!</ol>
					</ul>
					<a href="#" class="close"></a>
				</div>
				<div class="input">
					<label for="file">选择上传的资源</label>
					<div class="uploader" id="uniform-file">
						<input type="file" id="file" size="20" style="opacity: 0;">
						<span class="filename">还没有选择文件</span> 
						<span class="action">请选择一个文件</span>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>