package com.bupt.vouching.dao;

import java.util.List;
import java.util.Map;

import com.bupt.vouching.bean.Email;

/**
 * 邮件数据层接口
 * 
 * @author Hogan
 * 
 */
public interface EmailDao {

	/**
	 * 查询未读邮件的个数
	 * 
	 * @param receiveId
	 * @return
	 */
	public int findUnreadCount(String receiveId);

	/**
	 * 查询前五条未读邮件
	 * 
	 * @param receiveId
	 * @return
	 */
	public List<Email> findLastFiveUnreadEmail(String receiveId);

	/**
	 * 查询所有接收到的邮件
	 * 
	 * @param userId
	 * @return
	 */
	public List<Email> findReceiveEmails(String userId);

	/**
	 * 查询所有发送的邮件
	 * 
	 * @param userId
	 * @return
	 */
	public List<Email> findSentEmails(String userId);

	/**
	 * 根据邮件删除类型修改删除标记
	 * 
	 * @param params  删除类型  1 - 收件箱    2 - 发件箱
	 * @return
	 */
	public int updateDelFlagByType(Map<String, Object> params);

	/**
	 * 真正删除邮件
	 * 
	 * @param delEmailId
	 * @return
	 */
	public int deleteRealEmail(String delEmailId);

	/**
	 * 添加一条邮件
	 * 
	 * @param newEmail
	 * @return
	 */
	public int addEmail(Email newEmail);

}
