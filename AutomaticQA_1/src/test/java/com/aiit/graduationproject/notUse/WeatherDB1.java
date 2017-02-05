/**
 * Copyright 2017 Iflytek, Inc. All rights reserved.
 */
package com.aiit.graduationproject.notUse;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aiit.graduationproject.entity.Area;
import com.aiit.graduationproject.entity.Weather;
import com.aiit.graduationproject.service.AreaService;
import com.aiit.graduationproject.service.WeatherService;
import com.aiit.graduationproject.utils.DateUtil;
import com.aiit.graduationproject.utils.WeatherUtil;

/**
 * <p>
 * <code>WeatherDB</code>
 * </p>
 *
 * @author admin
 * @time 2017年1月3日 下午3:50:29
 * @since 1.0
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/applicationContext.xml","classpath:spring/applicationContext-mvc.xml"})
public class WeatherDB1 {
	@Autowired
	private WeatherService weatherService;
	@Autowired
	private AreaService areaService;
	/**
	 * 日志
	 */
	private static final Logger logger = LoggerFactory.getLogger(WeatherDB1.class);
	@Test
	public void test() throws InterruptedException{
		//清空表
		weatherService.truncateTable("tb_weather");
		logger.info("开始新增各地区7天的天气信息:::开始时间:::"+DateUtil.getLocationDate());
		//先查找
		List<Area> areaList = areaService.findAllArea();
		List<Weather> weatherList = null;
		try {
			weatherList = WeatherUtil.getWeatherInfoByList(areaList);
			System.out.println(weatherList.size()+"::::-----");
			weatherService.batchAddWeatherInfo(weatherList);
		} catch (IOException e) {
			logger.error("Jsoup解析数据超时！",e);
			e.printStackTrace();
		}
		logger.info("初始化地区7天的天气信息完成！总数量：" + weatherList.size() * areaList.size());
		logger.info("初始化各地区7天的天气信息完成！:::完成时间:::" + DateUtil.getLocationDate());
	}
}
