package com.bupt.vouching.frame;

/**
 * 常量类
 * 
 * @author Hogan
 * 
 */
public class Consts {

	/**
	 * 角色类型
	 */
	public static final int ROLE_ADMIN = 0;
	public static final int ROLE_STUDENT = 1;
	public static final int ROLE_TEACHER = 2;

	/**
	 * 班级状态
	 */
	public static final int CLASS_INACTIVE = 0;
	public static final int CLASS_ACTIVE = 1;

	/**
	 * 请求报文
	 */
	public static final String PARAMS_LABEL = "params";

	/**
	 * 登录后有效的用户标签
	 */
	public static final String SESSION_CURENT_USER_LABEL = "currentUser";

	/**
	 * 返回码标签
	 */
	public static final String RESULT_LABEL = "result";

	/**
	 * 分页标签
	 */
	public static final String PAGE_LABEL = "page";

	/**
	 * 错误信息标签
	 */
	public static final String ERROR_LABEL = "errorCode";

	/**
	 * 操作成功
	 */
	public static final String RESULT_SUCCESS = "success";

	/**
	 * 操作失败
	 */
	public static final String RESULT_FAILD = "faild";

	/**
	 * 业务返回信息标签
	 */
	public static final String DETAIL_LABEL = "detail";

	/**
	 * 分页各页码
	 */
	public static final int PAGE_SIZE_EMAIL_SENT = 5;
	public static final int PAGE_SIZE_EMAIL_RECEIVE = 5;

	public static final String PAGE_NUM = "pageNum";
	public static final String PAGE_SUM = "pageSum";
	public static final String PAGE_HAVE_NEXT_PAGE = "havNextPage";
	public static final String PAGE_RECORD_COUNT = "recordCount";

	/**
	 * 邮件删除标记
	 */
	public static final int EMAIL_NOT_DEL = 0;
	public static final int EMAIL_DEL = 1;

	/**
	 * 删除收件箱邮件
	 */
	public static final int EMAIL_DEL_RECEIVE = 1;
	/**
	 * 删除发件箱邮件
	 */
	public static final int EMAIL_DEL_SENT = 2;
	
	/**
	 * 单条数据插入成功标识
	 */
	public static final int INSERT_SINGLE_SUCCESS = 1;
	
	/**
	 * 单条数据更新成功标识
	 */
	public static final int UPDATE_SINGLE_SUCCESS = 1;

}
