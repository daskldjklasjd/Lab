package com.bupt.vouching.service;

import javax.servlet.http.HttpServletRequest;
import com.alibaba.fastjson.JSONObject;
import com.bupt.vouching.frame.MJSONObject;

/**
 * 用户业务层接口
 * 
 * @author Hogan
 * 
 */
public interface UserService {

	/**
	 * 用户登录校验
	 * 
	 * @param jo
	 * @param request
	 * @return
	 */
	public MJSONObject loginValidate(JSONObject jo, HttpServletRequest request);

	/**
	 * 首页导航栏装填数据
	 * 
	 * @param params
	 * @return
	 */
	public MJSONObject fillNavigation(HttpServletRequest request);

	/**
	 * 用户注销
	 * 
	 * @param request
	 */
	public void logout(HttpServletRequest request);

	/**
	 * 装填Email中班级同学的信息
	 * 
	 * @param params
	 * @return
	 */
	public MJSONObject fillUserInClass(JSONObject params);

	/**
	 * 装载首页详情信息
	 * 
	 * @param params
	 * @param request
	 * @return
	 */
	public MJSONObject fillDetail(JSONObject params,HttpServletRequest request);

	/**
	 * 用户注销
	 * 
	 * @param params
	 * @param request
	 * @return
	 */
	public MJSONObject logout(JSONObject params, HttpServletRequest request);

}
