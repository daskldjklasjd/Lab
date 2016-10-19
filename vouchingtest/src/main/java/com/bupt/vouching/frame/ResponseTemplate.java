package com.bupt.vouching.frame;

import com.alibaba.fastjson.JSONObject;
import com.bupt.vouching.util.ErrorCode;

/**
 * 响应模板
 * 
 * @author Hogan
 * 
 */
public class ResponseTemplate {

	private MJSONObject detail;

	public ResponseTemplate(MJSONObject detail) {
		this.detail = detail;
	}

	public JSONObject getReturn() {
		if (detail == null){
			detail = new MJSONObject();
			detail.setResult(Consts.RESULT_FAILD);
		} else {
			if (ErrorCode.SUCCESS.getDescription().equals(detail.getString(Consts.ERROR_LABEL))) {
				detail.setResult(Consts.RESULT_SUCCESS);
			} else {
				detail.setResult(Consts.RESULT_FAILD);
			}
		}
		return detail;
	}
}