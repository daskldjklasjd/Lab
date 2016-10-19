package com.bupt.vouching.util;

import com.bupt.vouching.frame.Type;

/**
 * 错误信息API
 * 
 * @author Hogan
 * 
 */
public enum ErrorCode implements Type{

	/**
	 * 操作成功
	 */
	SUCCESS(0x000, "操作成功"),
	
	//登录相关
	LOGIN_INPUT_IS_NULL(0x002,"用户名或密码不能为空!"),
	LOGIN_AP_IS_NOT_MATCH(0x003,"账号和密码不匹配!"), 
	CLASS_IS_NOT_IN_SYSTEM(0x004,"您所在的班级不在系统内，请联系管理员!"), 
	CLASS_IS_INACTIVE(0x005,"您所在的班级还没有激活，请联系管理员!"), 
	NOT_LOGIN(0x006,"您还没有登录!"), 
	UPDATE_FIALD(0x007,"数据更新失败!"), 
	SESSION_INVALID(0x008,"用户session失效，请重新登录!"), 
	RECEIVE_NOT_IN_SYSTEM(0x009,"您所发送的邮箱不存在!"), 
	SENT_EMAIL_ERROR(0X010,"发送邮件失败!"), 
	NO_DELETE_EMIAL_ID(0x011,"貌似您没有选中要删除的邮件!"), 
	NO_DELETE_EMIAL_TYPE(0x012,"未知邮件删除类型!"), 
	DELETE_EMIAL_TYPE_INVALID(0x013,"删除类型无效!"), 
	EMAIL_DELETE_FIALD(0x014,"邮件删除失败!"), 
	EMAIL_SUBJECT_NULL(0x015,"主题不能为空!"), 
	EMAIL_CONTENT_NULL(0x016,"邮件内容不能为空!"), 
	EMAIL_RECEIVE_NULL(0x017,"收件人不能为空!"), 
	EMAIL_SENT_FAILD(0x018,"邮件发送失败!"), 
	EMAIL_RECEIVE_INVALID(0x019,"收件人不在用户中!"), 
	;

	int id;
	String description;

	ErrorCode(int id, String description) {
		this.id = id;
		this.description = description;
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public String getDescription() {
		return description;
	}

}
