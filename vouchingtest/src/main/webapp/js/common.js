/**
 * 页面简单跳转
 * 
 * @param url
 */
function simpleHref(url) {
	window.location.href = url;
}

/**
 * 填充表格数据工具类
 * 
 * @param tbodyId    tbody的ID
 * @param columnName 数据的索引名称
 * @param data       JSON数据
 * @param footerTip  表格尾部信息
 * @param url        表格尾部连接的跳转URL
 */

function tableUtil(tbodyId, columnName, data, footerTip, url) {
	for ( var i = 0; i < data.length; i++) {
		$("#" + tbodyId).append("<tr></tr>");
		for ( var j = 0; j < columnName.length; j++) {
			var td = "<td><strong>" + eval("data[" + i + "]." + columnName[j])
					+ "</strong></td>";
			$("#" + tbodyId + ">tr").eq(i).append(td);
		}
	}
	if (footerTip != null) {
		$("#" + tbodyId).append(
				"<tr><td><a href=" + url + ">" + footerTip + "<a></td></tr>");
	}
}

/**
 * 
 * @param url
 *            跳转的URL
 * @param pageInfo
 *            ajax传回的page对象信息
 */
function generatePager(url, pageInfo) {
}
