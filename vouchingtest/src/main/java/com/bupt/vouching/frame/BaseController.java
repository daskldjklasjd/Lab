package com.bupt.vouching.frame;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 抽象的控制层
 * 
 * @author Hogan
 * 
 */
public abstract class BaseController {

	@Resource
	protected HttpServletRequest request;

	@Resource
	protected HttpServletResponse response;

	protected HttpSession session;

	public static final String PATH_FRONT = "front";
	public String front = PATH_FRONT;

	public static final String PATH_LOGIN = "/login";
	public String login = PATH_LOGIN;

	public static final String PATH_INDEX = "/index";
	public String index = PATH_INDEX;
	
	public static final String PATH_EMAIL = "/email";
	public String email = PATH_EMAIL;
	
	public static final String PATH_EMAIL_INDEX = "/emailIndex";
	public String emailIndex = PATH_EMAIL_INDEX;

	public static final String PATH_ERROR = "error";
	public String error = PATH_ERROR;
	
	public static final String PAHT_TEACHING_RESOURCE = "/teachingresource";
	public String teachingResource = PAHT_TEACHING_RESOURCE;
	
	public static final String PATH_UPLOAD = "/upload";
	public String upload = PATH_UPLOAD;


	/**
	 * 组合返回路径字符串
	 * 
	 * @param path
	 * @return
	 */
	public String formResult(String... path) {
		StringBuilder sb = new StringBuilder();
		for (String e : path) {
			sb.append(e);
		}
		return sb.toString();
	}

	/**
	 * 组合前台返回字符串
	 * 
	 * @param path
	 * @return
	 */
	public String formFrontResult(String... path) {
		return front + formResult(path);
	}
}
