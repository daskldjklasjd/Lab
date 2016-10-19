package com.bupt.vouching.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
import com.bupt.vouching.service.EmailService;
import com.bupt.vouching.util.ErrorCode;
import com.bupt.vouching.util.Utils;
import com.bupt.vouching.util.page.PageHelper;
import com.bupt.vouching.util.page.PageInfo;

/**
 * email业务实现
 * 
 * @author Hogan
 * 
 */
@Service("emailService")
public class EmailServiceImpl extends BaseService implements EmailService {

	@Resource
	private EmailDao emailDao;
	
	@Resource
	private UserDao userDao;
	
	@Resource
	private ClassDao classDao;

	@Override
	public MJSONObject fillReceiveBox(JSONObject params, HttpServletRequest request) {
		MJSONObject result = new MJSONObject();
		JSONObject detail = new JSONObject();
		int pageNum = params.getIntValue("pageNum");
		User user = getUserInSession(request);
		if (user != null) {
			PageHelper.startPage(pageNum, Consts.PAGE_SIZE_EMAIL_RECEIVE);
			List<Email> receiveEmails = emailDao.findReceiveEmails(user.getUserId());
			PageInfo<Email> emailPage = new PageInfo<Email>(receiveEmails);
			detail.put("receiveEmails", emailPage.getList());
			result.setDetail(detail);
			result.setPageInfo(emailPage);
			result.setErrorCode(ErrorCode.SUCCESS);
		} else {
			result.setErrorCode(ErrorCode.SESSION_INVALID);
		}
		return result;
	}

	@Override
	public MJSONObject fillSentBox(JSONObject params, HttpServletRequest request) {
		MJSONObject result = new MJSONObject();
		JSONObject detail = new JSONObject();
		int pageNum = params.getIntValue("pageNum");
		User user = getUserInSession(request);
		if (user != null) {
			PageHelper.startPage(pageNum, Consts.PAGE_SIZE_EMAIL_RECEIVE);
			List<Email> sentEmails = emailDao.findSentEmails(user.getUserId());
			PageInfo<Email> emailPage = new PageInfo<Email>(sentEmails);
			detail.put("senterEmails", emailPage.getList());
			result.setDetail(detail);
			result.setPageInfo(emailPage);
			result.setErrorCode(ErrorCode.SUCCESS);
		} else {
			result.setErrorCode(ErrorCode.SESSION_INVALID);
		}
		return result;
	}

	@Override
	public MJSONObject deleteSingleEmail(JSONObject params) {
		MJSONObject result = new MJSONObject();
		JSONObject detail = new JSONObject();
		Integer delEmailType = params.getIntValue("type");
		String delEmailId = params.getString("emailId");
		Map<String, Object> param = new HashMap<String, Object>();
		if (Utils.isNotNullOrBlank(delEmailType)) {
			if (Utils.isNotNullOrBlank(delEmailId)) {
				param.put("type", delEmailType);
				param.put("emailId", delEmailId);
				if (emailDao.updateDelFlagByType(param) == Consts.UPDATE_SINGLE_SUCCESS) {
					detail.put("deleteEmailId", delEmailId);
					result.setDetail(detail);
					result.setErrorCode(ErrorCode.SUCCESS);
				} else {
					result.setErrorCode(ErrorCode.EMAIL_DELETE_FIALD);
				}
			} else {
				result.setErrorCode(ErrorCode.NO_DELETE_EMIAL_ID);
			}
		} else {
			result.setErrorCode(ErrorCode.NO_DELETE_EMIAL_TYPE);
		}
		return result;
	}

	@Override
	public MJSONObject sentEmail(JSONObject params, HttpServletRequest request) {
		MJSONObject result = new MJSONObject();
		String subject = params.getString("subject");
		String content = params.getString("content");
		String receiveEmail = params.getString("receiveEmail");
		String[] receiveEmails = receiveEmail.split(";");
		User user = getUserInSession(request);
		if(user != null){
			if (Utils.isNotNullOrBlank(subject)) {
				if (Utils.isNotNullOrBlank(content)) {
					if (receiveEmails.length != 0) {
						for (int i = 0; i < receiveEmails.length; i++) {
							User receiveUser = userDao.findUserByEmail(receiveEmails[i]);
							if(receiveUser != null){
								Email newEmail = new Email();
								newEmail.setContent(content);
								newEmail.setEmailId(Utils.getUUID());
								newEmail.setIsRead(0);
								newEmail.setReceiveDel(0);
								newEmail.setReceiveEmail(receiveEmails[i]);
								newEmail.setReceiveId(receiveUser.getUserId());
								newEmail.setReceiveName(receiveUser.getName());
								newEmail.setSentDate(new Date());
								newEmail.setSentDel(0);
								newEmail.setSenterEmail(user.getEmail());
								newEmail.setSenterId(user.getUserId());
								newEmail.setSenterName(user.getName());
								newEmail.setSubject(subject);
								if (emailDao.addEmail(newEmail) == Consts.INSERT_SINGLE_SUCCESS) {
									result.setErrorCode(ErrorCode.SUCCESS);
								} else {
									result.setErrorCode(ErrorCode.EMAIL_SENT_FAILD);
								}
							} else {
								result.setErrorCode(ErrorCode.EMAIL_RECEIVE_INVALID);
							}
						}
					} else {
						result.setErrorCode(ErrorCode.EMAIL_RECEIVE_NULL);
					}
				} else {
					result.setErrorCode(ErrorCode.EMAIL_CONTENT_NULL);
				}
			} else {
				result.setErrorCode(ErrorCode.EMAIL_SUBJECT_NULL);
			}
		}
		return result;
	}

	@Override
	public MJSONObject listReceivers(JSONObject params, HttpServletRequest request) {
		MJSONObject result = new MJSONObject();
		JSONObject detail = new JSONObject();
		User user = getUserInSession(request);
		if (user != null) {
			Class clas = classDao.findClassById(user.getClassId());
			if (clas != null) {
				if (clas.getIsActive() == Consts.CLASS_ACTIVE) {
					List<Class> classes = classDao.findAllActiveClass();
					List<User> users = userDao.findUserByClass(user.getClassId());
					detail.put("classes", classes);
					detail.put("users",users);
					result.setDetail(detail);
					result.setErrorCode(ErrorCode.SUCCESS);
				} else {
					result.setErrorCode(ErrorCode.CLASS_IS_INACTIVE);
				}
			} else {
				result.setErrorCode(ErrorCode.CLASS_IS_NOT_IN_SYSTEM);
			}
		} else {
			result.setErrorCode(ErrorCode.SESSION_INVALID);
		}
		return result;
	}
}
