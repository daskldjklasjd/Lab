package com.bupt.vouching.dao;

import java.util.List;

import com.bupt.vouching.bean.User;

/**
 * 用户数据层接口
 * 
 * @author Hogan
 * 
 */
public interface UserDao {

	/**
	 * 根据用户名和密码查询用户
	 * 
	 * @param account
	 * @param password
	 * @return
	 */
	public User findUserByAccountAndPassword(String account, String password);

	/**
	 * 修改用户在线状态
	 * 
	 * @param user
	 * @return
	 */
	public int updateOnlineStatus(User user);

	/**
	 * 修改用户登录时间
	 * 
	 * @param user
	 * @return
	 */
	public int updateLastLoginDate(User user);

	/**
	 * 根据Email查询用户
	 * 
	 * @param receiveEmail
	 * @return
	 */
	public User findUserByEmail(String receiveEmail);

	/**
	 * 根据班级ID查询用户
	 * 
	 * @param classId
	 * @return
	 */
	public List<User> findUserByClass(String classId);
}
