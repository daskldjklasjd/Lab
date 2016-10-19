$(function(){

	//装载首页的头部和导航栏信息
	$.ajax({
		type : "post",
		url : "/vouchingtest/user/fillNavigation",
		async: false,
        dataType:'json',
        contentType:'application/json',
        data : JSON.stringify(null),
        success : function(data){
			if ("success" == data.result) {
				var user = data.detail.currentUser;
				$("#role").attr("value",user.role);
				$("#unReadEmailCount").text(data.detail.unReadEmailCount);
				
				//装载详情信息
				$.ajax({
					type : "post",
					url : "/vouchingtest/user/fillDetail",
					async: true,
			        dataType:'json',
			        contentType:'application/json',
			        data : JSON.stringify(null),
			        success : function(data){
			        	if ("success" == data.result) {
			        		//装载为批阅试卷或喂参加考试信息
			        		
			        		//装载成绩排名信息
			        		
			        		//装载未读邮件信息
			        		var data = data.detail.unreadEmails;
			        		var columnName =["senterName","subject","formatSentDate"];
			        		var footerTip = "更多站内信";
			        		var url = "/vouchingtest/common/emailIndex";
			        		tableUtil("unreadEmails",columnName,data,footerTip,url);
			        	} else {
			        		
			        	}
			        },
			        error : function(data){
			        	
			        }
				});
			} else {
				//--
			}
        },
        error : function(data){
        	//--
        }
	});
	
	var role = $("#role").val();
	
	if("1" == role){
		$("[role='2']").remove();
		$("#roleName").text("学生");
	}else{
		$("[role='1']").remove();
		$("#roleName").text("教师");
	}	
	
	$("#logout").unbind("click");
	$("#logout").bind("click",function(){
		$.ajax({
			type : "post",
			url : "/vouchingtest/user/logout",
			async : false,
			dataType : 'json',
			contentType : 'application/json',
			data : JSON.stringify(null),
			success : function(data) {
				if ("success" == data.result) {
					simpleHref("/vouchingtest/common/forwardFrontLogin");
				} else {
					
				}
			},
			error : function(data) {
				//commonErrorHandler(data.errorCode);
			}
	   });
	});
});