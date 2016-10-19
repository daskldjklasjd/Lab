package com.bupt.vouching.dao;

import java.util.List;

import com.bupt.vouching.bean.Class;

/**
 * 班级数据层接口
 * 
 * @author Hogan
 * 
 */
public interface ClassDao {

	/**
	 * 根据ID查询班级
	 * 
	 * @param classId
	 * @return
	 */
	public Class findClassById(String classId);

	/**
	 * 查询所有班级的信息
	 * 
	 * @return
	 */
	public List<Class> findAllActiveClass();
}
