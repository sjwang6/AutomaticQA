/**
 * Copyright 2016 Iflytek, Inc. All rights reserved.
 */
package com.aiit.graduationproject.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aiit.graduationproject.entity.Weather;

/**
 * 天气接口实现
 * <p>
 * <code>WeatherDao</code>
 * </p>
 *
 * @author sjwang6
 * @time 2016年12月29日 上午10:40:43
 * @since 1.0
 * @version 1.0
 */
public interface WeatherDao {

	/**
	 * 批量添加天气信息
	 * <p>
	 * <code>batchAddWeatherInfo</code>
	 * </p>
	 * 
	 * @author sjwang6
	 * @param weatherList
	 * @return
	 */
	public void batchAddWeatherInfo(@Param("weatherList") List<Weather> weatherList);

	/**
	 * 查询所以天气信息
	 * <p>
	 * <code>findWeatherAllByPage</code>
	 * </p>
	 * 
	 * @author sjwang6
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public List<Weather> findWeatherAllByPage(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);

	/**
	 * 清空天气信息表
	 * <p>
	 * <code>truncateWeatherInfo</code>
	 * </p>
	 * 
	 * @author sjwang6
	 * @param tableName
	 *            表名
	 * @return
	 */
	public void truncateTable(@Param("tableName") String tableName);

	/**
	 * 查询天气表 的日期和地区外键
	 * <p>
	 * <code>findWeatherDateAndFkAreaId</code>
	 * </p>
	 * 
	 * @author sjwang6
	 * @return
	 */
	public List<Weather> findWeatherDateAndFkAreaId();

	/**
	 * 根据天气表编号删除
	 * <p>
	 * <code>deleteWeatherByWeatherId</code>
	 * </p>
	 * 
	 * @author sjwang6
	 * @param weatherId
	 */
	public void deleteWeatherByWeatherId(@Param("weatherId") int weatherId);

	/**
	 * 根据地区编号查看信息是否存在
	 * <p>
	 * <code>findWeatherByAreaId</code>
	 * </p>
	 * 
	 * @author sjwang6
	 * @param areaId
	 */
	public List<Weather> findWeatherByAreaId(@Param("areaId") int areaId);
}
