/**
 * Copyright 2017 Iflytek, Inc. All rights reserved.
 */
package com.aiit.graduationproject.test;

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
import com.aiit.graduationproject.utils.MessagesUtils;
import com.aiit.graduationproject.utils.StringUtils;
import com.aiit.graduationproject.utils.WeatherUtil;

/**
 * <p>
 * <code>CheckWeatherDB</code>
 * </p>
 *
 * @author sjwang6
 * @time 2017年1月3日 下午3:50:29
 * @since 1.0
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml",
		"classpath:spring/applicationContext-mvc.xml" })
public class CheckWeatherDB {

	int num = StringUtils.StringCastInteger(MessagesUtils.getProperty(MessagesUtils.full_weather_num));
	/**
	 * 注入
	 */
	@Autowired
	private WeatherService weatherService;

	@Autowired
	private AreaService areaService;
	/**
	 * 日志
	 */
	private static final Logger logger = LoggerFactory.getLogger(CheckWeatherDB.class);

	@Test
	public void test() throws InterruptedException {
		List<Area> aList = areaService.findAllArea();
		logger.info("：：：正在检查缺少的数据：：：");
		for (Area area : aList) {
			List<Weather> wist = weatherService.findWeatherByAreaId(area.getAreaId());
			if (wist.size() != 7) {
				try {
					List<Weather> list = WeatherUtil.getWeatherInfoByListAndNum(area, num);
					weatherService.batchAddWeatherInfo(list);
				} catch (IOException e) {
					logger.error("流的读取错误", e);
					e.printStackTrace();
				}
			}
		}
	}
}