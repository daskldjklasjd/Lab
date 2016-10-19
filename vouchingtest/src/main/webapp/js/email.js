/**
 * Email页面所用到的jquery操作
 */
$(function() {

	var params = {
		pageNum : 1
	};
	var data = {
		params : params
	};
	
	//初始化加载收件箱信息
	loadReceiveBox(data);
	
	$("#receiveBox").bind("click",function(){
		loadReceiveBox(data);
	});
	
	$("#senterBox").bind("click",function(){
		loadSentBox(data);
	});
	
	//监听删除一个邮件的事件
	$("#deleteEmail").each(function(){
		$(this).unbind("click");
		$(this).bind("click",function(){
			var type = $(this).attr("type");
			var emailId = $(this).closest("tr").attr("id");
			deleteSingleEmail(type,emailId);
		});
	});
	
	//监听发送邮件事件
	$("#sentEmail").unbind("click");
	$("#sentEmail").bind("click",function(){
		var subject = $("#subject").val();
		var content = $("#contents").val();
		var receiveEmail = $("#receiveEmail").val();
		sentEmail(subject,content,receiveEmail);
	});
	
	/*//监听添加联系人事件
	$("#receiver").unbind("click");
	$("#receiver").bind("click",function(){
		var contents = "<div class='col-sm-5'><div class='list-group' id='receiverClass'>" + 
					   "<a href='#' class='list-group-item active'><span class='badge'>14</span>国贸一班</a>" +
					   "<a href='#' class='list-group-item'><span class='badge'>14</span>国贸一班</a>" +
					   "</div></div>" +
					   "<div class='col-sm-7'><div class='list-group' id='receiversUser'>" +
					   "<a href='#' class='list-group-item active'>同学</a>" +
					   "<a href='#' class='list-group-item'>同学</a>" +
					   "</div></div>";
		zeroModal.show({
            title: '添加收件人',
            content: contents,
			transition : true,
			esc : true,
			onLoad : function(){
				//加载班级信息和学生信息并装载到页面中
				$.ajax({
					type : "post",
					url : "/vouchingtest/email/listReceivers",
					async : false,
					dataType : 'json',
					contentType : 'application/json',
					data : JSON.stringify(null),
					success : function(data) {
						if("success" == data.result){
							
						} else {
							
						}
					},
					error : function(data){
						
					}
				});
			}
        });
	});*/
	
});

/**
 * 装载发件箱信息
 * 
 * @param data
 */
function loadSentBox(data){
	$.ajax({
		type : "post",
		url : "/vouchingtest/email/fillSentBox",
		async : false,
		dataType : 'json',
		contentType : 'application/json',
		data : JSON.stringify(data),
		success : function(data) {
			if ("success" == data.result) {
				var tbodyId = "senterEmails";
				var columnNames = ["emailId","isRead","receiveName","receiveEmail"
				                   ,"subject","formatSentDate"];
				var tableData = data.detail.senterEmails;
				generateReceiveOrSentMailTable(tbodyId, columnNames, tableData, 2);
			} else {

			}
		},
		error : function(data) {

		}
	});
}

/**
 * 装载收件箱信息
 * 
 * @param data
 */
function loadReceiveBox(data){
	$.ajax({
		type : "post",
		url : "/vouchingtest/email/fillReceiveBox",
		async : false,
		dataType : 'json',
		contentType : 'application/json',
		data : JSON.stringify(data),
		success : function(data) {
			if ("success" == data.result) {
				var tbodyId = "receiveEmails";
				var columnNames = ["emailId","isRead","senterName","senterEmail"
				                   ,"subject","formatSentDate"];
				var tableData = data.detail.receiveEmails;
				generateReceiveOrSentMailTable(tbodyId, columnNames, tableData, 1);
			} else {

			}
		},
		error : function(data) {

		}
	});
}

/**
 * 删除单个邮件
 * @param type		1-收件箱  2-发件箱
 * @param emailId   需要删除的邮件ID
 */
function deleteSingleEmail(type,emailId){
	var params = {type:type,emailId:emailId};
	var data = {params:params};
	$.ajax({
		type : "post",
		url : "/vouchingtest/email/deleteSingleEmail",
		async : false,
		dataType : 'json',
		contentType : 'application/json',
		data : JSON.stringify(data),
		success : function(data) {
			if ("success" == data.result) {
				$("#"+data.detail.deleteEmailId).remove();
			} else {
				
			}
		},
		error : function(data){
			
		}
	});
}

/**
 * 发送邮件
 * 
 * @param subject		邮件主题
 * @param content 		邮件内容
 * @param receiveEmails	收件人邮箱
 * @returns
 */
function sentEmail(subject,content,receiveEmail){
	var params = {subject:subject,content:content,receiveEmail:receiveEmail};
	var data = {params:params};
	$.ajax({
		type : "post",
		url : "/vouchingtest/email/sentEmail",
		async : false,
		dataType : 'json',
		contentType : 'application/json',
		data : JSON.stringify(data),
		success : function(data) {
			if("success" == data.result){
				
			} else {
				
			}
		},
		error : function(data){
			
		}
	});
}

/**
 * 加载联系人页面
 * 
 * @param data
 */
/*function loadReceiverList(data){
	for ( var  i= 0;  < data.classes.length; i++) {
		var content = "<a href='#' class='list-group-item active'><span class='badge'>14</span>国贸一班</a>";
		if(i==0){
			content
		}else{
			
		}
	}
	$("#receiverClass").append();
}*/


/**
 * 生成收件箱或发件箱表格
 * 
 * @param tbodyId      tbody的ID标识
 * @param columnNames  显示的数据名称
 * @param tableData    装载的数据
 * @returns
 */
function generateReceiveOrSentMailTable(tbodyId,columnName,data,type) {
	//删除之前填充的数据
	$("#" + tbodyId).children().remove();
	for ( var i = 0; i < data.length; i++) {
		//添加复选框
		$("#" + tbodyId).append("<tr id='"+data[i].emailId+"'><td><input type='checkbox' /></td></tr>");
		var td = "";
		for ( var j = 2; j < columnName.length; j++) {
			if(1 == data[i].isRead){
				td = "<td>" + eval("data["+i+"]."+columnName[j]) + "</td>";
			} else {//邮件未读，加粗显示
				td = "<td><strong>" + eval("data["+i+"]."+columnName[j]) + "</strong></td>";
			}
			$("#" + tbodyId + ">tr").eq(i).append(td);
		}
		//添加删除图标
		var td = "<td>" +
				     "<img style='cursor:pointer' src='/vouchingtest/img/icons/mail-open-1.png' alt='' />"+
				     "<img id='deleteEmail' type='"+type+"' style='cursor:pointer' src='/vouchingtest/img/icons/trash-shredder.png' alt='' /></td>";
		$("#" + tbodyId + ">tr").eq(i).append(td);
	}
}

