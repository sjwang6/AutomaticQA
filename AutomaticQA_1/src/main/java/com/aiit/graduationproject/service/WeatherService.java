/**
 * Copyright 2016 Iflytek, Inc. All rights reserved.
 */
package com.aiit.graduationproject.service;

import java.util.List;

import com.aiit.graduationproject.entity.Weather;

/**
 * 获取天气信息接口
 * <p>
 * <code>WeatherService</code>
 * </p>
 *
 * @author sjwang6
 * @time 2016年12月29日 上午9:40:13
 * @since 1.0
 * @version 1.0
 */
public interface WeatherService {

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
	public void batchAddWeatherInfo(List<Weather> weatherList);

	/**
	 * 清空表
	 * <p>
	 * <code>truncateTable</code>
	 * </p>
	 * 
	 * @author sjwang6
	 * @param tableName
	 *            表名
	 */
	public void truncateTable(String tableName);

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
	public List<Weather> findWeatherAllByPage(int pageNum, int pageSize);

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
	public void deleteWeatherByWeatherId(int weatherId);

	/**
	 * 根据地区编号查看信息是否存在
	 * <p>
	 * <code>findWeatherByAreaId</code>
	 * </p>
	 * 
	 * @author sjwang6
	 * @param areaId
	 */
	public List<Weather> findWeatherByAreaId(int areaId);
}
