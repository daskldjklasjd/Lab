package com.bupt.vouching.service;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSONObject;
import com.bupt.vouching.frame.MJSONObject;

/**
 * Email业务接口
 * 
 * @author Hogan
 * 
 */
public interface EmailService {

	/**
	 * 装载收件箱信息
	 * 
	 * @param params  前台接收的参数
	 * @param request 
	 * @return
	 */
	MJSONObject fillReceiveBox(JSONObject params, HttpServletRequest request);

	/**
	 * 装载发件箱信息
	 * 
	 * @param params  前台接收的参数
	 * @param request
	 * @return
	 */
	MJSONObject fillSentBox(JSONObject params, HttpServletRequest request);

	/**
	 * 删除单个邮件
	 * 
	 * @param params  前台接收的参数
	 * @return
	 */
	MJSONObject deleteSingleEmail(JSONObject params);

	/**
	 * 发送邮件
	 * 
	 * @param params  前台接收的参数
	 * @param request
	 * @return
	 */
	MJSONObject sentEmail(JSONObject params, HttpServletRequest request);

	/**
	 * 列举收件人
	 * 
	 * @param params
	 * @param request
	 * @return
	 */
	MJSONObject listReceivers(JSONObject params, HttpServletRequest request);

}
