package com.bupt.vouching.frame;

import com.alibaba.fastjson.JSONObject;

/**
 * 请求模板
 * 
 * @author Hogan
 * 
 */
public class RequestTemplate {

	/**
	 * 请求参数全部封装到params中
	 */
	public JSONObject params = null;

	public RequestTemplate(JSONObject reqJson) {
		if (reqJson != null) {
			params = reqJson.getJSONObject(Consts.PARAMS_LABEL);
		}
	}

	public JSONObject getParams() {
		return params;
	}

}
