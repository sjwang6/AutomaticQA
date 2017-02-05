/**
 * Copyright 2016 Iflytek, Inc. All rights reserved.
 */
package com.aiit.graduationproject.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aiit.graduationproject.dao.WeatherDao;
import com.aiit.graduationproject.entity.Weather;
import com.aiit.graduationproject.service.WeatherService;

/**
 * 天气接口实现类
 * <p>
 * <code>WeatherServiceImpl</code>
 * </p>
 *
 * @author sjwang6
 * @time 2016年12月29日 上午9:59:06
 * @since 1.0
 * @version 1.0
 */
@Service
public class WeatherServiceImpl implements WeatherService {

	/**
	 * 注入
	 */
	@Autowired
	private WeatherDao weatherDao;

	/**
	 * 日志
	 */
	private static final Logger logger = LoggerFactory.getLogger(WeatherServiceImpl.class);

	/**
	 * @see com.aiit.graduationproject.service.WeatherService#batchAddWeatherInfo(java.util.List)
	 */
	public void batchAddWeatherInfo(List<Weather> weatherList) {
		// logger.info("weadao::正在存入数据库！");
		weatherDao.batchAddWeatherInfo(weatherList);
	}

	/**
	 * @see com.aiit.graduationproject.service.WeatherService#truncateTable(java.lang.String)
	 */
	public void truncateTable(String tableName) {
		weatherDao.truncateTable(tableName);
		logger.info("清空:::" + tableName + ":::表OK！");

	}

	/**
	 * @see com.aiit.graduationproject.service.WeatherService#findWeatherDateAndFkAreaId()
	 */
	public List<Weather> findWeatherDateAndFkAreaId() {

		return weatherDao.findWeatherDateAndFkAreaId();
	}

	/**
	 * @see com.aiit.graduationproject.service.WeatherService#deleteWeatherByWeatherId(int)
	 */
	public void deleteWeatherByWeatherId(int weatherId) {
		weatherDao.deleteWeatherByWeatherId(weatherId);
	}

	/**
	 * @see com.aiit.graduationproject.service.WeatherService#findWeatherByAreaId(int)
	 */
	public List<Weather> findWeatherByAreaId(int areaId) {

		return weatherDao.findWeatherByAreaId(areaId);
	}

	/**
	 * @see com.aiit.graduationproject.service.WeatherService#findWeatherAllByPage(int,int)
	 */
	public List<Weather> findWeatherAllByPage(int pageNum, int pageSize) {

		return weatherDao.findWeatherAllByPage(pageNum, pageSize);
	}
}
