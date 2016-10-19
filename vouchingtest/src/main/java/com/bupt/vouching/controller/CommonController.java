package com.bupt.vouching.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bupt.vouching.frame.BaseController;

/**
 * 公共的控制层实现
 * 
 * @author Hogan
 * 
 */
@Controller("commonController")
@Scope("singleton")
@RequestMapping("common")
public class CommonController extends BaseController {

	/**
	 * 跳转到前台登录页面
	 * 
	 * @return
	 */
	@RequestMapping("/forwardFrontLogin")
	public String fowardFrontLogin() {
		return formFrontResult(login);
	}

	/**
	 * 跳转到前台主页
	 * 
	 * @return
	 */
	@RequestMapping("/forwardFrontIndex")
	public String forwardFrontIndex() {
		return formFrontResult(index);
	}

	/**
	 * 跳转到前台Email页面
	 * 
	 * @return
	 */
	@RequestMapping("/emailIndex")
	public String forwardFrontEmailIndex() {
		return formFrontResult(email, emailIndex);
	}

	/**
	 * 跳转到前台上传/下载教学资源页面
	 * 
	 * @return
	 */
	@RequestMapping("/upload")
	public String forwardFrontUpload() {
		return formFrontResult(teachingResource, upload);
	}
}
