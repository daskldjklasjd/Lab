$(function(){
	
	$("#loginErrorMsg").hide();	
	
	//表单非空校验
	$("input").unbind("focusout");
	$("input").bind("focusout",function(){
		var content = $(this).val();
		if(!isNotNullOrBlank(content)){
			$("#loginErrorMsg").text("账号或密码不能为空!");
			$("#loginErrorMsg").show();
			$("div[name="+$(this).attr("id")+"]").attr("class","form-group has-error has-feedback");
			$("span[name="+$(this).attr("id")+"]").attr("class","glyphicon glyphicon-remove form-control-feedback");
		} else {
			$("#loginErrorMsg").hide();
			$("div[name="+$(this).attr("id")+"]").attr("class","form-group has-success has-feedback");
			$("span[name="+$(this).attr("id")+"]").attr("class","glyphicon glyphicon-ok form-control-feedback");
		}
	});
	
	//提交登录表单
	$("#login").unbind("click");
	$("#login").bind("click",function(){
		var account = $("#account").val();
		var password = $("#password").val();
		var params = {account:account,password:password};
		var data = {params:params};
		$.ajax({
			type : "post",
			url : "/vouchingtest/user/login",
			async: false,
            dataType:'json',
            contentType:'application/json',
            data : JSON.stringify(data),
            success : function(data){
				if ("success" == data.result) {
					simpleHref("/vouchingtest/common/forwardFrontIndex");
				} else {
					$("#loginErrorMsg").text(data.errorCode);
					$("#loginErrorMsg").show();
					$("div[name='account']").attr("class","form-group has-error has-feedback");
					$("span[name='account']").attr("class","glyphicon glyphicon-remove form-control-feedback");
					$("div[name='password']").attr("class","form-group has-error has-feedback");
					$("span[name='password']").attr("class","glyphicon glyphicon-remove form-control-feedback");
				}
            },
            error : function(data){
            	
            }
		});
	})
	
});

//判断输入的信息是否为空
function isNotNullOrBlank(ele){
	if("" == ele || ele == null){
		return false;
	}
	return true;
}
