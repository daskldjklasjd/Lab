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
import com.bupt.vouching.service.EmailService;

/**
 * Email控制层实现
 * 
 * @author Hogan
 * 
 */
@Controller("emailController")
@Scope("prototype")
@RequestMapping("email")
public class EmailController extends BaseController {

	private Logger log = LoggerFactory.getLogger(getClass());

	@Resource
	private EmailService emailService;

	/**
	 * Email首页初始化装载收件箱信息
	 * 
	 * @param jo
	 * @return
	 */
	@RequestMapping("/fillReceiveBox")
	public @ResponseBody JSONObject fillReceiveBox(@RequestBody JSONObject jo){
		MJSONObject detail = null;
		try {
			RequestTemplate rt = new RequestTemplate(jo);
			detail = emailService.fillReceiveBox(rt.getParams(),request);
		} catch (Exception e) {
			log.error("",e);
			return new ResponseTemplate(null).getReturn();
		}
		return new ResponseTemplate(detail).getReturn();
	}
	
	/**
	 * 加载发件箱信息
	 * 
	 * @param jo
	 * @return
	 */
	@RequestMapping("/fillSentBox")
	public @ResponseBody JSONObject fillSentBox(@RequestBody JSONObject jo){
		MJSONObject detail = null;
		try {
			RequestTemplate rt = new RequestTemplate(jo);
			detail = emailService.fillSentBox(rt.getParams(),request);
		} catch (Exception e) {
			log.error("",e);
			return new ResponseTemplate(null).getReturn();
		}
		return new ResponseTemplate(detail).getReturn();
	}
	
	/**
	 * 删除一条邮件
	 * 
	 * @param jo
	 * @return
	 */
	@RequestMapping("/deleteSingleEmail")
	public @ResponseBody JSONObject deleteSingleEmail(@RequestBody JSONObject jo){
		MJSONObject detail = null;
		try {
			RequestTemplate rt = new RequestTemplate(jo);
			detail = emailService.deleteSingleEmail(rt.getParams());
		} catch (Exception e) {
			log.error("",e);
			return new ResponseTemplate(null).getReturn();
		}
		return new ResponseTemplate(detail).getReturn();
	}
	
	/**
	 * 发送邮件
	 * 
	 * @param jo
	 * @return
	 */
	@RequestMapping("/sentEmail")
	public @ResponseBody JSONObject sentEmail(@RequestBody JSONObject jo){
		MJSONObject detail = null;
		try {
			RequestTemplate rt = new RequestTemplate(jo);
			detail = emailService.sentEmail(rt.getParams(),request);
		} catch (Exception e) {
			log.error("",e);
			return new ResponseTemplate(null).getReturn();
		}
		return new ResponseTemplate(detail).getReturn();
	}
	
	/**
	 * 列举收件人
	 * 
	 * @param jo
	 * @return
	 */
	@RequestMapping("/listReceivers")
	public @ResponseBody JSONObject listReceivers(@RequestBody JSONObject jo){
		MJSONObject detail = null;
		try {
			RequestTemplate rt = new RequestTemplate(jo);
			detail = emailService.listReceivers(rt.getParams(),request);
		} catch (Exception e) {
			log.error("",e);
			return new ResponseTemplate(null).getReturn();
		}
		return new ResponseTemplate(detail).getReturn();
	}

}
