<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
	String bp = request.getScheme() + "://" + request.getServerName()
			+ ":" + request.getServerPort() + request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<!-- jQuery AND jQueryUI -->
<script type="text/javascript" src="<%=bp%>/js/libs/jquery/1.6/jquery.min.js"></script>
<script type="text/javascript" src="<%=bp%>/js/libs/jqueryui/1.8.13/jquery-ui.min.js"></script>
<script type="text/javascript" src="<%=bp%>/js/min.js"></script>
<script type="text/javascript" src="<%=bp%>/js/common.js"></script>
<script type="text/javascript" src="<%=bp%>/js/index.js"></script>

<!-- CSS -->
<link rel="stylesheet" href="<%=bp%>/css/min.css" />
