package com.bupt.vouching.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.bupt.vouching.bean.Class;
import com.bupt.vouching.bean.Email;
import com.bupt.vouching.bean.User;
import com.bupt.vouching.dao.ClassDao;
import com.bupt.vouching.dao.EmailDao;
import com.bupt.vouching.dao.UserDao;
import com.bupt.vouching.frame.BaseService;
import com.bupt.vouching.frame.Consts;
import com.bupt.vouching.frame.MJSONObject;
import com.bupt.vouching.service.UserService;
import com.bupt.vouching.util.ErrorCode;
import com.bupt.vouching.util.Utils;

/**
 * 用户业务层实现
 * 
 * @author Hogan
 * 
 */
@Service("userService")
public class UserServiceImpl extends BaseService implements UserService {
	
	public MJSONObject result = null;
	public JSONObject detail = null;

	@Resource
	private UserDao userDao;

	@Resource
	private ClassDao classDao;
	
	@Resource
	private EmailDao emailDao;

	@Override
	public MJSONObject loginValidate(JSONObject jo, HttpServletRequest request) {
		result = new MJSONObject();
		String account = jo.getString("account");
		String password = jo.getString("password");
		if (Utils.isNotNullOrBlank(account, password)) {
			User user = userDao.findUserByAccountAndPassword(account, password);
			if (user != null) {
				Class clas = classDao.findClassById(user.getClassId());
				if (clas != null) {
					if (Consts.CLASS_ACTIVE == clas.getIsActive()) {
						HttpSession session = request.getSession();
						session.setAttribute(Consts.SESSION_CURENT_USER_LABEL, user);
						result.setErrorCode(ErrorCode.SUCCESS);
						return result;
					} else {
						result.setErrorCode(ErrorCode.CLASS_IS_INACTIVE);
					}
				} else {
					result.setErrorCode(ErrorCode.CLASS_IS_NOT_IN_SYSTEM);
				}
			} else {
				result.setErrorCode(ErrorCode.LOGIN_AP_IS_NOT_MATCH);
			}
		} else {
			result.setErrorCode(ErrorCode.LOGIN_INPUT_IS_NULL);
		}
		return result;
	}

	@Override
	public MJSONObject fillNavigation(HttpServletRequest request) {
		result = new MJSONObject();
		detail = new JSONObject();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(Consts.SESSION_CURENT_USER_LABEL);
		if (user != null) {
			user.setIsOnline(1);
			if (userDao.updateOnlineStatus(user) == 1) {
				user.setLastLoginDate(new Date());
				if (userDao.updateLastLoginDate(user) == 1) {
					int unReadEmailCount = emailDao.findUnreadCount(user.getUserId());
					detail.put("unReadEmailCount", unReadEmailCount);
					detail.put(Consts.SESSION_CURENT_USER_LABEL, user);
					result.setErrorCode(ErrorCode.SUCCESS);
					result.setDetail(detail);
					return result;
				} else {
					result.setErrorCode(ErrorCode.UPDATE_FIALD);
				}
			} else {
				result.setErrorCode(ErrorCode.UPDATE_FIALD);
			}
		} else {
			result.setErrorCode(ErrorCode.NOT_LOGIN);
		}
		return result;
	}

	@Override
	public void logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute(Consts.SESSION_CURENT_USER_LABEL);
		if (user != null) {
			session.removeAttribute(Consts.SESSION_CURENT_USER_LABEL);
		}
	}


	@Override
	public MJSONObject fillUserInClass(JSONObject params) {
		MJSONObject result = new MJSONObject();
		JSONObject detail = new JSONObject();
		String classId = params.getString("classId");
		List<User> userInClass = userDao.findUserByClass(classId);
		detail.put("userInClass", userInClass);
		result.setDetail(detail);
		result.setErrorCode(ErrorCode.SUCCESS);
		return result;
	}

	@Override
	public MJSONObject fillDetail(JSONObject params,HttpServletRequest request) {
		User user = getUserInSession(request);
		if (user != null) {
			List<Email> unreadEmails = emailDao.findLastFiveUnreadEmail(user.getUserId());
			detail.put("unreadEmails", unreadEmails);
			result.setErrorCode(ErrorCode.SUCCESS);
			result.setDetail(detail);
		} else {
			result.setErrorCode(ErrorCode.SESSION_INVALID);
		}
		return result;
	}

	@Override
	public MJSONObject logout(JSONObject params, HttpServletRequest request) {
		MJSONObject result = new MJSONObject();
		User user = getUserInSession(request);
		if(user != null){
			request.getSession().removeAttribute(Consts.SESSION_CURENT_USER_LABEL);
		}
		result.setErrorCode(ErrorCode.SUCCESS);
		return result;
	}
	
}
