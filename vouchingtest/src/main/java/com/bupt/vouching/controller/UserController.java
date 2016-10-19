package com.bupt.vouching.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.bupt.vouching.frame.BaseController;
import com.bupt.vouching.frame.MJSONObject;
import com.bupt.vouching.frame.RequestTemplate;
import com.bupt.vouching.frame.ResponseTemplate;
import com.bupt.vouching.service.UserService;

/**
 * 用户控制层
 * 
 * @author Hogan
 * 
 */
@Controller("userController")
@Scope("prototype")
@RequestMapping("user")
public class UserController extends BaseController {

	private Logger log = LoggerFactory.getLogger(getClass());
	@Resource
	private UserService userService;

	/**
	 * 登录校验
	 * 
	 * @param jo
	 * @return
	 */
	@RequestMapping("/login")
	public @ResponseBody JSONObject login(@RequestBody JSONObject jo) {
		MJSONObject detail = null;
		try {
			RequestTemplate rt = new RequestTemplate(jo);
			detail = userService.loginValidate(rt.getParams(), request);
		} catch (Exception e) {
			log.error("",e);
			return new ResponseTemplate(null).getReturn();
		}
		return new ResponseTemplate(detail).getReturn();
	}
	
	/**
	 * 装填导航栏信息
	 * 
	 * @return
	 */
	@RequestMapping("/fillNavigation")
	public @ResponseBody JSONObject fillNavigation(@RequestBody JSONObject jo) {
		MJSONObject detail = null;
		try {
			detail = userService.fillNavigation(request);
		} catch (Exception e) {
			log.error("",e);
			return new ResponseTemplate(null).getReturn();
		}
		return new ResponseTemplate(detail).getReturn();
	}
	
	/**
	 * 装载首页详情信息
	 * 
	 * @param jo
	 * @return
	 */
	@RequestMapping("/fillDetail")
	public @ResponseBody JSONObject fillDetail(@RequestBody JSONObject jo) {
		MJSONObject detail = null;
		try {
			RequestTemplate rt = new RequestTemplate(jo);
			detail = userService.fillDetail(rt.getParams(),request);
		} catch (Exception e) {
			log.error("",e);
			return new ResponseTemplate(null).getReturn();
		}
		return new ResponseTemplate(detail).getReturn();
	}
	
	/**
	 * 用户注销
	 * 
	 * @param jo
	 * @return
	 */
	@RequestMapping("/logout")
	public @ResponseBody JSONObject logout(@RequestBody JSONObject jo) {
		MJSONObject detail = null;
		try {
			RequestTemplate rt = new RequestTemplate(jo);
			detail = userService.logout(rt.getParams(),request);
		} catch (Exception e) {
			log.error("",e);
			return new ResponseTemplate(null).getReturn();
		}
		return new ResponseTemplate(detail).getReturn();
	}
	
}
