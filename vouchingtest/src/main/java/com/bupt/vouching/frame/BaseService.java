package com.bupt.vouching.frame;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.bupt.vouching.bean.User;

/**
 * 基础的业务类
 * 
 * @author Hogan
 * 
 */
public abstract class BaseService {

	/**
	 * 获取session的用户信息
	 * 
	 * @param request
	 * @return
	 */
	protected User getUserInSession(HttpServletRequest request) {
		HttpSession session = request.getSession();
		return (User) session.getAttribute(Consts.SESSION_CURENT_USER_LABEL);
	}
}
