/**
 * Copyright 2016 Iflytek, Inc. All rights reserved.
 */
package com.aiit.graduationproject.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aiit.graduationproject.entity.Area;

/**
 * 全国各地区信息接口
 * <p>
 * <code>AreaService</code>
 * </p>
 *
 * @author sjwang6
 * @time 2016年12月29日 上午9:55:48
 * @since 1.0
 * @version 1.0
 */
public interface AreaService {

	/**
	 * 批量添加地区信息（名称+地址）
	 * <p>
	 * <code>batchAddAreaInfo</code>
	 * </p>
	 * 
	 * @author sjwang6
	 * @param areaList
	 * @param tableName
	 * @return
	 */
	public void batchAddAreaInfo(List<Area> areaList, String tableName);

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
	public List<Area> findAreaByIndexAndLastPos(@Param("indexPos") int indexPos, @Param("lastPos") int lastPos);

}
