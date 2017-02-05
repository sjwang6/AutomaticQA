/**
 * Copyright 2016 Iflytek, Inc. All rights reserved.
 */
package com.aiit.graduationproject.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aiit.graduationproject.entity.Area;

/**
 * 地区接口实现
 * <p>
 * <code>AreaDao</code>
 * </p>
 *
 * @author sjwang6
 * @time 2016年12月29日 上午10:41:50
 * @since 1.0
 * @version 1.0
 */
public interface AreaDao {

	/**
	 * 批量添加地区信息（名称+地址）
	 * <p>
	 * <code>batchAddAreaInfo</code>
	 * </p>
	 * 
	 * @author sjwang6
	 * @param areaList
	 * @return
	 */
	public void batchAddAreaInfo(@Param("areaList") List<Area> areaList);
	
	/**
	 * 清空表
	 * <p>
	 * <code>truncateTable</code>
	 * </p>
	 * 
	 * @author sjwang6
	 * @param tableName 表名
	 */
	public void truncateTable(@Param("tableName") String tableName);
	
	/**
	 * 查询所有的地区信息
	 * <p>
	 * <code>findAllArea</code>
	 * </p>
	 * 
	 * @author sjwang6
	 * @return
	 */
	public List<Area> findAllArea();
	
	/**
	 * 根据位置查询所有的地区信息
	 * <p>
	 * <code>findAreaByIndexAndLastPos</code>
	 * </p>
	 * 
	 * @author sjwang6
	 * @param indexPos
	 * @param lastPos
	 * @return
	 */
	public List<Area> findAreaByIndexAndLastPos(@Param("indexPos")int indexPos, @Param("lastPos")int lastPos);
}
